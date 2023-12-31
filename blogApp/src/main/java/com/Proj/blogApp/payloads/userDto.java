package com.Proj.blogApp.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class userDto {

    private int id;
    @NotEmpty
    @Size(min=4,message = "size must be min of 4")
    private String name;
    @Email(message = "Email address is not valid")
    private String email;

    @NotEmpty
    @Size(min=3,max=10,message = "size must be min 4 and max 10 chars!")
    private String password;
    @NotEmpty
    private String about;

    public userDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public userDto(int id, String name, String email, String password, String about) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.about = about;
    }
}
