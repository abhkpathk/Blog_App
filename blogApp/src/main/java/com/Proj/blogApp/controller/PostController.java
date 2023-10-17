package com.Proj.blogApp.controller;

import com.Proj.blogApp.entities.Post;
import com.Proj.blogApp.impl.PostServiceImpl;
import com.Proj.blogApp.payloads.ApiResponse;
import com.Proj.blogApp.payloads.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostServiceImpl postServiceImpl;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId)
    {
        PostDto createpost = this.postServiceImpl.CreatePost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createpost, HttpStatus.CREATED);
    }

    @PostMapping("/updateposts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId)
    {
        PostDto createpost = this.postServiceImpl.UpdatePost(postDto,postId);
        return new ResponseEntity<PostDto>(createpost, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletepost/{postId}")
    public ResponseEntity<PostDto> deletePost(@PathVariable Integer postId)
    {
        this.postServiceImpl.DeletePost(postId);
        return new ResponseEntity(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PostDto>> getAllPost()
    {
        List<PostDto> allPost = this.postServiceImpl.getAllPost();
        return ResponseEntity.ok(allPost);
    }
}
