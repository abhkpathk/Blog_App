package com.Proj.blogApp.impl;

import com.Proj.blogApp.entities.Category;
import com.Proj.blogApp.exceptions.ResourceNotFoundException;
import com.Proj.blogApp.payloads.CategoryDto;
import com.Proj.blogApp.repositories.CategoryRepo;
import com.Proj.blogApp.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category= this.DtoToEntity(categoryDto);
        Category savedCategory= this.categoryRepo.save(category);
        return this.EntitiToDto(savedCategory);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDesc(categoryDto.getCategoryDesc());
        CategoryDto categoryDto1 = this.EntitiToDto(category);
        return categoryDto1;
    }

    @Override
    public CategoryDto getById(Integer CategoryId) {
        Category category = this.categoryRepo.findById(CategoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Id",CategoryId));
        CategoryDto categoryDto1 = this.EntitiToDto(category);
        return categoryDto1;
    }

    @Override
    public CategoryDto deleteCategory(Integer CategoryId) {
        Category category = this.categoryRepo.findById(CategoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Id",CategoryId));
         this.categoryRepo.delete(category);
        return null;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> category= this.categoryRepo.findAll();
        List<CategoryDto> categoryDtos = category.stream().map(category1 -> this.EntitiToDto(category1)).collect(Collectors.toList());
        return categoryDtos;
    }

    public Category DtoToEntity(CategoryDto categoryDto)
    {
        Category category = this.modelMapper.map(categoryDto,Category.class);
        return category;
    }

    public CategoryDto EntitiToDto(Category category)
    {
        CategoryDto categoryDto = this.modelMapper.map(category,CategoryDto.class);
        return categoryDto;
    }
}
