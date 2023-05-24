package iniko.Voda.Repos;

import iniko.Voda.DTO.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;

public interface OrderRepo extends JpaRepository<Order,Integer> {

    Page<Order> findOrderByCategoryOrderCTIDAndDateCreated(int searchcat, Date dateCr,Pageable pageable);

    Page<Order> findOrderByCategoryOrderCTIDAndDateCreatedLike(int searchcat, Date dateCr, Pageable pageable);
    Page<Order> findOrderByCategoryOrderCTIDAndDateCreatedDateIsStartingWith(int searchcat, Date dateCr, Pageable pageable);
}
