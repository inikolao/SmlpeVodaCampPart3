package iniko.Voda.Controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class payments {

    @RequestMapping("/payments")
    public String paymentProcess(Model model, HttpSession session)
    {
        model.addAttribute("user",session.getAttribute("username"));
        return "payment";
    }
}
