package com.iamstevol.vehicleparkingsystem.service.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.iamstevol.vehicleparkingsystem.dto.request.CategoryRequestDto;
import com.iamstevol.vehicleparkingsystem.dto.request.UpdateRequestDto;
import com.iamstevol.vehicleparkingsystem.dto.response.CategoryResponseDto;
import com.iamstevol.vehicleparkingsystem.entity.Category;
import com.iamstevol.vehicleparkingsystem.exception.ResourceCreationException;
import com.iamstevol.vehicleparkingsystem.exception.ResourceNotFoundException;
import com.iamstevol.vehicleparkingsystem.repository.CategoryRepository;
import com.iamstevol.vehicleparkingsystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ReentrantLock lock = new ReentrantLock(true);

    @Override
    @Transactional
    public CategoryResponseDto addCategory(CategoryRequestDto request) {
        lock.lock();
        log.info("create a new category");
        try{
            if (categoryExist(request.getCategoryName())) {
                throw new ResourceCreationException("Category Already Exist");
            }
            Category category = new Category();
            category.setCategoryName(request.getCategoryName());
            Category savedCategory = categoryRepository.save(category);
            return mapToDto(savedCategory);
        } finally {
            lock.unlock();
        }

    }

    @Override
    public CategoryResponseDto editCategory(UpdateRequestDto request, String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category does not exist"));

        if(StringUtils.isNoneBlank(request.getCategoryName())) {
            category.setCategoryName(request.getCategoryName());
        }
        Category savedCategory = categoryRepository.save(category);
        return mapToDto(savedCategory);
    }

    @Override
    public void deleteCategory(String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category does not exist"));

        if(category != null) {
            categoryRepository.delete(category);
        }
    }

    boolean categoryExist(String categoryName) {
        return categoryRepository.existsByCategoryName(categoryName);
    }

    public CategoryResponseDto mapToDto(Category category) {
        return CategoryResponseDto.builder()
                .categoryName(category.getCategoryName())
                .build();
    }
}
