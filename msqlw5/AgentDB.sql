create database if not exists agentDB;

use agentDB;

drop table if exists agents;

create table agents (
	agentID int(10) not null auto_increment,
	name varchar(50) not null,
	email varchar(50) not null,
	primary key(agentID)
	);