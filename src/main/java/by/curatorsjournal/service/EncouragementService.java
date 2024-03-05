package by.curatorsjournal.service;

import by.curatorsjournal.entity.Encouragement;
import by.curatorsjournal.entity.Student;
import by.curatorsjournal.repository.EncouragementRepository;
import by.curatorsjournal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
@Service
public class EncouragementService {

    @Autowired
    private EncouragementRepository encouragementRepository;
    @Autowired
    private StudentRepository studentRepository;

    //создать поощрение
    public void createEncouragement(Encouragement encouragement, long studentId) {
        encouragementRepository.save(encouragement);
        Student student = studentRepository.getOne(studentId);
        student.getEncouragements().add(encouragement);
        studentRepository.save(student);
    }
}
