package com.iamstevol.vehicleparkingsystem.repository;

import com.iamstevol.vehicleparkingsystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{

    boolean existsByCategoryName (String categoryName);

    Category findCategoriesByCategoryName(String category);
}
