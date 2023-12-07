package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.entity.Employee;
import com.poly.truongnvph29176.repository.EmployeeRepository;
import com.poly.truongnvph29176.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.fetchAll();
    }

    @Override
    public boolean create(Employee employee) {
        return employeeRepository.create(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public boolean update(Long id, Employee employee) {
        return employeeRepository.update(id, employee);
    }

    @Override
    public boolean delete(Long id) {
        return employeeRepository.delete(id);
    }
}
