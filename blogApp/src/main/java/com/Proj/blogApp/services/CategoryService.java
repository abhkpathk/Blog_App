package com.Proj.blogApp.services;

import com.Proj.blogApp.entities.Category;
import com.Proj.blogApp.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
    CategoryDto getById(Integer CategoryId);
    CategoryDto deleteCategory(Integer CategoryId);
    List<CategoryDto> getAllCategory();
}
