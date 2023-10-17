package com.Proj.blogApp.impl;

import com.Proj.blogApp.entities.User;
import com.Proj.blogApp.exceptions.ResourceNotFoundException;
import com.Proj.blogApp.payloads.userDto;
import com.Proj.blogApp.repositories.userRepo;
import com.Proj.blogApp.services.userService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class userServiceImpl implements userService {

    @Autowired
    private userRepo userrepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public userDto createUser(userDto userdto) {
        User user = this.dtoToEntity(userdto);
        User savedUser= this.userrepo.save(user);
        return this.entityToDto(savedUser);
    }

    @Override
    public userDto updateUser(userDto userdto, int userId) {
        User user = this.userrepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        user.setName(userdto.getName());
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        user.setAbout(userdto.getAbout());
        User savedUser =this.userrepo.save(user);
        userDto userDto1=this.entityToDto(savedUser);
        return userDto1;
    }

    @Override
    public userDto getUserById(int userId) {

        User user = this.userrepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        return this.entityToDto(user);
    }

    @Override
    public List<userDto> getAllUser() {
        List<User> users = this.userrepo.findAll();
        List<userDto> userdtos = users.stream().map(user -> this.entityToDto(user)).collect(Collectors.toList());
        return userdtos;
    }

    @Override
    public void deletUser(int userId) {
        User user = this.userrepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        this.userrepo.delete(user);
    }

    public User dtoToEntity(userDto userdto)
    {
        User user=this.modelMapper.map(userdto,User.class);

        /*user.setId(userdto.getId());
        user.setName(userdto.getName());
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        user.setAbout(userdto.getAbout());*/

        return user;
    }

    public userDto entityToDto(User user)
    {
        userDto userdto=this.modelMapper.map(user,userDto.class);

       /* userdto.setId(user.getId());
        userdto.setName(user.getName());
        userdto.setEmail(user.getEmail());
        userdto.setPassword(user.getPassword());
        userdto.setAbout(user.getAbout());*/

        return userdto;
    }
}
