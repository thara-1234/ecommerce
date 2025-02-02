package com.quickshop.onlinestore.service;

import com.quickshop.onlinestore.model.Category;
import com.quickshop.onlinestore.payload.CategoryDTO;
import com.quickshop.onlinestore.payload.CategoryResponse;

public interface CategoryService {
CategoryResponse getAllCategories(Integer pageNumber,Integer pageSize,String sortBy,String sortOrder);
CategoryDTO createCategory(CategoryDTO categoryDTO);
CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
