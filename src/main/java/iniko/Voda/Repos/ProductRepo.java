package iniko.Voda.Repos;

import iniko.Voda.DTO.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product,Integer> {
}
