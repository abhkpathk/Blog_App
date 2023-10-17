package com.Proj.blogApp.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CategoryDto {

    private Integer CategoryId;

    @NotEmpty
    @Size(min=4,message = "size must be greater than 4 ")
    private String CategoryTitle;

    @NotEmpty
    @Size(min=10,message = "size must be greater than 10")
    private String CategoryDesc;

    public Integer getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Integer categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryTitle() {
        return CategoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        CategoryTitle = categoryTitle;
    }

    public String getCategoryDesc() {
        return CategoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        CategoryDesc = categoryDesc;
    }

    public CategoryDto(Integer categoryId, String categoryTitle, String categoryDesc) {
        CategoryId = categoryId;
        CategoryTitle = categoryTitle;
        CategoryDesc = categoryDesc;
    }

    public CategoryDto() {
    }
}
