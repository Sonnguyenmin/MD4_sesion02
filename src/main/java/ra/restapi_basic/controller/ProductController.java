package ra.restapi_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.restapi_basic.model.dto.DataResponse;
import ra.restapi_basic.model.entity.Product;
import ra.restapi_basic.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<DataResponse> getAllProducts(){
        return new ResponseEntity<>(new DataResponse(productService.getProducts(), HttpStatus.OK),HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<DataResponse> getById(@PathVariable("productId")Integer productId){
        return new ResponseEntity<>(new DataResponse(productService.getProductById(productId),HttpStatus.OK),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse> insertProductService(@RequestBody Product product){
        return new ResponseEntity<>(new DataResponse(productService.insertProduct(product),HttpStatus.CREATED),HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<DataResponse> upateProduct(@PathVariable("productId")Integer productId, @RequestBody Product product){
        return new ResponseEntity<>(new DataResponse(productService.upateProduct(productId,product),HttpStatus.OK),HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<DataResponse> deleteProduct(@PathVariable("productId")Integer productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>(new DataResponse("Đã xóa thành công category có mã: "+productId,HttpStatus.NO_CONTENT),HttpStatus.OK);
    }

    @GetMapping("/searchByName/{productName}")
    public ResponseEntity<DataResponse> searchProductByName(@PathVariable("productName")String productName){
        return  new ResponseEntity<>(new DataResponse(productService.getProductsByName(productName),HttpStatus.OK),HttpStatus.OK);
    }

}
