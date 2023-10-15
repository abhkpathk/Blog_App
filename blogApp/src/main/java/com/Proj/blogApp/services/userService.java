package com.Proj.blogApp.services;

import com.Proj.blogApp.payloads.userDto;

import java.util.List;

public interface userService {

    userDto createUser(userDto user);
    userDto updateUser(userDto user,int userId);
    userDto getUserById(int userId);
    List<userDto> getAllUser();
    void deletUser(int userId);

}
