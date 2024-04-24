package org.klozevitz.First_REST_API.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee  {
    private Integer id;
    private String fio;
    private String note;
    private Department department;
    private Profession profession;

    public Employee(String fio, String note, Department department, Profession profession) {
        this.fio = fio;
        this.note = note;
        this.department = department;
        this.profession = profession;
    }
}
