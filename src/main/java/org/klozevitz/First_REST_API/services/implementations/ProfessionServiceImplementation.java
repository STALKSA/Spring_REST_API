package org.klozevitz.First_REST_API.services.implementations;

import lombok.RequiredArgsConstructor;
import org.klozevitz.First_REST_API.model.entities.Profession;
import org.klozevitz.First_REST_API.model.repositories.ProfessionRepository;
import org.klozevitz.First_REST_API.services.interfaces.ProfessionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionServiceImplementation implements ProfessionService {
    private final ProfessionRepository repo;

    @Override
    public List<Profession> findAll() {
        return repo.findAll();
    }

    @Override
    public Profession findById(int id) throws Exception {
        return repo.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public Profession save(Profession profession) {
        if (profession.getId() == null) {
            return repo.save(profession);
        }
        return null;
    }

    @Override
    public Profession update(Profession profession) {
        if (!repo.existsById(profession.getId())) {
            return null;
        }
        Profession professionToUpdate = repo.findById(profession.getId()).get();
        professionToUpdate.update(profession);
        repo.save(professionToUpdate);
        return professionToUpdate;
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
    public List<Profession> findByNoteLike(String notePart) {
        return repo.findAllByNoteLike(notePart);
    }

    @Override
    public List<Profession> findByNote(String notePart) {
        return repo.findAllByNote(notePart);
    }
}
