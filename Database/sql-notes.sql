-- DML vs DDL --

/*
	DDL - Data Definition Language
			-> SQL commands that are used to create, drop, and modify database objects 
			-> Not the data itself, but where it sits
			
				- CREATE - creates a table
				- ALTER - modify the structure of an existing table
				- DROP - deletes a table and all of its data
				- TRUNCATE - removes all the data from the table, but keeps the table
				
	DML - Data Manipulation Language
			-> SQL commands that are used to add, delete, and edit data in your tables
					
				- INSERT - adds new data into your tables
				- UPDATE - modifies data existing in your table 
				- DELETE - removes specified data from a table
				- SELECT - retrieves data from one or more tables
*/


CREATE Table library (
	Library_ID BIGSERIAL PRIMARY KEY,
	Name VARCHAR(255),
	location VARCHAR(255)
);

ALTER TABLE library
ADD COLUMN Library_ID BIGSERIAL
PRIMARY KEY;

-- inserts values into a table --
INSERT INTO library (Name, location) 
VALUES ('Piedmont Library', 'Georgia'),
	   ('Memorial Library', 'Texas'),
	   ('Little Free Library', 'North Carolina'),
	   ('Golden Gate Library', 'California'),
	   ('Willow Creeek Library', 'South Carolina');
	   
-- modifies a value of a specified row --
UPDATE library
SET Name = 'Willow Creek Library'
WHERE library_id = 5;

DELETE FROM library
WHERE library_id = 1;
		

SELECT * FROM library;





