package by.curatorsjournal.repository;

import by.curatorsjournal.entity.Group;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
public interface GroupRepository extends JpaRepository<Group, Long> {

    //установить старосту, замстаросты и профорга группы
    @Transactional
    @Modifying
    @Query(value = "UPDATE groups SET head_id=:headId, vicehead_id=:viceheadId, prof_org_id=:profOrgId WHERE id=:groupId", nativeQuery = true)
    public void setGroupActive(long groupId, long headId, long viceheadId, long profOrgId);
}
