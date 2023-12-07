package com.poly.truongnvph29176.repository;

import com.poly.truongnvph29176.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private final HashOperations<String, Long, Employee> hashOperations;
    private static final String EMPLOYEE_KEY = "Employee";

    public boolean create(Employee employee) {
        try {
            redisTemplate.opsForHash().put(EMPLOYEE_KEY, employee.getId().toString(), employee);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Employee findById(Long id) {
        return (Employee) redisTemplate.opsForHash().get(EMPLOYEE_KEY, id.toString());
    }

    public List<Employee> fetchAll() {
        return hashOperations.values(EMPLOYEE_KEY);
    }

    public boolean delete(Long id) {
        try {
            redisTemplate.opsForHash().delete(EMPLOYEE_KEY, id.toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Long id, Employee employee) {
        try {
            redisTemplate.opsForHash().put(EMPLOYEE_KEY, id, employee);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
