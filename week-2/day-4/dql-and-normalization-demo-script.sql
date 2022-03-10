
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;

CREATE TABLE departments (
	id SERIAL PRIMARY KEY,
	department VARCHAR(50) NOT NULL,
	description VARCHAR(200) NOT NULL
);

CREATE TABLE employees (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(200) NOT NULL,
	last_name VARCHAR(200) NOT NULL,
	salary INTEGER NOT NULL,
	department_id INTEGER NOT NULL,
	
	CONSTRAINT fk_departments FOREIGN KEY (department_id) REFERENCES departments(id)
);

INSERT INTO departments (
	department, description
) VALUES 
('IT', 'Handles internal IT issues'),
('HR', 'Handles onboarding and offboarding of employees and any employee complaints'),
('Finance', 'Handles producing financial reports of revenue operations');

SELECT *
FROM departments;

INSERT INTO employees (first_name, last_name, salary, department_id)
VALUES 
('Bach', 'Tran', 200000, 1),
('Jane', 'Doe', 80000, 2),
('John', 'Doe', 60000, 2),
('Arie', 'Baugh', 120000, 3),
('Nathaniel', 'Collins', 50000, 1);


-- What is the average salary of each department?
SELECT dep.department, AVG(emp.salary)
FROM employees emp
INNER JOIN departments dep
ON emp.department_id = dep.id
GROUP BY dep.department;


-- What is the average length of the first names for employees in each department?
-- Rank in order from highest to least
SELECT dep.department, AVG(LENGTH(emp.first_name))
FROM employees emp
INNER JOIN departments dep
ON emp.department_id = dep.id
GROUP BY dep.department
ORDER BY AVG(LENGTH(emp.first_name)) DESC;


-- What are the departments whose average salaries are greater than 100000?
SELECT dep.department, AVG(emp.salary)
FROM employees emp
INNER JOIN departments dep
ON emp.department_id = dep.id
GROUP BY dep.department
HAVING AVG(emp.salary) > 100000;

-- SCALAR example
SELECT first_name, LENGTH(first_name)
FROM employees;

-- AGGREGATE example 
-- Get the total compensation that must be paid out to employees 
SELECT SUM(salary)
FROM employees;

-- Get the total compensation PER department
SELECT dep.department, SUM(emp.salary)
FROM employees emp 
INNER JOIN departments dep 
ON emp.department_id = dep.id 
GROUP BY dep.department;
