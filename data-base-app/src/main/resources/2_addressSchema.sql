CREATE TABLE IF NOT EXISTS ADDRESS
(
id INT PRIMARY KEY AUTO_INCREMENT,
houseNumber INT not null,
street VARCHAR(255) not null,
city Varchar(255) not null,
country Varchar(255) not null,
postCode Varchar(255) not null
);