CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

insert into customers (first_name, last_name, age, country)
values ('Alexandr', 'Petrishev', 26, 'Russia');
insert into customers (first_name, last_name, age, country)
values ('Maxim', 'Zibrov', 29, 'Belarus');
insert into customers (first_name, last_name, age, country)
values ('Maria', 'Bolshova', 31, 'Russia');

CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);

insert into orders (amount, customer_id)
values (5, 1);
insert into orders (customer_id)
values (2);
insert into orders (amount, customer_id)
values (15, 3);

SELECT first_name, last_name
FROM customers c
WHERE c.id NOT IN (SELECT id FROM orders o WHERE (o.id = c.id));