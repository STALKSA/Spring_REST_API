package org.klozevitz.First_REST_API.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.First_REST_API.model.entities.Employee;
import org.klozevitz.First_REST_API.services.interfaces.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> all() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable int id) {
        try {
            return employeeService.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PatchMapping
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping
    public boolean delete(@RequestParam int id) {
        return employeeService.deleteById(id);
    }
}

