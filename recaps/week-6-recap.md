# Week 6 Recap

# Questions

## Hibernate
* What is Hibernate?
    - Hibernate is an ORM
    - Hibernate is an implementation of JPA
* What are some interfaces/classes associated with Hibernate?
    - Configuration class: you will provide configuration in the form of XML and also programmatically in order to then build the SessionFactory object from this class
    - SessionFactory interface: used to create Session objects
    - Session interface: the core interface that you will interact with when working with entities
    - Transaction interface: used to commit or rollback changes made to the persistent objects being modified during the course of that active transaction
* What is an ORM?
    - ORM stands for object relational mapper which takes the models we create in Java (classes) and maps them as entities in the database
    - An ORM allows you to abstract away operations that you would normally have manual queries for
    - Simplifies the process of establishing relationships between different entities
* What is JPA?
    - JPA stands for Java Persistence API
    - This is an API for utilizing ORMs that implement this API like Hibernate
    - Contains different annotations, interfaces, etc. for doing so
    - `EntityManager` is the primary interface for JPA
        - Hibernate's `Session` interface actually extends `EntityManager`
* What are some JPA annotations for mapping entities?
    - `@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@Column`, `@JoinColumn`, `@ManyToOne`, `@OneToMany`, `@OneToOne`, `@ManyToMany`
* What is the difference between `@ManyToOne` and `@OneToMany`?
    - `@ManyToOne` will be singular and `@OneToMany` will be a Collection such as a List or Set
* What are entities?
    - Entities are objects managed in the database
* What are the 3 object states?
    - Transient: any ordinary Java object that has been created. This object is not yet associated with any session
    - Persistent: this is an object that is associated with a particular session and therefore synchronized with the database. Any time you commit a transaction or "flush" the Session, the changes made to a persistent object will be sent the database
    - Detached: the session that a persistent object was a part of has been closed or the object has been evicted from a still active session
* Why is it important to understand what an entity object's state is?
    - We need to understand when an object is considered persistent or not, so that when we make changes to the object, we know whether or not those changes will be reflected in the database
* What is automatic dirty checking?
    - This is the process where Hibernate keeps track of changes made to a particular persistent object, where upon committing or flushing a session, the changes are persisted in the database
* What does flushing a Session do?
    - Synchronizing the state of the persistence context (Session object which tracks the persistent objects) with the underlying database
* What are the different ways of retrieving data with Hibernate?
    - session.get(id)
    - HQL / JPQL
    - Native SQL Queries (not very often used)
    - Criteria API
        - "Type-safe" API for retrieving data
        - Makes use of generics
* What is the difference between HQL and SQL?
    - HQL you are querying the models themselves, not the tables in the database
    - You don't care about the names of the columns or the names of the tables in the database
    - What you care about are the names of the classes and the names of the properties in that class
    - HQL is like an object query language instead of a relational database query language
* What is the difference between lazy loading and eager loading?
    - The data is not loaded until it is requested (invoking the getter for that particular mapping) in the case of lazy-loading
    - Primarily important to understand so that you could debug issues with "lazy loading exception"
        - If you have a lazy loaded mapping, and your object is now detached and you call the getter to retrieve that information, that information cannot be retrieved
    - The data is loaded up-front in the case of eager-loading
    - @ManyToOne, singular value, so it makes sense to be eagerly loaded
    - @OneToMany, collection, so it makes sense to be lazily loaded
    - @OneToOne, singular value, so it makes sense to be eagerly loaded
    - @ManyToMany, collection, so it makes sense to be lazily loaded
* What is a proxy object?
    - This is an object that takes lazy loading to the extreme
    - No data actually exists inside of the object
    - It's only when you call the getters to retrieve the properties that it actually queries the database for that information
    - `.load(id)` allows you to retrieve a proxy object v. `.get(id)` which will retrieve a full object

![Hibernate object state diagram](https://vladmihalcea.com/wp-content/uploads/2014/07/jpaentitystates.png)

## Spring
* What is Spring framework?
    - A family of modules and projects designed to ease development of Java applications
    - It revolves around the idea of inversion of control
* Inversion of Control
    - The framework takes control of instantiating objects
    - If an object depends on another object, the framework will provide this other object for use
        - **dependencies**
    - A particular implementation of IoC is **dependency injection**
* What is dependency injection?
    - Providing the dependency required
    - Ex. UserService needs a UserDao object
        - UserDao will be injected into UserService whenever UserService is instantiated
            1. UserDao is instantiated first
            2. UserService is then instantiated with UserDao injected into it
    - In the context of Spring, all of these objects are referred to as **Spring Beans**
* What is an IoC container?
    - A container that contains the Spring beans
    - In Spring, we have
        - BeanFactory
            - Old version
            - Lazily loads the Spring beans
            - DOES NOT have annotation based dependency injection
        - ApplicationContext
            - Extends BeanFactory
            - Modern version
            - Eagerly load the Spring beans
            - Provides annotation-based dependency injection
        - If you are constrained by memory, then BeanFactory would make more sense
* What are the types of dependency injection?
    - Constructor injection
        - Can be configured using
            - @Autowired
            - XML configuration
            - Class based configuration
    - Setter injection
        - Can be configured using
            - @Autowired
            - XML configuration
            - Class based configuration
    - Field injection
        - Configured using
            - @Autowired on top of a field directly
* How does @Autowired work?
    - If placed on top of a constructor, will perform constructor injection
    - If placed on top of a setter, will perform setter injection
    - If placed on top of a field, will perform field injection (utilizes the Java Reflection API)
* What is the Java Reflection API?
    - Reflection is an API to examine or modify the behavior of classes, methods, etc. at runtime
    - It can be used to inspect the properties that belong to a class and to also change access modifiers, scan for different annotations and do different activities based on those annotations etc
    - Java Reflection API forms the basis for how Hibernate annotations, JPA annotations, Spring annotations, etc. actually work
* What bean scopes are there (Spring beans)?
    - Universal Scopes
        - Singleton: default scope
        - Prototype: There will be a new Bean instantiated each time it is called for
    - Web-aware Scopes
        - Request: these beans are scoped to a single HTTP request
        - Session: these beans are scoped to a single HTTP session
        - WebSocket: scoped to a web socket
        - Application: scoped to a servlet context (servlet container)
            - Servlets are how Java deals with HTTP requests behind the scenes
            - Javalin makes use of Servlets
            - Spring Web also makes use of Servlets
* How do you actually configure (register) Spring beans to the IoC container?
    - XML Configuration
    - Annotation Configuration
        - Stereotype annotations
            - Go on top of classes
                - These classes will then be automatically instantiated and managed by the IoC container
            - @Component
            - @Service
            - @Controller / @RestController
            - @Repository
    - Class based configuration
        - @Configuration (stereotype annotation for "Configuration" classes)
        - @Bean (annotated on top of methods)
            - These methods will return an object that will be stored into the IoC container
            - The methods only run once to instantiate and configure the object that is then stored into the IoC container
    - @Bean and @Configuration are NOT annotation based configuration
* What is the difference between Spring modules and Spring projects?
    - By project, we don't mean our own Java projects / Gradle projects, we're talking about a Spring specific term
    - Spring projects are made up of Spring modules
    - Spring modules actually provide the core base functionality of whatever is being implemented in those projects
* Examples of Spring modules
    - ![Spring Modules](https://docs.spring.io/spring-framework/docs/3.0.0.M4/reference/html/images/spring-overview.png)
    - Spring Core Container
        - Modules
            - Beans Module
            - Core Module
            - Context Module
            - SpEL Module
        - The basis of Spring framework
        - IoC
        - Dependency injection
    - Spring Test module
    - Spring Web module
    - Spring AOP module
    - Spring ORM module
* Example of Spring projects
    - Spring Boot
    - Spring Data JPA
    - Spring Cloud (microservices)
    - Spring Security

## Spring Boot
* What is Spring Boot?
    - If you wanted to create a Spring REST API application in the past, you would've had to manually install a Tomcat server, provide some Servlet configuration (registering the Spring Web DispatcherServlet, provide some .xml configuration for that DispatcherServlet, etc.)
    - Spring boot allows you to easily create Spring applications that can be configured very easily
    - Spring boot takes an "opinionated" view of how to set up an application
        - "opinionated": doing things the way other people have done by convention
        - "Convention over configuration"
    - Whenever possible, Spring boot will automatically configure "starter" dependencies
        - You would have noticed this happening when providing the Spring Data JPA starter dependency
        - The only configuration you would've needed to provide is some basic database credentials and the hbm2ddl.auto configuration (create, validate, create-drop, etc.)
    - Provides an embedded web-server
        - Jetty, Tomcat, Undertow
        - By default, Spring boot will use Tomcat, but can be easily configured to use other webservers like Jetty
    - Removes XML configuration
        - `application.properties`
* What are Spring boot profiles?
    - When your application runs, it can be started up with a different profile
    - Ex.
        - dev profile
        - test profile
        - prod profile
    - You can configure certain Spring beans to only be available when a certain profile is active
        - @Profile("dev") on top of the class
    - The currently active profile whenever you run your application can be set
        - environment variable: spring_profiles_active=dev
        - application.properties: spring.profile.active=dev
* Spring Boot Actuator?
    - Allows you to examine the health of the application through HTTP
    - If configured, you can send requests to actuator endpoints, which will then provide information about the application
* Spring Boot DevTools?
    - Provides features such as automatic restart
    - When changes to code are made, it will automatically restart the Spring boot application instead of the developer needing to manually restart

## Spring Web
* What is Spring web?
    - Provides functionality for controllers
    - Controllers process HTTP requests to certain endpoints
* What annotations to map controller beans?
    - @Controller
        - Points to a file in the template engine (server-sided rendering)
            - Unless you put @ResponseBody for the return type
    - @RestController
        - Implicitly add @ResponseBody to the return type of the methods, which will automatically have the return object be serialized into JSON
* What annotations do we have to map requests?
    - Go on top of the methods in the controller
    - Could also go on top of the class to provide a certain path for all of the methods
    - @RequestMapping
    - @GetMapping
    - @PostMapping
    - @PutMapping
    - @DeleteMapping
    - @PatchMapping
* Annotations for our endpoints
    - @RequestBody: method parameter
        - Convert JSON in the request body into an object
    - @ResponseBody: return type
        - Convert return object into JSON for the response
    - @PathVariable: path parameters
        - `@GetMapping(path="users/{user_id})`
        - `public String test(@PathVariable("user_id") int id) {}`
        - ex. /users/1 <- 1 is a path parameter
    - @RequestParam: query parameters
        - ex. /test?parameterOne=10&parameterTwo=20&parameterThree=5
            - parameterOne, parameterTwo, and parameterThree are query parameters
    - @RequestHeader: header from the request
* What design pattern does Spring Web follow?
    - Front controller design pattern
    - A single point of entry exists for the application through which all HTTP requests are sent to
        - DispatcherServlet: take all requests and route the request to the appropriate controller and endpoint in that controller

## Spring Data
* What interfaces could we extend from our own repository interfaces?
    - CrudRepository: base interface for providing CRUD functionality
    - PagingAndSortingRepository: extends CrudRepository and provides the ability to do pagination and sorting of records
    - JpaRepository: extends PagingAndSortingRepository and adds JPA related methods such as the ability to flush the persistence context and batch delete records
    - JpaRepository contains ALL of the functionality defined by PagingAndSortingRepository + CrudRepository
* What does Spring Data JPA allow us to do compared to just using Hibernate directly?
    - Automatically provides implementation for the methods in the DAO layer
    - We don't to write our own code that accomplishes these tasks
    - It is able to do this through method naming conventions
        - ex. findByUsernameAndPassword(String username, String password)
            - We can define an abstract method, and Spring Data JPA will automatically know how to perform this operation based on the name of the method
    - In cases where there's no clear-cut way to define the behavior that you want using method naming conventions
        - @Query(jpql)
            - Utilize JPQL inside of @Query to define the behavior
    - Simplified transaction management
        - @Transactional on top of methods
        - During the entire running of the method, there will be a transaction + persistence context (session) associated with that method
        - Any entity objects will be persistent within that method and any methods invoked by that method
        - If you put @Transactional on top of the class, then every single method inside of the class will have @Transactional applied to it

## Spring AOP
* What is AOP?
    - AOP stands for aspect oriented programming
    - Aspects help us to address cross-cutting concerns in the application
    - Cross-cutting concern: something that applies across multiple layers of the application
        - Logging happens everywhere (controller layer, service layer, dao layer)
        - Security (if you want to check if a user is allowed to access different endpoints, security is a concern that might cut across multiple controllers)
        - Caching
        - Data validation
    - An aspect is a centralized location in which we can apply advice to certain areas in our application
* What are some of the terminologies that AOP brings attention to?
    - Aspect: a class that contains advice
    - Advice: a method that gets executed based on the execution of other methods in the application
        - Types of advice:
            - @Before: the advice will be executed before the method runs
            - @After: the advice will be executed whether the method returned or threw an exception
            - @AfterReturning: the advice will be executed whenever the join point returns successfully
            - @AfterThrowing: the advice will be executed whenever the join point throws an exception
            - @Around: the most powerful type of advice that "wraps" around the join point. We can choose to have the join point execute or not and even intercept exceptions from the join point that are thrown
    - Pointcut Expression: what allows for you to match advice with join points
        - `@Before(value = "execution(* com.revature.HelloSpringBoot.*.*.*(..))")`
    - Join Point: the actual method in the application that is being "intercepted" by a particular advice

## Spring Test
* What does Spring Test provide in terms of helpfulness for developers when it comes to testing?
    - Provides a "test bench" with all of the Spring bean configurations and wiring (dependency injection)
        - Provides an ApplicationContext for testing purposes
            - ApplicationContext: modern IoC container for Spring applications
    - Because all of the beans are wired together, this allows us to easily perform integration testing
    - In Spring Boot, we use the `@SpringBootTest` annotation at the top of the test class, which basically sets up this integration of different Spring beans
* What is an H2 database? Why do we use an H2 database for testing purposes?
    - An H2 database is an in-memory database that only exists whenever we run our tests
    - This means that we can test out the DAO layer and actually have it interact with a real SQL database
    - This database is temporary and therefore we don't interfere with our actual production database (PostgreSQL)
    - In a Spring application, we can provide configuration such that the H2 database is used instead of the production database
* What is the difference between unit and integration tests?
    - Unit test: testing a particular method / segments in that method in isolation from any dependencies
        - Therefore, we use Mockito so that we don't actually end up depending on the dependencies
        - We only want to test the logic purely within that method itself
    - Integration test: testing modules that are connected/integrated together
        - We want to see if the modules actually work together properly or not
* Spring Test provides MockMvc. What is MockMvc?
    - Provides functionality to mock http requests
    - We "send" http requests to our WebApplicationContext (sub-segment of the ApplicationContext) which will then delegate those requests to the appropriate endpoint mapping in the controllers
    - We can perform unit testing on our controller as well as integration testing
        - Unit testing: mock the service layer and then send mock http requests to the controller
        - Integration testing: no mocking, just test the actual endpoints with wiring to the service layer -> dao layer -> H2 database

## Microservices
* What are microservices?
    - Microservices are an architectural approach whereby services are broken up into small independent applications that communicate through APIs
    - Each microservice handles a particular domain or feature
    - ex. Authentication microservice, Users microservice
    - Commonly, HTTP is used for services to communicate with each other
    - Messaging queues are another approach in which microservices can communicate
* What are some of their advantages of microservices v. monolithic applications?
    - Due to the independent nature of each microservice, they can be independently updated
    - For large applications, the codebase is more easily managed because it is broken up into more maintainable units
    - It is easier to scale microservices independently
        - Imagine you have a monolithic application
            - It's working a period of time without degraded performance, but the user base is growing
            - At a certain point, the amount of traffic is too large and performance is low for users
            - You can deploy multiple compute engine instances each running a separate copy of the monolith and use a load balancer to distribute load between them
            - Imagine that only one part of the application is heavily used (social media application ex. Post related features)
                - With a monolith, even if only one part of the application is the bottleneck, you still have to scale the entire thing
                - Poor utilization of space, RAM, resources
                - However, if we broke this application into microservices, then we could scale the Post microservice independently from the others (since the Post feature is the most commonly used)
* What is Eureka?
    - Eureka is a client-side service discovery implementation originally created by Netflix
        - Eureka is part of the Spring cloud project
    - It allows services to find and communicate with each other without needing to manually hardcode the hostname and port
    - The Eureka registry is the only central location that services need to register with
* What is an API gateway?
    - A central location through which client requests are routed to the appropriate microservice
    - The gateway will talk with the service discovery registry (Eureka) in order to route to a microservice
* What is RestTemplate?
    - It is a way provided by Spring for a Java application to send HTTP requests
    - Commonly used for synchronous communication with other microservices

## Messaging Queues
* What are some messaging queue vendors?
    - Apache Kafka
    - RabbitMQ
    - MuleSoft Anypoint platform
* What is a messaging queue?
    - A messaging queue is a way for services to communicate with each other asynchronously
    - Utilizes the pub/sub (publisher subscriber) design pattern
    - One service will publish a message to the queue (publisher)
    - Another service will consume the message from the queue (subscriber)
    - Allow for us to implement a more **reactive** paradigm for our applications
