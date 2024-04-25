package org.klozevitz.First_REST_API.model.repositories;

import org.klozevitz.First_REST_API.model.entities.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// опционально
@Repository
public interface ProfessionRepository extends JpaRepository<Profession, Integer> {
    List<Profession> findAllByNoteLike(String notePart);
    List<Profession> findAllByNote(String notePart);
}
