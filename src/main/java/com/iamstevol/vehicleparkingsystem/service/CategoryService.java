package com.iamstevol.vehicleparkingsystem.service;

import com.iamstevol.vehicleparkingsystem.dto.request.CategoryRequestDto;
import com.iamstevol.vehicleparkingsystem.dto.request.UpdateRequestDto;
import com.iamstevol.vehicleparkingsystem.dto.response.CategoryResponseDto;
import com.iamstevol.vehicleparkingsystem.entity.Category;
import org.hibernate.sql.Update;

import java.util.Optional;

public interface CategoryService {

    CategoryResponseDto addCategory (CategoryRequestDto request);

    CategoryResponseDto editCategory(UpdateRequestDto request, String categoryId);

    void deleteCategory (String categoryId);
}
