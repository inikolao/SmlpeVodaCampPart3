package iniko.Voda.Controlers.AppFuntions;

import iniko.Voda.DTO.Enums.PaymentType;
import iniko.Voda.DTO.Payments;
import iniko.Voda.DTO.User;
import iniko.Voda.Services.DB.PaymentsService;
import iniko.Voda.Services.DB.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/pay")
public class PaymentsControler {

    @Autowired
    PaymentsService paymentsService;

    @Autowired
    UserService userService;

    @PostMapping("/newpay")
    public String makeorder (@RequestParam("paymentType") String paymentType, @RequestParam("cardNumber") String cardNumber, @RequestParam("expirationDate") String expirationDate,@RequestParam("totalp") String totalp, HttpSession session)
    {
        User user= userService.findByUsername((String) session.getAttribute("username"));
        Payments payments=new Payments(1,user,PaymentType.valueOf(paymentType),GetNow(),Integer.parseInt(totalp));
        paymentsService.CreatePayment(payments);


        return  "redirect:/";
    }

    private Date GetNow() {
        Instant instant = Instant.now();
        return java.sql.Date.valueOf(instant.atZone(ZoneId.systemDefault()).toLocalDate());
    }
}
