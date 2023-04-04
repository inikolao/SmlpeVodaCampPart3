package iniko.Voda.Controlers.App;

import iniko.Voda.Services.DB.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class ProductsControler {

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public String GetProducts(Model model)
    {
        model.addAttribute("products",productService.GetAllProducts());
        return "products";
    }

    @RequestMapping("/search")
    public String GetProducts(Model model,String keyword)
    {
        model.addAttribute("products",productService.GetProductsByName(keyword));
        return "search";
    }
}
