package iniko.Voda.Services;

import iniko.Voda.DTO.Product;
import iniko.Voda.Repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public void CreateProduct(Product product)
    {
        productRepo.save(product);
    }
}
