package by.curatorsjournal.repository;

import by.curatorsjournal.entity.Discipline;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
       //получение списка дисциплин групп в зависимости от формы аттестатации
    @Query(value = "SELECT d.id FROM Disciplines d JOIN Groups g ON g.speciality_id=d.speciality_id WHERE g.id = :groupId AND d.type=:typeId", nativeQuery = true)
    public List<Long> getDisciplinesForGroup(long groupId, long typeId);
}
