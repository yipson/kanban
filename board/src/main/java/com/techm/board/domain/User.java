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

    public User(){}

    public User(String name,
                String lastName,
                String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public User(Long id,
                String name,
                String lastName,
                String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }
}
