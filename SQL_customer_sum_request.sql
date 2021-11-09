-- find customer's name, customer's phone and orders sum of all his orders and sort it's by sum (from biggest sum to smallest sum)
WITH sum_table AS ( -- add a name for result table
SELECT
	customer.name AS customer_name,
	customer.phone AS phone,
	SUM(price) AS sum
FROM
	customer
	INNER JOIN customer_orders ON customer.id = customer_orders.customer_id
	INNER JOIN orders ON customer_orders.order_id = orders.id
GROUP BY
	customer_name,
	phone
ORDER BY 
	sum DESC
)
SELECT * FROM sum_table; -- get all from sum_table