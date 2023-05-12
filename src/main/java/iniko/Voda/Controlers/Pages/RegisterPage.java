package iniko.Voda.Controlers.Pages;

import iniko.Voda.DTO.User;
import iniko.Voda.Services.DB.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.Console;
import java.util.Date;

@Controller
public class RegisterPage {

    @Autowired
    UserService userService;

    @RequestMapping({ "/register"})
    public String Getit(Model model, HttpSession session)
    {
        return "register";
    }

    @PostMapping({ "/registeru"})
    public String Register(@ModelAttribute("user") User user,
                           BindingResult bindingResult, HttpSession session){
            if (bindingResult.hasErrors()) {
                System.out.println(bindingResult.toString());
                return "register";
            }
        String plainPassword = user.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(plainPassword);
        user.setPassword(encryptedPassword);
            user.setActive(true);
            user.setAdmin(false);
            user.setLastLogIn(null);
            user.setDateCreated(Date.from(java.time.Clock.systemUTC().instant()));
            userService.CreateUser(user);
        return "redirect:/login";
    }
}
