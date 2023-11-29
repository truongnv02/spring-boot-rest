package com.poly.truongnvph29176.service;

import com.poly.truongnvph29176.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    void create(Employee employee);
    Employee findById(Long id);
    void update(Long id, Employee employee);
    void delete(Long id);
}
