package com.poly.truongnvph29176.service;

import com.poly.truongnvph29176.dto.SignupRequest;

public interface AuthService {
    boolean createCustomer(SignupRequest signupRequest);
}
