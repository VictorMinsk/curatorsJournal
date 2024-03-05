package by.curatorsjournal.repository;

import by.curatorsjournal.entity.Methodist;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
public interface MethodistRepository extends JpaRepository<Methodist, Long> {
    //получить методиста по id пользователя
    @Query(value = "SELECT m.id FROM Methodists m JOIN T_user u ON m.user_id=u.id WHERE u.username = :userName", nativeQuery = true)
    public List<Long> getMethodistByUserId(String userName);

    //получить факультет по методисту
    @Query(value = "SELECT faculty_id FROM Methodists WHERE id = :methodistId", nativeQuery = true)
    public List<Long> getFacultyId(long methodistId);
}
