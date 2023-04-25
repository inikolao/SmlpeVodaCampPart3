package iniko.Voda.Controlers.App.Admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminControler {

    @GetMapping("/dashboard")
    public String admin(Model model) {
        return "/admin/dashboard";
    }
}
