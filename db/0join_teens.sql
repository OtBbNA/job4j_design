create table genders(
	id serial primary key,
	sex varchar
);

insert into genders(sex) values ('M');
insert into genders(sex) values ('W');

create table teens(
	id serial primary key,
	name varchar,
	gender_id int references genders(id)
);

insert into teens(name, gender_id) values ('Grisha', 1);
insert into teens(name, gender_id) values ('Misha', 1);
insert into teens(name, gender_id) values ('Sasha', 1);
insert into teens(name, gender_id) values ('Lyosha', 1);
insert into teens(name, gender_id) values ('Gosha', 1);
insert into teens(name, gender_id) values ('Masha', 2);
insert into teens(name, gender_id) values ('Dasha', 2);
insert into teens(name, gender_id) values ('Glasha', 2);
insert into teens(name, gender_id) values ('Natasha', 2);
insert into teens(name, gender_id) values ('Sasha', 2);

select m.name, w.name, (m.gender_id != w.gender_id) as "pair"
from teens m cross join teens w
where (m.gender_id != w.gender_id) != false;