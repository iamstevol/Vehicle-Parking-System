package com.iamstevol.vehicleparkingsystem.repository;

import com.iamstevol.vehicleparkingsystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
    Category findCategoriesByCategoryName(String categoryName);
}
