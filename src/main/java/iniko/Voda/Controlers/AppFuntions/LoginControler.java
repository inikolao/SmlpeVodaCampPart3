package iniko.Voda.Controlers.AppFuntions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginControler {

    @GetMapping("/login")
    public String login(HttpSession session) {
        if(session.getAttribute("username")!=null)
        {
            return "/user/home";
        }
        else {
            return "login";
        }
    }
}
