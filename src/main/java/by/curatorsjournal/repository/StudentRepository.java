package by.curatorsjournal.repository;

import by.curatorsjournal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    //получение номера группы для студента
    @Query(value = "SELECT group_id FROM Students WHERE id = :studentId", nativeQuery = true)
    public int getGroupByStudentId(long studentId);
}
