package org.example.recs_shreyoshi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PaymentView {
    private LocalDate date;
    private BigDecimal paidAmount;
}

