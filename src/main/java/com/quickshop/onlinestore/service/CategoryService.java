package com.quickshop.onlinestore.service;

import com.quickshop.onlinestore.model.Category;
import com.quickshop.onlinestore.payload.CategoryDTO;
import com.quickshop.onlinestore.payload.CategoryResponse;

public interface CategoryService {
CategoryResponse getAllCategories();
CategoryDTO createCategory(CategoryDTO categoryDTO);
String deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
