package iniko.Voda.Controlers.AppFuntions;

import iniko.Voda.DTO.Product;
import iniko.Voda.DTO.ProductCategory;
import iniko.Voda.Services.DB.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ecategory")
public class CategoriesControler {

    @Autowired
    ProductCategoryService productCategoryService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    public String deleteCategory(Model model, @PathVariable int id)
    {
        ProductCategory productCategory=productCategoryService.GetProductCategoryByID(id);
        if (productCategory ==null) {
            model.addAttribute("mcategories",productCategoryService.GetAllProductCategories());
            return "redirect:/admin/mcategories";
        }
        else {
            model.addAttribute("mcategories",productCategoryService.GetAllProductCategories());
            productCategoryService.DeleteCategory(productCategory);
        }

        return "redirect:/admin/mcategories";
    }
}
