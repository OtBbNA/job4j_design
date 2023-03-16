create table addresses(
	id serial primary key,
	house_address text
);

create table tenants(
	id serial primary key,
	name varchar(255),
	address_id int references addresses(id)
);

insert into addresses(house_address) values ('г.Гюмри, ул.Ленина, д.15');
insert into addresses(house_address) values ('г.Гюмри, ул.Ленина, д.16');

insert into tenants(name, address_id) values ('Гриша', 1);
insert into tenants(name, address_id) values ('Маша', 1);
insert into tenants(name, address_id) values ('Даша', 1);

insert into tenants(name, address_id) values ('Вася', 2);
insert into tenants(name, address_id) values ('Жора', 2);
insert into tenants(name, address_id) values ('Миша', 2);
insert into tenants(name, address_id) values ('Глаша', 2);