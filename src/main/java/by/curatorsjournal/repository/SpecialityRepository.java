package by.curatorsjournal.repository;

import by.curatorsjournal.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
public interface SpecialityRepository extends JpaRepository<Speciality, Long>{
     //получение специальности группы
    @Query(value = "SELECT speciality_id FROM Groups WHERE id = :groupId", nativeQuery = true)
    public long getSpecialityOfGroup(long groupId);
}
