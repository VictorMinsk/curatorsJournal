package by.curatorsjournal.repository;

import by.curatorsjournal.entity.Curator;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
public interface CuratorRepository extends JpaRepository<Curator, Long> {

    //получение списка групп куратора
    @Query(value = "SELECT id FROM Groups WHERE curator_id = :curatorId", nativeQuery = true)
    public List<Long> getGroupsByCuratorId(long curatorId);

    //получение куратора по id пользователя
    @Query(value = "SELECT c.id FROM Curators c JOIN T_user u ON c.user_id=u.id WHERE u.username = :userName", nativeQuery = true)
    public List<Long> getCuratorByUserId(String userName);
}
