package iniko.Voda.Services.DB;

import iniko.Voda.DTO.Order;
import iniko.Voda.Repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public void CreateOrder(Order order)
    {
        orderRepo.save(order);
    }

    public Page<Order> SearchOrdersByDateAndCategory(int searchcatID, LocalDate dateCr, int pageNumber, int pageSize)
    {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
       // Date date = Date.from(dateCr.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date date=java.sql.Date.valueOf(dateCr);

        return orderRepo.findOrderByCategoryOrderCTIDAndDateCreated(searchcatID,date,pageable);
    }
}
