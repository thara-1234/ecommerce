package com.quickshop.onlinestore.repositories;

import com.quickshop.onlinestore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
