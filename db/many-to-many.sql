create table tickets(
	id serial primary key,
	name varchar(255)
);

create table tourists(
	id serial primary key,
	name varchar(255)
);

create table tour(
	id serial primary key,
	tourist_id int references tourists(id),
	ticket_id int references tickets(id)
);

insert into tickets(name) values ('Airplane');
insert into tickets(name) values ('Helicopter');
insert into tickets(name) values ('Boat');
insert into tickets(name) values ('Yacht');
insert into tickets(name) values ('Bus');
insert into tickets(name) values ('Cruise_ship');

insert into tourists(name) values ('Peter');
insert into tourists(name) values ('Masha');
insert into tourists(name) values ('Grisha');
insert into tourists(name) values ('Misha');

insert into tour(tourist_id, ticket_id) values (1,1); 
insert into tour(tourist_id, ticket_id) values (1,4);
insert into tour(tourist_id, ticket_id) values (2,1);
insert into tour(tourist_id, ticket_id) values (2,4);
insert into tour(tourist_id, ticket_id) values (3,1);
insert into tour(tourist_id, ticket_id) values (3,5);
insert into tour(tourist_id, ticket_id) values (3,3);
insert into tour(tourist_id, ticket_id) values (4,2);
insert into tour(tourist_id, ticket_id) values (4,6);