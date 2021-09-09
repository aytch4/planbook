drop database if exists planbook;

create database planbook;
 
use planbook;

drop table if exists dayslessons;
drop table if exists lesson;
drop table if exists unit;
drop table if exists day;
drop table if exists subject;
drop table if exists grade;

create table if not exists grade (
	gradeNumber int unique not null,
	gradeName varchar(15) not null,
	primary key (gradeNumber)
	);

create table if not exists subject (
	subjectId int auto_increment not null,
	subjectName varchar(15) not null,
	primary key (subjectId)
	);

create table if not exists day (
	dayId int unique not null,
	dayOfTheWeek varchar(10) not null,
	primary key (dayId)
	);

create table if not exists unit (
	unitId int auto_increment not null,
	unitName varchar(25) not null,
	subjectId int not null,
	gradeNumber int not null,
	primary key (unitId),
	foreign key (subjectId) references subject(subjectId),
	foreign key (gradeNumber) references grade(gradeNumber)
	);

create table lesson (
	lessonId int not null auto_increment,
    lessonName varchar(75) not null,
	objective varchar(255) not null,
	content text not null,
	unitId int not null,
	primary key (lessonId),
	foreign key (unitId) references unit(unitId)
	);

create table DaysLessons (
	dayslessonsId int not null auto_increment,
	dayId int not null,
	lessonId int not null,
	primary key (dayslessonsId),
	foreign key (dayId) references day(dayId),
	foreign key (lessonId) references lesson(lessonID)
	);
