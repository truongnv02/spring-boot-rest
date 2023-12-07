package com.poly.truongnvph29176.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.poly.truongnvph29176.dto.SignupRequest;
import com.poly.truongnvph29176.entity.Customer;
import com.poly.truongnvph29176.repository.CustomerRepository;
import com.poly.truongnvph29176.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean createCustomer(SignupRequest signupRequest) {
        // check if customer already exist
        if(customerRepository.existsByEmail(signupRequest.getEmail())) {
            return false;
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(signupRequest, customer);

        // hash the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        customer.setPassword(hashPassword);
        customerRepository.save(customer);

        return true;
    }
}
