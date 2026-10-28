package com.springboot.graphql.serviceImpl;

import com.springboot.graphql.entity.User;
import com.springboot.graphql.repository.UserRepository;
import com.springboot.graphql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private  final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found with given id: "+userId));
    }

    @Override
    public boolean deleteByUserId(Long userId) {
        User user =userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found with given id: "+userId));
        userRepository.delete(user);
        return  true;
    }

    @Override
    public User updateUser(
            Long id,
            String name,
            String email,
            String phone) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found with id : " + id));

        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);

        return userRepository.save(user);
    }
}
