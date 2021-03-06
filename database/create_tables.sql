DROP TABLE pizzarivi;
DROP TABLE juomarivi;
DROP TABLE pohja;
DROP TABLE tilaus;
DROP TABLE tila;
DROP TABLE juoma;
DROP TABLE pizzantayte;
DROP TABLE tayte;
DROP TABLE pizza;
DROP TABLE kayttaja;

CREATE TABLE tiedote (
	id	SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	aikaleima TIMESTAMP NOT NULL,
	otsikko VARCHAR(50) NOT NULL,
	sisalto VARCHAR(500) NOT NULL
)ENGINE=InnoDB CHARACTER SET=UTF8;
	

CREATE TABLE kayttaja (
	id SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(255) NOT NULL UNIQUE KEY,
	password_hash VARCHAR(255) NOT NULL,
	salt VARCHAR(255) NOT NULL
)ENGINE=InnoDB CHARACTER SET=UTF8;

CREATE TABLE pizza (
	id SMALLINT NOT NULL AUTO_INCREMENT,
	numero SMALLINT NOT NULL,
	nimi VARCHAR(20) NOT NULL,
	hinta DECIMAL(4,2) NOT NULL,
	energia INT,
	proteiini DECIMAL(4,2),
	hiilihydraatti DECIMAL(5,2),
	rasva DECIMAL(4,2),
	PRIMARY KEY(id)
)ENGINE=InnoDB CHARACTER SET=UTF8;

CREATE TABLE tayte (
	id SMALLINT NOT NULL AUTO_INCREMENT,
	nimi VARCHAR(25) NOT NULL,
	PRIMARY KEY(id)
)ENGINE=InnoDB CHARACTER SET=UTF8;

CREATE TABLE pizzantayte ( 
	id SMALLINT NOT NULL AUTO_INCREMENT,
	pizza_id SMALLINT NOT NULL,
	tayte_id SMALLINT NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(pizza_id) REFERENCES pizza(id),
	FOREIGN KEY(tayte_id) REFERENCES tayte(id)
)ENGINE=InnoDB CHARACTER SET=UTF8;

CREATE TABLE juoma (
	id SMALLINT NOT NULL AUTO_INCREMENT,
	numero SMALLINT NOT NULL,
	nimi VARCHAR(23) NOT NULL,
	maara INT NOT NULL,
	hinta DECIMAL(4,2) NOT NULL,
	energia INT,
	proteiini DECIMAL(4,2),
	hiilihydraatti DECIMAL(4,2),
	rasva DECIMAL(4,2),
	PRIMARY KEY(id)
)ENGINE=InnoDB CHARACTER SET=UTF8;

CREATE TABLE tila (
	id SMALLINT NOT NULL,
	nimi VARCHAR(20) NOT NULL,
	PRIMARY KEY(id)
)ENGINE=InnoDB CHARACTER SET=UTF8;

CREATE TABLE tilaus (
	id INT NOT NULL AUTO_INCREMENT,
	hinta DECIMAL(8,2) NOT NULL,
	aikaleima TIMESTAMP NOT NULL,
	kotiinkuljetus BOOLEAN NOT NULL,
	etunimi VARCHAR(20),
	sukunimi VARCHAR(30),
	puhelinnumero VARCHAR(15),
	sahkoposti VARCHAR(50),
	katuosoite VARCHAR(50),
	postinro CHAR(5),
	postitmp VARCHAR(30),
	lisatiedot VARCHAR(200),
	tila_id SMALLINT NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(tila_id) REFERENCES tila(id)
)ENGINE=InnoDB CHARACTER SET=UTF8;

CREATE TABLE pohja (
	id SMALLINT NOT NULL,
	nimi VARCHAR(20) NOT NULL,
	PRIMARY KEY(id)
)ENGINE=InnoDB CHARACTER SET=UTF8;

CREATE TABLE juomarivi (
	id INT NOT NULL AUTO_INCREMENT,
	maara SMALLINT NOT NULL,
	hinta DECIMAL(6,2) NOT NULL,
	juoma_id SMALLINT NOT NULL,
	tilaus_id INT NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(juoma_id) REFERENCES juoma(id),
	FOREIGN KEY(tilaus_id) REFERENCES tilaus(id)
)ENGINE=InnoDB CHARACTER SET=UTF8;

CREATE TABLE pizzarivi (
	id INT NOT NULL AUTO_INCREMENT,
	maara SMALLINT NOT NULL,
	hinta DECIMAL(6,2) NOT NULL,
	oregano BOOLEAN NOT NULL,
	valkosipuli BOOLEAN NOT NULL,
	pohja_id SMALLINT NOT NULL,
	pizza_id SMALLINT NOT NULL,
	tilaus_id INT NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(pohja_id) REFERENCES pohja(id),
	FOREIGN KEY(pizza_id) REFERENCES pizza(id),
	FOREIGN KEY(tilaus_id) REFERENCES tilaus(id)
)ENGINE=InnoDB CHARACTER  SET=UTF8;
	

INSERT INTO pizza (numero, nimi, hinta, energia, proteiini, hiilihydraatti, rasva)
values 	(1, 'Hawaji', 8.70, 645, 27.50, 77.00, 30.00),
	(2, 'Italiano', 9.70, 663, 29.00, 78.00, 31.50),
	(3, 'Mexico', 8.90, 681, 29.50, 78.50, 32.00),
	(4, 'Pizza Blue Special', 9.50, 699, 32.00, 79.00, 32.50),
	(5, 'Empire', 9.70, 698, 31.00, 79.50, 32.50),
	(6, 'Bacon', 9.90, 717, 32.50, 82.00, 33.00),
	(7, 'Vave', 8.70, 687, 30.00, 80.00, 32.00),
	(8, 'Vege Americano', 8.90, 657, 28.00, 77.50, 32.50),
	(9, 'Tropical Chicken', 8.70, 442, 16.00, 40.00, 22.00),
	(10, 'Vege', 8.70, 448, 17.50, 43.00, 24.00),
	(11, 'Pepperoni', 8.70, 478, 34.00, 71.00, 34.50),
	(12, 'Chicken Feta', 9.20, 448, 29.00, 74.00, 30.00);

INSERT INTO tayte (id, nimi)
values	(1, 'kinkku'),
	(2, 'ananas'),
	(3, 'salami'),
	(4, 'aurajuusto'),
	(5, 'katkarapu'),
	(6, 'pepperoni'),
	(7, 'jalapeno'),
	(8, 'chili'),
	(9, 'paprika'),
	(10, 'tomaatti'),
	(11, 'mozzarella'),
	(12, 'sipuli'),
	(13, 'pekoni'),
	(14, 'seitan'),
	(15, 'kana'),
	(16, 'herkkusieni'),
	(17, 'oliivi'),
	(18, 'feta');

INSERT INTO pizzantayte (id, pizza_id, tayte_id)
values	(1, 1, 1),
	(2, 1, 2),
	(3, 2, 3),
	(4, 2, 1),
	(5, 2, 4),
	(6, 2, 5),
	(7, 3, 6),
	(8, 3, 2),
	(9, 3, 7),
	(10, 4, 8),
	(11, 4, 9),
	(12, 4, 12),
	(13, 4, 10),
	(14, 4, 11),
	(15, 5, 5),
	(16, 5, 3),
	(17, 5, 12),
	(18, 5, 1),
	(19, 6, 13),
	(20, 6, 12),
	(21, 6, 5),
	(22, 6, 9),
	(23, 6, 4),
	(24, 7, 9),
	(25, 7, 12),
	(26, 7, 3),
	(27, 8, 2),
	(28, 8, 4),
	(29, 8, 14),
	(30, 9, 15),
	(31, 9, 2),
	(32, 9, 4),
	(33, 10, 16),
	(34, 10, 17),
	(35, 10, 9),
	(36, 10, 10),
	(37, 10, 12),
	(38, 11, 6),
	(39, 12, 15),
	(40, 12, 18),
	(41, 12, 17);

INSERT INTO juoma (numero, nimi, maara, hinta, energia, proteiini, hiilihydraatti, rasva)
values  (1, 'Coca Cola', 330, 1.90, 108, 0.00, 27.00, 0.00),
	(2, 'Coca Cola Light', 330, 1.90, 0, 0.00, 0.00, 0.00),
	(3, 'Fanta', 330, 1.90, 110, 0.00, 27.00, 0.00),
	(4, '7UP', 330, 1.90, 108, 0.00, 27.50, 0.00),
	(5, 'Mountain Dew', 330, 1.90, 108, 0.00, 27.00, 0.00),
	(6, 'Energiajuoma', 500, 2.90, 100, 16, 10, 0.00),
	(7, 'Vihersmoothie', 330, 2.90, 50, 0.40, 11.00, 0.00),
	(8, 'Persikka-Mango Smoothie', 330, 3.40, 100, 2.00, 14.00, 2.00),
	(9, 'Vesimelonimehu', 350, 3.40, 80, 1.00, 16.00, 0.00),
	(10, 'Hedelmämehu', 500, 2.90, 111, 0.00, 24.00, 0.00),
	(11, 'Mehu', 350, 2.50, 120, 0.00, 22.00, 0.00),
	(12, 'Vesi', 500, 1.00, 0.00, 0.00, 0.00, 0.00);
	
INSERT INTO pohja (id, nimi) 
values	(1, 'Tavallinen'),
	(2, 'Täysjyvä'),
	(3, 'Gluteeniton');

INSERT INTO tila (id, nimi)
values	(1, 'käsittelyssä'),
	(2, 'valmis'),
	(3, 'maksettu');