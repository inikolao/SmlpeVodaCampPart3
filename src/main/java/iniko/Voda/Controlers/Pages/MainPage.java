package iniko.Voda.Controlers.Pages;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPage {

    @RequestMapping({"/", "/index"})
    public String Getit(Model model)
    {
        return "index";
    }
}
