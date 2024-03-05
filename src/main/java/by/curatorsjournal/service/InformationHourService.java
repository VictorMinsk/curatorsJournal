package by.curatorsjournal.service;

import by.curatorsjournal.entity.Group;
import by.curatorsjournal.entity.InformationHour;
import by.curatorsjournal.repository.GroupRepository;
import by.curatorsjournal.repository.InformationHourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
@Service
public class InformationHourService {
    @Autowired
    private InformationHourRepository informationHourRepository;
    @Autowired
    private GroupRepository groupRepository;
    
    //создать инфорационный час
    public void createInformationHour(InformationHour informationHour, long groupId) {
        informationHourRepository.save(informationHour);
        groupId = 1;
        Group group = groupRepository.getOne(groupId);
        group.getInformationHours().add(informationHour);
        groupRepository.save(group);
    }
    
   
}
