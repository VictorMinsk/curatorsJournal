package by.curatorsjournal.service;

import by.curatorsjournal.entity.Cathedra;
import by.curatorsjournal.entity.Curator;
import by.curatorsjournal.entity.Group;
import by.curatorsjournal.repository.CathedraRepository;
import by.curatorsjournal.repository.CuratorRepository;
import by.curatorsjournal.repository.GroupRepository;
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
public class CuratorService {

    @Autowired
    CuratorRepository curatorRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    UserService userService;
    @Autowired
    CathedraRepository cathedraRepository;

    //получение списка групп куратора
    public List<Group> getGroups(long curatorId) {
        List<Long> groupsId = curatorRepository.getGroupsByCuratorId(curatorId);
        List<Group> groupList = new ArrayList<Group>();
        groupsId.forEach(gId -> groupList.add(groupRepository.getOne(gId)));
        return groupList;
    }

    //получение куратора по id
    public Curator getById(long curatorId) {
        return curatorRepository.getOne(curatorId);
    }

    //получение куратора по id пользователя
    public Curator getByUserId(String userName) {
        return getById(curatorRepository.getCuratorByUserId(userName).get(0));
    }

    //создать куратора
    public void createCurator(Curator curator, long cathedraId) {
        curatorRepository.save(curator);
        Cathedra cathedra = cathedraRepository.getOne(cathedraId);
        cathedra.getCurators().add(curator);
        cathedraRepository.save(cathedra);
    }

    //сохранить куратора
    public void saveCurator(Curator curator) {
         Curator curator2=curatorRepository.getOne(curator.getId());
        curator.setUser(curator2.getUser());
        curatorRepository.save(curator);
    }
}
