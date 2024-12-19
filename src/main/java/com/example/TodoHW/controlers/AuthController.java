package com.example.TodoHW.controlers;

import com.example.TodoHW.model.dto.UserCreateRequest;
import com.example.TodoHW.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController

@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public String signup (@RequestBody UserCreateRequest request){
        return userService.createUser(request);

    }
}
