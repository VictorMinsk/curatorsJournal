package by.curatorsjournal.service;

import by.curatorsjournal.entity.Discipline;
import by.curatorsjournal.entity.Faculty;
import by.curatorsjournal.repository.DisciplineRepository;
import by.curatorsjournal.repository.FacultyRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
@Service
public class DisciplineService {

  @Autowired
  DisciplineRepository disciplineRepository;
  
  public List<Discipline> getExamsForGroup(long groupId){
      List<Discipline> disciplines=new ArrayList<Discipline>();
      List<Long>disciplinesId=disciplineRepository.getDisciplinesForGroup(groupId, 1);
      disciplinesId.forEach(discId->disciplines.add( disciplineRepository.getOne(discId)));
      Collections.sort(disciplines, Comparator.comparing(Discipline::getName));
      return disciplines;
  }
  
  public List<Discipline> getSetOffsForGroup(long groupId){
      List<Discipline> disciplines=new ArrayList<Discipline>();
      List<Long>disciplinesId2=disciplineRepository.getDisciplinesForGroup(groupId, 2);
        List<Long>disciplinesId3=disciplineRepository.getDisciplinesForGroup(groupId, 3);
      disciplinesId2.forEach(discId->disciplines.add( disciplineRepository.getOne(discId)));
        disciplinesId3.forEach(discId->disciplines.add( disciplineRepository.getOne(discId)));
          Collections.sort(disciplines, Comparator.comparing(Discipline::getName));
      return disciplines;
  }
  
  public List<Discipline> getCourseProjectsForGroup(long groupId){
      List<Discipline> disciplines=new ArrayList<Discipline>();
      List<Long>disciplinesId=disciplineRepository.getDisciplinesForGroup(groupId, 4);
      disciplinesId.forEach(discId->disciplines.add( disciplineRepository.getOne(discId)));
        Collections.sort(disciplines, Comparator.comparing(Discipline::getName));
      return disciplines;
  }
}
