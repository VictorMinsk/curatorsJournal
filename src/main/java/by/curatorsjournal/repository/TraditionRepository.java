package by.curatorsjournal.repository;

import by.curatorsjournal.entity.Tradition;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
public interface TraditionRepository extends JpaRepository<Tradition, Long>{
    /*   @Modifying(clearAutomatically  = true)
 @Query(value="SELECT * FROM Traditions WHERE group_id = :groupId", nativeQuery = true)
    public List<Tradition> getTradionsOfGroup(long groupId);
    
     @Query(value="COMMIT", nativeQuery = true)
    public void commit();*/
}
