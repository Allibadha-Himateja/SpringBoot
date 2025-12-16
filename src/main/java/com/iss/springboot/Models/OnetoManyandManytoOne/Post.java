package com.iss.springboot.Models.OnetoManyandManytoOne;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, updatable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(// use name post_id instead of the default comments_id
            name = "post_id",
            // no comments without a related post
            nullable = false
    )
    // To solve the below problem, you can indicate a better name for the join column like this:
    private List<Comment> comments;
    // understand the rules of unidirectional @OnetoMany
    // the result of this relationship will create two tables which are post and comment
    // but but but there is a twist in creation of tables

    /// the post table will contain three columns instead of four
    /// and the comment table will contain four columns instead of three(comments_id is the new column in comments table)
    // THIS IS BECAUSE
    // Spring generated join column.
    // The default naming behavior is to append _id onto the end of the @OneToMany annotated field name.
    // In this case, that resulted in comments_id.
    // Even though this works, it is inadequate. Anyone who takes a look at the table will be confused.

    // set up many-to-many relationship with the Location class
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Location> locations;

    // this will create a unidirectional ManytoMany relationship from post to location and post is the owner
    // for the creating of join table we will be resulting with
    // post->id,content,username ,
    // comments->id,content,username,post_id (OnetoMany unidirectional join)
    // post-location join table -> post_id,location_id(post to location unidirectional,with post as its owner)
    // Locations->id,latitude,longitude,name



}
