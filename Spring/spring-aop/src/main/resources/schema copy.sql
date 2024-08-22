/*

    used by the h2 database duing application startup
    
    creates our in-memory database tables

*/


/* If the movies or directors table already exists, drop it so it can be remade */


create table DIRECTORS (
	id Serial PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50)
);

create table MOVIES (
	id Serial PRIMARY KEY,
	movie_title VARCHAR(50),
	rating INT,
	director_id INT,
	FOREIGN KEY (director_id) REFERENCES DIRECTORS(id)
);

create table USERS (
	id Serial PRIMARY KEY,
	username text,
	user_password text,
	user_role text
);