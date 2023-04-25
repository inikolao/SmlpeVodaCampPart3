package iniko.Voda.Repos;

import iniko.Voda.DTO.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {
}
