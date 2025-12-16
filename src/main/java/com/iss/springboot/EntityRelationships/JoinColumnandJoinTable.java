package com.iss.springboot.EntityRelationships;

public class JoinColumnandJoinTable {

    //it is very crucial to understand how and where do we actually use the
    // @JoinColumn and @JoinTable annotations

    //@JoinColumn is used when a relationship is stored using a foreign key column.
    //@JoinTable is used when the relationship is stored using a separate join table.

    //@JoinColumn — Foreign Key based relationships
    //A column in one table references the primary key of another table
    //Database view
    //drivers
    //---------
    //id
    //name
    //car_id  → FK to cars.id

    //Entity mapping
    //@Entity
    //public class Driver {
    //    @Id
    //    private Long id;
    //    @OneToOne
    //    @JoinColumn(name = "car_id")  // FK column
    //    private Car car;
    //}

    //When to use @JoinColumn
    //✔ One-to-One
    //✔ Many-to-One
    //✔ One-to-Many (owning side)
    //✔ When FK column exists in a table

    //Example: Many-to-One (most common in real apps)
    //@Entity
    //public class Order {
    //
    //    @ManyToOne
    //    @JoinColumn(name = "customer_id")
    //    private Customer customer;
    //}
    //DB:
    //orders
    //------
    //id
    //customer_id  → customers.id



    //@JoinTable — Separate join table relationships
    //Relationship is stored in a separate table
    //Many-to-Many
    //OR you don’t want a FK in either entity table

    //Example: Many-to-Many (classic use case)
    //DB structure
    //students
    //courses
    //student_course  ← join table
    //--------------
    //student_id
    //course_id
    //
    //Entity mapping
    //@Entity
    //public class Student {
    //
    //    @Id
    //    private Long id;
    //
    //    @ManyToMany
    //    @JoinTable(
    //        name = "student_course",
    //        joinColumns = @JoinColumn(name = "student_id"),
    //        inverseJoinColumns = @JoinColumn(name = "course_id")
    //    )
    //    private List<Course> courses;
    //}
    //
    //Meaning
    //joinColumns → FK to owning entity
    //inverseJoinColumns → FK to other entity



    //Can @JoinTable be used in One-to-One or One-to-Many?
    //
    //👉 Yes, but rarely
    //
    //Example: One-to-One using join table
    //@OneToOne
    //@JoinTable(
    //    name = "user_profile",
    //    joinColumns = @JoinColumn(name = "user_id"),
    //    inverseJoinColumns = @JoinColumn(name = "profile_id")
    //)
    //private Profile profile;

    //Owning side concept (critical for understanding usage)
    //The side that contains @JoinColumn or @JoinTable is the owning side

    //Example: One-to-Many
    //@Entity
    //public class Department {
    //
    //    @OneToMany(mappedBy = "department")
    //    private List<Employee> employees;
    //}
    //
    //@Entity
    //public class Employee {
    //
    //    @ManyToOne
    //    @JoinColumn(name = "department_id")  // owning side
    //    private Department department;
    //}

    //Decision guide (very practical)
    //Ask yourself:
    //Is there a foreign key column?
    //Use @JoinColumn
    //Is it Many-to-Many?
    //Use @JoinTable
    //Do I want a separate table for the relationship?
    //Use @JoinTable
    //Normal One-to-One / Many-to-One?
    //Use @JoinColumn
}
