create database Custome;
use Custome;

create table cust(
id int primary key not null,
first_name varchar(50) not null,
last_name varchar(50) not null,
email varchar(50) not null,
phone_number varchar(10) not null
);