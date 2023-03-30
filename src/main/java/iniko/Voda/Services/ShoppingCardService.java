package iniko.Voda.Services;

import iniko.Voda.DTO.ShoppingCard;
import iniko.Voda.Repos.ShoppingCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCardService {

    @Autowired
    private ShoppingCardRepo shoppingCardRepo;

    private void CreateShoppingCard(ShoppingCard shoppingCard)
    {
        shoppingCardRepo.save(shoppingCard);
    }

}
