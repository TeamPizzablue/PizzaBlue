DROP TABLE pizzarivi;
DROP TABLE juomarivi;
DROP TABLE pohja;
DROP TABLE tilaus;
DROP TABLE juoma;
DROP TABLE pizzantayte;
DROP TABLE tayte;
DROP TABLE pizza;

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
	nimi VARCHAR(20) NOT NULL,
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
	toimitustapa BOOLEAN NOT NULL,
	etunimi VARCHAR(20),
	sukunimi VARCHAR(30),
	puhelinnumero VARCHAR(15),
	sahkoposti VARCHAR(50),
	toimitusosoite VARCHAR(50),
	lisatiedot VARCHAR(200),
	tila_id SMALLINT NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(tila_id) REFERENCES tila(id)
)ENGINE=InnoDB CHARACTER SET=UTF8;

CREATE TABLE pohja (
	id SMALLINT NOT NULL AUTO_INCREMENT,
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
	id INT NOT NULL AUTO_INCREMENT,show
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
values 	(1, 'Hawaji', 7.90, 645, 27.50, 77.00, 30.00),
	(2, 'Italiano', 8.90, 663, 29.00, 78.00, 31.50),
	(3, 'Mexico', 8.90, 681, 29.50, 78.50, 32.00),
	(4, 'Pizza Blue Special', 9.90, 699, 32.00, 79.00, 32.50),
	(5, 'Empire', 8.90, 698, 31.00, 79.50, 32.50),
	(6, 'Bacon', 9.90, 717, 32.50, 82.00, 33.00),
	(7, 'Vave', 7.90, 687, 30.00, 80.00, 32.00),
	(8, 'Vege Americano', 8.90, 657, 28.00, 77.50, 32.50),
	(9, 'Tropical Chicken', 7.90, 442, 16.00, 40.00, 22.00),
	(10, 'Vege', 8.90, 448, 17.50, 43.00, 24.00),
	(11, 'Pepperoni', 8.90, 478, 34.00, 71.00, 34.50),
	(12, 'Chicken Feta', 9.90, 448, 29.00, 74.00, 30.00);

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
values  (1, 'Coca cola', 250, 1.90, 108, 0.00, 27.00, 0.00),
	(2, 'Fanta', 250, 1.90, 110, 0.00, 27.00, 0.00),
	(3, '7UP', 250, 1.90, 108, 0.00, 27.50, 0.00),
	(4, 'Mountain Dew', 250, 1.90, 108, 0.00, 27.00, 0.00),
	(5, 'Vihersmoothie', 100, 2.90, 50, 0.40, 11.00, 0.00),
	(6, 'Hedelmämehu', 250, 2.90, 111, 0.00, 24.00, 0.00),
	(7, 'Mehu', 200, 2.50, 120, 0.00, 22.00, 0.00),
	(8, 'Vesi', 200, 1.00, 0.00, 0.00, 0.00, 0.00);

INSERT INTO tila (id, nimi)
values	(1, 'käsittelyssä'),
	(2, 'valmis'),
	(3, 'maksettu');