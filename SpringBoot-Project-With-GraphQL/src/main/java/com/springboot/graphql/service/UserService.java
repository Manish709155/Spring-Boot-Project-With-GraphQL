package com.springboot.graphql.service;

import com.springboot.graphql.entity.User;
import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUser();

    User getUser(Long userId);

    public  boolean deleteByUserId(Long userId);

    User updateUser(
            Long id,
            String name,
            String email,
            String phone
    );
}
