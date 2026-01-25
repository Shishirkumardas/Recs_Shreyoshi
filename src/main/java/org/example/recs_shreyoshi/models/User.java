package org.example.recs_shreyoshi.models;

import jakarta.persistence.*;
import lombok.*;
import org.example.recs_shreyoshi.enums.Role;


import java.util.UUID;


@Entity
@Table(name = "users")
@Data

public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;
    private String phone;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String address;



    public User() {}

    public User(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}

