insert into ers_user_role (user_role)
values ('finance_manager'),
('employee');

insert into ers_user
(ers_user_username, ers_user_password, ers_user_firstname, ers_user_lastname, ers_user_email, ers_user_role_id)
values
('bach_tran', 'password123', 'Bach', 'Tran', 'bach_tran@email.com', 1),
('jane_doe', 'password', 'Jane', 'Doe', 'jane_doe@email.com', 2),
('john_doe', 'pass12345', 'John', 'Doe', 'john_doe@email.com', 2),
('john_smith', 'pass123', 'John', 'Smith', 'john_smith@email.com', 2);