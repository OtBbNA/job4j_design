create table type(
	id serial primary key,
	name varchar
);

create table product(
	id serial primary key,
	name varchar,
	type_id int references type(id),
	expired_date date,
	price float	
);

insert into type(name) values ('СЫР');
insert into type(name) values ('МОЛОКО');
insert into type(name) values ('КОНФЕТЫ');
insert into type(name) values ('ХЛЕБОБУЛОЧНЫЕ');
insert into type(name) values ('МОРОЖЕНОЕ');

insert into product(name, type_id, expired_date, price) 
values('Сыр плавленный', 1, '2023-05-04', 45.16);
insert into product(name, type_id, expired_date, price) 
values('Сыр моцарелла', 1, '2022-12-26', 362.10);
insert into product(name, type_id, expired_date, price) 
values('Сыр пармезан', 1, '2023-06-20', 451.16);
insert into product(name, type_id, expired_date, price) 
values('Сыр фета', 1, '2023-05-01', 1732.99);
insert into product(name, type_id, expired_date, price) 
values('Сыр чеддер', 1, '2023-01-30', 450.23);

insert into product(name, type_id, expired_date, price) 
values('Молоко ФрауМу', 2, '2023-05-04', 68.90);
insert into product(name, type_id, expired_date, price) 
values('Молоко БМК', 2, '2023-03-30', 113.00);
insert into product(name, type_id, expired_date, price) 
values('Молоко Вкуснотеево', 2, '2023-06-20', 137.53);
insert into product(name, type_id, expired_date, price) 
values('Молоко Nevelvend', 2, '2023-04-17', 900.72);
insert into product(name, type_id, expired_date, price) 
values('Молоко Belvend', 2, '2023-05-01', 320.50);
insert into product(name, type_id, expired_date, price) 
values('Молоко Коровка из кореновки', 2, '2023-01-10', 81.34);
insert into product(name, type_id, expired_date, price) 
values('Молоко Белебеевское', 2, '2023-03-20', 100.94);
insert into product(name, type_id, expired_date, price) 
values('Молоко Веселый молочник', 2, '2023-02-15', 95.38);
insert into product(name, type_id, expired_date, price) 
values('Молоко Милава', 2, '2022-12-25', 83.95);
insert into product(name, type_id, expired_date, price) 
values('Молоко Простоквашино', 2, '2023-03-23', 84.23);
insert into product(name, type_id, expired_date, price) 
values('Молоко Вологодское', 2, '2023-02-23', 72.30);

insert into product(name, type_id, expired_date, price) 
values('Конфеты Twix', 3, '2023-07-07', 413.67);
insert into product(name, type_id, expired_date, price) 
values('Конфеты Bounty', 3, '2023-09-13', 511.10);
insert into product(name, type_id, expired_date, price) 
values('Конфеты Snikers', 3, '2023-09-11', 396.38);
insert into product(name, type_id, expired_date, price) 
values('Конфеты Roshen', 3, '2023-08-03', 312.90);
insert into product(name, type_id, expired_date, price) 
values('Конфеты Milky Way', 3, '2023-06-26', 390.55);
insert into product(name, type_id, expired_date, price) 
values('Конфеты Рачки', 3, '1989-08-31', 3.00);

insert into product(name, type_id, expired_date, price) 
values('Булочка Розан', 4, '2023-03-20', 62.56);
insert into product(name, type_id, expired_date, price) 
values('Хлеб Покровский', 4, '2023-03-25', 41.29);
insert into product(name, type_id, expired_date, price) 
values('Булочка с Маком', 4, '2023-03-26', 60.94);
insert into product(name, type_id, expired_date, price) 
values('Хлеб Горчичный', 4, '2023-03-21', 78.50);
insert into product(name, type_id, expired_date, price) 
values('Багет Сырный', 4, '2023-03-22', 70.63);
insert into product(name, type_id, expired_date, price) 
values('Батон Крымский', 4, '2023-03-27', 39.05);
insert into product(name, type_id, expired_date, price) 
values('Слойка Ягодная', 4, '2023-03-25', 52.44);
insert into product(name, type_id, expired_date, price) 
values('Хлеб Семейная Нарезка', 4, '2023-03-26', 50.93);
insert into product(name, type_id, expired_date, price) 
values('Батон Отрубной', 4, '2023-03-20', 29.30);
insert into product(name, type_id, expired_date, price) 
values('Слойка Сырная', 4, '2023-03-30', 47.59);

insert into product(name, type_id, expired_date, price) 
values('Мороженое Пломбир', 5, '2023-03-30', 00.05);
insert into product(name, type_id, expired_date, price) 
values('Мороженое Замороженный лед', 5, '2023-04-30', 79.15);
insert into product(name, type_id, expired_date, price) 
values('Мороженое В Стаканчике', 5, '2023-04-21', 44.55);
insert into product(name, type_id, expired_date, price) 
values('Мороженое Доброе', 5, '2023-03-20', 25.99);
insert into product(name, type_id, expired_date, price) 
values('Мороженое Сырые Швеллера', 5, '2023-01-20', 50.00);
insert into product(name, type_id, expired_date, price) 
values('Мороженое Советское', 5, '1991-01-12', 10.10);
insert into product(name, type_id, expired_date, price) 
values('Мороженое Из Желтой бочки', 5, '2023-02-02', 80.02);
insert into product(name, type_id, expired_date, price) 
values('Мороженое 10 съезд КПСС', 5, '1921-04-16', 4.21);

select * from product join type on type_id = type.id where type.name like 'СЫР';

select * from product where name like 'Мороженое%';

select * from product where current_date > expired_date;

select max(price) from product;

select s.name, 
count(s.id)
from type as s join product as ss 
on ss.type_id = s.id
group by s.name;

select s.name, ss.name
from product as s join type as ss
on s.type_id = ss.id
group by s.name, ss.name
having ss.name like 'СЫР' or ss.name like 'МОЛОКО';

select s.name, 
count(s.id)
from type as s join product as ss 
on ss.type_id = s.id
group by s.name
having count(s.id) < 10;

select s.name, ss.name
from product as s join type as ss
on s.type_id = ss.id
group by s.name, ss.name;