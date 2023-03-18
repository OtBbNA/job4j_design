create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) 
values ('Marmota bobak', 16, date '1776-04-01');
insert into fauna(name, avg_age, discovery_date) 
values ('Marmota caligata', 14, date '1829-09-04');
insert into fauna(name, avg_age, discovery_date) 
values ('Marmota caudata', 17, date '1844-03-09');
insert into fauna(name, avg_age, discovery_date) 
values ('Marmota menzbieri', 15, date '1925-03-01');
insert into fauna(name, avg_age, discovery_date) 
values ('Marmota olympus', 16, date '1898-05-03');

insert into fauna(name, avg_age, discovery_date) 
values ('Lepus alleni', 4, date '1890-08-01');
insert into fauna(name, avg_age, discovery_date) 
values ('Lepus timidus', 5, date '1758-02-04');
insert into fauna(name, avg_age, discovery_date) 
values ('Lepus capensis', 17, date '1758-02-03');
insert into fauna(name, avg_age, discovery_date) 
values ('Lepus castroviejoi', 15, date '1977-08-08');
insert into fauna(name, avg_age, discovery_date) 
values ('Lepus peguensis', 16, date '1855-09-03');

insert into fauna(name, avg_age, discovery_date) 
values ('Rattus adustus', 2, date '1940-04-02');
insert into fauna(name, avg_age, discovery_date) 
values ('Rattus turkestanicus', 2, date '1903-02-04');
insert into fauna(name, avg_age, discovery_date) 
values ('Rattus bontanus', 1, date '1921-03-09');
insert into fauna(name, avg_age, discovery_date) 
values ('Rattus lutreolus', 2, date '1841-04-01');
insert into fauna(name, avg_age, discovery_date) 
values ('Rattus exulans', 1, date '1848-02-02');

insert into fauna(name, avg_age, discovery_date) 
values ('Atelopus certus', 14, date '1923-08-01');
insert into fauna(name, avg_age, discovery_date) 
values ('Atelopus elegans', 14, date '1882-02-04');
insert into fauna(name, avg_age, discovery_date) 
values ('Atelopus nahumae', 13, date '1994-02-03');
insert into fauna(name, avg_age, discovery_date) 
values ('Atelopus varius', 15, date '1856-08-08');
insert into fauna(name, avg_age, discovery_date) 
values ('Atelopus zeteki', 10, date '1933-09-03');

insert into fauna(name, avg_age) 
values ('Drakonus Neizvestnus', 333);

select * from fauna where name like 'Rattus%';
select * from fauna where avg_age >= 5 and avg_age <=14;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1900-01-01';