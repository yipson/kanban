package com.techm.loginregister.service;

import com.techm.loginregister.domain.User;
import com.techm.loginregister.repository.UserRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {

        if(user.getName() == null ||
                user.getName().length() == 0){
            throw new IllegalStateException("Field Name is required");
        }

        if(user.getLastName() == null ||
                user.getLastName().length() == 0){
            throw new IllegalStateException("Field Last Name is required");
        }

        if(user.getEmail() == null ||
                user.getEmail().length() == 0){
            throw new IllegalStateException("Field Email is required");
        }

        if(user.getPassword() == null ||
                user.getPassword().length() == 0){
            throw new IllegalStateException("Field Email is required");
        }

        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());

        if (userOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String passwordHashed = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(passwordHashed);

        userRepository.save(user);
    }
}
