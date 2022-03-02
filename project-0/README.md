# Project 0: RESTful API

Due Date: Wednesday, March 16th

## Description
You are developing a simple API for a bank.

Leveraging Java 8, create a RESTful API application that supports two main resources: clients and accounts.

* Client: a particular customer of the bank
* Account: a client can have multiple bank accounts (ex. 2 checking accounts, 3 savings accounts)

### Technologies
1. Java
2. Javalin
3. JDBC
4. Logback / SLF4J
5. JUnit
6. Mockito
7. PostgreSQL

## Requirements

### Endpoint Requirements
The following endpoints and their respective verbs should support the operations as described. In the HTTP response, use appropriate status codes (as specific as possible) and response bodies where applicable.

- `POST /clients`: Creates a new client
- `GET /clients`: Gets all clients
- `GET /clients/{client_id}`: Get client with an id of X (if the client exists)
- `PUT /clients/{client_id}`: Update client with an id of X (if the client exists)
- `DELETE /clients/{client_id}`: Delete client with an id of X (if the client exists)
- `POST /clients/{client_id}/accounts`: Create a new account for a client with id of X (if client exists)
- These two should be the same endpoint (check for query parameters using ctx.queryParam("amountLessThan") / ctx.queryParam("amountGreaterThan)):
    - `GET /clients/{client_id}/accounts`: Get all accounts for client with id of X (if client exists)
    - `GET /clients/{client_id}/accounts?amountLessThan=2000&amountGreaterThan=400`: Get all accounts for client id of X with balances between 400 and 2000 (if client exists)
- `GET /clients/{client_id}/accounts/{account_id}`: Get account with id of Y belonging to client with id of X (if client and account exist AND if account belongs to client)
- `PUT /clients/{client_id}/accounts/{account_id}`: Update account with id of Y belonging to client with id of X (if client and account exist AND if account belongs to client)
- `DELETE /clients/{client_id}/accounts/{account_id}`: Delete account with id of Y belonging to client with id of X (if client and account exist AND if account belongs to client)

### General Requirements
- Java 8
- Users of the application should be able to interact with it through a RESTful API utilizing HTTP
- 3 layered architecture
    - Controller (presentation) layer
    - Service (business logic) layer
    - Data Access layer (DAO aka Data Access Object layer)
- 80-90% test coverage for the **service layer** using JUnit
    - Utilize Mockito in order to mock DAO dependencies
- Logging should be accomplished using Logback
    - Have a mental model of what should ideally be logged in an application
        - Http Requests
        - Methods being executed
        - Exceptions
        - etc.
- Create a SQL script that will create a table schema and populate some data for your application
- Utilize JDBC in the application for data persistence
    - Must utilize the DAO design pattern
    - PostgreSQL

### Stretch Goals
Remember that the above requirements are the minimum viable product (MVP). You can always look into adding more

Here are some ideas:
- Postman tests to verify API functionality
- Run the application as a standalone JAR
- Run the application on a docker image
- Deploy the application to a Google Cloud Compute instance
- Use at least 1 stored procedure w/ Postgres
- Additional resources and RESTful endpoints (in addition to the clients and accounts resources in the main requirements)
- Login Functionality?
    - Research about Session management (HttpSession, Javalin's Access Manager, etc)
