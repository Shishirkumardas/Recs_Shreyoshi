package org.example.recs_shreyoshi.services;

import org.example.recs_shreyoshi.dto.PaymentRequest;
import org.example.recs_shreyoshi.models.Payment;

import java.util.List;


public interface PaymentService2 {


    Payment addPayment(Long masterDataId, PaymentRequest request);

    List<Payment> getPayments(Long masterDataId);
    Payment processPayment(Long masterId);


}
