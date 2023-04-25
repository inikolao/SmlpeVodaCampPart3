package iniko.Voda.Repos;

import iniko.Voda.DTO.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory,Integer> {
}
