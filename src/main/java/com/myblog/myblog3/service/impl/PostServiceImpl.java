package com.myblog.myblog3.service.impl;

import com.myblog.myblog3.entity.Post;
import com.myblog.myblog3.exception.ResourceNotFoundException;
import com.myblog.myblog3.payload.PostDto;
import com.myblog.myblog3.repository.PostRepository;
import com.myblog.myblog3.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;

        this.modelMapper = modelMapper;
    }
@Override
    public PostDto createPost(PostDto postDto) {

        Post post = mapToEntity(postDto);


      //  Post post = new Post();

//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
   Post savedPost = postRepository.save(post);
 //   PostDto dto = new PostDto();
//    dto.setId(savePost.getId());
//    dto.setTitle(savePost.getTitle());
//    dto.setContent(savePost.getContent());
//    dto.setDescription(savePost.getDescription());
    PostDto dto= mapToDto(savedPost);
    return dto;

    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post not found with Id" + id)
        );
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());
        return dto;

      }

    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
       Pageable pageable = PageRequest.of(pageNo,pageSize, sort);
        Page<Post> pagePosts = postRepository.findAll(pageable);
        List<Post> posts = pagePosts.getContent();
        List<PostDto> dtos = posts.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return dtos;
    }
    PostDto mapToDto(Post post)
    {

         PostDto dto =  modelMapper.map(post,PostDto.class);
//        PostDto dto = new PostDto();
//        dto.setId(post.getId());
//        dto.setTitle(post.getTitle());
//        dto.setContent(post.getContent());
//        dto.setDescription(post.getDescription());
        return dto;
    }

    Post mapToEntity(PostDto postDto)
    {
        Post post = modelMapper.map(postDto,Post.class);
//        Post post = new Post();
//       // post.setId(postDto.getId());
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
       return post;

    }

}

