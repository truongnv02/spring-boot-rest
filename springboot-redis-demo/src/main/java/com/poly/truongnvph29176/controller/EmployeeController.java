package com.poly.truongnvph29176.controller;

import com.poly.truongnvph29176.entity.Employee;
import com.poly.truongnvph29176.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<?> getAllEmployee() {
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }
}
