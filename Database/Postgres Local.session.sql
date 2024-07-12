-- DATA Types -- 
/*
    SERIAL

    CHAR
    VARCHAR
    TEXT

    INTEGER
    SMALLINT
    BIGINT
    DECIMAL or DEC
    FLOAT

    BOOLEAN or BOOL

    DATE
    TIME
    TIMESTAMP

*/

SELECT * FROM album;

-- AND operator -- 
SELECT * FROM track
WHERE genre_id = 2 AND milliseconds > 300000;

-- ORDER BY  - used to sort results in asc or desc order -- 
SELECT * FROM track
ORDER BY album_id DESC;

-- Built-in Function --
-- AS - used as an alias to change the column name of a retrieved record
SELECT MAX(total) AS max_total
FROM invoice;

SELECT MIN(total) AS min_total
FROM invoice;

SELECT AVG(total) AS total_avg
FROM invoice;

SELECT COUNT(total) AS total_count
FROM invoice;

SELECT SUM(total) AS sum
FROM invoice;

-- return customers that are not in the USA --
SELECT first_name, last_name, address, country
FROM customer
WHERE NOT country = 'USA';

-- create a query that will show Invoices of customers who are from Brazil. --
-- We want the resulting table to display the customers full name, Invoice ID, Date of Invoice, and Billing country --
SELECT c.first_name, c.last_name, c.country, i.invoice_id, i.invoice_date, i.billing_country
FROM customer AS c, invoice AS i
WHERE c.country = 'Brazil' AND c.customer_id = i.customer_id;


-- JOINS --

/*
INNER JOIN
- returns records with matching values in both tables
*/

/*
LEFT JOIN
- returns records from your left table and any matching records from the right table 
*/

/*
RIGHT JOIN 
- returns records from your right table and any matching records from the left table 
*/

/*
FULL JOIN
- return all records from both tables
*/


-- returns records from emploee, customer, and invoice table
SELECT e.first_name, e.last_name, i.invoice_id, i.customer_id, c.first_name, c.last_name
FROM employee AS e
JOIN customer AS c ON e.employee_id = c.support_rep_id
JOIN invoice AS i ON c.customer_id = i.customer_id



-- create a query that will include purchased tracks and the artist name with each invoice line item --
SELECT i.*, t.name AS track_name, ar.name AS artist_name
FROM invoice_line AS i
JOIN track AS t ON i.track_id = t.track_id
JOIN album AS a ON t.album_id = a.album_id
JOIN artist AS ar ON a.artist_id = ar.artist_id;

-- britt's example --
SELECT i.*, t.name AS track_name, ar.name AS artist_name
FROM track AS t
    JOIN album AS a ON t.album_id = a.album_id
    JOIN invoice_line AS i ON i.track_id = t.track_id
    JOIN artist AS ar ON ar.artist_id = a.artist_id;


-- create a query that will find what sales agent made the most sales 2021 --
SELECT MAX(total_sum) AS total_sum
FROM (  SELECT e.*, SUM(i.total) AS total_sum
        FROM employee AS e
        JOIN customer AS c ON e.employee_id = c.support_rep_id
        JOIN invoice AS i ON i.customer_id = c.customer_id
        WHERE i.invoice_date BETWEEN '2021-01-01' AND '2021-12-31'
        GROUP BY e.employee_id
    ) As total_sum;


SELECT CONCAT(first_name, ' ', last_name) AS employee_name, total_sales_amt
FROM (
        SELECT SUM(i.total) AS total_sales_amt, e.*
        FROM employee AS e
        INNER JOIN customer AS c ON c.support_rep_id = e.employee_id
        INNER JOIN invoice AS i ON i.customer_id = c.customer_id
        WHERE i.invoice_date BETWEEN '2021-01-01' AND '2021-12-31'
        GROUP BY e.employee_id
    ) AS total_sales_amt ORDER BY total_sales_amt DESC LIMIT 1;









