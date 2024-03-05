package by.curatorsjournal.repository;

import by.curatorsjournal.entity.Cathedra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
public interface CathedraRepository extends JpaRepository<Cathedra, Long> {

    //установить заведующего для кафедры
    @Transactional
    @Modifying
    @Query(value = "UPDATE Cathedras SET head_id=:headId WHERE id = :cathedraId", nativeQuery = true)
    public void setHead(long headId, long cathedraId);
}
