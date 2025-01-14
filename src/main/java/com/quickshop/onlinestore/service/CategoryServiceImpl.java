package com.quickshop.onlinestore.service;

import com.quickshop.onlinestore.exception.APIException;
import com.quickshop.onlinestore.exception.ResourceNotFoundException;
import com.quickshop.onlinestore.model.Category;
import com.quickshop.onlinestore.payload.CategoryDTO;
import com.quickshop.onlinestore.payload.CategoryResponse;
import com.quickshop.onlinestore.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryResponse getAllCategories() {
        List<Category> categories=categoryRepository.findAll();
        if(categories.isEmpty())
            throw new APIException("No Category created till now.");
        List<CategoryDTO> categoryDTOS=categories.stream().map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();
        CategoryResponse categoryResponse=new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        return categoryResponse;
    }

    @Override
    public void createCategory(Category category) {
        Category savedCategory=categoryRepository.findByCategoryName(category.getCategoryName());
        if(savedCategory!=null)
            throw new APIException("Category with the name "+category.getCategoryName()+" already exists!!!");
        categoryRepository.save(category);

    }
    @Override
    public String deleteCategory(Long categoryId) {
        //Category category=categories.stream().filter(c->c.getCategoryId().equals(categoryId)).findFirst().get();
        //Category category=categories.stream().filter(c->c.getCategoryId().equals(categoryId)).findFirst().orElse(null);
        Category category=categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));

        categoryRepository.delete(category);
        return "Category with categoryId "+categoryId+" deleted successfully";
    }
    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category savedCategory=categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        category.setCategoryId(categoryId);

       return categoryRepository.save(category);

    }
}
