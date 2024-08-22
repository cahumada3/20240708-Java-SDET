/*

    used by the h2 database duing application startup

    populates table with data
    
*/

/* make sure to insert directors first */
insert into USERS (username, user_password, user_role) values ('username1', 'password1', 'USER');
insert into USERS (username, user_password, user_role) values ('username2', 'password2', 'USER');
insert into USERS (username, user_password, user_role) values ('username3', 'password3', 'USER');
insert into USERS (username, user_password, user_role) values ('username4', 'password4', 'MOD');
insert into USERS (username, user_password, user_role) values ('username5', 'password5', 'ADMIN');
insert into USERS (username, user_password, user_role) values ('carolineahu', '$2y$10$L.S2VIJroEFIZO.aizkL5uOR8WFERmwUNJZrKmH00qUwHMgf0AX9S', 'USER');


