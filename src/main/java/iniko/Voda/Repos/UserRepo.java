package iniko.Voda.Repos;

import iniko.Voda.DTO.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Integer> {
}
