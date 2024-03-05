package by.curatorsjournal.service;

import by.curatorsjournal.entity.Cathedra;
import by.curatorsjournal.repository.CathedraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
@Service
public class CathedraService {

    @Autowired
    CathedraRepository cathedraRepository;

    //получение кафедры по id
    public Cathedra getById(long cathedraId) {
        return cathedraRepository.getOne(cathedraId);
    }
}
