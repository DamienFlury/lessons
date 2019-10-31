create database if not exists employeehibernatedemo default character set utf8 collate utf8_general_ci;
use employeehibernatedemo;

create table employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    dept_id int(11) not null
);

insert into employee (id, firstName, lastName, dept_id) values
(10, "hans", "kuster", 11);

alter table employee
    modify id int(11) not null auto_increment, auto_increment=11;
commit;