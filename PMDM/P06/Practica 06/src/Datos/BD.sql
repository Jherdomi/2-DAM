DROP TABLE asignacion;
DROP TABLE pirata;
DROP TABLE arma;
DROP TABLE tesoro;
DROP TABLE banda;


CREATE TABLE banda(
codBanda 				INTEGER NOT NULL PRIMARY KEY,
nomBanda 				VARCHAR(30),
totMiembros				INTEGER,
numTesoros				INTEGER,
fechaCreacion                           DATE,
contraseña				VARCHAR(30)
);

CREATE TABLE tesoro(
codTesoro 				INTEGER NOT NULL PRIMARY KEY,
nomTesoro 				VARCHAR(30),
bandaPertenece			INTEGER NOT NULL,
FOREIGN KEY (bandaPertenece) REFERENCES banda(codBanda)
);

CREATE TABLE arma(
codArma 				INTEGER NOT NULL PRIMARY KEY,
nomArma					VARCHAR(15)
);

CREATE TABLE pirata(
codPirata				INTEGER NOT NULL PRIMARY KEY,
nomPirata				VARCHAR(30),
apePirata				VARCHAR(30),
fechaIncorporacion		DATE,
foto					VARCHAR(30),
asesinatos				INTEGER,
capitan					INTEGER NOT NULL,
codigoBanda				INTEGER NOT NULL,
codigoArma				INTEGER NOT NULL,
FOREIGN KEY (capitan) REFERENCES pirata(codPirata),
FOREIGN KEY (codigoBanda) REFERENCES banda(codBanda),
FOREIGN KEY (codigoArma) REFERENCES arma(codArma)
);

CREATE TABLE asignacion(
pirata 					INTEGER NOT NULL,
arma					INTEGER NOT NULL,
coste 					NUMERIC(8, 2) DEFAULT 0,
FOREIGN KEY (pirata) REFERENCES pirata(codPirata),
FOREIGN KEY (arma) REFERENCES arma(codArma)
);

INSERT INTO banda VALUES(1, 'Mugiwara', NULL, NULL, '1995/12/18', 'luffy');
INSERT INTO banda VALUES(2, 'RedHair', NULL, NULL, '1997/11/19', 'shanks');
INSERT INTO banda VALUES(3, 'Heart', NULL, NULL, '1986/03/20', 'law');
INSERT INTO banda VALUES(4, 'Buggy', NULL, NULL, '1990/05/20', 'buggy');

INSERT INTO tesoro VALUES(1, 'Tesoro Skypie', 1);
INSERT INTO tesoro VALUES(2, 'Tesoro Syrup', 2);
INSERT INTO tesoro VALUES(3, 'Tesoro Little Garden', 3);
INSERT INTO tesoro VALUES(4, 'Tesoro Arabasta', 4);
INSERT INTO tesoro VALUES(5, 'Tesoro Wano', 1);
INSERT INTO tesoro VALUES(6, 'Tesoro Whole Cake', 4);
INSERT INTO tesoro VALUES(7, 'Tesoro Amazon Lilly', 2);
INSERT INTO tesoro VALUES(8, 'Tesoro LaughTale', 1);

INSERT INTO arma VALUES(1, 'Pistola');
INSERT INTO arma VALUES(2, 'Escudo');
INSERT INTO arma VALUES(3, 'Espada');
INSERT INTO arma VALUES(4, 'Katana');
INSERT INTO arma VALUES(5, 'Puños');
INSERT INTO arma VALUES(6, 'Lanza');
INSERT INTO arma VALUES(7, 'Cañon');
INSERT INTO arma VALUES(8, 'Cuchillo');

INSERT INTO pirata VALUES(1, 'Luffy', 'Monkey D.', '1995/12/18', '1001.jpg', 213, 1, 1, 5);
INSERT INTO pirata VALUES(2, 'Zoro', 'Roronoa', '1996/01/20', '1002.jpg', 200, 1, 1, 4);
INSERT INTO pirata VALUES(3, 'Sanji', 'Vinsmoke', '1996/02/10', '1003.jpg', 179, 1, 1, 8);
INSERT INTO pirata VALUES(4, 'Usopp', 'God', '1996/01/25', '1004.jpg', 120, 1, 1, 1);
INSERT INTO pirata VALUES(5, 'Robin', 'Demon Child', '1997/05/25', '1005.jpg', 157, 1, 1, 2);

INSERT INTO pirata VALUES(6, 'Shanks', 'RedHair', '1997/11/19', '1006.jpg', 510, 6, 2, 3);
INSERT INTO pirata VALUES(7, 'Ben', 'Beckman', '1997/11/20', '1007.jpg', 420, 6, 2, 7);
INSERT INTO pirata VALUES(8, 'Lucky', 'Roux', '1998/01/21', '1008.jpg', 390, 6, 2, 1);
INSERT INTO pirata VALUES(9, 'Yasopp', 'GodFather', '1997/12/22', '1009.jpg', 460, 6, 2, 1);
INSERT INTO pirata VALUES(10, 'Uta', 'RedHair', '1997/11/30', '1010.jpg', 100, 6, 2, 6);

INSERT INTO pirata VALUES(11, 'Law', 'Trafalgar D.', '1986/03/20', '1011.jpg', 211, 11, 3, 4);
INSERT INTO pirata VALUES(12, 'Beppo', 'Bear', '1986/03/22', '1012.jpg', 210, 11, 3, 5);
INSERT INTO pirata VALUES(13, 'Jean', 'Bart', '1987/02/28', '1013.jpg', 160, 11, 3, 2);
INSERT INTO pirata VALUES(14, 'Ikkaku', 'Heart', '1986/05/28', '1014.jpg', 140, 11, 3, 1);
INSERT INTO pirata VALUES(15, 'Penguin', 'Guy', '1990/08/20', '1015.jpg', 160, 11, 3, 3);

INSERT INTO pirata VALUES(16, 'Buggy', 'The Clown', '1990/05/20', '1016.jpg', 173, 16, 4, 1);
INSERT INTO pirata VALUES(17, 'Mihawk', 'Dracule', '1990/05/21', '1017.jpg', 460, 16, 4, 3);
INSERT INTO pirata VALUES(18, 'Crocodile', 'SandStorm', '1990/05/21', '1018.jpg', 320, 16, 4, 8);
INSERT INTO pirata VALUES(19, 'Mohji', 'Lion', '1991/09/30', '1019.jpg', 100, 16, 4, 7);
INSERT INTO pirata VALUES(20, 'Alvida', 'Iron Maze', '1999/12/01', '1020.jpg', 99, 16, 4, 6);

INSERT INTO asignacion VALUES(1, 5, 10);
INSERT INTO asignacion VALUES(6, 3, 1000);
INSERT INTO asignacion VALUES(11, 4, 1500);
INSERT INTO asignacion VALUES(16, 1, 1020);
INSERT INTO asignacion VALUES(2, 4, 1500);
INSERT INTO asignacion VALUES(7, 7, 1600);
INSERT INTO asignacion VALUES(12, 5, 10);
INSERT INTO asignacion VALUES(17, 3, 1900);
INSERT INTO asignacion VALUES(3, 8, 100);
INSERT INTO asignacion VALUES(8, 1, 1400);
