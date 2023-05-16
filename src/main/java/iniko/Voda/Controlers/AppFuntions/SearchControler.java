package iniko.Voda.Controlers.AppFuntions;


import iniko.Voda.DTO.Product;
import iniko.Voda.DTO.ProductCategory;
import iniko.Voda.DTO.User;
import iniko.Voda.Services.DB.ProductCategoryService;
import iniko.Voda.Services.DB.ProductService;
import iniko.Voda.Services.DB.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/search")
public class SearchControler {

    @Autowired
    ProductService productService;
    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    private UserService userService;

    @PostMapping("/name")
    public Map<String, Object> GetSearchByPName(@RequestBody Map<String, Object> payload, HttpSession session, @RequestParam(defaultValue = "1") int page, Model model)
    {
        //search
        Map<String, Object> returnload = new HashMap<>();
        String searchKey=payload.get("search").toString();
        Page<Product> productList=productService.findProductsByName(searchKey,page, 9);
        returnload.put("products",productList.getContent());
        returnload.put("totalPages", productList.getTotalPages());
        returnload.put("page", page);
        return returnload;

    }
    @PostMapping("/aname")
    public String searchPByName(@RequestParam("search") String searchTerm, Model model)
    {
        Page<Product> searchResults = productService.findProductsByName(searchTerm,1,9);
        model.addAttribute("mproducts",searchResults.getContent());
        model.addAttribute("mcategories",productCategoryService.GetAllProductCategories());
        model.addAttribute("totalPages", searchResults.getTotalPages());
        model.addAttribute("page", 1);
        return "admin/mproducts";
    }

    @PostMapping("/cname")
    public String searchCByName(@RequestParam("search") String searchTerm, Model model)
    {
        List<ProductCategory> productCategories=productCategoryService.getProductGategoryByName(searchTerm,1);
        model.addAttribute("mcategories",productCategories);
        return "admin/mcategories";
    }
    @PostMapping("/user")
    public String searchUserByName(@RequestParam("search") String searchTerm, Model model)
    {
        Page<User> users = userService.findByUsernamePages(searchTerm,3,9);
        model.addAttribute("users", users.getContent());
        model.addAttribute("totalPages", users.getTotalPages());
        model.addAttribute("page", 3);
        return "admin/user-list";
    }
}
