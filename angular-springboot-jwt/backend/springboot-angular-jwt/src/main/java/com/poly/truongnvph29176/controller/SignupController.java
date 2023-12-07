package com.poly.truongnvph29176.controller;

import com.poly.truongnvph29176.dto.SignupRequest;
import com.poly.truongnvph29176.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignupController {
    private final AuthService authService;

    @PostMapping("")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {
        boolean isUserCreated = authService.createCustomer(signupRequest);
        if(isUserCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Customer created successfully");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create customer");
        }
    }
}
