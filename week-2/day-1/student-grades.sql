
-- DDL queries
-- (CREATE, ALTER, DROP, TRUNCATE)
DROP TABLE IF EXISTS grades;
DROP TABLE IF EXISTS students;

CREATE TABLE students (
	id SERIAL PRIMARY KEY, -- SERIAL is a special datatype that will automatically increment itself
	-- SERIAL is an autoincrementing INTEGER
	-- A primary key serves as a unique identifier for a row. Primary keys are implicitly UNIQUE and NOT NULL
	first_name VARCHAR(200) NOT NULL,
	last_name VARCHAR(200) NOT NULL,
	age INTEGER NOT NULL
);

-- Grades (one-to-many) students <-> grades
CREATE TABLE grades (
	id SERIAL PRIMARY KEY, -- PRIMARY KEY (implicitly UNIQUE and NOT NULL)
	assignment_name VARCHAR(50) NOT NULL,
	grade INTEGER NOT NULL DEFAULT 0 CHECK(grade >= 0), -- NOT NULL, DEFAULT, CHECK
	student_id INTEGER NOT NULL,
	
	CONSTRAINT fk_student FOREIGN KEY(student_id) REFERENCES students(id) ON DELETE CASCADE -- FOREIGN KEY
);


-- DML queries
INSERT INTO students (first_name, last_name, age) 
VALUES 
('Bach', 'Tran', 24),
('John', 'Doe', 18),
('Jane', 'Doe', 25);

INSERT INTO grades (assignment_name, grade, student_id) 
VALUES 
('Midterm 1', 90, 1),
('Midterm 1', 95, 2),
('Homework 1.1', 85, 2),
('Midterm 1', 97, 3),
('Homework 1.1', 80, 3);


SELECT *
FROM students;

SELECT *
FROM grades;

