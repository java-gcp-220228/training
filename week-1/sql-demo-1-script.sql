-- Table of Students
-- Students have many grades

DROP TABLE IF EXISTS students;

CREATE TABLE students (
	id SERIAL PRIMARY KEY, -- SERIAL is a special datatype that will automatically increment itself
	-- SERIAL is an autoincrementing INTEGER
	-- A primary key serves as a unique identifier for a row. Primary keys are implicitly UNIQUE and NOT NULL
	first_name VARCHAR(200) NOT NULL,
	last_name VARCHAR(200) NOT NULL,
	age INTEGER NOT NULL
);

INSERT INTO students (first_name, last_name, age) 
VALUES 
('Bach', 'Tran', 24),
('John', 'Doe', 18),
('Jane', 'Doe', 25);

SELECT *
FROM students;

-- Grades (one-to-many) students <-> grades
DROP TABLE IF EXISTS grades;

CREATE TABLE grades (
	id SERIAL PRIMARY KEY,
	assignment_name VARCHAR(50) NOT NULL,
	grade INTEGER NOT NULL,
	student_id INTEGER NOT NULL,
	
	CONSTRAINT fk_student FOREIGN KEY(student_id) REFERENCES students(id)
);

INSERT INTO grades (assignment_name, grade, student_id) 
VALUES 
('Midterm 1', 90, 1),
('Midterm 1', 95, 2),
('Homework 1.1', 85, 2),
('Midterm 1', 97, 3),
('Homework 1.1', 80, 3),
('Quiz 1', 70, 4);

SELECT *
FROM grades;


-- Contacts (One-to-one) Students <-> Contacts
DROP TABLE IF EXISTS contacts;

CREATE TABLE contacts (
	id SERIAL PRIMARY KEY,
	cell VARCHAR(50),
	home VARCHAR(50),
	email VARCHAR(50),
	student_id INTEGER NOT NULL UNIQUE,
	
	CONSTRAINT fk_student FOREIGN KEY(student_id) REFERENCES students(id)
);

INSERT INTO contacts (cell, home, email, student_id)
VALUES 
('512-000-0000', '512-000-0001', 'bach_tran@email.com', 1);



-- Teachers (Many-to-many) Students <-> Teachers

DROP TABLE IF EXISTS teachers;

CREATE TABLE teachers (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	subject VARCHAR(50) NOT NULL
);

INSERT INTO teachers (name, subject) 
VALUES 
('Mr. Balch', 'Mathematics'),
('Mr. Tran', 'English');

SELECT *
FROM teachers;

-- Junction table
CREATE TABLE students_teachers (
	student_id INTEGER NOT NULL,
	teacher_id INTEGER NOT NULL,
	CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES students(id),
	CONSTRAINT fk_teacher FOREIGN KEY (teacher_id) REFERENCES teachers(id),
	PRIMARY KEY(student_id, teacher_id)
);

INSERT INTO students_teachers (student_id, teacher_id) 
VALUES 
(1, 1),
(1, 2),
(2, 1),
(3, 2),
(4, 1),
(4, 2);



-- Querying
SELECT * 
FROM students;

SELECT * 
FROM contacts;

-- JOINS
-- Join the records from two different tables together based on a certain condition (normally PK = FK)
SELECT *
FROM students -- left table
LEFT JOIN contacts -- right table
ON students.id = contacts.student_id;

SELECT *
FROM students -- left table
INNER JOIN contacts -- right table
ON students.id = contacts.student_id;

SELECT *
FROM students -- left table
RIGHT JOIN contacts -- right table
ON students.id = contacts.student_id;


-- Up above, the LEFT table is the students table 
-- the RIGHT table is the contacts table
-- When you do a LEFT join, you display all of the information in the left table, and any records that don't have a match 
-- to the right table, will display the right side as NULL

-- Multiple Joins in one query
SELECT *
FROM students s
INNER JOIN students_teachers st 
ON s.id = st.student_id 
INNER JOIN teachers t 
ON t.id = st.teacher_id;


-- Select students who are older than 20
SELECT *
FROM students 
WHERE age > 20;


-- Select the student(s) who is/are the oldest
SELECT *
FROM students 
ORDER BY age DESC
LIMIT 1;


-- Subquerying example
-- A query inside of a query
SELECT *
FROM students
WHERE age = (
	SELECT MAX(age)
	FROM students
);












