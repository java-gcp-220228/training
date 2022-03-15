# Week 2 Recap

## Day 1
- Intro to SQL (From Friday, Week-1)
    - [image](./images/sql.JPG)
    - Sublanguages
        - [image](./images/sql-sublanguages.JPG)
    - Multiplicity
        - [image](./images/multiplicity.JPG)
- SQL Constraints
    - [image](./images/sql-constraints.JPG)
- Referential Integrity
    - [image](./images/referential-integrity.JPG)
- JDBC
    - [image](./images/jdbc-notes.JPG)
    - [classes and interfaces](./images/jdbc-classes-and-interfaces.JPG)
- CRUD operations
    - DML
    - INSERT (C), SELECT (R), UPDATE (U), DELETE (D)
    - [image](./images/crud-dml.JPG)
- Steps to use JDBC
    - [image](./images/steps-to-use-jdbc.JPG)
- SQL Script (for CRUD JDBC Demo)
    - [student-grades.sql](https://github.com/java-gcp-220228/training/blob/main/week-2/day-1/student-grades.sql)
- CRUD JDBC Demo
    - INSERT (C)
        - [addStudent(...)](https://github.com/java-gcp-220228/training/blob/main/week-2/day-1/crud-demo/src/main/java/com/revature/dao/StudentDao.java#L20-L38)
    - SELECT (R)
        - [getStudentById(...)](https://github.com/java-gcp-220228/training/blob/main/week-2/day-1/crud-demo/src/main/java/com/revature/dao/StudentDao.java#L41-L68)
        - [getAllStudents()](https://github.com/java-gcp-220228/training/blob/main/week-2/day-1/crud-demo/src/main/java/com/revature/dao/StudentDao.java#L70-L91)
    - UPDATE (U)
        - [updateStudent(...)](https://github.com/java-gcp-220228/training/blob/main/week-2/day-1/crud-demo/src/main/java/com/revature/dao/StudentDao.java#L94-L113)
    - DELETE (D)
        - [deleteStudentById(...)](https://github.com/java-gcp-220228/training/blob/main/week-2/day-1/crud-demo/src/main/java/com/revature/dao/StudentDao.java#L117-L133)
- [Introduction to REST and HTTP](https://github.com/java-gcp-220228/training/blob/main/week-2/day-1/http-rest-webservices.md)

## Day 2
- RESTful naming conventions
    - [image 1](./images/restful-naming-conventions-1.JPG)
    - [image 2 (continued)](./images/restful-naming-conventions-2.JPG)
    - [image 3 (continued)](./images/restful-naming-conventions-3.JPG)
- n-tier architecture
    - [3 tier](./images/3-tier-architecture.JPG)
- Unit testing definition
    - [image](./images/unit-testing.JPG)
- Javalin demo for day-2
    - [code overview](https://github.com/java-gcp-220228/training/tree/main/week-2/day-2/javalin-demo/src/main/java/com/revature)
        - [main method and helper method for mapping controllers](https://github.com/java-gcp-220228/training/blob/main/week-2/day-2/javalin-demo/src/main/java/com/revature/main/Driver.java#L11-L23)
        - [StudentController](https://github.com/java-gcp-220228/training/blob/main/week-2/day-2/javalin-demo/src/main/java/com/revature/controller/StudentController.java#L11-L40)
        - [StudentService](https://github.com/java-gcp-220228/training/blob/main/week-2/day-2/javalin-demo/src/main/java/com/revature/service/StudentService.java#L10-L45)
        - [StudentDao](https://github.com/java-gcp-220228/training/blob/main/week-2/day-2/javalin-demo/src/main/java/com/revature/dao/StudentDao.java)
        - [ExceptionController](https://github.com/java-gcp-220228/training/blob/main/week-2/day-2/javalin-demo/src/main/java/com/revature/controller/ExceptionController.java#L11-L29)
- Unit testing the service layer of the Student demo for Javalin
    - [StudentServiceTest](https://github.com/java-gcp-220228/training/blob/main/week-2/day-2/javalin-demo/src/test/java/com/revature/service/StudentServiceTest.java)

## Day 3
- Multi-threading
    - [image](./images/multi-threading.JPG)
    - [2 ways to create and run a thread](https://github.com/java-gcp-220228/training/blob/main/week-2/day-3/multi-threading-intro/src/com/revature/main/Driver.java#L7-L10)
        - Extending the Thread class
            - [demo](https://github.com/java-gcp-220228/training/blob/main/week-2/day-3/multi-threading-intro/src/com/revature/main/Driver.java#L12-L14)
            - [class MyTask extends Thread](https://github.com/java-gcp-220228/training/blob/main/week-2/day-3/multi-threading-intro/src/com/revature/main/MyTask.java#L3-L14)
        - Creating a Runnable
            - [demo](https://github.com/java-gcp-220228/training/blob/main/week-2/day-3/multi-threading-intro/src/com/revature/main/Driver.java#L16-L19)
            - [class MyRunnable implements Runnable](https://github.com/java-gcp-220228/training/blob/main/week-2/day-3/multi-threading-intro/src/com/revature/main/MyRunnable.java#L3-L15)
            - [using a lambda for a Runnable](https://github.com/java-gcp-220228/training/blob/main/week-2/day-3/multi-threading-intro/src/com/revature/main/Driver.java#L21-L27)
    - Fibonacci Number demo
        - [fibonacci recursion illustration](./images/fibonacci-recursion.JPG)
        - [demo](https://github.com/java-gcp-220228/training/blob/main/week-2/day-3/fibonacci-number-multithreading/src/com/revature/main/Driver.java#L7-L36)
        - [slow fibonacci algorithm (recursion) O(2^n)](https://github.com/java-gcp-220228/training/blob/main/week-2/day-3/fibonacci-number-multithreading/src/com/revature/main/NumberUtility.java#L7-L14)
        - [fast fibonacci algorithm (recursion with memoization) O(n)](https://github.com/java-gcp-220228/training/blob/main/week-2/day-3/fibonacci-number-multithreading/src/com/revature/main/NumberUtility.java#L16-L31)
    - Synchronization demo
        - [race condition diagram](./images/race-condition.JPG)
        - [Using a lock and synchronization block](https://github.com/java-gcp-220228/training/blob/main/week-2/day-3/synchronization-demo/src/com/revature/main/Counter.java#L7-L32)
- OWASP Top 10
    - [Injection](https://owasp.org/www-project-top-ten/2017/A1_2017-Injection)
    - [Insufficient Logging and Monitoring](https://owasp.org/www-project-top-ten/2017/A10_2017-Insufficient_Logging%2526Monitoring)
    - [image](./images/owasp-sql-injection-insufficient-logging.JPG)
- Javalin Demo
    - Adding addStudent and editStudent functionality
        - [StudentController](https://github.com/java-gcp-220228/training/blob/main/week-2/day-3/javalin-demo/src/main/java/com/revature/controller/StudentController.java#L35-L51)
        - [StudentService](https://github.com/java-gcp-220228/training/blob/main/week-2/day-3/javalin-demo/src/main/java/com/revature/service/StudentService.java#L50-L95)

## Day 4

- SQL Script for the day
    - [sql script](https://github.com/java-gcp-220228/training/blob/main/week-2/day-4/dql-and-normalization-demo-script.sql)
- DQL Clauses
    - [image](./images/dql-clauses.JPG)
    - SELECT
    - FROM
    - JOIN
    - WHERE
    - GROUP BY
    - HAVING
    - ORDER BY
    - LIMIT
- GROUP BY
    - [image diagram of GROUP BY](./images/group-by.JPG)
- Functions
    - Scalar Functions
    - Aggregate Functions
    - [image](./images/functions.JPG)
- Database Normalization
    - [image](./images/normalization.JPG)
    - 0NF (Not really a normal form)
        - [image](./images/0nf.JPG)
    - 1st NF
        - [image](./images/1nf.JPG)
    - 2nd NF
        - [image](./images/2nf.JPG)
    - 3rd NF
        - [image](./images/3nf.JPG)
    - Summary
        - [image](./images/nf-summary.JPG)
- Schema
    - [image](./images/schema.JPG)
    - Entity Relationship Diagram (ERD)
        - [example #1](./images/erd-1.JPG)
        - [example #2](./images/erd-2.JPG)
- Unit tests for addStudent()
    - [demo](https://github.com/java-gcp-220228/training/blob/main/week-2/day-4/javalin-demo/src/test/java/com/revature/service/StudentServiceTest.java#L121-L201)

## Day 5
- Pseudotables
    - [image](./images/pseudotables.JPG)
    - Subquery
        - [SELECT employee with highest salary](https://github.com/java-gcp-220228/training/blob/main/week-2/day-5/sql-script.sql#L42-L48)
        - [SELECT employee with second highest salary w/ subquery](https://github.com/java-gcp-220228/training/blob/main/week-2/day-5/sql-script.sql#L50-L58)
    - View
        - [Example #1](https://github.com/java-gcp-220228/training/blob/main/week-2/day-5/sql-script.sql#L125-L133)
        - [Example #2](https://github.com/java-gcp-220228/training/blob/main/week-2/day-5/sql-script.sql#L136-L145)
- Set Operations
    - [image](./images/set-operations.JPG)
    - [UNION v. UNION ALL v. INTERSECT v. EXCEPT](./images/set-operations-comparisons.JPG)
    - [SELECT employee with second highest salary using EXCEPT set operation + subquery](https://github.com/java-gcp-220228/training/blob/main/week-2/day-5/sql-script.sql#L79-L94)
    - [SELECT employee with third and fourth highest salaries using EXCEPT set operation + subquery](https://github.com/java-gcp-220228/training/blob/main/week-2/day-5/sql-script.sql#L96-L111)
- IN keyword example
    - [demo](https://github.com/java-gcp-220228/training/blob/main/week-2/day-5/sql-script.sql#L115-L122)
- SQL Index
    - [Balanced Tree (B-Tree) data structure diagram](./images/b-tree.JPG)
    - [some query optimizations](./images/query-optimization.JPG)
    - [Creating an index for first_name](https://github.com/java-gcp-220228/training/blob/main/week-2/day-5/sql-script.sql#L173-L176)
- SQL Transactions
    - [image](./images/sql-transactions.JPG)
    - ACID properties
        - [image](./images/acid-properties.JPG)
    - Read phenonomena and isolation levels
        - [image](./images/read-phenomena-isolation-levels.JPG)
- Postgres Functions and Procedures
    - [image](./images/functions-and-procedures.JPG)
    - [transfer function example](https://github.com/java-gcp-220228/training/blob/main/week-2/day-5/sql-script.sql#L204-L229)
    - [transfer procedure example](https://github.com/java-gcp-220228/training/blob/main/week-2/day-5/sql-script.sql#L232-L255)
    - [invoking function v. procedure](https://github.com/java-gcp-220228/training/blob/main/week-2/day-5/sql-script.sql#L258-L259)

# Questions
* What is SQL?
* Is SQL a programming language?
* What are the 5 sublanguages in SQL?
* What commands does DDL contain?
* What commands does DML contain?
* What command(s) does DQL contain?
* What commands does TCL contain?
* What commands does DCL contain?
* What constraints are there in SQL?
* What is a primary key?
* What is a foreign key?
* What is referential integrity?
* What is JDBC?
* What are the classes/interfaces that are part of the JDBC API?
* What are the general steps to using JDBC?
* What sublanguage do CRUD operations belong to? What are the commands corresponding to each letter in the CRUD acronym?
* What is REST?
* What are the constraints of REST?
* What is HTTP?
* What are the components of an HTTP request?
* What are the components of an HTTP response?
* What do the 1XX response status codes mean?
* What do the 2XX response status codes mean?
* What do the 3XX response status codes mean?
* What do the 4XX response status codes mean?
* What do the 5xx response status codes mean?
---
* What is a GET request meant to do?
* What is a POST request meant to do?
* What is a PUT request meant to do?
* What is a PATCH request meant to do?
* What is a DELETE request meant to do?
* What are singleton v. collection resources in REST?
* What are sub-singleton and sub-collection resources?
* Describe 3-layer architecture
* What is unit testing?
* Why do we use mockito w/ unit testing?
---
* What is a thread?
* What are two ways of creating and running a thread?
* What type of interface is the Runnable interface and why is this useful?
* What is a race condition?
* What helps to prevent race conditions?
* How does the lock-key model for synchronization work?
* What is SQL injection?
* What are some issues that arise with insufficient logging and monitoring?
---
* What are the DQL clauses, and what order do they go in?
* What is the difference between WHERE and HAVING?
* How does GROUP BY work?
* What is the difference between scalar and aggregate functions?
* Describe the 3 levels of normalization?
* What is an ERD / Entity Relationship Diagram?
---
* What is a subquery?
* What is a view?
* How do Set operations work compared to JOINS?
* What are the 4 Set operations?
* What is a SQL index?
* What are the 4 ACID properties?
* What are read phenomena? What are the isolation levels?
* What is the difference between a Postgres function and procedure?
