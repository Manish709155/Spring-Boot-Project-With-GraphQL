package com.springboot.graphql.controller;

import com.springboot.graphql.entity.User;
import com.springboot.graphql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email, @Argument String phone){
        User user =new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        return userService.createUser(user);
    }

    @QueryMapping
    public List<User> getAllUser(){
       return userService.getAllUser();
    }

    @QueryMapping
    public  User getUser(@Argument Long userId){

        return  userService.getUser(userId);
    }

    @MutationMapping
    public  boolean deleteUser(@Argument Long userId){

        return  userService.deleteByUserId(userId);
    }
    @MutationMapping
    public User updateUser(
            @Argument Long id,
            @Argument String name,
            @Argument String email,
            @Argument String phone) {

        return userService.updateUser(
                id,
                name,
                email,
                phone
        );
    }
}
