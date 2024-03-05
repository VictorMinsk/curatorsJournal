package by.curatorsjournal.service;

import by.curatorsjournal.entity.Group;
import by.curatorsjournal.entity.Student;
import by.curatorsjournal.repository.GroupRepository;
import by.curatorsjournal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private GroupService groupService;
    
    
    public void createStudent(Student student, long groupId) {
        studentRepository.save(student);
       Group group = groupRepository.getOne(groupId);
        group.getStudents().add(student);
        groupRepository.save(group);
    }
    
    public Student getById(long studentId){
        return studentRepository.getOne(studentId);
    }
    
       @Modifying(clearAutomatically  = true)
    public boolean delStudent(long studentId) {
        long groupId=groupService.getGroupIdByStudent(studentId);
        Group group=groupRepository.getOne(groupId);
        if (group.getHead().getId()==studentId) return false;
          if (group.getVicehead().getId()==studentId) return false;
            if (group.getProfOrg().getId()==studentId) return false;
        studentRepository.deleteById(studentId);
       return true;

    }
    
     public long getGroupId(long studentId){
        return studentRepository.getGroupByStudentId(studentId); 
     }
}
