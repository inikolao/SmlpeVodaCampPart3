package iniko.Voda.Repos;

import iniko.Voda.DTO.User;
import iniko.Voda.DTO.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepo extends JpaRepository<WishList,Integer> {

    WishList findWhshListById(int id);

    WishList findByUserOwner(User user);



}
