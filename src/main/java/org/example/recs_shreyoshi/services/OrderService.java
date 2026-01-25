package org.example.recs_shreyoshi.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.recs_shreyoshi.dto.OrderItemResponseDTO;
import org.example.recs_shreyoshi.dto.OrderResponseDTO;
import org.example.recs_shreyoshi.enums.OrderStatus;
import org.example.recs_shreyoshi.models.Order;
import org.example.recs_shreyoshi.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public Order updateStatus(Long orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);
        return order;
    }

    public List<OrderResponseDTO> getAllOrdersForAdmin() {
        return orderRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private OrderResponseDTO toDTO(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.id = order.getId();
        dto.orderDate = order.getOrderDate();
        dto.status = order.getStatus().name();
        dto.totalAmount = order.getTotalAmount();
        dto.address=order.getUser().getAddress();

        dto.items = order.getOrderItems().stream().map(item -> {
            OrderItemResponseDTO i = new OrderItemResponseDTO();
            i.productId = item.getProduct().getId();
            i.productName = item.getProduct().getName();
            i.category = item.getProduct().getCategory();
            i.imageUrl = item.getProduct().getImageUrl();
            i.quantity = item.getQuantity();
            i.price = item.getPrice();
            return i;
        }).toList();

        return dto;
    }


}
