package by.curatorsjournal.service;

import by.curatorsjournal.entity.Group;
import by.curatorsjournal.entity.Tradition;
import by.curatorsjournal.repository.GroupRepository;
import by.curatorsjournal.repository.TraditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
@Service
public class TraditionService {

    @Autowired
    private TraditionRepository traditionRepository;
    @Autowired
    private GroupRepository groupRepository;
      @Autowired
    private GroupService groupService;

    //создать традицию
    @Modifying(clearAutomatically = true)
    public void createTradition(Tradition tradition, long groupId) {
        traditionRepository.saveAndFlush(tradition);
        Group group = groupRepository.getOne(groupId);
        group.getTraditions().add(tradition);
        groupRepository.saveAndFlush(group);
        //  traditionRepository.commit();
    }
    
      //получить традицию по id
    public Tradition getById(long traditionId) {
        return traditionRepository.getOne(traditionId);
    }
    
      @Modifying(clearAutomatically  = true)
    public boolean delTradition(long traditionId) {
       /* long groupId=groupService.getGroupIdByStudent(studentId);
        Group group=groupRepository.getOne(groupId);*/
        traditionRepository.deleteById(traditionId);
       return true;

    }
}
