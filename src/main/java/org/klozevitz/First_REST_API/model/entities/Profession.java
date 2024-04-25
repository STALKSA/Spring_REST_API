package org.klozevitz.First_REST_API.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profession_t")
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "note")
    private String note;

    public Profession(String name, String note) {
        this.name = name;
        this.note = note;
    }

    public void update(Profession profession) {
        name = profession.getName();
        note = profession.getNote();
    }
}
