package iniko.Voda.Controlers.Pages;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CartPage {

    @RequestMapping({ "/cart"})
    public String Getit(Model model, HttpSession session)
    {
        if(session.getAttribute("userlog")== null)
        {
            model.addAttribute("sCardProducts",session.getAttribute("sCardProducts"));
            model.addAttribute("SCsum",(session.getAttribute("SCsum")==null)?0:session.getAttribute("SCsum"));
        }
        return "cart";
    }
}
