package iniko.Voda.Controlers.AppFuntions;


import iniko.Voda.DTO.Product;
import iniko.Voda.Services.DB.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/search")
public class SearchControler {

    @Autowired
    ProductService productService;

    @PostMapping("/name")
    public Map<String, Object> GetSearchByPName(@RequestBody Map<String, Object> payload, HttpSession session, @RequestParam(defaultValue = "1") int page, Model model)
    {
        //search
        Map<String, Object> returnload = new HashMap<>();
        String searchKey=payload.get("search").toString();
        Page<Product> productList=productService.findProductsByName(searchKey,page, 9);
        returnload.put("products",productList.getContent());
        returnload.put("totalPages", productList.getTotalPages());
        returnload.put("page", page);
        return returnload;

    }
}
