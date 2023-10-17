package com.Proj.blogApp.services;

import com.Proj.blogApp.entities.Post;
import com.Proj.blogApp.payloads.PostDto;

import java.util.List;

public interface PostService {

    PostDto CreatePost(PostDto postDto,Integer userId,Integer CategoryId);

    PostDto UpdatePost(PostDto postDto,Integer postId);

    void DeletePost(Integer postId);

    List<PostDto> getAllPost();

    PostDto getPostById(Integer postId);

    List<PostDto> getPostByUser(Integer userId);

    List<PostDto> getPostByCategory(Integer categoryId);

    List<PostDto> searchPost(String keyword);
}
