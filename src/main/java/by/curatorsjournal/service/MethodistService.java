package by.curatorsjournal.service;

import by.curatorsjournal.entity.Faculty;
import by.curatorsjournal.entity.Methodist;
import by.curatorsjournal.repository.FacultyRepository;
import by.curatorsjournal.repository.MethodistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
@Service
public class MethodistService {

    @Autowired
    MethodistRepository methodistRepository;
    @Autowired
    FacultyRepository facultyRepository;

    //получить методиста по id
    public Methodist getById(long methodistId) {
        return methodistRepository.getOne(methodistId);
    }

    //получить методиста по id пользователя
    public Methodist getByUserId(String userName) {
        return getById(methodistRepository.getMethodistByUserId(userName).get(0));
    }

    //создать методиста
    public void createMethodist(Methodist methodist, long facultyId) {
        methodistRepository.save(methodist);
        Faculty faculty = facultyRepository.getOne(facultyId);
        faculty.getMethodists().add(methodist);
        facultyRepository.save(faculty);
    }

    //получить факультет методиста
    public Faculty getFaculty(long methodistId) {
        long facultyId = methodistRepository.getFacultyId(methodistId).get(0);
        return facultyRepository.getOne(facultyId);
    }
    
     //сохранить изменения в объекте методиста
    public void saveMethodist(Methodist methodist, long facultyId) {
        Methodist methodist2=methodistRepository.getOne(methodist.getId());
        methodist.setUser(methodist2.getUser());
        methodistRepository.save(methodist);
    }

    
}
