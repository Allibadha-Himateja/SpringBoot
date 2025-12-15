package com.iss.springboot.EntityRelationships;

public class OnetoOne {

    // in a OnetoOne to relationship there are two variations
    // which are unidirectional owned and bidirectional owned
    // unidirectional is the relationship where only one entity whose about the relationship
    // bidirectional is the constract of the unidirectional

    /// UNIDIRECTIONAL OnetoOne relation
    // two classes needs to be related
    // at any given time ,only one instance of the each class must be linked
    // only one class is requires awareness and access to other class in relationship
    /// example, a Formula 1 race: the relationship between cars and drivers.
    // In this scenario, each car is associated with precisely one driver, and each driver is assigned to a single car.
    /// CHECK OUT THE CAR AND DRIVER MODELS IN THE MODELS DIRECTORY
    /// and the hibernate logs after running the main application are
    // Hibernate: create table cars (id bigint not null, brand varchar(255) not null, horsepower int, primary key (id))
    // Hibernate: create table drivers (id bigint identity not null, name varchar(255) not null, car_id bigint, primary key (id))
    // Hibernate: drop index drivers.UKbmu3ye24d5fffo9uj1xl5gpva
    // Hibernate: create unique nonclustered index UKbmu3ye24d5fffo9uj1xl5gpva on drivers (car_id) where car_id is not null
    // Hibernate: create sequence cars_seq start with 1 increment by 50
    // Hibernate: alter table drivers add constraint FKk3xt9q1jot6100fo7mp0wm2pw foreign key (car_id) references cars
    // here is the translation for these logs
    // FIRST we see the creation of @Entity car with all its attributes
    // SECOND we see the creation of @Entity Driver which contains the @OnetoOne and the reference of Car object
    // this means we are making the Driver class the owner of the relationship and it does not have a mappedBy attribute too
    // this Driver class will be created with the car_id -----> hibernate thinks=" Driver has a foreign key referencing the Car"
    // so car_id is the foreign_key
    // THIRD Unique Constraint – The CORE of One-to-One
    //🔹 This is the most important line:
    // Hibernate: create unique nonclustered index UKbmu3ye24d5fffo9uj1xl5gpva on drivers (car_id) where car_id is not null
    //❓ Why a UNIQUE index?
    // Without this:
    // Many drivers could point to the same car
    // That would become Many-to-One
    // “Each car_id can appear only once in drivers table”
    // FOURTH create sequence cars-seq start with 1 increament by 50 is by @AUTO in the cars entity
    // the optimal key generator is sequence
    // FIFTH alter table drivers add constraint FKk3xt9q1jot6100fo7mp0wm2pw foreign key (car_id) references cars
    // This enforces:
    // drivers.car_id must exist in cars.id
    // Prevents orphan references

    ///  CHANGING THE DEFAULTS:
    // 1) You can force the relationship - aka - a Driver must have a Car, through the use of the optional parameter in the @OneToOne annotation like so:
    //  @OneToOne(optional = false)
    //  private Car car;
    // 2) If this relationship is used infrequently, you can set the fetch type to LAZY by changing the fetch parameter on the @OneToOne annotation like so:
    //  @OneToOne(fetch = FetchType.LAZY)
    //  private Car car;
    // 3) To change cascade behavior, you can use the cascade parameter in the @OneToOne annotation, as shown below.
    //  @OneToOne(cascade = CascadeType.ALL)
    //  private Car car;

    /// BIDIRECTIONAL RELATIONSHIP
    // simply by applying the rules of bidirectional relationship
    // that is the child entity must be aware of parent entity
    // bidirectional Driver entity
    // @OneToOne(
    //            // a car will only be retrieved from the database when
    //            // it is explicitly accessed
    //            fetch = FetchType.LAZY,
    //            // you must specify a Car before you save the Driver
    //            optional = false,
    //            // all save/persist operations will be propagated
    //            // through to the Car
    //            cascade = CascadeType.PERSIST
    //    )
    //    private Car car;
    // bidirectional Car Entity
    // WE HAVE TO ADD A NEW ATTRIBUTE FOR THE CARS ENTITY WHICH IS BECAUSE OF BIDIRECTIONAL RELATIONSHIP
    // note that the annotation and field are new
    //    @OneToOne(
    //            // indicates that this is the child side of a
    //            // relationship and refers to the field in the Driver
    //            // class that defines the relationship there
    //            mappedBy = "car"
    //    )
    //    private Driver driver;


    /// A PROBLEM IN BIDIRECTIONAL RELATIONSHIP
    // driver1.setCar(car2);
    // car2.setDriver(driver3);
    // In this scenario, if an attempt is made to persist these changes to the database,
    // Spring faces a dilemma: should the relationship be between driver1 and car2, or between car2 and driver3?
    // To address such ambiguities, JPA has a defined fallback behavior.

    // This fallback behavior prioritizes the "owning" or "parent" side of the relationship.
    // The owning side is the entity where the relationship is defined with the foreign key,
    // aka - the class where the relationship-defining annotation does not specify a mappedBy parameter.
    // In this example, since the Driver class is the owning side of the relationship
    // (as it doesn't use mappedBy), changes made through driver1.setCar(car2) take precedence over car2.setDriver (driver3).
    // This results in driver1 being linked with car2 in the database.
}
