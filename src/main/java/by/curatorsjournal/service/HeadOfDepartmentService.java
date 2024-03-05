package by.curatorsjournal.service;

import by.curatorsjournal.entity.Cathedra;
import by.curatorsjournal.entity.HeadOfDepartment;
import by.curatorsjournal.repository.CathedraRepository;
import by.curatorsjournal.repository.HeadOfDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
@Service
public class HeadOfDepartmentService {

    @Autowired
    HeadOfDepartmentRepository headOfDepartmentRepository;
    @Autowired
    CathedraRepository cathedraRepository;

    //полуение заведующего кафедрой по имени пользователя
    public HeadOfDepartment getByUserId(String userName) {
        return getById(headOfDepartmentRepository.getHeadOfByUserId(userName).get(0));
    }

    //получение заведующего кафедрой по id
    public HeadOfDepartment getById(long headId) {
        return headOfDepartmentRepository.getOne(headId);
    }

    //создать заведующего кафедрой
    public void createHeadOfDepartment(HeadOfDepartment headOfDepartment, long cathedraId) {
        headOfDepartmentRepository.save(headOfDepartment);
        cathedraRepository.setHead(headOfDepartment.getId(), cathedraId);
    }

    //получить кафедру по ее заведующему
    public Cathedra getCathedra(long headId) {
        long cathedraId = headOfDepartmentRepository.getCathedraId(headId);
        return cathedraRepository.getOne(cathedraId);
    }
    
       //сохранить изменения в объекте заведующего кафедрой
    public void saveHeadOfDepartment(HeadOfDepartment headOfDepartment, long cathedraId) {
        HeadOfDepartment headOfDepartment2=headOfDepartmentRepository.getOne(headOfDepartment.getId());
        headOfDepartment.setUser(headOfDepartment2.getUser());
        headOfDepartmentRepository.save(headOfDepartment);
    }
}
