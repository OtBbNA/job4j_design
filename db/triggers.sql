create or replace function tribute()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
	where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tribute_trigger
    before insert on products
    referencing new table as inserted
    for each statement
    execute procedure tribute();


create or replace function scat()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
	where id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger scat_trigger
    after insert on products
    for each row
    execute procedure scat();


create or replace function history_data()
    returns trigger as
$$
    BEGIN
        insert into history_of_price(name, price, date)
        values (new.name, new.price, current_date);
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger history_trigger
    before insert
    on products
    for each row
    execute procedure history_data();