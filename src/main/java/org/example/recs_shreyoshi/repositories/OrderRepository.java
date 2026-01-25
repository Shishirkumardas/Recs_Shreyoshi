package org.example.recs_shreyoshi.repositories;

import org.example.recs_shreyoshi.models.Order;
import org.example.recs_shreyoshi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);

    List<Order> findByUserId(Long userId);
}
