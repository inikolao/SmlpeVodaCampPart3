package iniko.Voda.Controlers.Admin;


import iniko.Voda.DTO.OrderCategory;
import iniko.Voda.DTO.Product;
import iniko.Voda.DTO.User;
import iniko.Voda.Repos.UserRepo;
import iniko.Voda.Services.DB.OrderCategoryService;
import iniko.Voda.Services.DB.ProductCategoryService;
import iniko.Voda.Services.DB.ProductService;
import iniko.Voda.Services.DB.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminControler {

    @Autowired
    private UserService userService;
    @Autowired
    ProductService productService;

    @Autowired
    ProductCategoryService productCategoryService;
    @Autowired
    OrderCategoryService orderCategoryService;



    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/dashboard")
    public String admin(Model model)
    {
        model.addAttribute("chMsg","Enter changes.");
        return "/admin/dashboard";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public String listUsers(Model model,@RequestParam(defaultValue = "1") int page) {
        Page<User> users = userService.findAllP(page,9);
        model.addAttribute("users", users.getContent());
        model.addAttribute("totalPages", users.getTotalPages());
        model.addAttribute("page", page);
        return "admin/user-list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/mproducts")
    public String GetProductsMg(Model model,@RequestParam(defaultValue = "1") int page)
    {
        Page<Product> productList=productService.findAllProducts(page, 9);
        model.addAttribute("mproducts",productList.getContent());
        model.addAttribute("mcategories",productCategoryService.GetAllProductCategories());
        model.addAttribute("totalPages", productList.getTotalPages());
        model.addAttribute("page", page);
        return "admin/mproducts";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/mcategories")
    public String GetCategoriesMg(Model model)
    {
        model.addAttribute("mcategories",productCategoryService.GetAllProductCategories());
        return "admin/mcategories";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/data")
    public String dataMg(Model model)
    {
        model.addAttribute("mcategories",productCategoryService.GetAllProductCategories());
        return "admin/datain";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/finance")
    public String GetFinanceMg(Model model,@RequestParam(defaultValue = "1") int page)
    {
        model.addAttribute("fcategories",orderCategoryService.getAll());
        model.addAttribute("totalPages", 2);
        model.addAttribute("page", page);
        return "admin/finance";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/changePass")
    public String ChangePassMg(Model model, @RequestParam("current-password") String cpass, @RequestParam("new-password") String npass, @RequestParam("confirm-password") String cnpass, HttpSession session)
    {
        String msg="";
        if(!npass.equals(cnpass))
        {
            msg="Please confirm pass again.";
            model.addAttribute("chMsg",msg);
            return "admin/dashboard";
        }
        else
        {
            User user=userService.findByUsername((String) session.getAttribute("username"));

            BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
            if(passwordEncoder.matches(cpass,user.getPassword()))
            {
                user.setPassword(encryptPass(npass));
                userService.save(user);
                msg="Changes was successful.";
                model.addAttribute("chMsg",msg);
            }
            else
            {
                msg="Old password is wrong.";
                model.addAttribute("chMsg",msg);
                return "admin/dashboard";
            }

        }

        return "admin/dashboard";
    }

    private  String encryptPass(String pass)
    {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        return passwordEncoder.encode(pass);
    }

}
