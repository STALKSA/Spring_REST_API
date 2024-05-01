package org.klozevitz.First_REST_API.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.First_REST_API.model.entities.Department;
import org.klozevitz.First_REST_API.services.interfaces.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public List<Department> all() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable int id) {
        try {
            return departmentService.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public Department save(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @PatchMapping
    public Department update(@RequestBody Department department) {
        return departmentService.update(department);
    }

    @DeleteMapping
    public boolean delete(@RequestParam int id) {
        return departmentService.deleteById(id);
    }
}
