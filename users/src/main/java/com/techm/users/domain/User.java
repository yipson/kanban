package com.techm.users.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public User(){}

    public User(String name,
                String lastName,
                String email,
                String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
