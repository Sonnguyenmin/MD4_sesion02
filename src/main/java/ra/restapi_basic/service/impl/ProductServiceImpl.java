package ra.restapi_basic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.restapi_basic.model.entity.Product;
import ra.restapi_basic.repository.ProductRepository;
import ra.restapi_basic.service.ProductService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer proId) {
        return productRepository.findById(proId).orElseThrow(() -> new NoSuchElementException("Khong ton tai san pham nao co ma: "+proId));
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product upateProduct(Integer productId, Product product) {
        productRepository.findById(productId).orElseThrow(()->new NoSuchElementException("Khong ton tai prduct co ma: "+productId));
        product.setProductId(productId);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> getProductsByName(String productName) {
        return productRepository.findProductByProductNameContains(productName);
    }
}
