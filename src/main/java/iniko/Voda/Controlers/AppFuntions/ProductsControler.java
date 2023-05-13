package iniko.Voda.Controlers.AppFuntions;

import iniko.Voda.DTO.Product;
import iniko.Voda.DTO.ProductCategory;
import iniko.Voda.Services.DB.ProductCategoryService;
import iniko.Voda.Services.DB.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/page")
public class ProductsControler {

    @Autowired
    ProductService productService;

    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping("/products")
    public String GetProducts(Model model, @RequestParam(defaultValue = "1") int page)
    {
        Page<Product> productList=productService.findAllProducts(page, 9);
        List<ProductCategory> categories=productCategoryService.GetAllProductCategories();
        List<String> categoryNames=categories.stream().map(ProductCategory::getName).collect(Collectors.toList());
        model.addAttribute("products",productList.getContent());
        model.addAttribute("prcategories",categoryNames);
        model.addAttribute("totalPages", productList.getTotalPages());
        model.addAttribute("page", page);
        return "products";
    }


    @RequestMapping("/searchp")
    public String GetProducts(Model model,String keyword)
    {
        model.addAttribute("products",productService.GetProductsByName(keyword));
        return "search";
    }
    @RequestMapping("/edit/{id}")
    public String editProducts(Model model, @PathVariable int id)
    {
        model.addAttribute("products",productService.findProductByProd_ID(id));
        return "search";
    }




}
