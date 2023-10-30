package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.dto.LoginDTO;
import com.poly.truongnvph29176.dto.RegisterDTO;
import com.poly.truongnvph29176.entity.User;
import com.poly.truongnvph29176.repository.UserRepository;
import com.poly.truongnvph29176.service.UserService;
import com.poly.truongnvph29176.util.EmailUtil;
import com.poly.truongnvph29176.util.OtpUtil;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OtpUtil otpUtil;
    @Autowired
    private EmailUtil emailUtil;

    @Override
    public User register(RegisterDTO registerDTO) {
        String otp = otpUtil.generateOtp();
        try {
            emailUtil.sendOtpEmail(registerDTO.getEmail(), otp);
        } catch (MessagingException e) {
            throw new RuntimeException("Unable to send otp please try again");
        }
        User user = User.builder()
                .name(registerDTO.getName())
                .email(registerDTO.getEmail())
                .password(registerDTO.getPassword())
                .otp(otp)
                .optGeneratedTime(LocalDateTime.now())
                .build();
        return userRepository.save(user);
    }

    @Override
    public String verifyAccount(String email, String otp) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with this email : " + email));
        if(user.getOtp().equals(otp) &&
                Duration.between(user.getOptGeneratedTime(), LocalDateTime.now()).getSeconds() < (1 * 60)) {
            user.setActive(true);
            userRepository.save(user);
            return "OTP verify you can login";
        }
        return "Please regenerate otp and try again";
    }

    @Override
    public String regenerateOtp(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with this email : " + email));
        String otp = otpUtil.generateOtp();
        try {
            emailUtil.sendOtpEmail(email, otp);
        } catch (MessagingException e) {
            throw new RuntimeException("Unable to send otp please try again");
        }
        user.setOtp(otp);
        user.setOptGeneratedTime(LocalDateTime.now());
        userRepository.save(user);
        return "Email sent... please verify account within 1 minute";
    }

    @Override
    public String login(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(
                        () -> new RuntimeException("User not found with this email: " + loginDTO.getEmail()));
        if (!loginDTO.getPassword().equals(user.getPassword())) {
            return "Password is incorrect";
        } else if (!user.isActive()) {
            return "your account is not verified";
        }
        return "Login successful";
    }
}
