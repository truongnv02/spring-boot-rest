package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.entity.Employee;
import com.poly.truongnvph29176.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private static final String EMPLOYEE_KEY = "Employee";

    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, Employee> hashOperations;

    @Override
    public List<Employee> findAll() {
        return hashOperations.values(EMPLOYEE_KEY);
    }

    @Override
    public void create(Employee employee) {
        hashOperations.put(EMPLOYEE_KEY, employee.getId(), employee);
    }

    @Override
    public Employee findById(Long id) {
        return null;
    }

    @Override
    public void update(Long id, Employee employee) {
        hashOperations.put(EMPLOYEE_KEY, employee.getId(), employee);
    }

    @Override
    public void delete(Long id) {
        hashOperations.delete(EMPLOYEE_KEY, id);
    }
}
