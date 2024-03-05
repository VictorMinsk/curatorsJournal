package by.curatorsjournal.service;

import by.curatorsjournal.entity.Parent;
import by.curatorsjournal.entity.Student;
import by.curatorsjournal.repository.GroupRepository;
import by.curatorsjournal.repository.ParentRepository;
import by.curatorsjournal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor
 */
@Service
public class ParentService {
    @Autowired
    ParentRepository parentRepository;
      @Autowired
    private StudentRepository studentRepository;
    
    public void createParent(Parent parent, long studentId){
        parentRepository.save(parent);
        Student student=studentRepository.getOne(studentId);
       student.getParents().add(parent);
        studentRepository.save(student);
    }
}
