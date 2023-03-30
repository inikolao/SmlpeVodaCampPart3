package iniko.Voda.Repos;

import iniko.Voda.DTO.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order,Integer> {
}
