package com.poly.truongnvph29176.service;

import com.poly.truongnvph29176.dto.LoginDTO;
import com.poly.truongnvph29176.dto.RegisterDTO;
import com.poly.truongnvph29176.entity.User;

public interface UserService {
    User register(RegisterDTO registerDTO);
    String verifyAccount(String email, String otp);
    String regenerateOtp(String email);
    String login(LoginDTO loginDTO);
}
