package iniko.Voda.Controlers.Pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AboutPage {

    @RequestMapping({ "/about"})
    public String Getit(Model model, HttpSession session)
    {
        return "about";
    }
}
