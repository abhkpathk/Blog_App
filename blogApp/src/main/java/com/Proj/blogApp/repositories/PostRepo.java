package com.Proj.blogApp.repositories;

import com.Proj.blogApp.entities.Category;
import com.Proj.blogApp.entities.Post;
import com.Proj.blogApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
