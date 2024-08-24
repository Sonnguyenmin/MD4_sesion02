package ra.restapi_basic.service;

import ra.restapi_basic.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryById(String categoryId);
    Category insertCategory(Category category);
    Category updateCategory(String categoryId, Category category);
    void deleteCategory(String categoryId);
    List<Category> getCategoriesByName(String categoryName);
}
