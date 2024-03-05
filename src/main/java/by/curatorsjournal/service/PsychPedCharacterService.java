package by.curatorsjournal.service;

import by.curatorsjournal.entity.Group;
import by.curatorsjournal.entity.PsychPedCharacter;
import by.curatorsjournal.repository.GroupRepository;
import by.curatorsjournal.repository.PsychPedCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
@Service
public class PsychPedCharacterService {
    @Autowired
    PsychPedCharacterRepository psychPedCharacterRepository;
    @Autowired
    GroupRepository groupRepository;
    
    //создать психолого-педагогическую характеристику
     public void createPsychPedCharacter(PsychPedCharacter psychPedCharacter, long groupId) {
        psychPedCharacterRepository.save(psychPedCharacter);
        Group group = groupRepository.getOne(groupId);
        group.getPsychPedCharacters().add(psychPedCharacter);
        groupRepository.save(group);
    }
    
}
