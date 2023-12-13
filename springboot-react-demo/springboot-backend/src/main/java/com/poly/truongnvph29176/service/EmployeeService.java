package com.poly.truongnvph29176.service;

import com.poly.truongnvph29176.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee createEmployee(Employee employee);
    Employee findEmployeeById(Long id) throws Exception;
    Employee updateEmployee(Long id, Employee employee) throws Exception;
    Boolean deleteEmployee(Long id);
}
