CREATE TABLE empresa (
    codigoEmpresa                      INTEGER NOT null primary key,
    nomEmpresa                      VARCHAR(30),
    totSal                          NUMERIC(8,2) DEFAULT 0,
    fechaCreacion                   DATE,
    contrasena                      VARCHAR(30)
);



CREATE TABLE trabajador (
    codTrabajador                   INTEGER NOT null primary key,
    nomTrabajador                   VARCHAR(30),
    apeTrabajador                   VARCHAR(30),
    fotoTrabajador                  VARCHAR(30),
    salario                         NUMERIC(8,2) DEFAULT 0,
    fechaAlta                       DATE,
    codEmpresa                      INTEGER NOT null,
    foreign key (codEmpresa) REFERENCES empresa(codigoEmpresa)
);

INSERT INTO empresa VALUES(1, 'NIKE', null, '09/12/2017', 'nike');
INSERT INTO empresa VALUES(2, 'ADIDAS', null, '07/07/2018', 'adidas');
INSERT INTO empresa VALUES(3, 'NEWBALANCE', null, '03/20/2019', 'new');

INSERT INTO trabajador VALUES(1, 'Jose', 'Perez', '1001.jpg', 1500, '09/11/2001', 1);
INSERT INTO trabajador VALUES(2, 'Martin', 'Martin', '1002.jpg', 3500, '10/11/2019', 1);
INSERT INTO trabajador VALUES(3, 'Jose', 'Zapata', '1005.jpg', 950, '02/11/2018', 1);

INSERT INTO trabajador VALUES(4, 'Olga', 'Puente', '1004.jpg', 1500, '03/12/2003', 2);
INSERT INTO trabajador VALUES(5, 'Ricardo', 'Ramirez', '1007.jpg', 1900, '05/10/2017', 2);
INSERT INTO trabajador VALUES(6, 'Pepe', 'Lopez', '1008.jpg', 1700, '01/07/2008', 2);

INSERT INTO trabajador VALUES(7, 'Juan', 'Hernandez', '1009.jpg', 3300, '09/30/2001', 3);
INSERT INTO trabajador VALUES(8, 'Tomas', 'Bender', '1010.jpg', 3000, '10/01/2018', 3);
INSERT INTO trabajador VALUES(9, 'Gabriel', 'Gavi', '1011.jpg', 900, '10/10/2006', 3);
