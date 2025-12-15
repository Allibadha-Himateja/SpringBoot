package com.iss.springboot.EntityRelationships;

public class OnetoManyandManytoOne {
    // similar to onetoone relationships we are having the variations of relationship in onetomany and manytoone
    // onetomany and manytoone are the constract to each other
    // Deciding which to use only applies to unidirectional relationships since
    // bidirectional relationships require the use of both (one on the parent side, and one on the child side).

    /// UNIDIRECTIONAL @OneToMany Relationship
    // 1)Annotate the field with @OneToMany: The annotation is placed on the "one" side of the relationship.
    // It indicates that one instance of this entity (the parent) can be associated with multiple instances of another entity (the children).
    // 2)Ensure the field is a type of Collection: The field that is annotated with @OneToMany should be a List<T>, Set<T>, or any other Collection<T>, where T represents the entity type on the "many" side.
    // This is important because the parent needs a place to store multiple children.
    // 3)Set up a join column: The default behavior for a @OneToMany relationship is to use a join table,
    // but you can optionally use the @JoinColumn annotation to use a join column instead.
    // understand the unidirectional relationship with post and comment relationship

    // IMPORTANT NOTE FROM UNIDIRECTIONAL ONETOMANY
    // It was previously stated that the owning side of a relationship typically contains the join column in its database table. However,
    // @OneToMany relationships are an exception,
    // where the join column is found in the table of the entity on the "many" side, in this case the Comments table.
    // that means even though the parent/owner of the unidirectional relationship is post
    // the new column that is foreign key is created at Many side (in this case its child side)

    /// UNIDIRECTIONAL @ManytoOne Relationship
    // this is much straightforward then onetomany
    //public class Post {
    //    @Id
    //    @GeneratedValue
    //    private Long id;
    //    @Column(nullable = false, updatable = false)
    //    private String username;
    //    @Column(nullable = false)
    //    private String content;
    //}
    //public class Comment {
    //    @Id
    //    @GeneratedValue
    //    private Long id;
    //    @Column(nullable = false, updatable = false)
    //    private String username;
    //    @Column(nullable = false)
    //    private String content;
    //    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    //    private Post post;
    //}

    ///  BIDIRECTIONAL @OnetoMany and @ManytoOne
    // this is similar to onetoone bidirectional but it had few differences
    // 1) @ManyToOne Side: This is usually considered the "parent" or "owning" side of the relationship,
    // since this entity will have a foreign key column in its table that points to the primary key of the entity on the "one" side.
    // 2) @OneToMany Side: This is usually the "child" side of the relationship,
    // using the mappedBy attribute to indicate such. @ManyToOne does not offer a mappedBy attribute.
    // 3) Configuration: While the @ManyToOne side generally manages the foreign key,
    // both sides of the relationship can have additional configuration.
    // For example, you might configure cascade types or fetch strategies on both sides of the relationship.

    //public class Post {
    //    @Id
    //    @GeneratedValue
    //    private Long id;
    //    @Column(nullable = false, updatable = false)
    //    private String username;
    //    @Column(nullable = false)
    //    private String content;
    //
    //    // this annotation references the configuration
    //    // on the post field in the Comment class
    //    @OneToMany(mappedBy = "post")
    //    private Set<Comment> comments;
    //}
    //public class Comment {
    //    @Id
    //    @GeneratedValue
    //    private Long id;
    //    @Column(nullable = false, updatable = false)
    //    private String username;
    //    @Column(nullable = false)
    //    private String content;
    //
    //    @ManyToOne(
    //            cascade = CascadeType.ALL,
    //            optional = false
    //    )
    //    private Post post;
    //}

    /// THE PROBLEM OF BDIRECTIONAL RELATIONSHIP
    // When saving changes, actions should take place from the owning side -
    // in this case, the Comment class. You should set the relationship through Comment rather than directly modifying the Set<Comment> in Post.
    // This will ensure consistent and reliable synchronization of the relationship in the database.
    //// correct approach
    //// setting the relationship on the owning-side
    //comment.setPost(post);
    //saveComment(comment);
    //
    //// instead of
    //post.getComments().add(post);
    //savePost(post);
}
