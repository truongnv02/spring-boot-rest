package com.poly.truongnvph29176.service;

import com.poly.truongnvph29176.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    boolean create(Employee employee);
    Employee findById(Long id);
    boolean update(Long id, Employee employee);
    boolean delete(Long id);
}
