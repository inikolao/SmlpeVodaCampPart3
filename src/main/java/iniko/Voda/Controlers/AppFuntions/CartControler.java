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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cart")
public class CartControler {

    private List<Product> shopingCart = new ArrayList<>();
    @Autowired
    ShoppingCardService shoppingCardService;
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @PostMapping("/add")
    @ResponseBody
    public String addToCart(@RequestBody Map<String, Object> payload, HttpSession session) {
        //ShoppingCard shoppingCard=new ShoppingCard(userService.findByUsername(payload.get("username").toString()));

        int productId = Integer.parseInt(payload.get("productId").toString());
        Product product = productService.findProductByProd_ID(productId);
        if (session.getAttribute("userlog")==null) {
            if (product != null) {
                shopingCart.add(product);
               // shoppingCardService.CreateShoppingCard(shoppingCard);
                session.setAttribute("sCardProducts",shopingCart);
                return "Product added to cart";
            } else {
                return "Product not found";
            }
        }
        return "addToCard";
    }

    @PostMapping("/remove")
    @ResponseBody
    public String removeFromCart(@RequestBody Map<String, Object> payload, HttpSession session) {
        //ShoppingCard shoppingCard=new ShoppingCard(userService.findByUsername(payload.get("username").toString()));
        int productId = Integer.parseInt(payload.get("productId").toString());
        shopingCart= (List<Product>) session.getAttribute("sCardProducts");


        if(session.getAttribute("userlog")== null)
        {
            if (!shopingCart.isEmpty()) {
                List <Product> fx= shopingCart.stream().filter(productsx -> productId==productsx.getId()).collect(Collectors.toList());

                shopingCart.remove(fx.get(0));
                session.setAttribute("sCardProducts",shopingCart);
                return "Product removed to cart";
            } else {
                return "Product not found";
            }
        }
        return "removeFromCard";
    }
}
