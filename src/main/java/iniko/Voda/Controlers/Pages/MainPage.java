package iniko.Voda.Controlers.Pages;


import iniko.Voda.DTO.Product;
import iniko.Voda.Services.DB.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class MainPage {

    @Autowired
    ProductService productService;

    @RequestMapping({"/", "/index"})
    public String Getit(Model model, HttpSession session)
    {
        List<Product> products=productService.GetAllProducts();
        List<Product> productsv=new ArrayList<>();
        int rand=GenRandomInt();
        for (int i = rand; i < 3+rand; i++) {
            productsv.add(products.get(i));
        }

        model.addAttribute("productsint",productsv);
        return "index";
    }

    private Integer GenRandomInt()
    {
        Random rand = new Random();
        // Setting the upper bound to generate the
        // random numbers in specific range
        int upperbound = 6;
        // Generating random values from 0 - 24
        // using nextInt()
        return rand.nextInt(upperbound);
    }
}
