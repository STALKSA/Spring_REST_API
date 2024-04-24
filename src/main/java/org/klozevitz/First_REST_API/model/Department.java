package org.klozevitz.First_REST_API.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Department {
    private Integer id;
    private String name;
    private String note;
    private Department parent;

    public Department(String name, String note, Department parent) {
        this.name = name;
        this.note = note;
        this.parent = parent;
    }
}
