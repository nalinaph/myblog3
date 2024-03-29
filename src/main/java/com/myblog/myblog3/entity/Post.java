package com.myblog.myblog3.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String description;
    private String title;
    private String content;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "post")
    private List<Comment> comments;

}
