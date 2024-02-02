package com.myblog.myblog3.service;

import com.myblog.myblog3.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Long postId);

    void deleteComment(long id);

    CommentDto updatecomment(CommentDto commentDto, long id, long postId);
}
