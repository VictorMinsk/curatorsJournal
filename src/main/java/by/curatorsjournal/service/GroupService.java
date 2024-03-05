package by.curatorsjournal.service;

import by.curatorsjournal.entity.Discipline;
import by.curatorsjournal.entity.Group;
import by.curatorsjournal.entity.IdeologicalWork;
import by.curatorsjournal.entity.InformationHour;
import by.curatorsjournal.entity.Progress;
import by.curatorsjournal.entity.PsychPedCharacter;
import by.curatorsjournal.entity.Speciality;
import by.curatorsjournal.entity.Student;
import by.curatorsjournal.entity.Tradition;
import by.curatorsjournal.repository.GroupRepository;
import by.curatorsjournal.repository.StudentRepository;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
@Service
public class GroupService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GroupRepository groupRepository;
     @Autowired
    private SpecialityService specialityService;

    //получить список студентов группы
    @Modifying(clearAutomatically = true)
    public List<Student> getStudentsOfGroup(long groupId) {
        Group g = groupRepository.getOne(groupId);
        List<Student> students=g.getStudents();
        Collections.sort(students, Comparator.comparing(Student::getSurname));
        return g.getStudents();
    }

    //получение списка информационных часов группы
    @Modifying(clearAutomatically = true)
    public List<InformationHour> getInfoHoursOfGroup(long groupId) {
        Group g = groupRepository.getOne(groupId);
        return g.getInformationHours();
    }

    //получение списка традиций группы
    public List<Tradition> getTraditionsOfGroup(long groupId) {
        Group g = groupRepository.getOne(groupId);
        return g.getTraditions();
    }

    //получение психолого-педагогической характеристики группы
    public List<PsychPedCharacter> getCharacteristicsOfGroup(long groupId) {
        Group g = groupRepository.getOne(groupId);
        return g.getPsychPedCharacters();
    }

    //получение списка идеологической и воспитательной работы
    public List<IdeologicalWork> getIdeologicalWorkOfGroup(long groupId) {
        Group g = groupRepository.getOne(groupId);
        return g.getIdeologicalWorks();
    }
    
     public List<Discipline> getDisciplinesOfGroup(long groupId) {
        Speciality speciality=specialityService.getSpecialityOfGroup(groupId);
        return speciality.getDisciplines();
    }

    //сохранить актив группы
    public void saveActive(Group group, long groupId) {
        long headId = Long.parseLong(group.getHead().getSurname().split(" ")[0]);
        long viceheadId = Long.parseLong(group.getVicehead().getSurname().split(" ")[0]);
        long profOrgId = Long.parseLong(group.getProfOrg().getSurname().split(" ")[0]);
        groupRepository.setGroupActive(groupId, headId, viceheadId, profOrgId);
    }

    //получить группы по id
    public Group getById(long groupId) {
        return groupRepository.getOne(groupId);
    }

    //получение группы по id студента
    public long getGroupIdByStudent(long studentId) {
        return studentRepository.getGroupByStudentId(studentId);
    }

}
