package org.klozevitz.First_REST_API.services.interfaces;

import org.klozevitz.First_REST_API.model.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id) throws Exception;
    Employee save(Employee employee);
    Employee update(Employee employee);
    boolean deleteById(int id);
}
