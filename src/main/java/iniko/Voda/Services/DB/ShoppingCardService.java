package iniko.Voda.Services.DB;

import iniko.Voda.DTO.Product;
import iniko.Voda.DTO.ShoppingCard;
import iniko.Voda.Repos.ShoppingCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCardService {

    @Autowired
    private ShoppingCardRepo shoppingCardRepo;

    public void CreateShoppingCard(ShoppingCard shoppingCard)
    {
        shoppingCardRepo.save(shoppingCard);
    }
    public void AddProductsToCard(ShoppingCard shoppingCard, Product product)
    {

    }

}
