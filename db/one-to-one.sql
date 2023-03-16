create table body_numbers(
	id serial primary key,
	number varchar(255)
);

create table car_numbers(
	id serial primary key,
	number varchar(255)
);

create table body_car_numbers(
	id serial primary key,
	body_id int references body_numbers(id) unique,
	car_id int references car_numbers(id) unique
);

insert into body_numbers(number) values ('ZFA22300005556777');
insert into body_numbers(number) values ('WRC57386928474723');
insert into body_numbers(number) values ('JHP68473024859774');

insert into car_numbers(number) values ('A652PA152');
insert into car_numbers(number) values ('E329MX42');
insert into car_numbers(number) values ('T714BO92');

insert into body_car_numbers(body_id, car_id) values (1,1);
insert into body_car_numbers(body_id, car_id) values (2,2);
insert into body_car_numbers(body_id, car_id) values (3,3);