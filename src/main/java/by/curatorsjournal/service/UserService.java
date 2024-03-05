package by.curatorsjournal.service;

import by.curatorsjournal.entity.Role;
import by.curatorsjournal.entity.User;
import by.curatorsjournal.repository.RoleRepository;
import by.curatorsjournal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Класс
 *
 * @author V.A.Nichyporuk
 */
@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;
      @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    //загрузить пользователя по логину
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    //получить пользователя по id
    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    //получить список всех пользователей
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    //сохранить пользователя куратора
    public boolean saveCuratorUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null) {
            return false;
        }
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_CURATOR")));
        //щифрование пароля
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    //сохранить пользователя методиста
    public boolean saveMethodistUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null) {
            return false;
        }
        user.setRoles(Collections.singleton(new Role(3L, "ROLE_METHODIST")));
        //щифрование пароля
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    //сохранить пользователя заведующего кафедрой
    public boolean saveHeadOfDepartmentUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null) {
            return false;
        }
        user.setRoles(Collections.singleton(new Role(4L, "ROLE_HEAD_OF_DEPARTMENT")));
        //щифрование пароля
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
     //сохранить пользователя администратора
     public boolean saveAdminUser() {
        User userFromDB = userRepository.findByUsername("admin");
        if (userFromDB != null) {
            return false;
        }
        User user=new User();
        user.setUsername("admin");
        user.setRoles(Collections.singleton(new Role(2L, "ROLE_ADMIN")));
        //щифрование пароля
        user.setPassword(bCryptPasswordEncoder.encode("admin"));
        userRepository.save(user);
        return true;
    }
     
     public boolean createRoles(){
        if (roleRepository.existsById(1L)) return false;
        roleRepository.save(new Role(1L, "ROLE_CURATOR"));
        roleRepository.save(new Role(2L, "ROLE_ADMIN"));
        roleRepository.save(new Role(3L, "ROLE_METHODIST"));
        roleRepository.save(new Role(4L, "ROLE_HEAD_OF_DEPARTMENT"));
        return true;
     }

    //удалить пользователя
    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<User> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
                .setParameter("paramId", idMin).getResultList();
    }

    //сменить пароль
    public void changePassword(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
       // userRepository.changePassword(user.getId(), user.getPassword());
    }
}
