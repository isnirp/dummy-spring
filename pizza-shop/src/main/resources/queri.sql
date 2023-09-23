CREATE TABLE pizza(
id SERIAL PRIMARY KEY,
crust VARCHAR(30),
size VARCHAR(30)
);

CREATE TABLE topping(
id SERIAL PRIMARY KEY,
pizza_id INTEGER REFERENCES pizza(id),
name VARCHAR(64)
);

INSERT INTO pizza(crust, size) VALUES
('basic','LARGE'),('basic','MEDIUM'),('basic','SMALL');

INSERT INTO topping(pizza_id, name) VALUES
(1,'cheese'),(1,'fungus'),(2,'salami'),(3,'pineapple');