package org.klozevitz.First_REST_API.services.interfaces;

import org.klozevitz.First_REST_API.model.entities.Profession;

import java.util.List;

public interface ProfessionService extends DAO<Profession>{
    List<Profession> findByNoteLike(String notePart);
    List<Profession> findByNote(String notePart);
}
