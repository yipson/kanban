package com.techm.users.service;

import com.techm.users.domain.User;
import com.techm.users.repository.UserRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getOneUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()){
            return userOptional;
        }

        throw new IllegalStateException("invalid user id");
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

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

    @Override
    public User returnUserByCredentials(User user) {
        List<User> isUserPresent =
                userRepository.verifyCredentials(user.getEmail());

        if(isUserPresent.isEmpty()){
            return null;
        }

        String passwordHashed = isUserPresent.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed,user.getPassword())){
            return isUserPresent.get(0);
        }
        return null;
    }

}
