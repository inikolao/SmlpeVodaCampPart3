package iniko.Voda.Controlers.Pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WhishListPage {

    @RequestMapping({"/wishlist"})
    public String Getit(Model model)
    {
        return "wishlist";
    }
}
