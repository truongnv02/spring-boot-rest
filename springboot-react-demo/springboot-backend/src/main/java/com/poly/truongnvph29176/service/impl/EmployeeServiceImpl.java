package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.exception.DataNotFoundException;
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
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) throws Exception {
        return employeeRepository.findById(id).orElseThrow(() ->
                new DataNotFoundException("Cannot find Employee with id = " + id));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) throws Exception {
        Employee idEmployee = findEmployeeById(id);
        idEmployee.setFirstName(employee.getFirstName());
        idEmployee.setLastName(employee.getLastName());
        idEmployee.setEmailId(employee.getEmailId());
        employeeRepository.save(idEmployee);
        return idEmployee;
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
