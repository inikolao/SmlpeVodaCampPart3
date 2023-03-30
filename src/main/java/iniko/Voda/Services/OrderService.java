package iniko.Voda.Services;

import iniko.Voda.DTO.Order;
import iniko.Voda.Repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    private void CreateOrder(Order order)
    {
        orderRepo.save(order);
    }
}
