package ra.restapi_basic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.restapi_basic.model.dto.DataResponse;
import ra.restapi_basic.model.entity.Category;
import ra.restapi_basic.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<DataResponse> getAllCategories(){
        return new ResponseEntity<>(new DataResponse(categoryService.getCategories(), HttpStatus.OK),HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<DataResponse> getById(@PathVariable("categoryId")String categoryId){
        return new ResponseEntity<>(new DataResponse(categoryService.getCategoryById(categoryId),HttpStatus.OK),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse> insertCategory(@RequestBody Category cate){
        return new ResponseEntity<>(new DataResponse(categoryService.insertCategory(cate),HttpStatus.CREATED),HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<DataResponse> upateCategory(@PathVariable("categoryId")String categoryId, @RequestBody Category cate){
        return new ResponseEntity<>(new DataResponse(categoryService.updateCategory(categoryId,cate),HttpStatus.OK),HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<DataResponse> deleteCategory(@PathVariable("categoryId")String categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(new DataResponse("Đã xóa thành công category có mã: "+categoryId,HttpStatus.NO_CONTENT),HttpStatus.OK);
    }

    @GetMapping("/searchByName/{categoryName}")
    public ResponseEntity<DataResponse> searchCategoryByName(@PathVariable("categoryName")String categoryName){
        return  new ResponseEntity<>(new DataResponse(categoryService.getCategoriesByName(categoryName),HttpStatus.OK),HttpStatus.OK);
    }
}
