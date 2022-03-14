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

INSERT INTO employees (first_name, last_name, salary, department_id)
VALUES 
('Bach', 'Tran', 200000, 1),
('Jane', 'Doe', 80000, 2),
('John', 'Doe', 60000, 2),
('Arie', 'Baugh', 120000, 3),
('Nathaniel', 'Collins', 50000, 1);

SELECT *
FROM employees;

SELECT *
FROM departments;


-- SELECT the employee with the highest salary
SELECT *
FROM employees
WHERE salary = (
	SELECT MAX(salary)
	FROM employees
);

-- SELECT the employee with the second highest salary
SELECT *
FROM employees 
WHERE salary = (
	SELECT salary 
	FROM employees
	ORDER BY salary DESC
	LIMIT 1 OFFSET 1
);

-- SET Operations
-- Vertically combining or subtracting rows from two result sets
-- UNION 
-- UNION ALL 
-- INTERSECT 
-- EXCEPT

-- Set operation example
(SELECT salary
FROM employees 
ORDER BY salary DESC
LIMIT 2)

EXCEPT 

(SELECT MAX(salary) 
FROM employees);


-- SELECT the employee with the second highest salary
SELECT *
FROM employees 
WHERE salary = (
	(SELECT salary
	FROM employees 
	ORDER BY salary DESC
	LIMIT 2)
	
	EXCEPT 
	
	(SELECT salary 
	FROM employees
	ORDER BY salary DESC
	LIMIT 1)
);

-- SELECT the employees with the third and fourth highest salaries
SELECT *
FROM employees 
WHERE salary IN (
	(SELECT salary
	FROM employees 
	ORDER BY salary DESC
	LIMIT 4) -- 4 highest salaries
	
	EXCEPT -- "subtraction"
	
	(SELECT salary 
	FROM employees
	ORDER BY salary DESC
	LIMIT 2) -- 2 highest salaries
);



-- IN keyword
SELECT *
FROM employees 
WHERE department_id = 1 OR department_id = 2;

SELECT *
FROM employees 
WHERE department_id IN (1, 2);


-- A View is a pseudotable that is stored directly in the database
CREATE VIEW t 
AS
(SELECT *, DENSE_RANK() OVER (ORDER BY Salary Desc) AS rnk
FROM employees);

SELECT *
FROM t 
WHERE rnk = 2;


CREATE VIEW employee_department
AS 
(SELECT e.id as e_id, e.first_name, e.last_name, e.salary, dep.id as d_id, dep.department, dep.description 
FROM employees e
INNER JOIN departments dep
ON e.department_id = dep.id
);

SELECT *
FROM employee_department;




-- O(log n)
-- If you have any query where you are selecting based on a unique field or primary key, 
-- it will be O(log n) because of the way the data is referenced 
-- The row is referenced using a balanced-tree (behind the scenes)
-- SQL will create an "index" by default for primary keys and unique fields 
SELECT *
FROM employees 
WHERE id = 1;



-- O(n) without index
-- SQL will search through every row in that table to find the occurrences where first_name matches 'Jane'
SELECT *
FROM employees 
WHERE first_name = 'Jane' AND last_name = 'Doe';

-- By creating an index for a particular field, you can optimize
-- the time it takes to do that same query 
-- If you have a bunch of records, ex. 1,000,000 records, creating the index for the first time
-- can take a really long time (5-10 minutes, for example)
-- But, once the index is finished being created, any queries on the first_name field (using the WHERE clause)
-- should be faster
CREATE INDEX first_name_field ON employees
(
	first_name
);

-- O(log n) with index
-- SQL will search through every row in that table to find the occurrences where first_name matches 'Jane'
SELECT *
FROM employees 
WHERE first_name = 'Jane';
-- O(log n) <- find primary key(s) in the non-clustered index leaf node
-- O(log n) <- to find the record(s) corresponding to the id(s)
-- log n + log n = 2 log n <- O(log n)




-- Stored Procedure demo
CREATE TABLE accounts (
	id SERIAL PRIMARY KEY,
	balance INTEGER NOT NULL
);

INSERT INTO accounts (balance) 
VALUES 
(10000),
(5000);

SELECT *
FROM accounts;

CREATE OR REPLACE FUNCTION transfer_function(
	sender INTEGER,
	receiver INTEGER,
	amount INTEGER
) RETURNS boolean
language plpgsql 
as 
$$
begin 
	
	IF amount > (SELECT balance FROM accounts WHERE id = sender) THEN
		RETURN FALSE;
	END IF;
	
	UPDATE accounts 
	SET balance = balance - amount
	WHERE id = sender;

	UPDATE accounts 
	SET balance = balance + amount 
	WHERE id = receiver;
	

	RETURN TRUE;
END;
$$ -- plpgsql is an actual programming language for Postgres databases (unlike SQL itself, which isn't a programming language)


CREATE OR REPLACE PROCEDURE transfer_procedure(
	sender INTEGER,
	receiver INTEGER,
	amount INTEGER
)
language plpgsql 
as 
$$
begin 
	
	IF amount > (SELECT balance FROM accounts WHERE id = sender)
		THEN RAISE EXCEPTION 'Insufficient Balance'; -- If an exception occurs, it will rollback the transaction immediately
	END IF;
	
	UPDATE accounts 
	SET balance = balance - amount
	WHERE id = sender;

	UPDATE accounts 
	SET balance = balance + amount 
	WHERE id = receiver;
	
END;
$$ -- plpgsql is an actual programming language for Postgres databases (unlike SQL itself, which isn't a programming language)


SELECT transfer_function(1, 2, 10000); -- SELECT is used to call functions
CALL transfer_procedure(2, 1, 20000); -- CALL is used to call procedures
