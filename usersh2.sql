create table if not exists users (
	id varchar(40) primary key,
	pass varchar(40),
	city varchar(40));

insert into users values('luffy', 'pass', 'water7');
insert into users values('a', 'b', 'c');