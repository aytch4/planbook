-- drop database if exists planbook;

-- create database planbook;

use planbook;

drop table if exists student_group_subject; 
drop table if exists lesson;
drop table if exists unit;
drop table if exists subject;
drop table if exists student_group;
drop table if exists user;

create table if not exists subject (
	id int auto_increment not null,
    name varchar(45) not null unique,
    primary key (id)
    );
    
create table if not exists user (
	id int auto_increment not null, 
    name varchar(25) not null unique,
  --  password varchar (25), 
  --  student_group_id int,
    primary key (id)
  --  foreign key (student_group_id) references student_group(id)
    );
  
create table if not exists student_group (
	id int auto_increment not null,
    name varchar(25) unique,
    user_id int,
    primary key (id), 
    foreign key (user_id) references user(id)
    );     
  
create table if not exists unit (
    id int auto_increment not null,
    name varchar(45) not null unique,
    subject_id int not null,
    primary key (id),
    foreign key (subject_id) references subject(id)
    );
    
create table if not exists lesson (
	id int auto_increment not null,
    name varchar(100) not null unique,
    objective varchar(255),
    content text,
    unit_id int,
    primary key (id),
    foreign key (unit_id) references unit(id)
    );
        
    create table if not exists student_group_subject (
	id int auto_increment not null,
    subject_id int not null,
    student_group_id int not null,
    primary key (id),
    foreign key (subject_id) references subject(id),
    foreign key (student_group_id) references student_group(id)
    );
