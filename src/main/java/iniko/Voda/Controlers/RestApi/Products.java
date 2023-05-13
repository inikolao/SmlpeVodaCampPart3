package iniko.Voda.Controlers.RestApi;

import iniko.Voda.DTO.Product;
import iniko.Voda.DTO.User;
import iniko.Voda.Services.DB.ProductService;
import iniko.Voda.Services.DB.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Products {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @RequestMapping("/getProducts")
    @ResponseBody
    public List<Product> GetAllProducts()
    {
        return productService.GetAllProducts();
    }

    @RequestMapping("/getusers")
    @ResponseBody
    public List<User> GetAllUsers()
    {
        return userService.findAll();
    }

    @RequestMapping("/getuser")
    @ResponseBody
    public User GetUser(@RequestParam(name = "user") String username)
    {
        return userService.findByUsername(username);
    }
}
