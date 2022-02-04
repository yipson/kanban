package com.techm.loginregister.repository;

import com.techm.loginregister.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findUserByEmail(String email);

    @Query("FROM User u WHERE u.email = ?1 AND u.password = ?2")
    List<User> verifyCredentials(String email, String password);
}
