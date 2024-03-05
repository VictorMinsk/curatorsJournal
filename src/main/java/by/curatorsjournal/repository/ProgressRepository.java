package by.curatorsjournal.repository;

import by.curatorsjournal.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
public interface ProgressRepository extends JpaRepository<Progress, Long> {
       //получение отметки студента по конкретному предмету
    @Query(value = "SELECT  COALESCE(AVG(mark), 0) FROM Progress WHERE student_id = :studentId AND discipline_id=:disciplineId", nativeQuery = true)
    public byte getProgress(long studentId, long disciplineId);
}
