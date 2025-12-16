package com.iss.springboot.EntityRelationships;

public class ManytoMany {
    // the ManytoMany relationship will be unique from both the onetoone and onetomany relationship
    // in this relationship we will be handling the collections

    /// UNIDIRECTIONAL @ManytoMany
    // we will use the post and comments model for representing the ManytoMany relationship
    // with a new class called the Locations
    // the locations will be related to the post entity in a ManytoMany relationship

    // for the post class we are adding the location
    // set up many-to-many relationship with the Location class
    // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // private Set<Location> locations;

    //and the location entity will be
//    @Entity
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    public class Location {
//
//        @Id
//        @GeneratedValue
//        private Long id;
//
//        @Column(nullable = false)
//        private String name;
//
//        @Column(nullable = false)
//        private Long latitude;
//
//        @Column(nullable = false)
//        private Long longitude;
//    }

    // this will create a unidirectional ManytoMany relationship from post to location and post is the owner
    // for the creating of join table we will be resulting with
    // post->id,content,username ,
    // comments->id,content,username,post_id (OnetoMany unidirectional join)
    // post-location join table -> post_id,location_id(post to location unidirectional,with post as its owner)
    // Locations->id,latitude,longitude,name


    /// BIDIRECTIONAL @ManyToMany
    //Creating a bidirectional many-to-many relationship is
    // similar to the switch from unidirectional to bidirectional for many-to-one relationships.
    // Create a new field in the unaware class of type List<T>, Set<T>, or any other Collection<T>,
    // where T represents the other entity to be related.
    // Mark the new field with @ManyToMany, and utilize the mappedBy attribute to specify
    // which field in the owning side manages the relationship.

    //post
    // @Entity
    //@Getter
    //@Setter
    //@NoArgsConstructor
    //public class Post {
    //
    //   @Id
    //   @GeneratedValue
    //   private Long id;
    //
    //   @Column(nullable = false, updatable = false)
    //   private String username;
    //
    //   @Column(nullable = false)
    //   private String content;
    //
    //   @OneToMany(cascade = CascadeType.ALL)
    //   @JoinColumn(name = "post_id", nullable = false)
    //   private Set<Comment> comments;
    //
    //   @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //   private Set<Location> locations;
    //}
    //location class
    // this annotation refers to the
    //   // locations field in the Post class
    // @ManytoMany(mappedBy="location")
    // private Set<Post> posts;

    // therefore we can say that post will be the parent which does not contain any mappedBy

}
