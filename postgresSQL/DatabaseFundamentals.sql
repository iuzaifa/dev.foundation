
CREATE DATABASE dbname;

-- this is teminal commond 
\c dbname -- to connect database 

-- create table 
create table users (
    id SERIAL PRIMARY KEY,
    fullname varchar(255) not null,
    email varchar(255) not null unique,
    password varchar(255) not null,
    is_active boolean not null default false; 
);

-- insert data into table 
insert into users (fullname, email, password,is_active) values ('huzaifa', 'huzaifa@gmail.com', 'huzaifa#123', false)
