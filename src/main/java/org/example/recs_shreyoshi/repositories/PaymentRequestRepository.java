package org.example.recs_shreyoshi.repositories;


import org.example.recs_shreyoshi.dto.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRequestRepository extends JpaRepository<PaymentRequest, Long> {



}
