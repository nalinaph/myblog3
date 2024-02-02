package com.myblog.myblog3.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.boot.autoconfigure.web.WebProperties;
@Entity
@Table(name="comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private  String text;
    private String email;
    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

}
