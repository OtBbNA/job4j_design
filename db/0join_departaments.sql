create table departaments(
	id serial primary key,
	name varchar
);

create table employees(
	id serial primary key,
	name varchar,
	departament_id int references departaments(id)
);

insert into departaments(name) values ('creative');
insert into departaments(name) values ('2d graphics');
insert into departaments(name) values ('3d models');
insert into departaments(name) values ('animation');
insert into departaments(name) values ('quests');
insert into departaments(name) values ('map');
insert into departaments(name) values ('mass media');
insert into departaments(name) values ('director');

insert into employees(name) values ('Radmir');
insert into employees(name) values ('Abdusalam');
insert into employees(name, departament_id) values ('Misha', 1);
insert into employees(name, departament_id) values ('Masha', 1);
insert into employees(name, departament_id) values ('Yasha', 1);
insert into employees(name, departament_id) values ('Grisha', 2);
insert into employees(name, departament_id) values ('Dasha', 2);
insert into employees(name, departament_id) values ('Misha', 2);
insert into employees(name, departament_id) values ('Sasha', 3);
insert into employees(name, departament_id) values ('Gosha', 3);
insert into employees(name, departament_id) values ('Natasha', 3);
insert into employees(name, departament_id) values ('Lyosha', 4);
insert into employees(name, departament_id) values ('Nysha', 4);
insert into employees(name, departament_id) values ('Arkasha', 5);
insert into employees(name, departament_id) values ('Gosha', 5);
insert into employees(name, departament_id) values ('Yasha', 6);
insert into employees(name, departament_id) values ('Isha', 6);
insert into employees(name, departament_id) values ('Kesha', 7);
insert into employees(name, departament_id) values ('Levsha', 7);
insert into employees(name, departament_id) values ('Gosha', 7);


select * from departaments d left join employees e on e.departament_id = d.id;
select * from employees e right join departaments d on e.departament_id = d.id;

select * from departaments d full join employees e on e.departament_id = d.id;
select * from employees e full join departaments d on e.departament_id = d.id;

select * from employees e cross join departaments d;


select * from departaments d left join employees e on e.departament_id = d.id where e.departament_id is null;


select * from employees e left join departaments d on e.departament_id = d.id;
select * from employees e right join departaments d on e.departament_id = d.id;

select * from departaments d right join employees e on e.departament_id = d.id;
select * from departaments d left join employees e on e.departament_id = d.id;