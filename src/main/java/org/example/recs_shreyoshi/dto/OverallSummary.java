package org.example.recs_shreyoshi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OverallSummary {
    private BigDecimal totalPurchase;
    private BigDecimal totalPaid;
    private BigDecimal totalDue;
}

