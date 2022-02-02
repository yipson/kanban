package com.techm.users.bootstrap;

import com.techm.users.domain.User;
import com.techm.users.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


//@Configuration
//public class UserBootstrap {
//
//    @Bean
//    CommandLineRunner commandLineRunner(
//            UserRepository repository) {
//        return args -> {
//
//            User user = new User(
//                    "Sebastian",
//                    "Valencia",
//                    "sebastian@mail.com",
//                    "1234"
//            );
//
//            User user2 = new User(
//                    "Andrea",
//                    "Gomez",
//                    "andrea@mail.com",
//                    "1234"
//            );
//
//            repository.saveAll(
//                    List.of(user,user2)
//            );
//        };
//    }
//}
