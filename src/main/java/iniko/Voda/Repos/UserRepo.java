package iniko.Voda.Repos;

import iniko.Voda.DTO.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {



   /* @Query("select u from users u where u.Username=?1")
    public User findUserByUsername(String username);*/
   User findByUsername(String username);

    User findByIsAdminTrue();

    Page<User> findAllByUsernameContainingIgnoreCase(String username, Pageable pageable);

    Page<User> findUserByUsernameContainingIgnoreCase(String username, Pageable pageable);

    List<User> findUserByUsernameContainingIgnoreCase(String username);

    Page<User> findByUsernameContainingIgnoreCase(String username, Pageable pageable);


    User findByUserID(int id);
}
