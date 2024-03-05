package by.curatorsjournal.service;

import by.curatorsjournal.entity.Discipline;
import by.curatorsjournal.entity.Student;
import by.curatorsjournal.repository.ProgressRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
@Service
public class ProgressService {
      @Autowired
    ProgressRepository progressRepository;
           @Autowired
    GroupService groupService;
               @Autowired
    DisciplineService disciplineService;
      
    //получение успеваемости для группы
    public String[][]getMarksForGroup(long groupId){
        List<Student>students=groupService.getStudentsOfGroup(groupId);
        List<Discipline>disciplines=disciplineService.getExamsForGroup(groupId);
     disciplines.addAll(disciplineService.getSetOffsForGroup(groupId));
        disciplines.addAll(disciplineService.getCourseProjectsForGroup(groupId));
        String[][]marks=new String[students.size()][disciplines.size()+1];
       for (int i=0; i<marks.length; i++)
           marks[i][0]=students.get(i).getSurname()+" "+students.get(i).getName()+" "+students.get(i).getPatronymic();
             for (int i=0; i<marks.length; i++)
                 for (int j=0; j<marks[0].length-1; j++)
                 {
                     byte mark=progressRepository.getProgress(students.get(i).getId(), disciplines.get(j).getId());
                     if (mark==11) marks[i][j+1]="зачтено";
                     else if (mark==-1) marks[i][j+1]="не зачтено";
                     else if (mark==0) marks[i][j+1]=" ";
                     else marks[i][j+1]=String.valueOf(mark);
                 }
        return marks;
    }
}
