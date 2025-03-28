package com.kensmith.entity;

import com.kensmith.enums.Role;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
    Boolean isActive = false;
    private LocalDateTime createdAt;
    private LocalDateTime LastLogin;
    private Boolean isVerified = false;
    private String fullName;
    private String phoneNumber;

    @OneToOne(mappedBy = "user")
    private Address address;
    @OneToMany(mappedBy ="user")
    private List<Transaction> transaction;

    @OneToOne(mappedBy = "user")
    private Cart cart;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<ShippingAddress> shippingAddress;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserAccountToken> userAccountToken;

}
