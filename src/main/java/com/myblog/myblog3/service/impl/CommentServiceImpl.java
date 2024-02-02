package com.myblog.myblog3.service.impl;
import com.myblog.myblog3.entity.Comment;
import com.myblog.myblog3.entity.Post;
import com.myblog.myblog3.exception.ResourceNotFoundException;
import com.myblog.myblog3.payload.CommentDto;
import com.myblog.myblog3.repository.CommentRepository;
import com.myblog.myblog3.repository.PostRepository;
import com.myblog.myblog3.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
@Service

public class CommentServiceImpl implements CommentService {
    PostRepository postRepository;
    CommentRepository commentRepository;
    ModelMapper modelMapper;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;

        this.modelMapper = modelMapper;
    }

    public CommentDto createComment(CommentDto commentDto, Long postId) {

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post not found with id" + postId));
        Comment comment = new Comment();
        //comment.setId(commentDto.getId());
        comment.setText(commentDto.getText());
        comment.setEmail(commentDto.getEmail());
        comment.setPost(post);
        Comment savedcomment = commentRepository.save(comment);
        CommentDto dto = new CommentDto();
        // dto.setId(savedcomment.getId());
        dto.setText(savedcomment.getText());
        dto.setEmail(savedcomment.getEmail());
        return dto;


    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updatecomment(CommentDto commentDto, long id, long postId) {
        Post post=postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("comment not found with ID" + id));

        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("comment not found with ID" + id));
        Comment c = maptoEntity(commentDto);

        c.setId(comment.getId());
        c.setPost(post);

        Comment savedComment = commentRepository.save(c);

        return maptoDto(comment);
    }

    CommentDto maptoDto(Comment comment) {
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
        return dto;
    }

    Comment maptoEntity(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return comment;

    }
}