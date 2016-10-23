INSERT INTO GLOBAL_USER_ROLE (id, name) VALUES (1, 'USER');
INSERT INTO GLOBAL_USER_ROLE (id, name) VALUES (2, 'ADMIN');
INSERT INTO GLOBAL_USER (id, login, password, available, firstname, lastname, email, role) VALUES (1, 'user', 'user', true, 'User', 'Userovich', 'user@email.com', 1);
INSERT INTO GLOBAL_USER (id, login, password, available, firstname, lastname, email, role) VALUES (2, 'admin', 'admin', true, 'Admin', 'Adminin', 'admin@email.com', 2);
INSERT INTO TEST_SOME_CLASS (id, one, two) VALUES (1, 'one', 'two');