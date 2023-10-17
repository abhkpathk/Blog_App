package com.Proj.blogApp.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PostId;

    @Column(name = "post_title",length = 100)
    private String PTitle;

    @Column(name = "post_content",length = 1000)
    private String Pcontent;

    @Column(name = "image_url",length = 100)
    private String imagename;

    @Column(name = "addeddate",length = 100)
    private Date  AddedDate;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne
    private User user;


    public Integer getPostId() {
        return PostId;
    }

    public void setPostId(Integer postId) {
        PostId = postId;
    }

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

    public Post(Integer postId, String PTitle, String pcontent, String imagename, Date addedDate, Category category, User user) {
        PostId = postId;
        this.PTitle = PTitle;
        Pcontent = pcontent;
        this.imagename = imagename;
        AddedDate = addedDate;
        this.category = category;
        this.user = user;
    }

    public Post() {
    }
}
