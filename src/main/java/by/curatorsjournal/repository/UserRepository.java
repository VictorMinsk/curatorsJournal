package by.curatorsjournal.repository;

import by.curatorsjournal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
public interface UserRepository extends JpaRepository<User, Long> {
    //получение пользователя по его логину
    User findByUsername(String username);
    
    //сменить пароль пользователя
    @Transactional
    @Modifying
     @Query(value="UPDATE t_user SET password=:newPassword WHERE id = :userId", nativeQuery = true)
    public void changePassword(long userId, String newPassword);
}
