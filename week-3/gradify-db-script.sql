DROP TABLE IF EXISTS user_role CASCADE;
DROP TABLE IF EXISTS assignments CASCADE;
DROP TABLE IF EXISTS users CASCADE;


CREATE TABLE user_role (
	id SERIAL PRIMARY KEY,
	role VARCHAR(20) NOT NULL
);

INSERT INTO user_role (role)
VALUES ('student'),
('trainer');

SELECT *
FROM user_role;

CREATE TABLE users (
	id SERIAL PRIMARY KEY,
	username VARCHAR(200) NOT NULL UNIQUE,
	password VARCHAR(200) NOT NULL,
	user_role_id INTEGER NOT NULL,
	CONSTRAINT fk_user_userrole FOREIGN KEY (user_role_id) REFERENCES user_role(id)
);

INSERT INTO users (username, password, user_role_id)
VALUES ('bach_tran', 'password123', 2),
('jane_doe', 'pass12345', 1),
('john_doe', '12345', 1);

SELECT *
FROM users;

SELECT users.id, users.username, users.password, user_role.role
FROM users
INNER JOIN user_role 
ON users.user_role_id = user_role.id
WHERE users.username = 'bach_tran' AND users.password = 'password123';

CREATE TABLE assignments (
	id SERIAL PRIMARY KEY,
	assignment_name VARCHAR(200) NOT NULL,
	grade INTEGER,
	assignment_image bytea,
	student_id INTEGER NOT NULL,
	grader_id INTEGER,
	CONSTRAINT fk_assignments_students FOREIGN KEY (student_id) REFERENCES users(id),
	CONSTRAINT fk_assignments_graders FOREIGN KEY (grader_id) REFERENCES users(id)
);

INSERT INTO assignments (assignment_name, grade, student_id, grader_id) 
VALUES 
('Midterm 1', 90, 2, 1);

SELECT *
FROM assignments;

SELECT a.assignment_image 
FROM assignments a
WHERE a.id = 6 AND ;

