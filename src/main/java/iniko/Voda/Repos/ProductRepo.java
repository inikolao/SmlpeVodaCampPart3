package iniko.Voda.Repos;

import iniko.Voda.DTO.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepo extends JpaRepository<Product,Integer> {

    Product getProductById(int id);
    Page<Product> findAllByName(String name, Pageable pageable);

    Page<Product> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
