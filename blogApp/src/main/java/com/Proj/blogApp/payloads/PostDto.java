package com.Proj.blogApp.payloads;

import com.Proj.blogApp.entities.Category;
import com.Proj.blogApp.entities.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class PostDto {

    private Integer PostId;
    private String PTitle;


    private String Pcontent;

    private String imagename;

    private Date AddedDate;

    private Category category;

    private User user;

    public String getPTitle() {
        return PTitle;
    }

    public void setPTitle(String PTitle) {
        this.PTitle = PTitle;
    }

    public String getPcontent() {
        return Pcontent;
    }

    public void setPcontent(String pcontent) {
        Pcontent = pcontent;
    }


    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public Date getAddedDate() {
        return AddedDate;
    }

    public void setAddedDate(Date addedDate) {
        AddedDate = addedDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPostId() {
        return PostId;
    }

    public void setPostId(Integer postId) {
        PostId = postId;
    }

    public PostDto(String PTitle, String Pcontent, String imagename, Date addedDate, Category category, User user) {
        this.PTitle = PTitle;
        this.Pcontent = Pcontent;
        this.imagename = imagename;
        AddedDate = addedDate;
        this.category = category;
        this.user = user;
    }

    public PostDto(Integer postId, String PTitle, String pcontent, String imagename, Date addedDate, Category category, User user) {
        PostId = postId;
        this.PTitle = PTitle;
        Pcontent = pcontent;
        this.imagename = imagename;
        AddedDate = addedDate;
        this.category = category;
        this.user = user;
    }

    public PostDto() {
    }
}
