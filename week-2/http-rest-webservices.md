# Introduction to Webservices

Web services revolve around using a web API.

# What is an API?
API is a very broad term that stands for Application Programming Interface. It enables two applications (or modules) to interact with each other according to a collection of software functions and procedures. An API is essentially software code that can be accessed and executed.

For example, think of the different features in Java we have used or looked at:
* Core Java (part of the runtime library (JRE))
    - String API
    - Collections API
    - JDBC API

* External libraries (from other developers):
    - Javalin API
    - JUnit 5 API (to write JUnit tests): Assertions class, annotations, etc.
    - Selenium API (to write Selenium automation scripts)

As a quick summary: you can think of any group of functionality that you interact with as an API. 
- Input
- Output

# Web Service
The application / API that you are building in project-0 is a **web service** that utilizes HTTP for communication. We have a client/server relationship that is established between Postman (client) and the P0 application (server)

The idea of a web service is provide a common platform that allows many different applications built on many different programming languages to communicate through a common standard. For example, you could have a JavaScript application running in your web browser that sends HTTP requests to the backend and receives data as a response. You could have Postman send a request and receive data in response. You could have a Python application that receives data in the form of an HTTP request, processes the data through machine learning algorithms, and then sends it onto another server for storage in a database using JDBC. 

In any case, web services nowadays utilize HTTP as a protocol for sending and receiving information as well as adhere to RESTful standard in current modern development.

We have in general two types of web services in common use today:
1. SOAP (Simple Object Access Protocol)
    - Old and typically not utilized anymore except for in legacy systems
        - Old government systems are probably the most common
    - Data is transferred in XML format
        - Uses the idea of messages that contain
            - Header
            - Body
    - Uses HTTP
2. RESTful web services
    - Lightweight, maintainable, and scalable
    - Uses JSON to structure data
    - Uses HTTP
    - Stands for REpresentational State Transfer
    - Key elements:
        - Request
            - a. Resources: specified in the URI (`/students/10`)
            - b. Request Verbs: GET, POST, PUT, DELETE, PATCH, etc. (`GET /students/10`)
            - c. Request Headers: metadata sent with the request, such as the type of data being sent
                - ex. `'Content-Type': 'application/json'` 
            - d. Request body: data being sent with the request
        - Response
            - a. Response Status Codes
                - 1XX informational, 2XX success, 3XX redirect, 4XX client error, 5XX internal server error
            - b. Response Body: data sent with the response
            - c. Response Headers: metadata sent with the response

# REST
- REpresentational State Transfer
- The main concept of REST is to represent "resources"
- There are a series of constraints on how to best build out a "RESTful" system (or application)
- REST constraints:
    - i. Stateless
        - The server should not save information (state) about a previous request
        - In the future, we might need to violate this constraint if we are implementing login functionality. We might achieve login functionality through what is known as an HTTP Session (which the server will keep track of), and this would NOT be stateless
    - ii. Cacheable
        - If requests occur often enough for the same resource, there should be some ability to have caching for improved performance
        - So, for example, instead of querying the database for every single GET request, the resource might be cached on the server itself
    - iii. Uniform interface
        - We should have a uniform way of representing our resources throughout the application
        - URIs and HTTP methods used for manipulating the resources should be consistent
        - Response data should be structured in a similar fashion for different resources as well
    - iv. Client/Server relationship
        - The API should have an evolving relationship with the client that is using it
        - As resources are changed/added/deleted, we should think about having some dynamic behavior on both sides
    - v. Layered Architecture
        - The web service/API could be structured as many different servers that communicate to each other
        - But, all of this complexity should be hidden from the end-user of the API
        - The API should function as if the end consumer is only aware of a single destination, even if there are many "nested" layers of servers behind the scenes.
    - vi. Code on Demand (Optional)
        - The server should be able to send some code on demand for the client to execute
        - Code can be represented as a resource