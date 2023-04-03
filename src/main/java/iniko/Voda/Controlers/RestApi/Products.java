package iniko.Voda.Controlers.RestApi;

import iniko.Voda.DTO.Product;
import iniko.Voda.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Products {

    @Autowired
    ProductService productService;

    @RequestMapping("/getProducts")
    @ResponseBody
    public List<Product> GetAllProducts()
    {
        return productService.GetAllProducts();
    }

}
