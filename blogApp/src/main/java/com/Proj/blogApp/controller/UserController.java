package com.Proj.blogApp.controller;

import com.Proj.blogApp.impl.userServiceImpl;
import com.Proj.blogApp.payloads.userDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private userServiceImpl userserviceimpl;

    @PostMapping("/")
    public ResponseEntity<userDto> createUser(@RequestBody userDto userdto)
    {
        userDto createdUser = userserviceimpl.createUser(userdto);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

}
