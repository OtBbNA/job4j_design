create table individual_number(
	id serial primary key,
	number_in int
);

create table batch_number(
	id serial primary key,
	number_bn int
);

create table packing_date(
	id serial primary key,
	packed date
);

create table product_type(
	id serial primary key,
	name_pt varchar
);

create table complete_goods(
	id serial primary key,
	name_cg varchar,
	individual_id int references individual_number(id) unique,
	product_id int references product_type(id)
);

create table shipment(
	id serial primary key,
	name_s varchar,
	complete_id int references complete_goods(id) unique,
	batch_id int references batch_number(id),
	packing_id int references packing_date(id)
);

insert into individual_number(number_in) values (0);
insert into individual_number(number_in) values (12);
insert into individual_number(number_in) values (23);
insert into individual_number(number_in) values (31);
insert into individual_number(number_in) values (41);
insert into individual_number(number_in) values (52);
insert into individual_number(number_in) values (69);
insert into individual_number(number_in) values (74);
insert into individual_number(number_in) values (83);
insert into individual_number(number_in) values (92);
insert into individual_number(number_in) values (105);

insert into batch_number(number_bn) values (156);
insert into batch_number(number_bn) values (2179);
insert into batch_number(number_bn) values (335);

insert into packing_date(packed) values (current_date);

insert into product_type(name_pt) values ('Toys');
insert into product_type(name_pt) values ('Books');
insert into product_type(name_pt) values ('Electronics');

insert into complete_goods(name_cg, individual_id, product_id) 
values ('Buzz Lightyear', 1, 1);
insert into complete_goods(name_cg, individual_id, product_id) 
values ('Buzz Lightyear', 2, 1);
insert into complete_goods(name_cg, individual_id, product_id) 
values ('Buzz Lightyear', 3, 1);
insert into complete_goods(name_cg, individual_id, product_id) 
values ('Buzz Lightyear', 4, 1);
insert into complete_goods(name_cg, individual_id, product_id)
values ('Alexander Griboyedov "Woe from Wit"', 5, 2);
insert into complete_goods(name_cg, individual_id, product_id)
values ('Agatha Christie "10 Little Indians"', 6, 2);
insert into complete_goods(name_cg, individual_id, product_id)
values ('Albert Camus "The Plague"', 7, 2);
insert into complete_goods(name_cg, individual_id, product_id)
values ('Strugatsky brothers "Its hard to be God"', 8, 2);
insert into complete_goods(name_cg, individual_id, product_id)
values ('ZET GAMING NEO M091', 9, 3);
insert into complete_goods(name_cg, individual_id, product_id)
values ('ZET GAMING NEO M087', 10, 3);
insert into complete_goods(name_cg, individual_id, product_id)
values ('ZET GAMING NEO M089', 11, 3);

insert into shipment(name_s, complete_id, batch_id, packing_id) 
values ('Nevada, Sacramento, Downtown Plaza', 1, 1, 1);
insert into shipment(name_s, complete_id, batch_id, packing_id) 
values ('Nevada, Sacramento, Downtown Plaza', 2, 1, 1);
insert into shipment(name_s, complete_id, batch_id, packing_id) 
values ('Nevada, Sacramento, Downtown Plaza', 3, 1, 1);
insert into shipment(name_s, complete_id, batch_id, packing_id) 
values ('Nevada, Sacramento, Downtown Plaza', 4, 1, 1);
insert into shipment(name_s, complete_id, batch_id, packing_id) 
values ('Nevada, Sacramento, Article Consignment Boutique', 5, 2, 1);
insert into shipment(name_s, complete_id, batch_id, packing_id) 
values ('Nevada, Sacramento, Article Consignment Boutique', 6, 2, 1);
insert into shipment(name_s, complete_id, batch_id, packing_id) 
values ('Nevada, Sacramento, Article Consignment Boutique', 7, 2, 1);
insert into shipment(name_s, complete_id, batch_id, packing_id) 
values ('Nevada, Sacramento, Article Consignment Boutique', 8, 2, 1);
insert into shipment(name_s, complete_id, batch_id, packing_id) 
values ('Nevada, Sacramento, Sunrise Malla', 9, 3, 1);
insert into shipment(name_s, complete_id, batch_id, packing_id) 
values ('Nevada, Sacramento, Sunrise Mall', 10, 3, 1);
insert into shipment(name_s, complete_id, batch_id, packing_id) 
values ('Nevada, Sacramento, Sunrise Mall', 11, 3, 1);

create view show_where_individual_number_less_then_80 as
select sh.name_s, cg.name_cg, bn.number_bn, pd.packed, pt.name_pt, inu.number_in
from shipment as sh
join complete_goods as cg on sh.complete_id = cg.id
join product_type as pt on cg.product_id = pt.id
join individual_number as inu on cg.individual_id = inu.id
join batch_number as bn on sh.batch_id = bn.id
join packing_date as pd on sh.packing_id = pd.id
group by sh.name_s, cg.name_cg, bn.number_bn, pt.name_pt, pd.packed, inu.number_in
having inu.number_in < 80;

select * from show_where_individual_number_less_then_80;
