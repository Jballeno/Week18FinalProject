DROP TABLE IF EXISTS car_location;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS model;

CREATE TABLE model (
	model_id int NOT NULL AUTO_INCREMENT,
	name varchar(128),
	PRIMARY KEY(model_id)

);




CREATE TABLE car (
	car_id int NOT NULL AUTO_INCREMENT,
	model_id int NOT NULL,
	name varchar(50) NOT NULL,
	manufactured_year int,
	color varchar(128),
	PRIMARY KEY(car_id),
	FOREIGN KEY (model_id) REFERENCES model(model_id) ON DELETE CASCADE 
);


CREATE TABLE location (
	location_id int NOT NULL AUTO_INCREMENT,
	business_name varchar(256) NOT NUll,
	address varchar(128),
	city varchar(50) ,
	state varchar(50),
	zip varchar(20),
	phone varchar(30),
	PRIMARY KEY (location_id)
	
);

CREATE TABLE car_location (
	car_id int NOT NULL,
	location_id int NOT NULL,
	FOREIGN KEY (car_id) REFERENCES car (car_id) ON DELETE CASCADE,
	FOREIGN KEY (location_id) REFERENCES location (location_id) ON DELETE CASCADE
);