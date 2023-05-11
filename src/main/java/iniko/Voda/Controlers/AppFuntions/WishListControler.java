package iniko.Voda.Controlers.AppFuntions;


import iniko.Voda.DTO.Product;
import iniko.Voda.Services.DB.ProductService;
import iniko.Voda.Services.DB.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/wishlist")
public class WishListControler {
    private List<Product> whishlist = new ArrayList<>();

    @Autowired
    WishListService whishListService;

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    @ResponseBody
    public String addToWishlist(@RequestBody Map<String, Object> payload, HttpSession session) {
        int productId = Integer.parseInt(payload.get("productId").toString());
        Product product=productService.findProductByProd_ID(productId);


        if(session.getAttribute("userlog")== null)
        {
            if (product != null) {
                whishlist.add(product);
                session.setAttribute("wproducts",whishlist);
                return "Product added to cart";
            } else {
                return "Product not found";
            }
        }


       // int userId = Integer.parseInt(payload.get("userId").toString());
        //whishListService.addProductToWhish();
        //Product product = productService.getProductById(productId);
      /*  if (product != null) {
            whishlist.add(product);
            return "Product added to cart";
        } else {
            return "Product not found";
        }*/
        return "addToWishlist";
    }

    @PostMapping("/remove")
    @ResponseBody
    public String removeToWishlist(@RequestBody Map<String, Object> payload, HttpSession session) {
        int productId = Integer.parseInt(payload.get("productId").toString());
        whishlist= (List<Product>) session.getAttribute("wproducts");


        if(session.getAttribute("userlog")== null)
        {
            if (!whishlist.isEmpty()) {
               List <Product> fx= whishlist.stream().filter(productsx -> productId==productsx.getId()).collect(Collectors.toList());

                whishlist.remove(fx.get(0));
                session.setAttribute("wproducts",whishlist);
                return "Product removed to cart";
            } else {
                return "Product not found";
            }
        }


        // int userId = Integer.parseInt(payload.get("userId").toString());
        //whishListService.addProductToWhish();
        //Product product = productService.getProductById(productId);
       /* if (product != null) {
            whishlist.add(product);
            return "Product added to cart";
        } else {
            return "Product not found";
        }*/
         return "removeToWishlist";
    }

    @PostMapping("/get")
    @ResponseBody
    public String getWishlist(@RequestBody Map<String, Object> payload) {
        Long productId = Long.parseLong(payload.get("productId").toString());
        /*Product product = productService.getProductById(productId);
        if (product != null) {
            cart.add(product);
            return "Product added to cart";
        } else {
            return "Product not found";
        }*/
        return "addToWishlist";
    }

}
