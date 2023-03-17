insert into role(name) values('admin');
insert into role(name) values('moderator');
insert into role(name) values('editor');
insert into role(name) values('bot manager');

insert into rules(name) values('add users');
insert into rules(name) values('delete users');
insert into rules(name) values('move users');
insert into rules(name) values('change roles');
insert into rules(name) values('delete massages');
insert into rules(name) values('delete attachs');
insert into rules(name) values('add bots');
insert into rules(name) values('fix bots');
insert into rules(name) values('delete bots');

insert into users(name, role_id) values('Grisha', 1);
insert into users(name, role_id) values('Misha', 2);
insert into users(name, role_id) values('Sasha', 2);
insert into users(name, role_id) values('Masha', 3);
insert into users(name, role_id) values('Lyosha', 4);

insert into category(name) values('fix');
insert into category(name) values('edit');
insert into category(name) values('move');
insert into category(name) values('delete');
insert into category(name) values('add');

insert into state(name) values('new');
insert into state(name) values('in processing');
insert into state(name) values('in work');
insert into state(name) values('completed');

insert into item(number, user_id, category_id, state_id) values(342, 3, 3, 1);
insert into item(number, user_id, category_id, state_id) values(267, 5, 4, 3);
insert into item(number, user_id, category_id, state_id) values(47, 2, 2, 2);
insert into item(number, user_id, category_id, state_id) values(342, 1, 1, 4);

insert into role_rules(role_id, rules_id) value (1, 1);
insert into role_rules(role_id, rules_id) value (1, 2);
insert into role_rules(role_id, rules_id) value (1, 3);
insert into role_rules(role_id, rules_id) value (1, 4);
insert into role_rules(role_id, rules_id) value (1, 5);
insert into role_rules(role_id, rules_id) value (1, 6);
insert into role_rules(role_id, rules_id) value (2, 1);
insert into role_rules(role_id, rules_id) value (2, 2);
insert into role_rules(role_id, rules_id) value (2, 3);
insert into role_rules(role_id, rules_id) value (2, 5);
insert into role_rules(role_id, rules_id) value (2, 6);
insert into role_rules(role_id, rules_id) value (3, 5);
insert into role_rules(role_id, rules_id) value (4, 7);
insert into role_rules(role_id, rules_id) value (4, 8);
insert into role_rules(role_id, rules_id) value (4, 9);

insert into comments(name, item_id) value ('who will do it?', 1);
insert into comments(name, item_id) value ('cant delete', 2);
insert into comments(name, item_id) value ('the bot is broken', 4);

insert into comments(name, item_id) value ('screenshot', 4);
insert into comments(name, item_id) value ('screenshot', 2);