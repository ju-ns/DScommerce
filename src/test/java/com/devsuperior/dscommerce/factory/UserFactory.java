package com.devsuperior.dscommerce.factory;

import com.devsuperior.dscommerce.entities.Role;
import com.devsuperior.dscommerce.entities.User;

import java.time.LocalDate;

public class UserFactory {

    public static User createClientUser(){
        User user = new User(1L, "Maria", "maria@gmail.com", "98887699", LocalDate.parse("2001-07-25"),"$2a$10$S1TerH./s1XP8p0vim6nh.nOJgYKP2K8UuuidR2SOJIi9hRGNK7Pi");
        user.addRole(new Role(1L,"ROLE_CLIENT"));
        return user;
    }

    public static User createAdminUser(){
        User user = new User(2L, "Alex", "alex@gmail.com", "98887699", LocalDate.parse("1987-12-13"),"$2a$10$S1TerH./s1XP8p0vim6nh.nOJgYKP2K8UuuidR2SOJIi9hRGNK7Pi");
        user.addRole(new Role(2L,"ROLE_ADMIN"));
        return user;
    }

    public static User createCustomAdminUser(Long id, String userName){
        User user = new User(id, "Alex", userName, "98887699", LocalDate.parse("1987-12-13"),"$2a$10$S1TerH./s1XP8p0vim6nh.nOJgYKP2K8UuuidR2SOJIi9hRGNK7Pi");
        user.addRole(new Role(2L,"ROLE_ADMIN"));
        return user;
    }

    public static User createCustomClientUser(Long id, String userName){
        User user = new User(id, "maria", userName, "98887699", LocalDate.parse("2001-07-25"),"$2a$10$S1TerH./s1XP8p0vim6nh.nOJgYKP2K8UuuidR2SOJIi9hRGNK7Pi");
        user.addRole(new Role(1L,"ROLE_CLIENT"));
        return user;
    }
}
