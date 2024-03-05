package by.curatorsjournal.service;

import by.curatorsjournal.entity.Speciality;
import by.curatorsjournal.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
@Service
public class SpecialityService {

    @Autowired
    SpecialityRepository specialityRepository;

    //получить специальность по id
    public Speciality getById(long specialityId) {
        return specialityRepository.getOne(specialityId);
    }
    
    //получение специальности группы
    public Speciality getSpecialityOfGroup(long groupId){
        return specialityRepository.getOne(specialityRepository.getSpecialityOfGroup(groupId));
    }
}
