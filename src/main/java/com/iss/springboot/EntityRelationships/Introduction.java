package com.iss.springboot.EntityRelationships;

public class Introduction {
    // there are four fundamental annotation for representing th entity relationships
    // those are  @OnetoOne, @OnetoMany, @ManytoOne, @ManytoMany

    // UNIDIRECTIONAL VS BIDIRECTIONAL
    // unidirectional is the relationship where only one class is aware of the relationship
    // bidirectional is the relationship where both the classes will be aware of the relationship
    // oneside vs twoside

    // THE OWNERSHIP OF RELATIONSHIP( it is also referred as parent and child relationship
    // it is dependent of the unidirectional and bidirectional
    // in unidirectional the class which is aware is the owner of relationship
    // bidirectional relationship the ownership is for the class which
    // does not contain the mappedBy annotation

    // why do we need the ownership of the relationship
    // the data writing from the child/owned class is problematic
    // the location of the join column in the database depends on which side the owns the relationship.

    // JPA ENTITY relationship options
    // FETCH,OPTIONAL,CASCADE

    // FETCH
    // Fetch in something which is how you want to get the related entities from the db...?
    // There are two options in fetch those are  LAZY AND EAGER
    // EAGER fetch means that if you want to load parent entity the child will be loaded simultaneously
    // Lazy is fetched on demand

    // OPTIONAL
    // its a boolean which determines whether the relationship must include a related entity or can be null
    // its similar to @Column(nullable=false) optional=false in a relationship means there is a mandatory
    // association between the entities

    // CASCADE
    // it will tell how the data in the database changes to the changes in one relationship
    // if two tables are related, and you delete the parent entity,
    // does that delete command also propagate to the child entity?
    // this has four fundamental types...
    // CascadeType.ALL / PERSIST / MERGE / REMOVE
    // ALL = all operations will cascadde to the child entity
    // PERSIST = when persisting the parent entity the previoud unpersisted child entities will be also persisted
    // MERGE = Operation that merge entities will cascade
    // REMOVE = Deletion operations on the parent entity will also remove related child entities.


}

