package org.example.recs_shreyoshi.repositories;


import org.example.recs_shreyoshi.models.CartItem;

import org.example.recs_shreyoshi.models.Product;
import org.example.recs_shreyoshi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(Long userId);

    Optional<CartItem> findByUserAndProduct(User user, Product product);
}