package com.Proj.blogApp.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CategoryId;


    @Column(name = "title",length=100,nullable=false)
    private String CategoryTitle;

    @NotEmpty
    @Size(min=10)
    @Column(name = "description",length=100,nullable=false)
    private String CategoryDesc;

    public Category() {

    }

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

    public Category(Integer categoryId, String categoryTitle, String categoryDesc) {
        CategoryId = categoryId;
        CategoryTitle = categoryTitle;
        CategoryDesc = categoryDesc;
    }
}
