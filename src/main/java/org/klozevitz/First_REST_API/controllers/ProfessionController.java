package org.klozevitz.First_REST_API.controllers;

import org.klozevitz.First_REST_API.model.DB;
import org.klozevitz.First_REST_API.model.Profession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profession")
public class ProfessionController {
    private final DB db = new DB();

    @GetMapping
    public List<Profession> all() {
        return db.getProfessions();
    }

    @GetMapping("/{id}")
    public Profession findById(@PathVariable int id) {
        return db.getProfessions().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

//    @PostMapping()
//    public Profession save(@RequestParam String name, @RequestParam String note) {
//        Profession profession = new Profession(name, note);
//        profession.setId(db.getLastId(db.getProfessions()) + 1);
//        db.getProfessions().add(profession);
//        return profession;
//    }

    @PostMapping
    public Profession save(@RequestBody Profession profession) {
        profession.setId(db.getLastId(db.getProfessions()) + 1);
        db.getProfessions().add(profession);
        return profession;
    }

    @PatchMapping
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

    @DeleteMapping
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
