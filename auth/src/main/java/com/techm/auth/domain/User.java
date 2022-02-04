package com.techm.auth.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private String lastName;
    private String email;
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
