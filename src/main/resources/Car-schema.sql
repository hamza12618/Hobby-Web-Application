/*
DROP TABLE IF EXISTS `garage` CASCADE;
CREATE TABLE `garage`
(
	`garage_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`garage_name` VARCHAR(255) NOT NULL,
	`garage_location` VARCHAR(255) NOT NULL
	
	
);
*/
DROP TABLE IF EXISTS `car` CASCADE;
CREATE TABLE `car`
(
	`car_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`car_name` VARCHAR(255) NOT NULL,
	`garage_garage_id` BIGINT,
	`reg_number` VARCHAR(255) NOT NULL
	-- FOREIGN KEY (garage_garage_id) REFRENCES garage(garage_id)
	
	
	
	
);