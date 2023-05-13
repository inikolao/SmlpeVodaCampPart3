package iniko.Voda.Repos;

import iniko.Voda.DTO.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Long> {



   /* @Query("select u from users u where u.Username=?1")
    public User findUserByUsername(String username);*/
   User findByUsername(String username);

    User findByIsAdminTrue();

    Page<User> findAllByUsernameContainingIgnoreCase(String username, Pageable pageable);
}
