package iniko.Voda.Repos;

import iniko.Voda.DTO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Integer> {

   /* @Query("select u from users u where u.Username=?1")
    public User findUserByUsername(String username);*/

}
