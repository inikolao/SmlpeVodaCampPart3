package iniko.Voda.Controlers.Pages;


import iniko.Voda.Services.DB.OrderCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CartPage {

    @Autowired
    OrderCategoryService orderCategoryService;
    @RequestMapping({ "/cart"})
    public String Getit(Model model, HttpSession session)
    {
        if(session.getAttribute("userlog")== null)
        {
            model.addAttribute("sCardProducts",session.getAttribute("sCardProducts"));
            model.addAttribute("sCardProductsx",session.getAttribute("sCardProducts"));
            model.addAttribute("SCsum",(session.getAttribute("SCsum")==null)?0:session.getAttribute("SCsum"));
            model.addAttribute("ordcategories",orderCategoryService.getAll());
        }
        return "cart";
    }
}
