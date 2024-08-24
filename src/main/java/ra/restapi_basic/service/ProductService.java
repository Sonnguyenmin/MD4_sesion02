package ra.restapi_basic.service;

import ra.restapi_basic.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(Integer proId);
    Product insertProduct(Product product);
    Product upateProduct(Integer productId, Product product);
    void deleteProduct(Integer productId);
    List<Product> getProductsByName(String productName);
}
