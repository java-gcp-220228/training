# Week 2 Recap

## Day 1
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
    - [student-grades.sql](https://github.com/java-gcp-220228/training/blob/main/week-2/student-grades.sql)
- CRUD JDBC Demo
    - INSERT (C)
        - [addStudent(...)](https://github.com/java-gcp-220228/training/blob/main/week-2/crud-demo/src/main/java/com/revature/dao/StudentDao.java#L20-L38)
    - SELECT (R)
        - [getStudentById(...)](https://github.com/java-gcp-220228/training/blob/main/week-2/crud-demo/src/main/java/com/revature/dao/StudentDao.java#L41-L68)
        - [getAllStudents()](https://github.com/java-gcp-220228/training/blob/main/week-2/crud-demo/src/main/java/com/revature/dao/StudentDao.java#L70-L91)
    - UPDATE (U)
        - [updateStudent(...)](https://github.com/java-gcp-220228/training/blob/main/week-2/crud-demo/src/main/java/com/revature/dao/StudentDao.java#L94-L113)
    - DELETE (D)
        - [deleteStudentById(...)](https://github.com/java-gcp-220228/training/blob/main/week-2/crud-demo/src/main/java/com/revature/dao/StudentDao.java#L117-L133)