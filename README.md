# hibernate-advanced

Advanced Mappings:
   One-to-One
   One-to-Many,Many-to-One
   Many-to-Many
Important Database concepts to use:   Primary Key,Foreign Key,Cascade 
One-to-One :
           @OneToOne(cascade=CascadeType.ALL)
           @JoinColumn(name=“instructor_detail_id")
          private InstructorDetail instructorDetail;
One-to-One(bidirectional):
          @OneToOne(mappedBy="instructorDetail")
One-To-Many:
          @ManyToOne
          @JoinColumn(name="instructor_id")
          private Instructor instructor
      @OneToMany(mappedBy="instructor")
private List<Course> courses;

mappedBy tells Hibernate
• Look at the instructor property in the Course class
• Use information from the Course class @JoinColumn
• To help find associated courses for instructor

Do Lazy fetch instead of Eager Fetch in One-to-Many and Many-to-Many
