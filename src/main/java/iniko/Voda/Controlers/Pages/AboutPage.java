package iniko.Voda.Controlers.Pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutPage {

    @RequestMapping({ "/about"})
    public String Getit(Model model)
    {
        return "about";
    }
}
