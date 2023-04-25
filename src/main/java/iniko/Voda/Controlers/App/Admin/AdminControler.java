package iniko.Voda.Controlers.App.Admin;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminControler {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/dashboard")
    public String admin(Model model) {
        return "/admin/dashboard";
    }
}
