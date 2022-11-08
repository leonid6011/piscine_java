insert into users (login, password) values ('Leonid', 'leonid601');
insert into users (login, password) values ('Sergey', 'sergey543');
insert into users (login, password) values ('Polina', '123polina');
insert into users (login, password) values ('Daniil', '987daniil');
insert into users (login, password) values ('Anton', 'anton43');

INSERT INTO rooms (name, owner_id) VALUES ('general', 1);
INSERT INTO rooms (name, owner_id) VALUES ('random', 2);
INSERT INTO rooms (name, owner_id) VALUES ('java', 3);
INSERT INTO rooms (name, owner_id) VALUES ('moscow_adm', 4);
INSERT INTO rooms (name, owner_id) VALUES ('pedago_intra', 1);

INSERT INTO messages (author, room, text) VALUES (1, 1, 'hello world');
INSERT INTO messages (author, room, text) VALUES (2, 2, 'whats up?');
INSERT INTO messages (author, room, text) VALUES (3, 3, 'java is wonderful');
INSERT INTO messages (author, room, text) VALUES (1, 4, 'i like java');
INSERT INTO messages (author, room, text) VALUES (5, 5, 'lol');
INSERT INTO messages (author, room, text) VALUES (4, 3, 'its a joke');