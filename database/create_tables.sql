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
)ENGINE=InnoDB CHARACTER SET=Latin1;

DROP TABLE tayte;

CREATE TABLE tayte (
	id SMALLINT NOT NULL AUTO_INCREMENT,
	nimi VARCHAR(25) NOT NULL,
	PRIMARY KEY(id)
)ENGINE=InnoDB CHARACTER SET=Latin1;

DROP TABLE pizzantayte;

CREATE TABLE pizzantayte (
	id SMALLINT NOT NULL AUTO_INCREMENT,
	pizza_id SMALLINT NOT NULL,
	tayte_id SMALLINT NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(pizza_id) REFERENCES pizza(id),
	FOREIGN KEY(tayte_id) REFERENCES tayte(id)
)ENGINE=InnoDB CHARACTER SET=Latin1;

INSERT INTO pizza (numero, nimi, hinta)
values 	(1, 'Hawaji', 7.90),
	(2, 'Italiano', 8.90),
	(3, 'Mexico', 8.90),
	(4, 'Pizza Blue Special', 9.90),
	(5, 'Empire', 8.90),
	(6, 'Bacon', 9.90),
	(7, 'Vave', 7.90),
	(8, 'Vege Americano', 8.90),
	(9, 'Tropical Chicken', 7.90),
	(10, 'Vege', 8.90);

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
	(17, 'oliivi');

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
	(37, 10, 12);