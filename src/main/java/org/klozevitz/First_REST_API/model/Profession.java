package org.klozevitz.First_REST_API.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profession {
    private Integer id;
    private String name;
    private String note;

    public Profession(String name, String note) {
        this.name = name;
        this.note = note;
    }
}
