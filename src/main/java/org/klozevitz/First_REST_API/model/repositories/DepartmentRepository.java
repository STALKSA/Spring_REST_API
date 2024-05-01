package org.klozevitz.First_REST_API.model.repositories;

import org.klozevitz.First_REST_API.model.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findAllByDepartmentNameContaining(String partOfName);
}
