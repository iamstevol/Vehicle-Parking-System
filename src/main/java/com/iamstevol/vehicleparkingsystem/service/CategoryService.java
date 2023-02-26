package com.iamstevol.vehicleparkingsystem.service;

import com.iamstevol.vehicleparkingsystem.dto.request.CategoryRequestDto;
import com.iamstevol.vehicleparkingsystem.entity.Category;

import java.util.Optional;

public interface CategoryService {

    Optional<Category> addCategory (CategoryRequestDto request);

    Category editCategory (CategoryRequestDto request);

    void deleteCategory ();
}
