package iniko.Voda.Controlers.Pages;

import iniko.Voda.Services.DB.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class WhishListPage {

    @Autowired
    WishListService wishListService;

    @RequestMapping({"/wishlist"})
    public String Getit(Model model, HttpSession session)
    {
        if(session.getAttribute("userlog")== null)
        {
            model.addAttribute("wproducts",session.getAttribute("wproducts"));
        }

        return "wishlist";
    }
}
