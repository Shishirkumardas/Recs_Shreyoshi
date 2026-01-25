package org.example.recs_shreyoshi.dto;

import lombok.Data;
import org.example.recs_shreyoshi.enums.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class CustomerFormDTO {

    private String customerName;
    private BigDecimal nid;

    private Long areaID;
    private BigDecimal phoneNumber;
    private LocalDate paymentDate;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;

}

