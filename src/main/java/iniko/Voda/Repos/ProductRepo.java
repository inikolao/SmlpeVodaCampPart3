package iniko.Voda.Repos;

import iniko.Voda.DTO.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
