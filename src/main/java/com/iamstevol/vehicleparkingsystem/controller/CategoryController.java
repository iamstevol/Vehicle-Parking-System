package com.iamstevol.vehicleparkingsystem.controller;

import com.iamstevol.vehicleparkingsystem.dto.request.CategoryRequestDto;
import com.iamstevol.vehicleparkingsystem.dto.request.UpdateRequestDto;
import com.iamstevol.vehicleparkingsystem.dto.response.CategoryResponseDto;
import com.iamstevol.vehicleparkingsystem.service.impl.CategoryServiceImpl;
import com.iamstevol.vehicleparkingsystem.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@Log4j2
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @PostMapping("/addCategory")
    public ResponseEntity<ApiResponse<CategoryResponseDto>> addCategory(@RequestBody @Valid CategoryRequestDto request) {
        log.info("category controller: add category :: [{}] ::", request.getCategoryName());
        CategoryResponseDto response = categoryService.addCategory(request);
        log.info("Success creating category");
        return new ResponseEntity<>(new ApiResponse<>("Category successfully created", true, response), HttpStatus.CREATED);
    }

    @PostMapping("/editCategory/{categoryId}")
    public ResponseEntity<ApiResponse<CategoryResponseDto>> editCategory(@PathVariable("categoryId") String categoryId, @RequestBody UpdateRequestDto request) {
        log.info("category controller: edit category :: [{}] ::", categoryId);
        CategoryResponseDto response = categoryService.editCategory(request, categoryId);
        log.info("Success editing category");
        return new ResponseEntity<>(new ApiResponse<>("Successfull updated category", true, response), HttpStatus.OK);
    }

    @PostMapping("/deleteCategory/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") String categoryId) {
        log.info("category controller: delete category :: [{}] ::", categoryId);
        categoryService.deleteCategory(categoryId);
        log.info("Success deleting category");
        return new ResponseEntity<>("Successfully deleted category", HttpStatus.NO_CONTENT);
    }
}
