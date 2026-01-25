package org.example.recs_shreyoshi.controller;


import org.example.recs_shreyoshi.dto.OrderResponseDTO;
import org.example.recs_shreyoshi.models.CartItem;
import org.example.recs_shreyoshi.models.Order;
import org.example.recs_shreyoshi.models.OrderItem;
import org.example.recs_shreyoshi.models.User;
import org.example.recs_shreyoshi.repositories.CartItemRepository;
import org.example.recs_shreyoshi.repositories.OrderItemRepository;
import org.example.recs_shreyoshi.repositories.OrderRepository;
import org.example.recs_shreyoshi.repositories.UserRepository;
import org.example.recs_shreyoshi.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public Order createOrder(@RequestParam Long userId, @RequestBody String shippingAddress) { // Simplify; update user address too
        User user = userRepository.findById(userId).orElseThrow();
        user.setAddress(shippingAddress); // Update address
        userRepository.save(user);

        List<CartItem> cartItems = cartItemRepository.findByUserId(userId);
        double total = cartItems.stream().mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice()).sum();

        Order order = Order.builder()
                .user(user)
                .orderDate(LocalDateTime.now())
                .status(OrderStatus.PENDING)
                .totalAmount(total)
                .build();
        order = orderRepository.save(order);

        // Move cart to order items
//        List<OrderItem> orderItems = cartItems.stream().map(cartItem ->
//                OrderItem.builder()
//                        .order(order)
//                        .product(cartItem.getProduct())
//                        .quantity(cartItem.getQuantity())
//                        .price(cartItem.getProduct().getPrice())
//                        .build()
//        ).collect(Collectors.toList());

        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = OrderItem.builder()
                    .product(cartItem.getProduct())
                    .quantity(cartItem.getQuantity())
                    .price(cartItem.getProduct().getPrice())
                    .build();

            order.addOrderItem(orderItem);   // sets both sides
        }
        order = orderRepository.save(order);

        // Clear cart
        cartItemRepository.deleteAll(cartItems);

        return order;
    }

//    @GetMapping
//    public List<Order> getUserOrders(@RequestParam Long userId) {
//        return orderRepository.findByUserId(userId);
//    }

    @GetMapping
    public List<OrderResponseDTO> getUserOrders(@RequestParam Long userId) {
        return orderRepository.findByUserId(userId)
                .stream()
                .map(order -> {
                    OrderResponseDTO dto = new OrderResponseDTO();
                    dto.id = order.getId();
                    dto.orderDate = order.getOrderDate();
                    dto.status = order.getStatus().name();
                    dto.totalAmount = order.getTotalAmount();
                    return dto;
                })
                .toList();
    }


}
