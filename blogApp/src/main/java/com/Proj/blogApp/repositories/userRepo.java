package com.Proj.blogApp.repositories;

import com.Proj.blogApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User,Integer> {

}
