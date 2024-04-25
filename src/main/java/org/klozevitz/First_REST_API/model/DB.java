package org.klozevitz.First_REST_API.model;

import lombok.Data;
import org.klozevitz.First_REST_API.model.entities.Department;
import org.klozevitz.First_REST_API.model.entities.Employee;
import org.klozevitz.First_REST_API.model.entities.Profession;

import java.util.LinkedList;

@Data
public class DB {
    private LinkedList<Department> departments;
    private LinkedList<Profession> professions;
    private LinkedList<Employee> employees;

    public DB() {
        departments = new LinkedList<>();
        deptsInit();
        professions = new LinkedList<>();
        employees = new LinkedList<>();
    }

    public int getLastId(LinkedList<?> list) {
        if (list.isEmpty())
            return 0;
        Object obj = list.getLast();
        if (obj instanceof Department)
            return ((Department) obj).getId();
        if (obj instanceof Profession)
            return ((Profession) obj).getId();
        if (obj instanceof Employee)
            return ((Employee) obj).getId();
        return -1;
    }

    private void deptsInit() {
        Department root1 = new Department(1, "DB", "корневой отдел по разработке DB", null);
        departments.add(root1);
        Department dev1 = new Department(2, "DevDB", "родитель - 1 - DB", root1);
        departments.add(dev1);
        Department dev1dev = new Department(3, "Dev", "родитель - 2 - Dev", dev1);
        departments.add(dev1dev);
        Department dev1test = new Department(4, "Test", "родитель - 2 - Dev", dev1);
        departments.add(dev1test);
        Department dev1design = new Department(5, "Design", "родитель - 2 - Dev", dev1);
        departments.add(dev1design);
        Department mark1 = new Department(6, "MarkDB", "родитель - 1 - DB", root1);
        departments.add(mark1);
        Department mark1cc = new Department(7, "Call-center", "родитель - 6 Markdb", mark1);
        departments.add(mark1cc);
        Department mark1med = new Department(8, "Media", "родитель - 6 Markdb", mark1);
        departments.add(mark1med);
        Department acc = new Department(9, "Accounting", "родитель - 1 - DB", root1);
        departments.add(acc);
    }
}
