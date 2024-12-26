package com.example.TodoHW.controllers;

import com.example.TodoHW.model.dto.AuthResponse;
import com.example.TodoHW.model.dto.UserCreateRequest;
import com.example.TodoHW.model.dto.UserLoginRequest;
import com.example.TodoHW.service.UserService;
import com.example.TodoHW.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;


@RestController

@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public String signup (@RequestBody UserCreateRequest request){
        return userService.createUser(request);

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest request) {
        try {
            System.out.println("Attempting login with username: " + request.userName());

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.userName(), request.password())
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(request.userName());
            String jwt = jwtUtil.generateToken(userDetails);

            return ResponseEntity.ok(new AuthResponse(jwt));
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }
    }
}
