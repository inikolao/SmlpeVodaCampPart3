package iniko.Voda.Services.DB;

import iniko.Voda.DTO.Product;
import iniko.Voda.Repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public void CreateProduct(Product product)
    {
        productRepo.save(product);
    }

    public List<Product> GetAllProducts()
    {
        List<Product> products=new ArrayList<>();
        productRepo.findAll().forEach(products::add);
        return products;
    }
    public Product findProductByProd_ID(int ID)
    {
      return productRepo.getProductById(ID);
    }
    public List<Product> GetProductsByName(String keyword)
    {
        List<Product> products=new ArrayList<>();
        List<Product> productsr=new ArrayList<>();
        productRepo.findAll().forEach(products::add);
        for (Product prd: products
             ) {

            if(prd.getName().contains(keyword))
            {
                productsr.add(prd);
            }

        }
        return productsr;
    }

}
