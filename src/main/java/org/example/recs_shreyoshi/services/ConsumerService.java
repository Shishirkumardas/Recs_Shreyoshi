package org.example.recs_shreyoshi.services;

import org.example.recs_shreyoshi.ResourceNotFoundException;
import org.example.recs_shreyoshi.models.Consumer;
import org.example.recs_shreyoshi.repositories.ConsumerRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private ConsumerRepository consumerRepository;

    public Consumer updateConsumer(Long id, Consumer consumerDetails) {
        Consumer consumer = consumerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consumer not found"));
        consumer.setName(consumerDetails.getName());
        consumer.setArea(consumerDetails.getArea());
        consumer.setPurchaseAmount(consumerDetails.getPurchaseAmount());
        consumer.setDueAmount(consumerDetails.getDueAmount());
        return consumerRepository.save(consumer);
    }

    public Consumer getConsumerById(Long id) {
        return consumerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Area not found"));
    }

    public Consumer getConsumerByName(String name) {
        return consumerRepository.findByName(name);
    }

}
