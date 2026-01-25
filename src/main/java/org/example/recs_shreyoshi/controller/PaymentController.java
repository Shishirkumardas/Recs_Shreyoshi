package org.example.recs_shreyoshi.controller;

import lombok.RequiredArgsConstructor;
import org.example.recs_shreyoshi.dto.PaymentRequest;
import org.example.recs_shreyoshi.dto.PaymentView;
import org.example.recs_shreyoshi.models.Payment;
import org.example.recs_shreyoshi.repositories.MasterDataRepository;
import org.example.recs_shreyoshi.repositories.PaymentRepository;
import org.example.recs_shreyoshi.services.BkashService;
import org.example.recs_shreyoshi.services.PaymentService;
import org.example.recs_shreyoshi.services.PaymentService2;
import org.example.recs_shreyoshi.services.PaymentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3001")
public class PaymentController {

    private final PaymentRepository repo;
    private final PaymentService2 paymentService2;
    private final PaymentService paymentService;
    private final MasterDataRepository masterDataRepository;
    private final PaymentServiceImpl paymentServiceImpl;
    private final BkashService bkashService;

//    @GetMapping
//    public List<Payment> getAll() {
//        return repo.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Payment getPaymentById(@PathVariable Long id) {
//        return paymentService.getPaymentById(id);
//    }

    @GetMapping
    public List<PaymentView> payments() {
        return masterDataRepository.getPayments();
    }


    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        return paymentService.updatePayment(id, payment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok().body("Payment deleted successfully");
    }
    @PostMapping("/{id}/pay")
    public Payment addPayment(
            @PathVariable Long id,
            @RequestBody PaymentRequest request
    ) {
        return paymentService2.addPayment(id, request);
    }
    @PostMapping("/customer/{masterId}/pay")
    public Payment completePayment(
            @PathVariable Long masterId
    ) {
        return paymentService2.processPayment(masterId);
    }


    @GetMapping("/{id}/payments")
    public List<Payment> getPayments(@PathVariable Long id) {
        return paymentService2.getPayments(id);
    }

//    public Map<String, Object> createPayment(String amount, String orderId) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(bkashService.generateToken());
//
//        Map<String, Object> request = Map.of(
//                "amount", amount,
//                "currency", "BDT",
//                "intent", "sale",
//                "merchantInvoiceNumber", orderId
//        );
//
//        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);
//
//        ResponseEntity<Map> response = restTemplate.postForEntity(
//                "https://tokenized.sandbox.bka.sh/v1.2.0-beta/checkout/create",
//                entity,
//                Map.class
//        );
//
//        return response.getBody();
//    }
//
//    public Map<String, Object> executePayment(String paymentID) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(bkashService.generateToken());
//
//        Map<String, Object> request = Map.of(
//                "paymentID", paymentID
//        );
//
//        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);
//
//        ResponseEntity<Map> response = restTemplate.postForEntity(
//                "https://tokenized.sandbox.bka.sh/v1.2.0-beta/checkout/execute",
//                entity,
//                Map.class
//        );
//
//        return response.getBody();
//    }

    @GetMapping("/payment/success")
    public String success(@RequestParam String merchantInvoiceNumber) {
        paymentService.markPaymentSuccess(merchantInvoiceNumber);
        return "Payment Successful";
    }

    @GetMapping("/payment/failed")
    public String failed(@RequestParam String merchantInvoiceNumber) {
        paymentService.markPaymentFailed(merchantInvoiceNumber);
        return "Payment Failed";
    }
}

