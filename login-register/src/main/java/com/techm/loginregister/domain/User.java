package com.techm.loginregister.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;

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

    @Email(message = "Please enter valid email")
    @Column(name = "email")
    private String email;

    @Length(min=8)
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
