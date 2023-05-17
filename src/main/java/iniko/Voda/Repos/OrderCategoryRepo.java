package iniko.Voda.Repos;

import iniko.Voda.DTO.OrderCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCategoryRepo extends JpaRepository<OrderCategory,Integer> {

    OrderCategory findByOrderCTID(int id);
}
