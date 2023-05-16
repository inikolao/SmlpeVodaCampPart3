package iniko.Voda.Services.DB;

import iniko.Voda.DTO.Product;
import iniko.Voda.DTO.ProductCategory;
import iniko.Voda.Repos.ProductCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void DeleteCategory(ProductCategory category)
    {
        productCategoryRepo.delete(category);

    }

    public List<ProductCategory> getProductGategoryByName(String name,int pageNumber)
    {
        Pageable pageable = PageRequest.of(pageNumber - 1, 9);
        return productCategoryRepo.findProductCategoryByNameContainingIgnoreCase(name,pageable).getContent();
    }

}
