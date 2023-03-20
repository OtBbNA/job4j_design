create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('И15367287364', 10823.42);
insert into devices(name, price) values ('И45797870723', 988.54);
insert into devices(name, price) values ('И15347897987', 491.22);
insert into devices(name, price) values ('И84269082369', 3628.04);
insert into devices(name, price) values ('И18652479683', 1862.00);

insert into people(name) values ('Misha');
insert into people(name) values ('Grisha');
insert into people(name) values ('Masha');
insert into people(name) values ('Sasha');
insert into people(name) values ('Dasha');
insert into people(name) values ('Glasha');

insert into devices_people(people_id, device_id) values (1, 1);
insert into devices_people(people_id, device_id) values (1, 2);
insert into devices_people(people_id, device_id) values (1, 4);
insert into devices_people(people_id, device_id) values (2, 1);
insert into devices_people(people_id, device_id) values (2, 4);
insert into devices_people(people_id, device_id) values (2, 5);
insert into devices_people(people_id, device_id) values (3, 2);
insert into devices_people(people_id, device_id) values (3, 3);
insert into devices_people(people_id, device_id) values (4, 2);
insert into devices_people(people_id, device_id) values (4, 5);
insert into devices_people(people_id, device_id) values (5, 3);
insert into devices_people(people_id, device_id) values (6, 1);
insert into devices_people(people_id, device_id) values (6, 3);

select avg(price) from devices;

select avg(s.price), ss.people_id
from devices_people as ss join devices s on ss.device_id = s.id
group by ss.people_id;

select avg(s.price), ss.people_id
from devices_people as ss join devices s on ss.device_id = s.id
group by ss.people_id
having avg(s.price) > 5000;