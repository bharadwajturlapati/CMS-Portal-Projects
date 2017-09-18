create database cmsdb;
connect cmsdb;
create table employee(emp_id varchar(20), emp_name varchar(50), emp_email varchar(64), emp_secret varchar(24));
// sample data
insert into employee values('2000','john doe','john.doe@gmail.com','johndoe');

create table employee_activity(emp_id varchar(20), last_activity datetime);