package org.klozevitz.First_REST_API.services.implementations;

import lombok.RequiredArgsConstructor;
import org.klozevitz.First_REST_API.model.entities.Department;
import org.klozevitz.First_REST_API.model.repositories.DepartmentRepository;
import org.klozevitz.First_REST_API.services.interfaces.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DepartmentServiceImplementation implements DepartmentService {
    private final DepartmentRepository repo;

    @Override
    public List<Department> findAll() {
        return repo.findAll();
    }

    @Override
    public Department findById(int id) throws Exception {
        return repo.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public Department save(Department department) {
        if (department.getId() == null) {
            return repo.save(department);
        }
        return null;
    }

    @Override
    public Department update(Department department) {
        if (!repo.existsById(department.getId())) {
            return null;
        }
        Department departmentToUpdate = repo.findById(department.getId()).get();
        departmentToUpdate.update(department);
        repo.save(departmentToUpdate);
        return departmentToUpdate;
    }

    @Override
    public boolean deleteById(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Department> findByDepartmentNameContaining(String partOfName) {
        return repo.findAllByDepartmentNameContaining(partOfName);
    }
}

