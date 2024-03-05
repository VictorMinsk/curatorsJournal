package by.curatorsjournal.service;

import by.curatorsjournal.entity.Faculty;
import by.curatorsjournal.repository.FacultyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
@Service
public class FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    //получение списка всех факультетов
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    //получение факультета по id
    public Faculty getById(long facultyId) {
        return facultyRepository.getOne(facultyId);
    }
}
