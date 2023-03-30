package iniko.Voda.Services;

import iniko.Voda.DTO.ProductCategory;
import iniko.Voda.Repos.ProductCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    public void CreateProductCategory(ProductCategory productCategory)
    {
        productCategoryRepo.save(productCategory);
    }

    public List<ProductCategory> GetNumProductCategory(int Num)
    {
        List<ProductCategory> productCategories=new ArrayList<>();
        List<ProductCategory> categoriesReturned=null;
        productCategoryRepo.findAll().forEach(productCategories::add);
        for (int i = 0; i < Num; i++) {
            categoriesReturned.add(productCategories.get(i));
        }
        return categoriesReturned;
    }
    public List<ProductCategory> GetAllProductCategories()
    {
        List<ProductCategory> productCategories=new ArrayList<>();
        productCategoryRepo.findAll().forEach(productCategories::add);
        return productCategories;
    }
    public ProductCategory GetProductCategoryByID(int id)
    {
        return productCategoryRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Product category with "+id+" not found"));
    }

}
