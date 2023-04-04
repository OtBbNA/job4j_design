create or replace procedure delete_byID(u_id integer)
language 'plpgsql'
as $$
    BEGIN
        delete from products where products.id = u_id;
    END;
$$;

call delete_byID(1);

create or replace procedure delete_byCount(u_count integer)
language 'plpgsql'
as $$
    BEGIN
        delete from products where products.count <= u_count;
    END;
$$;

call delete_byCount(10);


create or replace function f_delete_data_byId(i_id integer)
returns void
language 'plpgsql'
as
$$
    begin
        delete from products where products.id = i_id;
    end;
$$;

select f_delete_data_byId(2);

create or replace function f_delete_data_byCount(i_count integer)
returns void
language 'plpgsql'
as
$$
    begin
        delete from products where products.count <= 10;
    end;
$$;

select f_delete_data_byCount(5);
