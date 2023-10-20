package com.Proj.blogApp.services;

import com.Proj.blogApp.entities.Post;
import com.Proj.blogApp.payloads.PostDto;
import com.Proj.blogApp.payloads.PostResponse;

import java.util.List;

public interface PostService {

    PostDto CreatePost(PostDto postDto,Integer userId,Integer CategoryId);

    PostDto UpdatePost(PostDto postDto,Integer postId);

    void DeletePost(Integer postId);

    PostResponse getAllPost(Integer pageNumber, Integer pageSize);

    PostDto getPostById(Integer postId);

    PostResponse getPostByUser(Integer userId,int pageNumber, int pageSize);

    PostResponse getPostByCategory(Integer categoryId,Integer pageNumber, Integer pageSize);

    List<PostDto> searchPost(String keyword);
}
