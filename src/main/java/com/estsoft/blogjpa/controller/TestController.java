package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.domain.User;
import com.estsoft.blogjpa.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private UserRepository userRepository;

    public TestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/test/{email}")
    public List<User> userList(@PathVariable String email) {
        return userRepository.findAllByEmail(email);
    }
}
