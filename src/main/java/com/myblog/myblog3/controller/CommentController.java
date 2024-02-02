package com.myblog.myblog3.controller;

import com.myblog.myblog3.payload.CommentDto;
import com.myblog.myblog3.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")

//http://localhost:8080/api/comments?postId=1
public class CommentController {
   private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
   public ResponseEntity<CommentDto> createComment
           (@RequestBody CommentDto commentDto,
            @RequestParam long postId)
   {


          CommentDto dto = commentService.createComment(commentDto,postId);
          return new ResponseEntity<>(dto, HttpStatus.CREATED);

   }

   @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id)
   {
       commentService.deleteComment(id);
       return new ResponseEntity<> ("Comment is deleted", HttpStatus.OK);

   }
   @PutMapping ("/{id}/post/{postId}")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto,@PathVariable long id,@PathVariable long postId)
   {
        CommentDto dto = commentService.updatecomment(commentDto,id,postId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
   }

}
