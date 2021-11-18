DROP TABLE IF EXISTS `garage` CASCADE;
CREATE TABLE `garage`
(
	`garage_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`garage_name` VARCHAR(255) NOT NULL,
	`garage_location` VARCHAR(255) NOT NULL
	
	
);