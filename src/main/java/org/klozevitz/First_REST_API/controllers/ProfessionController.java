package org.klozevitz.First_REST_API.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.First_REST_API.model.entities.Profession;
import org.klozevitz.First_REST_API.services.interfaces.ProfessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profession")
@RequiredArgsConstructor
public class ProfessionController {
    private final ProfessionService professionService;

    @GetMapping
    public List<Profession> all() {
        return professionService.findAll();
    }

    @GetMapping("/{id}")
    public Profession findById(@PathVariable int id) {
        try {
            return professionService.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/findByNoteLike")
    public List<Profession> findByNoteLike(@RequestParam String notePart) {
        return professionService.findByNoteLike("%".concat(notePart).concat("%"));
    }

    @GetMapping("/findByNote")
    public List<Profession> findByNote(@RequestParam String notePart) {
        return professionService.findByNote(notePart);
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
        return professionService.save(profession);
    }

    @PatchMapping
    public Profession update(@RequestBody Profession profession) {
        return professionService.update(profession);
    }

    @DeleteMapping
    public boolean delete(@RequestParam int id) {
        return professionService.deleteById(id);
    }
}
