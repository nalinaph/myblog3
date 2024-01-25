package com.myblog.myblog3.controller;

import com.myblog.myblog3.payload.PostDto;
import com.myblog.myblog3.service.PostService;
import com.myblog.myblog3.service.impl.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postdto)
    {
       PostDto dto = postService.createPost(postdto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
     //return null;
    }

}
