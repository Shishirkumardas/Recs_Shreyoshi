package org.example.recs_shreyoshi.dto;

import lombok.Data;

@Data
public class UpdateCartRequest {
    private Long itemId;
    private int quantity;
}
