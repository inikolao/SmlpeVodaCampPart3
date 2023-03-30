package iniko.Voda.Services;

import iniko.Voda.DTO.ProductType;
import iniko.Voda.Repos.ProductTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepo productTypeRepo;

    public void CreateProductType(ProductType productType)
    {

        productTypeRepo.save(productType);
    }
    public List<ProductType> GetNumProductType(int Num)
    {
        List<ProductType> productTypes=new ArrayList<>();
        List<ProductType> typesRetuned = null;
        productTypeRepo.findAll().forEach(productTypes::add);
        for (int i = 0; i < Num; i++) {
            typesRetuned.add(productTypes.get(i));
        }
        return typesRetuned;
    }
    public List<ProductType> GetAllProductTypes(int Num) {
        List<ProductType> productTypes=new ArrayList<>();
        productTypeRepo.findAll().forEach(productTypes::add);
        return productTypes;
    }
    public ProductType GetProductTypeByID(int id)
    {
        return productTypeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Product Type with "+id+" not found"));
    }

}
