package com.techm.board.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String port;

    public User(){}

    public User(String name,
                String lastName,
                String email,
                String password,
                String port) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(Long id,
                String name,
                String lastName,
                String email,
                String password,
                String port) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}