package com.poly.truongnvph29176.controller;

import com.poly.truongnvph29176.model.Employee;
import com.poly.truongnvph29176.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<?> getAllEmployees() {
        List<Employee> list = employeeService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable("id") Long id) throws Exception {
        Employee employee = employeeService.findEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee,
                                            BindingResult result) {
        try {
            if(result.hasErrors()) {
                List<String> errorMessage = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessage);
            }else {
                Employee createEmployee = employeeService.createEmployee(employee);
                return ResponseEntity.ok(createEmployee);
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> createEmployee(@PathVariable("id") Long id,
                                            @Valid @RequestBody Employee employee,
                                            BindingResult result) {
        try {
            if(result.hasErrors()) {
                List<String> errorMessage = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessage);
            }else {
                Employee updateEmployee = employeeService.updateEmployee(id, employee);
                return ResponseEntity.ok(updateEmployee);
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        boolean isDeleted = employeeService.deleteEmployee(id);
        if(isDeleted) {
            return ResponseEntity.ok("Deleted successfully");
        }else {
            return ResponseEntity.badRequest().body("Cannot find with id = " + id);
        }
    }
}
