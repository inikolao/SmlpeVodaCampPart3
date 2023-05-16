package iniko.Voda.Controlers.AppFuntions;

import iniko.Voda.DTO.ProductCategory;
import iniko.Voda.DTO.User;
import iniko.Voda.Services.DB.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserControler {

    @Autowired
    UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    public String deleteCategory(Model model, @PathVariable int id)
    {
        User user=userService.getUserByID(id);
        if (user ==null) {

            return "redirect:admin/user-list";
        }
        else {

            userService.deleteUser(user);
        }

        return "redirect:/admin/user-list";
    }
}
