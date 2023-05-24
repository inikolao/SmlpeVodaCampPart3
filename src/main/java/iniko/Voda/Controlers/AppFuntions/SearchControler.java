package iniko.Voda.Controlers.AppFuntions;


import iniko.Voda.DTO.Order;
import iniko.Voda.DTO.Product;
import iniko.Voda.DTO.ProductCategory;
import iniko.Voda.DTO.User;
import iniko.Voda.Repos.OrderRepo;
import iniko.Voda.Services.DB.OrderService;
import iniko.Voda.Services.DB.ProductCategoryService;
import iniko.Voda.Services.DB.ProductService;
import iniko.Voda.Services.DB.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
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

    @Autowired
    private OrderService orderService;

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
        Page<User> users = userService.findByUsernamePages(searchTerm,1,9);
        model.addAttribute("users", users.getContent());
        model.addAttribute("totalPages", users.getTotalPages());
        model.addAttribute("page", 1);
        return "admin/user-list";
    }

    @PostMapping("/findFinance")
    public String searchFinance(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-mm-dd") String searchdates, @RequestParam("category") int searchcategory, Model model) throws ParseException {
        LocalDate localDate;



        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        localDate = LocalDate.parse(searchdates, formatter);

       // localDate=dateTimeFormatter.format(searchdates);
       Page<Order> orders= orderService.SearchOrdersByDateAndCategory(searchcategory,localDate,1,9);
        model.addAttribute("financer", orders.getContent());
        model.addAttribute("totalPages", orders.getTotalPages());
        model.addAttribute("page", 1);
        return "admin/finance";
    }
}
