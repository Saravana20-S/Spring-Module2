//package com.bridgelabz.module2.config;
//
//import com.bridgelabz.module2.entity.User;
//import com.bridgelabz.module2.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DataInitializer {
//
//    @Bean
//    public CommandLineRunner loadData(UserRepository userRepository) {
//
//        return args -> {
//
//            User user = new User();
//
//            user.setUsername("karthik");
//            user.setPassword("12345");
//
//            userRepository.save(user);
//
//            System.out.println("Default user added successfully");
//        };
//    }
//}