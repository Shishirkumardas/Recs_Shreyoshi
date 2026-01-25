package org.example.recs_shreyoshi.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.recs_shreyoshi.enums.Role;

@Getter
@Setter
public class SignupRequest {
    private String email;
    private String password;
    private Role role; // ADMIN or CUSTOMER (optional)
}

