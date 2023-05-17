package iniko.Voda.Controlers.AppFuntions;

import iniko.Voda.DTO.Order;
import iniko.Voda.DTO.Product;
import iniko.Voda.DTO.ShoppingCard;
import iniko.Voda.DTO.User;
import iniko.Voda.Services.DB.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    OrderService orderService;

    @Autowired
    OrderCategoryService orderCategoryService;

    @PostMapping("/add")
    @ResponseBody
    public String addToCart(@RequestBody Map<String, Object> payload, HttpSession session) {
        //ShoppingCard shoppingCard=new ShoppingCard(userService.findByUsername(payload.get("username").toString()));

        int productId = Integer.parseInt(payload.get("productId").toString());
        Product product = productService.findProductByProd_ID(productId);
        long total=0;
        if (session.getAttribute("userlog")==null) {
            if (product != null) {
                shopingCart.add(product);
               // shoppingCardService.CreateShoppingCard(shoppingCard);
                total=shopingCart.stream().mapToLong(Product::getPrice).sum();
                session.setAttribute("sCardProducts",shopingCart);
                session.setAttribute("SCsum",total);
                session.setAttribute("scprSize",shopingCart.size());
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
        long total =(long) session.getAttribute("SCsum");

        if(session.getAttribute("userlog")== null)
        {
            if (!shopingCart.isEmpty()) {
                List <Product> fx= shopingCart.stream().filter(productsx -> productId==productsx.getId()).collect(Collectors.toList());

                shopingCart.remove(fx.get(0));
                total=total-fx.get(0).getPrice();
                session.setAttribute("sCardProducts",shopingCart);
                session.setAttribute("SCsum",total);
                session.setAttribute("scprSize",shopingCart.size());
                return "Product removed to cart";
            } else {
                return "Product not found";
            }
        }
        return "removeFromCard";
    }

    @PostMapping("/makeorder")
    public String makeorder (@RequestBody List<Integer> selectedProducts,@RequestBody int category,HttpSession session)
    {
        String username=(session.getAttribute("username")==null)?"guest": (String) session.getAttribute("username");//username
        List <Product> products=new ArrayList<>();
        for (Integer id: selectedProducts
             ) {
            products.add(productService.findProductByProd_ID(id));
        }
        User user=userService.findByUsername(username);
        Order order=new Order(1,user,orderCategoryService.getOrderCategoryByID(category),products,products.stream().mapToLong(Product::getPrice).sum(),products.size(),GetNow());
        orderService.CreateOrder(order);
        return  "redirect:/payments";
    }


    private Date GetNow()
    {
        Date dateOne = new Date();
        Instant inst = Instant.now();
        return dateOne.from(inst);
    }
}
