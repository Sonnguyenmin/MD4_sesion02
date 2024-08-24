package ra.restapi_basic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.restapi_basic.model.entity.Category;
import ra.restapi_basic.repository.CategoryRepository;
import ra.restapi_basic.service.CategoryService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(String categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(()->new NoSuchElementException("Khong co danh muc nao co ma: "+categoryId));
    }

    @Override
    public Category insertCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(String categoryId, Category category) {
        categoryRepository.findById(categoryId).orElseThrow(()-> new NoSuchElementException("Khong ton tai danh muc nao co ma: "+category.getCategoryId()));
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(String categoryId) {
        categoryRepository.findById(categoryId).orElseThrow(() -> new NoSuchElementException("Khong ton tai category: "+categoryId));
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public List<Category> getCategoriesByName(String categoryName) {
        return categoryRepository.findCategoryByCategoryNameContains(categoryName);
    }
}
