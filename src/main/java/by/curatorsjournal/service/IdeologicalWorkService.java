package by.curatorsjournal.service;

import by.curatorsjournal.entity.Group;
import by.curatorsjournal.entity.IdeologicalWork;
import by.curatorsjournal.repository.GroupRepository;
import by.curatorsjournal.repository.IdeologicalWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
@Service
public class IdeologicalWorkService {

    @Autowired
    private IdeologicalWorkRepository ideologicalWorkRepository;
    @Autowired
    private GroupRepository groupRepository;

    //создать идеологическую работу
    public void createIdeologicalWork(IdeologicalWork ideologicalWork, long groupId) {
        ideologicalWorkRepository.save(ideologicalWork);
        Group group = groupRepository.getOne(groupId);
        group.getIdeologicalWorks().add(ideologicalWork);
        groupRepository.save(group);
    }
}
