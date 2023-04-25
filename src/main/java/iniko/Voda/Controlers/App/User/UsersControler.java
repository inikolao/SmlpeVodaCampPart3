package iniko.Voda.Controlers.App.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UsersControler {


    @GetMapping("/{username}/home")
    public String admin(Model model) {
        return "home";
    }
}
