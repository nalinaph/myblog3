package com.myblog.myblog3.repository;

import com.myblog.myblog3.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
