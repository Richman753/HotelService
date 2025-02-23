CREATE TABLE IF NOT EXISTS HOTEL
(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255) not null,
description VARCHAR,
brand Varchar(255) not null,
address_id INT not null,
contacts_id INT not null,
arrivalTime_id INT not null,
amenities Varchar(255)
);