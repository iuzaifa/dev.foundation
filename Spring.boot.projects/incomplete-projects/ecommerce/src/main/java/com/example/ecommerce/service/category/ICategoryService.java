package com.example.ecommerce.service.category;

import com.example.ecommerce.model.Category;

import java.util.List;

public interface ICategoryService {

    Category getCategoryById(Long id);
    Category getCateGortByName(String name);
    List<Category> getAllCategories();

    Category addCategory(Category category);
    Category updateCategoryById(Long id, Category category);

    void  deleteCategoryById(Long id);
}
