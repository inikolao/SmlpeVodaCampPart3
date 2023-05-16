package iniko.Voda.Repos;

import iniko.Voda.DTO.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory,Integer> {

    Page<ProductCategory> findProductCategoryByNameContainingIgnoreCase(String name, Pageable pageable);

}
