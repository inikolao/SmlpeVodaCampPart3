package iniko.Voda.Services.DB;

import iniko.Voda.DTO.OrderCategory;
import iniko.Voda.Repos.OrderCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCategoryService {
    @Autowired
    private OrderCategoryRepo orderCategoryRepo;

    public void CreateOrderCategory(OrderCategory orderCategory)
    {
        orderCategoryRepo.save(orderCategory);
    }

    public List<OrderCategory> getAll()
    {
       return orderCategoryRepo.findAll();
    }

    public OrderCategory getOrderCategoryByID(int id)
    {
        return orderCategoryRepo.findByOrderCTID(id);
    }
}
