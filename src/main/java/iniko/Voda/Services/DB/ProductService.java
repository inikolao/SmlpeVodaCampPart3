package iniko.Voda.Services.DB;

import iniko.Voda.DTO.Product;
import iniko.Voda.Repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public void CreateProduct(Product product)
    {
        productRepo.save(product);
    }
    @Transactional
    public void UpdateProduct(Product product)
    {

        Product pr=productRepo.getProductById(product.getId());
        product.setDateAdded(pr.getDateAdded());
        product.setFilesRelated(pr.getFilesRelated());
        productRepo.save(product);

    }
    @Transactional
    public void UpdateProductCat(Product product)
    {

        Product pr=productRepo.getProductById(product.getId());
        product.setRating(pr.getRating());
        product.setPrice(pr.getPrice());
        product.setName(pr.getName());
        product.setType(pr.getType());
        product.setDescription(pr.getDescription());
        product.setDateAdded(pr.getDateAdded());
        product.setFilesRelated(pr.getFilesRelated());
        productRepo.save(product);

    }

    @Transactional
    public void DeleteProduct(Product product)
    {
        productRepo.delete(product);

    }

    public List<Product> GetAllProducts()
    {
        //List<Product> products=new ArrayList<>();
       // productRepo
        //List<Product> products= productRepo.findAll();//.forEach(products::add);
        return productRepo.findAll();
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

    public Page<Product> findAllProducts(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Product> pageResult = productRepo.findAll(pageable);
        return pageResult;
    }
    public Page<Product> findProductsByName(String search,int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Product> pageResult = productRepo.findAllByNameContainingIgnoreCase(search,pageable);
        return pageResult;
    }


}
