package org.klozevitz.First_REST_API.controllers;

import org.klozevitz.First_REST_API.model.DB;
import org.klozevitz.First_REST_API.model.entities.Profession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professions")
public class ProfessionControllerAlt {
    private final DB db = new DB();

    @GetMapping("/all")
    public List<Profession> all() {
        return db.getProfessions();
    }

    @GetMapping("/findById")
    public Profession findById(@RequestParam int id) {
        return db.getProfessions().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

//    @PostMapping("/save")
//    public Profession save(@RequestParam String name, @RequestParam String note) {
//        Profession profession = new Profession(name, note);
//        profession.setId(db.getLastId(db.getProfessions()) + 1);
//        db.getProfessions().add(profession);
//        return profession;
//    }

    @PostMapping("/save")
    public Profession save(@RequestBody Profession profession) {
        profession.setId(db.getLastId(db.getProfessions()) + 1);
        db.getProfessions().add(profession);
        return profession;
    }

    @PostMapping("/update")
    public Profession update(@RequestBody Profession profession) throws IllegalAccessException {
        if (profession.getId() != null) {
            Profession professionToUpdate = db.getProfessions().stream()
                    .filter(p -> p.getId() == profession.getId())
                    .findFirst()
                    .get();

            professionToUpdate.setName(profession.getName());
            professionToUpdate.setNote(profession.getNote());
            return profession;
        }
        return null;
    }

    @PostMapping("/delete")
    public boolean delete(@RequestParam int id) {
        Profession professionToDelete = db.getProfessions().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        if (professionToDelete == null)
            return false;

        db.getProfessions().remove(professionToDelete);
        return true;
    }
}
