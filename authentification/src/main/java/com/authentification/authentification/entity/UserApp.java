package com.authentification.authentification.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserApp {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String pseudo;

    private String password;

    public UserApp(String pseudo, String encodedPassword) {
        this.pseudo = pseudo;
        this.password = encodedPassword;
    }
}
