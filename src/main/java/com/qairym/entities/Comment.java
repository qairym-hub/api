package com.qairym.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "comments")
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long commentId;

    @ManyToOne
    @JoinColumn(
        name = "author_id",
        nullable = false
    )
    @JsonBackReference(value = "user-comments")
    private User author;

    @ManyToOne
    @JoinColumn(
        name = "post_id",
        nullable = false
    )
    @JsonBackReference
    private Post post;

    @OneToMany(mappedBy = "liker")
    private Collection<Like> likes;
}