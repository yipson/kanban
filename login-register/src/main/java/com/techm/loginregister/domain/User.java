package com.techm.loginregister.client;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {

    private Long id;
    private String name;
    private String lastName;

    @Email
    private String email;
    private String password;
}
