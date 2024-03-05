package by.curatorsjournal.service;

import by.curatorsjournal.entity.DisciplinaryLiability;
import by.curatorsjournal.entity.Student;
import by.curatorsjournal.repository.DisciplinaryLiabilityRepository;
import by.curatorsjournal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
@Service
public class DisciplinaryLiabilityService {

    @Autowired
    private DisciplinaryLiabilityRepository disciplinaryLiabilityRepository;
    @Autowired
    private StudentRepository studentRepository;

    //создать дисциплинарное взыскание
    public void createDisciplinaryLiability(DisciplinaryLiability disciplinaryLiability, long studentId) {
        disciplinaryLiabilityRepository.save(disciplinaryLiability);
        Student student = studentRepository.getOne(studentId);
        student.getDisciplinaryLiabilities().add(disciplinaryLiability);
        studentRepository.save(student);
    }
}
