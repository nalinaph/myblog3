package com.myblog.myblog3.service.impl;

import com.myblog.myblog3.entity.Post;
import com.myblog.myblog3.payload.PostDto;
import com.myblog.myblog3.repository.PostRepository;
import com.myblog.myblog3.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
@Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
    Post savePost = postRepository.save(post);
    PostDto Dto = new PostDto();
    postDto.setTitle(savePost.getTitle());
    postDto.setContent(savePost.getContent());
    postDto.setDescription(savePost.getDescription());
    return postDto;

    }


}

