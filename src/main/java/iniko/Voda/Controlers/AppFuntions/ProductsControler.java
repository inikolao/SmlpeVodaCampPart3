package iniko.Voda.Controlers.AppFuntions;

import iniko.Voda.DTO.Product;
import iniko.Voda.DTO.ProductCategory;
import iniko.Voda.Services.DB.ProductCategoryService;
import iniko.Voda.Services.DB.ProductService;
import iniko.Voda.Services.DB.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @Autowired
    ProductTypeService productTypeService;

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

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/edit/{id}")
    public String editProducts(Model model, @PathVariable int id)
    {
        Product product=productService.findProductByProd_ID(id);
        model.addAttribute("categories",productCategoryService.GetAllProductCategories());
        model.addAttribute("products",product);
        model.addAttribute("types",productTypeService.GetProductTypes());
        return "search";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/update")
    public String updateProducts(@ModelAttribute("product") Product product,
                                 BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "redirect:/admin/mproducts";
        }
        else {
            productService.UpdateProduct(product);
        }
        return "redirect:/admin/mproducts";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/updateCat")
    public String updateProductCategory(@ModelAttribute("product") Product product,
                                        BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "redirect:/admin/mproducts";
        }
        else {
            productService.UpdateProductCat(product);
        }
        return "redirect:/admin/mproducts";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/deleteProd/{id}")
    public String deleteProduct(Model model, @PathVariable int id)
    {
        Product product=productService.findProductByProd_ID(id);
        if (product ==null) {
            return "redirect:/admin/mproducts";
        }
        else {
            productService.DeleteProduct(product);
        }
        return "redirect:/admin/mproducts";
    }




}
