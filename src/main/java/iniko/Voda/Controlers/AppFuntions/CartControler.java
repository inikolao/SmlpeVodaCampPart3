package iniko.Voda.Controlers.AppFuntions;

import iniko.Voda.DTO.Product;
import iniko.Voda.DTO.ShoppingCard;
import iniko.Voda.Services.DB.ProductService;
import iniko.Voda.Services.DB.ShoppingCardService;
import iniko.Voda.Services.DB.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/scart")
public class CartControler {

    @Autowired
    ShoppingCardService shoppingCardService;
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @PostMapping("/add")
    @ResponseBody
    public String addToCart(@RequestBody Map<String, Object> payload) {


        ShoppingCard shoppingCard=new ShoppingCard(userService.findByUsername(payload.get("username").toString()));

        Integer productId = Integer.parseInt(payload.get("productId").toString());
        Product product = productService.findProductByProd_ID(productId);
        if (product != null) {
            shoppingCardService.CreateShoppingCard(shoppingCard);
            return "Product added to cart";
        } else {
            return "Product not found";
        }
    }

}
