package com.quickshop.onlinestore.service;

import com.quickshop.onlinestore.model.Category;
import com.quickshop.onlinestore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    //private List<Category> categories=new ArrayList<>();
   // private Long nextId= 1L;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        //return categories;
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        //category.setCategoryId(nextId++);
        //categories.add(category);
        categoryRepository.save(category);

    }

    @Override
    public String deleteCategory(Long categoryId) {
        //Category category=categories.stream().filter(c->c.getCategoryId().equals(categoryId)).findFirst().get();
        //Category category=categories.stream().filter(c->c.getCategoryId().equals(categoryId)).findFirst().orElse(null);
        Category category=categoryRepository.findById(categoryId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));

        categoryRepository.delete(category);
        return "Category with categoryId "+categoryId+" deleted successfully";
    }
    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category savedCategory=categoryRepository.findById(categoryId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found"));
        category.setCategoryId(categoryId);

       return categoryRepository.save(category);

    }


}
