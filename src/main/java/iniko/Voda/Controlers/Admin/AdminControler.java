package iniko.Voda.Controlers.Admin;


import iniko.Voda.DTO.User;
import iniko.Voda.Repos.UserRepo;
import iniko.Voda.Services.DB.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminControler {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    ProductService productService;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/dashboard")
    public String admin(Model model) {
        return "/admin/dashboard";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "admin/user-list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/mproducts")
    public String GetProductsMg(Model model)
    {
        model.addAttribute("mproducts",productService.GetAllProducts());
        return "admin/mproducts";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/finance")
    public String GetFinanceMg(Model model)
    {
       // model.addAttribute("mproducts",productService.GetAllProducts());
        return "admin/finance";
    }
}
