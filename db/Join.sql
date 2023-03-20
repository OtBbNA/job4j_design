create table shops(
	id serial primary key,
	name varchar
);

create table products(
	id serial primary key,
	name varchar
);

create table products_shops(
	id serial primary key,
	shop_id int references shops(id),
	product_id int references products(id)
);

insert into shops(name) values ('Diksi');
insert into shops(name) values ('DNS');
insert into shops(name) values ('ELDORADO');
insert into shops(name) values ('Indicator');

insert into products(name) values ('headphones');
insert into products(name) values ('motherboards');
insert into products(name) values ('CD-Rom');

insert into products_shops(product_id, shop_id) values (1, 1);
insert into products_shops(product_id, shop_id) values (1, 2);
insert into products_shops(product_id, shop_id) values (1, 3);
insert into products_shops(product_id, shop_id) values (2, 1);
insert into products_shops(product_id, shop_id) values (2, 2);
insert into products_shops(product_id, shop_id) values (2, 3);
insert into products_shops(product_id, shop_id) values (2, 4);
insert into products_shops(product_id, shop_id) values (3, 2);
insert into products_shops(product_id, shop_id) values (3, 4);

select * from products_shops
join products on products_shops.product_id = products.id
join shops on products_shops.shop_id = shops.id;




create table unit(
	id serial primary key,
	number int
);

create table soldier(
	id serial primary key,
	name varchar,
	token_number int,
	number int references unit(id)
);

create table army(
	id serial primary key,
	name int references soldier(id) unique,
	rank varchar,
	post varchar
);

insert into unit(number) values ('33212');
insert into unit(number) values ('18253');
insert into unit(number) values ('29247');

insert into soldier(name, token_number, number) values ('Grisha', 121212, 1);
insert into soldier(name, token_number, number) values ('Misha', 131313, 2);
insert into soldier(name, token_number, number) values ('Misha', 232323, 3);

insert into army(name, rank, post) values (1, 'private', 'mechanic');
insert into army(name, rank, post) values (2, 'private', 'mechanic');
insert into army(name, rank, post) values (3, 'sergeant', 'senior mechanic');

select pp.name, p.name, p.token_number 
from army as pp join soldier as p on pp.name = p.id;

select pp.name as id, p.name as Name, p.token_number as Tocken
from army as pp join soldier as p on pp.name = p.id;

select pp.name, pp.post, p.name, p.token_number, p.number, ppp.number
from army as pp join soldier as p on pp.name = p.id join unit as ppp on p.number = ppp.id;