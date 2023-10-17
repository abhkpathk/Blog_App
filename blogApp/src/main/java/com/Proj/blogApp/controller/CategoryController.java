package com.Proj.blogApp.controller;


import com.Proj.blogApp.impl.CategoryServiceImpl;
import com.Proj.blogApp.payloads.ApiResponse;
import com.Proj.blogApp.payloads.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCatogery(@Valid @RequestBody CategoryDto categoryDto)
    {
        CategoryDto createdCategory = categoryServiceImpl.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @PostMapping("/{CategoryId}")
    public ResponseEntity<CategoryDto> updateCatogery(@Valid @RequestBody CategoryDto categoryDto,@PathVariable("CategoryId") Integer categoryId)
    {
        CategoryDto updatedCategory = categoryServiceImpl.updateCategory(categoryDto,categoryId);
        return ResponseEntity.ok(updatedCategory);
    }

    @GetMapping("/{CategoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("CategoryId") Integer categoryId)
    {
        CategoryDto getCategory = categoryServiceImpl.getById(categoryId);
        return ResponseEntity.ok(getCategory);
    }

    @DeleteMapping("/{CategoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("CategoryId") Integer categoryId)
    {
        categoryServiceImpl.deleteCategory(categoryId);
        Long timestamp = System.currentTimeMillis();
        return new ResponseEntity<>(new ApiResponse(timestamp,"Deleted successfully",true), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDto>> getAll()
    {
        List<CategoryDto> allCategory = categoryServiceImpl.getAllCategory();
        return ResponseEntity.ok(allCategory);
    }

}
