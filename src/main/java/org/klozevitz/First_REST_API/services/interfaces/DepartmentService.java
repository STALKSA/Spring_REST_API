package org.klozevitz.First_REST_API.services.interfaces;

import org.klozevitz.First_REST_API.model.entities.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
    Department findById(int id) throws Exception;
    Department save(Department department);
    Department update(Department department);
    boolean deleteById(int id);
}
