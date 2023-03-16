create table example(
	id serial primary key,
	City varchar(255),
	Index int,
	GDP money
);
insert into example(City, Index, GDP) values ('Moscow city', 101000, 213000000000);
update example set GDP = 213330000000;
delete from example;