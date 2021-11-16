/*
1.- AÑade las siguientes restricciones a la tabla departamentos:

- Todos los campos numéricos de la tabla son positivos.

- El Tipo de Director es 'F' o 'P'. Si no pudieras añadir alguna de las restricciones anteriores modifica los valores de las columnas correspondientes para añadirlas.

2.-Añade las siguientes restricciones a la tabla empleados:

- Todos los nombres de los empleados deben estar en mayúsculas.

- Todos los empleados eran mayores de edad cuando se incorporaron. Si no pudieras añadir alguna de las restricciones anteriores modifica los valores de las columnas correspondientes para añadirlas.

3.- Añade la columna NIVEL_HE NUMBER(2), a la tabla HABIEMPL con las siguientes restricciones:	

- Por defecto vale 5.0	

- Valores válidos entre 1 y 10.
*/

/*EJERCICIO 1*/

--PRIMERA PARTE

ALTER TABLE DEPARTAMENTOS
ADD CONSTRAINT SALMAYOR CHECK (DIRECTOR_DE > 0);

ALTER TABLE DEPARTAMENTOS
ADD CONSTRAINT PRESUPMAYOR CHECK (PRESUP_DE > 0);

--SEGUNDA PARTE

ALTER TABLE DEPARTAMENTOS
ADD CONSTRAINT VALORTIPO CHECK (TIPODIR_DE IN ('P', 'F'));

/*EJERCICIO 2*/

--PRIMERA PARTE

ALTER TABLE EMPLEADOS
ADD CONSTRAINT NOMBMAYU CHECK (NOMB_EM = UPPER(NOMB_EM));

-- SEGUNDA PARTE 

UPDATE TABLE EMPLEADOS
SET FECINC_EM=ADD_MONTHS(FECINC_EM, 12)
WHERE MONTHS_BETWEEN(FECINC_EM, FECNAC_EM)>(18*12));

ALTER TABLE EMPLEADOS
ADD CONSTRAINT CK_EDADMAYOR 
CHECK (MONTHS_BETWEEN(FECINC_EM, FECNAC_EM)>(18*12));

/*EJERCICIO 3*/

--PRIMERA PARTE

ALTER TABLE HABIEMPL
ADD (NIVEL_HE NUMBER(2))

ALTER TABLE HABIEMPL
ADD DEFAULT 5 FOR NIVEL_HE;

ALTER TABLE HABIEMPL
ADD CONSTRAINT CK_VALOR CHECK (NIVEL_HE IN(1, 10));








