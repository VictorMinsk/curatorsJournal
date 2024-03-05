package by.curatorsjournal.repository;

import by.curatorsjournal.entity.Encouragement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
public interface EncouragementRepository extends JpaRepository<Encouragement, Long>  {
    
}
