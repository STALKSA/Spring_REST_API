package org.klozevitz.First_REST_API.services.implementations;

import org.klozevitz.First_REST_API.model.entities.Employee;
import org.klozevitz.First_REST_API.services.interfaces.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    // Вставьте необходимые операции для работы с сущностями Employee, такие как доступ к базе данных или работа с репозиторием

    @Override
    public List<Employee> findAll() {
        // Реализация получения всех сотрудников
        return null;
    }

    @Override
    public Employee findById(int id) throws Exception {
        // Реализация поиска сотрудника по идентификатору
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        // Реализация сохранения сотрудника
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        // Реализация обновления сотрудника
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        // Реализация удаления сотрудника
        return false;
    }
}
