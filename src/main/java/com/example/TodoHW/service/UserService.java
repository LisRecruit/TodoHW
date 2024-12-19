package com.example.TodoHW.service;

import com.example.TodoHW.model.User;
import com.example.TodoHW.model.dto.UserCreateRequest;
import com.example.TodoHW.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String createUser (UserCreateRequest request) {
        if (userRepository.existsByUserName(request.userName())) {
           return "User already exists";
        }
        User user = User.builder()
                .userName(request.userName())
                .password(passwordEncoder.encode(request.password()))
                .enabled(Boolean.TRUE)
                .build();
        userRepository.save(user);
        return "createUser";
    }
    public User findByUserName (String userName){
        return userRepository.findByUserName(userName)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }

}
