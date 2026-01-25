package org.example.recs_shreyoshi.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    // NO password, NO orders list!
}
