package org.example.recs_shreyoshi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class AccounceFormDTO {
    private LocalDate date;
    private String name;
    private String expenseHead;
    private BigDecimal expenseAmount;
}
