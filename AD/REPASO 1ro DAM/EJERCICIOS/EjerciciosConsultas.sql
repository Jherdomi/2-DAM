
1.- Listar el c�digo y nombre de los empleados cuyo c�digo sea distinto de 1, 4, 6, 8 � 10.

SQL>

SELECT COD_EM, NOMB_EM FROM EMPLEADOS
WHERE COD_EM != 1 AND COD_EM != 4 AND  COD_EM != 6 AND COD_EM != 8 AND COD_EM != 10; 

RESULTADO:

    COD_EM NOMB_EM
---------- ----------------------------------------
         5 ALADA VERAZ, JUANA
         7 FORZADO LÓPEZ, JUAN
         9 MANDO CORREA, ROSA
         2 MANRIQUE BACTERIO, LUISA
         3 MONFORTE CID, ROLDÁN
		 
		 
************************************************************************
2.- Listar el nombre de los empleados que no tienen extensi�n telef�nica.

SQL>

SELECT NOMB_EM FROM EMPLEADOS
WHERE EXTIEL_EM IS NULL;

RESULTADO:

NOMB_EM
----------------------------------------
FORZADO LÓPEZ, JUAN
MASCULLAS ALTO, ELOISA
PÉREZ MUÑOZ, ALFONSO


************************************************************************
3.- Listado del c�digo, nombre y presupuesto de los departamentos ordenado por criterio descendente de presupuesto anual.

SQL>

SELECT COD_DE, NOMB_DE, PRESUP_DE FROM DEPARTAMENTOS
ORDER BY PRESUP_DE DESC;

RESULTADO:

COD_D NOMB_DE                                   PRESUP_DE
----- ---------------------------------------- ----------
PROZS PRODUCCIÓN ZONA SUR                       108000000
DIRGE DIRECCIÓN GENERAL                          26000000
INYDI INVESTIGACIÓN Y DISEÑO                     25000000
ADMZS ADMINISTRACIÓN ZONA SUR                    14000000
VENZS VENTAS ZONA SUR                            13500000
JEFZS JEFATURA FÁBRICA ZONA SUR                   6200000


************************************************************************
4.- Listar el nombre del empleado y el nombre y fecha de nacimiento de su hijo/a para aquellos empleados con un �nico hijo. 
Ordenar por fecha de nacimiento de los hijos.

SQL>

SELECT NOMB_EM, NOMB_HI, FECNAC_HI FROM EMPLEADOS E, HIJOS H
WHERE E.COD_EM=H.PADRE_HI AND NUMHIJ_EM = 1
ORDER BY FECNAC_HI;

RESULTADO:

NOMB_EM                                  NOMB_HI                                  FECNAC_HI
---------------------------------------- ---------------------------------------- ----------
ALADA VERAZ, JUANA                       PASTORA ALADA, MATEO                     06/03/1982
RUIZ DE LOPERA, MANUEL                   RUIZ DENIL, SON                          07/06/1989
MONFORTE CID, ROLDÁN                     MONFORTE LEMOS, JESÚS                    12/09/1990
MASCULLAS ALTO, ELOISA                   FUERTE MASCULLAS, ANACLETO               14/03/1994


************************************************************************
5.- Listar el nombre de los departamentos y del departamento del que dependen (s�lo para los departamentos dependientes).

SQL>

SELECT NOMB_DE, DEPTJEFE_DE FROM DEPARTAMENTOS
WHERE DEPTJEFE_DE IS NOT NULL;

RESULTADO:

NOMB_DE                                  DEPTJ
---------------------------------------- -----
INVESTIGACIÓN Y DISEÑO                   DIRGE
PRODUCCIÓN ZONA SUR                      JEFZS
VENTAS ZONA SUR                          ADMZS


************************************************************************
6.- Listar el NIF, nombre del empleado y el nombre del dpto. al que se encuentra asignado ordenado por dpto. 
y dentro de cada dpto por el nombre de empleado.

SQL>

SELECT DNI_EM, NOMB_EM, NOMB_DE FROM EMPLEADOS E, DEPARTAMENTOS D
WHERE E.COD_EM = D.DIRECTOR_DE
ORDER BY COD_DE;

RESULTADO:

DNI_EM    NOMB_EM                                  NOMB_DE
--------- ---------------------------------------- ----------------------------------------
38223822T ALADA VERAZ, JUANA                       ADMINISTRACIÓN ZONA SUR
21452145V RUIZ DE LOPERA, MANUEL                   DIRECCIÓN GENERAL
21232123K MANRIQUE BACTERIO, LUISA                 INVESTIGACIÓN Y DISEÑO
26452645D GOZQUE ALTANERO, CARLOS                  JEFATURA FÁBRICA ZONA SUR
11311131D MANDO CORREA, ROSA                       PRODUCCIÓN ZONA SUR
23822382D MONFORTE CID, ROLDÁN                     VENTAS ZONA SUR


************************************************************************
7.- Listar el salario m�nimo, m�ximo y medio para cada dpto. indicando el c�digo de dpto. al que pertenece el dato.

SQL>

SELECT COD_DE, MIN(SALARIO_EM), MAX(SALARIO_EM), AVG(SALARIO_EM) FROM  EMPLEADOS E, DEPARTAMENTOS D
WHERE E.COD_EM = D.DIRECTOR_DE
GROUP BY COD_DE;

RESULTADO:

COD_D MIN(SALARIO_EM) MAX(SALARIO_EM) AVG(SALARIO_EM)
----- --------------- --------------- ---------------
ADMZS         6200000         6200000         6200000
DIRGE         7200000         7200000         7200000
INYDI         4500000         4500000         4500000
JEFZS         5000000         5000000         5000000
PROZS         3100000         3100000         3100000
VENZS         5200000         5200000         5200000

************************************************************************
8.- Listar el salario promedio de los empleados.

SQL>

SELECT AVG(SALARIO_EM) FROM EMPLEADOS;

RESULTADO:

AVG(SALARIO_EM)
---------------
        3890000

************************************************************************
9.- Listar el nombre de los hijos del empleado que se apellida 'Correa'.

SQL>

SELECT NOMB_HI FROM EMPLEADOS E, HIJOS H
WHERE E.COD_EM=H.PADRE_HI AND NOMB_EM LIKE '%CORREA%';

RESULTADO:

NOMB_HI
----------------------------------------
LEÓN MANDO, ELVIRA
LEÓN MANDO, PLÁCIDO

************************************************************************
10.- Listar el nombre de los departamentos en los que la suma de los sueldos es igual o mayor al 25% del presupuesto.

SQL>

SELECT NOMB_DE FROM DEPARTAMENTOS D, EMPLEADOS E
WHERE D.DIRECTOR_DE=E.COD_EM
GROUP BY NOMB_DE, PRESUP_DE
HAVING SUM(SALARIO_EM)>=PRESUP_DE*0.25;


RESULTADO:

NOMB_DE
----------------------------------------
ADMINISTRACIÓN ZONA SUR
DIRECCIÓN GENERAL
JEFATURA FÁBRICA ZONA SUR
VENTAS ZONA SUR

************************************************************************
11.- Listar los departamentos que tengan alg�n empleado que gane m�s de 500.000 ptas al mes. (Recuerda que el salario es anual).

SQL>

SELECT COD_DE FROM DEPARTAMENTOS D, EMPLEADOS E
WHERE D.DIRECTOR_DE=E.COD_EM
AND ((SALARIO_EM/12)*166)>=500000;

RESULTADO:

COD_D
-----
ADMZS
DIRGE
INYDI
JEFZS
PROZS
VENZS


************************************************************************
12.- Para cada extensi�n telef�nica, hallar cu�ntos empleados la usan y el salario medio de �stos.

SQL>

SELECT EXTIEL_EM, COUNT(NOMB_EM), AVG(SALARIO_EM) FROM EMPLEADOS
GROUP BY EXTIEL_EM;

RESULTADO:

EXTIEL_EM COUNT(NOMB_EM) AVG(SALARIO_EM)
--------- -------------- ---------------
1111                   1         7200000
12124                  1         3100000
1239                   1         6200000
2133                   1         5200000
2233                   1         4500000
23838                  1         5000000
3838                   1         3200000
                       3         1500000


************************************************************************
13.- Hallar el salario medio por departamento para aquellos departamentos cuyo salario m�ximo es inferior al salario medio de todos los empleados.

SQL>

SELECT COD_DE, AVG(SALARIO_EM) FROM DEPARTAMENTOS D, EMPLEADOS E
WHERE D.DIRECTOR_DE=E.COD_EM
HAVING MAX(PRESUP_DE)<AVG(SALARIO_EM)
GROUP BY COD_DE;


RESULTADO:

ninguna fila seleccionada

************************************************************************
14.- Mostrar la habilidad que no tiene ningún empleado.

SQL>

SELECT CODHA_HE FROM HABIEMPL
WHERE CODEM_HE IS NULL;

RESULTADO:

ninguna fila seleccionada

************************************************************************
15.- Mostrar los nombres propios de los empleados que tienen al menos dos habilidades.

SQL>

SELECT NOMB_EM FROM EMPLEADOS E, HABIEMPL H
WHERE E.COD_EM=H.CODEM_HE AND CODEM_HE >=  2;

RESULTADO:

NOMB_EM
----------------------------------------
MONFORTE CID, ROLDÁN
TOPAZ ILLÁN, CARLOS
ALADA VERAZ, JUANA
ALADA VERAZ, JUANA
MASCULLAS ALTO, ELOISA


************************************************************************
16.- Realiza un informe que muestre el nombre de cada departamento, nombre y salario de cada empleado y salario medio por departamento.

SQL>

REM NOMBRE: INFORME PREGUNTA 166
TTITLE 'MUESTRA EL NOMBRE DEL DEPT, EL NOMBRE Y SALARIO DE LOS EMPLEADOS Y EL SALARIO MEDIO POR DEPT'
BTITLE LEFT '29/09/2021'

SET LINESIZE 150
SET PAGESIZE 120

SELECT NOMB_DE, NOMB_EM, SALARIO_EM, AVG(SALARIO_EM) FROM DEPARTAMENTOS D, EMPLEADOS E
WHERE D.DIRECTOR_DE=E.COD_EM
GROUP BY NOMB_DE, NOMB_EM, SALARIO_EM;

TTITLE OFF
BTITLE OFF

RESULTADO:

Mié Sep 29                                                                                                                                 página    1
                             MUESTRA EL NOMBRE DEL DEPT, EL NOMBRE Y SALARIO DE LOS EMPLEADOS Y EL SALARIO MEDIO POR DEPT

NOMB_DE                                  NOMB_EM                                  SALARIO_EM AVG(SALARIO_EM)
---------------------------------------- ---------------------------------------- ---------- ---------------
ADMINISTRACIÓN ZONA SUR                  ALADA VERAZ, JUANA                          6200000         6200000
DIRECCIÓN GENERAL                        RUIZ DE LOPERA, MANUEL                      7200000         7200000
INVESTIGACIÓN Y DISEÑO                   MANRIQUE BACTERIO, LUISA                    4500000         4500000
JEFATURA FÁBRICA ZONA SUR                GOZQUE ALTANERO, CARLOS                     5000000         5000000
PRODUCCIÓN ZONA SUR                      MANDO CORREA, ROSA                          3100000         3100000
VENTAS ZONA SUR                          MONFORTE CID, ROLDÁN                        5200000         5200000

29/09/2021

************************************************************************
17.- Crear la tabla TEMP(CODEMP, NOMDEPT, NOMEMP, SALEMP) cuyas columnas tienen el mismo tipo y tama�o las similares existentes en la BD. 
Insertar en dicha tabla el c�digo de empleado, nombre de dpto, nombre de empleado y salario de los empleados de los centros de MURCIA.

SQL>

CREATE TABLE TEMP
(
CODEMP 		NUMBER(6)	PRIMARY KEY,
NOMDEPT 	VARCHAR2(40),
NOMEMP		VARCHAR2(40),
SALEMP		NUMBER(9)
);

INSERT INTO TEMP
SELECT COD_EM, NOMB_DE, NOMB_EM, SALARIO_EM FROM EMPLEADOS E, DEPARTAMENTOS D, CENTROS C
WHERE D.DIRECTOR_DE=E.COD_EM AND E.COD_EM=C.DIRECTOR_CE
AND POBLAC_CE='MURCIA';

SELECT * FROM TEMP;

RESULTADO:

Tabla creada.

1 fila creada.

    CODEMP NOMDEPT                                  NOMEMP                                       SALEMP
---------- ---------------------------------------- ---------------------------------------- ----------
         1 DIRECCIÓN GENERAL                        RUIZ DE LOPERA, MANUEL                      7200000

************************************************************************
18.- Incrementar en un 10% los salarios de los empleados que ganen menos de 5.000.000 de ptas.

SQL>

UPDATE EMPLEADOS
SET SALARIO_EM=SALARIO_EM+(SALARIO_EM*0.1)
WHERE (SALARIO_EM*166)<5000000;

RESULTADO:

0 filas actualizadas.

************************************************************************
19.- Deshacer la operaci�n anterior.

SQL>

ROLLBACK;

RESULTADO:

Rollback terminado.

************************************************************************
20.- Borrar la tabla TEMP y todas las anteriores.

SQL>

DROP TABLE TEMP;
DROP TABLE CENTROS;
DROP TABLE HABILIDADES;
DROP TABLE EMPLEADOS;
DROP TABLE DEPARTAMENTOS;
DROP TABLE HIJOS;
DROP TABLE HABIEMPL;

RESULTADO:

Tabla borrada.
Tabla borrada.
Tabla borrada.
Tabla borrada.
Tabla borrada.
Tabla borrada.
Tabla borrada.

************************************************************************
