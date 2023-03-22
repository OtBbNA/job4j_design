create table car_bodies(
	id serial primary key,
	name varchar
);

create table car_engines(
	id serial primary key,
	name varchar
);

create table car_transmissions(
	id serial primary key,
	name varchar
);

create table cars(
	id serial primary key,
	name varchar,
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values ('Hatchback');
insert into car_bodies(name) values ('Sedan');
insert into car_bodies(name) values ('Liftback');
insert into car_bodies(name) values ('Wagon');
insert into car_bodies(name) values ('Coupe');
insert into car_bodies(name) values ('Crossover');
insert into car_bodies(name) values ('SUV');
insert into car_bodies(name) values ('Minivan');

insert into car_engines(name) values ('VAZ 11183');
insert into car_engines(name) values ('VAZ 21126');
insert into car_engines(name) values ('VOLKSWAGEN EA111-1.6 AEE');
insert into car_engines(name) values ('VOLKSWAGEN EA288 CRLB');
insert into car_engines(name) values ('ACTECO SQRE4G15');
insert into car_engines(name) values ('ACTECO SQRF4J16');
insert into car_engines(name) values ('TOYOTA 1VZ-FE');
insert into car_engines(name) values ('TOYOTA 1ZR-FE');
insert into car_engines(name) values ('MAZDA L8-DE');
insert into car_engines(name) values ('MAZDA 13B-MSP');
insert into car_engines(name) values ('LANDROVER 20T2N');
insert into car_engines(name) values ('LANDROVER 200TDI');

insert into car_transmissions(name) values ('2WD Front Manual');
insert into car_transmissions(name) values ('2WD Rear Manual');
insert into car_transmissions(name) values ('4WD - Manual');
insert into car_transmissions(name) values ('2WD Front Automatic');
insert into car_transmissions(name) values ('2WD Rear Automatic');
insert into car_transmissions(name) values ('4WD - Automatic');

insert into cars(name, body_id, engine_id, transmission_id) values ('LADA GRANTA 2190', 2, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) values ('LADA KALINA SPORT', 1, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id) values ('TOYOTA CAMRY2', 2, 7, 5);
insert into cars(name, body_id, engine_id, transmission_id) values ('MAZDA MX-5 III (NC)', 5, 8, 2);
insert into cars(name, body_id, engine_id, transmission_id) values ('LANDROVER DEFENDER 1 (L316)', 7, 12, 3);
insert into cars(name, body_id, engine_id, transmission_id) values ('LANDROVER FREELANDER 1 (L314)', 6, 11, 6);
insert into cars(name, body_id, engine_id) values ('GEELY EMGRAND 7', 1, 5);
insert into cars(engine_id, transmission_id) values (8, 6);
insert into cars(engine_id, transmission_id) values (8, 1);
insert into cars(name, body_id, transmission_id) values ('GEELY GS1', 6, 6);

select c.name, cb.name, ce.name, ct.name
from cars as c
left join car_bodies as cb on c.body_id = cb.id
left join car_engines as ce on c.engine_id = ce.id
left join car_transmissions as ct on c.transmission_id = ct.id;

select car_bodies.name
from car_bodies
left join cars on cars.body_id = car_bodies.id
where cars.body_id is null;

select car_engines.name
from car_engines
left join cars on cars.engine_id = car_engines.id
where cars.engine_id is null;

select car_transmissions.name
from car_transmissions
left join cars on cars.transmission_id = car_transmissions.id
where cars.transmission_id is null;


