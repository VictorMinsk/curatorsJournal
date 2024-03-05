package by.curatorsjournal.repository;

import by.curatorsjournal.entity.HeadOfDepartment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
public interface HeadOfDepartmentRepository extends JpaRepository<HeadOfDepartment, Long> {
    //получить заведующего кафедрой по id пользователя
    @Query(value = "SELECT ch.id FROM cathedra_heads ch JOIN T_user u ON ch.user_id=u.id WHERE u.username = :userName", nativeQuery = true)
    public List<Long> getHeadOfByUserId(String userName);

    //получить кафедру по ее заведующему
    @Query(value = "SELECT id FROM cathedras WHERE head_id = :headId", nativeQuery = true)
    public Long getCathedraId(long headId);
}
