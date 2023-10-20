package com.Proj.blogApp.impl;

import com.Proj.blogApp.entities.Category;
import com.Proj.blogApp.entities.Post;
import com.Proj.blogApp.entities.User;
import com.Proj.blogApp.exceptions.ResourceNotFoundException;
import com.Proj.blogApp.payloads.PostDto;
import com.Proj.blogApp.payloads.PostResponse;
import com.Proj.blogApp.repositories.CategoryRepo;
import com.Proj.blogApp.repositories.PostRepo;
import com.Proj.blogApp.repositories.userRepo;
import com.Proj.blogApp.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private userRepo userrepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto CreatePost(PostDto postDto,Integer userId,Integer CategoryId)
    {
        User user= this.userrepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","user Id",userId));
        Category category= this.categoryRepo.findById(CategoryId).orElseThrow(()-> new ResourceNotFoundException("Catogery","category Id",CategoryId));
        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImagename("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post savePost = this.postRepo.save(post);
        return this.modelMapper.map(savePost,PostDto.class );
    }

    @Override
    public PostDto UpdatePost(PostDto postDto, Integer postId)
    {
     //   User user= this.userrepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","user Id",userId));
     //   Category category= this.categoryRepo.findById(CategoryId).orElseThrow(()-> new ResourceNotFoundException("Catogery","category Id",CategoryId));
        Post post= this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post Id",postId));
        //Post post = this.modelMapper.map(postDto, Post.class);
    //    post.setPostId(postDto.getPostId());
        post.setPTitle(postDto.getPTitle());
        post.setPcontent(postDto.getPcontent());
        post.setImagename("default.png");
    //    post.setAddedDate(new Date());
    //    post.setUser(user);
    //    post.setCategory(category);

        Post updatePost = this.postRepo.save(post);
        return this.modelMapper.map(updatePost,PostDto.class );
    }

    @Override
    public void DeletePost(Integer postId) {
        Post post= this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post Id",postId));
        this.postRepo.delete(post);


    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize) {

        Pageable p= PageRequest.of(pageNumber,pageSize);

        Page<Post> pagepost =this.postRepo.findAll( p);

        List<Post> posts = pagepost.getContent();

        List<PostDto> postdtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        PostResponse postRes=new PostResponse();
        postRes.setContent(postdtos);
        postRes.setPageNumber(pagepost.getNumber());
        postRes.setPageSize(pagepost.getSize());
        postRes.setTotalElemnt(pagepost.getTotalPages());
        postRes.setTotalpages(pagepost.getTotalPages());

        return postRes;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post2 =this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","postId",postId));
        //List<Post> posts =this.postRepo.findById(post2);
       // List<PostDto> postdtos = posts.stream().map((post) -> this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());


        PostDto postDtos = this.modelMapper.map(post2, PostDto.class);
        return postDtos;
    }

    @Override
    public PostResponse getPostByUser(Integer userId,int pageNumber, int pageSize) {
        Pageable p= PageRequest.of(pageNumber,pageSize);
        User user =this.userrepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("USer","userId",userId));
        //List<Post> posts =this.postRepo.findByUser(user);


        Page<Post> pagepost =  this.postRepo.findByUser(user,p);
        List<Post> posts = pagepost.getContent();

        List<PostDto> postdtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        PostResponse postRes =new PostResponse();

        postRes.setContent(postdtos);
        postRes.setPageNumber(pagepost.getNumber());
        postRes.setPageSize(pagepost.getSize());
        postRes.setTotalElemnt((int) pagepost.getTotalElements());
        postRes.setTotalpages(pagepost.getTotalPages());
        return postRes;
    }

    @Override
    public PostResponse getPostByCategory(Integer categoryId,Integer pageNumber,Integer pageSize) {
        Pageable p= PageRequest.of(pageNumber,pageSize);
        Category category =this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId));
        Page<Post> pagepost =this.postRepo.findByCategory(category,p);
        List<Post> posts=pagepost.getContent();
        List<PostDto> postdtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        PostResponse postRes =new PostResponse();

        postRes.setContent(postdtos);
        postRes.setPageNumber(pagepost.getNumber());
        postRes.setPageSize(pagepost.getSize());
        postRes.setTotalElemnt((int) pagepost.getTotalElements());
        postRes.setTotalpages(pagepost.getTotalPages());
        return postRes;

    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        return null;
    }
}
