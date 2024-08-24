package ra.restapi_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.restapi_basic.model.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductByProductNameContains(String productName);
}
