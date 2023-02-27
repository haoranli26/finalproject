package com.example.demo.service;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.model.User;

public interface UserService {
    public void createUser();
    public User findUserByEmail(String email);
    User save(UserRegistrationDto registration);
}
