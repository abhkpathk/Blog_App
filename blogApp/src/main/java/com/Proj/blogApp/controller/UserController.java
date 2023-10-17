package com.Proj.blogApp.controller;

import com.Proj.blogApp.impl.userServiceImpl;
import com.Proj.blogApp.payloads.ApiResponse;
import com.Proj.blogApp.payloads.userDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private userServiceImpl userserviceimpl;

    @PostMapping("/")
    public ResponseEntity<userDto> createUser(@Valid @RequestBody userDto userdto)
    {
        userDto createdUser = userserviceimpl.createUser(userdto);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<userDto> updateUser(@RequestBody userDto userdto,@PathVariable("userId") int uid)
    {
        userDto updatedUser = userserviceimpl.updateUser(userdto,uid);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<userDto> getUserById(@PathVariable("userId") int uid)
    {
        userDto UserById = userserviceimpl.getUserById(uid);
        return ResponseEntity.ok(UserById);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<userDto>> getAllUser()
    {
        List<userDto> allUser = userserviceimpl.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> DeleteUser(@PathVariable("userId") int uid)
    {
         userserviceimpl.deletUser(uid);

        return new ResponseEntity(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
    }

}
