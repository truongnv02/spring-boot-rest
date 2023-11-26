package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.model.Employee;
import com.poly.truongnvph29176.repository.EmployeeRepository;
import com.poly.truongnvph29176.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
