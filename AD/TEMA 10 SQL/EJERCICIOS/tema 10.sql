/*ACTIVIDADES TEMA 10*/

set serveroutput on

/*CASO PRÁCTICO 1*/

DECLARE 
	v_num_empleados NUMBER(2);
BEGIN
	INSERT INTO depart VALUES (99,'PROVISIONAL',NULL);
	UPDATE emple SET dept_no = 99
	WHERE dept_no = 20;
	v_num_empleados := SQL%ROWCOUNT;
	DELETE FROM depart
	WHERE dept_no = 20;
	DBMS_OUTPUT.PUT_LINE(v_num_empleados || ' Empleados ubicados en PROVISIONAL');
EXCEPTION
	WHEN OTHERS THEN
	RAISE_APPLICATION_ERROR(-20000, 'Error en la aplicación');
END;


/*CASO PRÁCTICO 2*/

DECLARE
	v_ape VARCHAR2(10);
	v_oficio VARCHAR2(10);
BEGIN
	SELECT apellido, oficio INTO v_ape, v_oficio FROM EMPLE
	WHERE EMP_NO = 7900;
	DBMS_OUTPUT.PUT_LINE(v_ape || '*' || v_oficio);
END;

/*CASO PRÁCTICO 3*/

DECLARE
	v_ape VARCHAR2(10);
	v_oficio VARCHAR2(10);
BEGIN
	SELECT apellido, oficio INTO v_ape, v_oficio FROM EMPLE
	WHERE EMP_NO = 7900;
	DBMS_OUTPUT.PUT_LINE(v_ape || '*' || v_oficio);
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		RAISE_APPLICATION_ERROR(-20000, 'ERROR no hay datos');
	WHEN TOO_MANY_ROWS THEN
		RAISE_APPLICATION_ERROR(-20000, 'ERROR demasiados datos');
	WHEN OTHERS THEN
		RAISE_APPLICATION_ERROR(-20000, 'Error en la aplicación');
END;

/*CASO PRÁCTICO 4*/

CREATE OR REPLACE TRIGGER audit_borrado_emple
			BEFORE DELETE
			ON emple
		FOR EACH ROW
BEGIN
	DBMS_OUTPUT.PUT_LINE('BORRADO EMPLEADO' || '*' || :old.emp_no || '*' || :old.apellido);
END;

/*CASO PRÁCTICO 5*/

DECLARE
	v_nom CLIENTES.NOMBRE%TYPE; --(ejemplo USO %TYPE)
BEGIN
	SELECT nombre INTO v_nom FROM clientes
	WHERE NIF = &vn_cli;
	DBMS_OUTPUT.PUT_LINE(v_nom);
END;

/*ACTIVIDADES PROPUESTAS 1*/

DECLARE PROCEDURE EJ5
	v_nom CLIENTES.NOMBRE%TYPE; --(ejemplo USO %TYPE)
BEGIN
	SELECT nombre INTO v_nom FROM clientes
	WHERE NIF = &vn_cli;
	DBMS_OUTPUT.PUT_LINE(v_nom);
END;



/*CASO PRÁCTICO 6*/

CREATE OR REPLACE PROCEDURE ver_depart (numdepart NUMBER)
AS
	v_dnombre VARCHAR2(14);
	v_localidad VARCHAR2(14);
BEGIN
	SELECT dnombre, loc INTO v_dnombre, v_localidad FROM depart
	WHERE dept_no = numdepart;
	DBMS_OUTPUT.PUT_LINE('Num depart:' || numdepart || '* Nombre dep:' || v_dnombre || '* Localidad:' || v_localidad);
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	DBMS_OUTPUT.PUT_LINE('No encontrado departamento');
END ver_depart;

/*CASO PRÁCTICO 7*/

--EJ1

CREATE OR REPLACE PROCEDURE ver_precio(v_num_producto NUMBER)
AS
	v_precio NUMBER;
BEGIN
	SELECT precio_actual INTO v_precio FROM producto
	WHERE producto_no = v_num_producto;
	DBMS_OUTPUT.PUT_LINE('Precio =' || v_precio);
END;
	
	
--EJ2

CREATE OR REPLACE PROCEDURE modificar_precio_producto(numproducto NUMBER, nuevoprecio NUMBER)
AS
	v_precioant NUMBER(5);
BEGIN
	SELECT precio_actual INTO v_precioant FROM productos
	WHERE producto_no = numproducto;
	IF (v_precioant * 0.20) > (nuevoprecio-v_precioant) THEN
		UPDATE productos SET precio_actual = nuevoprecio
		WHERE producto_no = numproducto;
	ELSE
		DBMS_OUTPUT.PUT_LINE('No encontrado producto ' || numproducto);
END modificar_precio_producto;

--EJ3

CREATE OR REPLACE FUNCTION con_iva (cantidad NUMBER, tipo NUMBER DEFAULT 16)
AS
	v_resultado NUMBER (10,2) DEFAULT 0;
BEGIN
	v_resultado := cantidad * (1+(tipo/100));
	RETURN (v_resultado);
END con_iva;

--------------------------------------------------------------------------------------------------------------

BEGIN DBMS_OUTPUT.PUT_LINE(con_iva(200));END;

--------------------------------------------------------------------------------------------------------------

SELECT producto_no, precio_actuaL, con_iva(precio_actual) FROM productos;

/*ACTIVIDADES COMPLEMENTARIAS*/

--EJ1

BEGIN
	DBMS_OUTPUT.PUT_LINE('Hola');
END;

--EJ2

DECLARE
	v_num NUMBER;
BEGIN
	SELECT count(*) INTO v_num FROM productos;
	DBMS_OUTPUT.PUT_LINE(v_num);
END;

/*Declara una variable llamada v_num que almacena el número de filas que tiene la tabla productos*/

--EJ3

DECLARE
	v_num NUMBER;
BEGIN
	SELECT count(*) INTO v_num FROM productos;
	DBMS_OUTPUT.PUT_LINE(v_num);
END;

/*
9

Procedimiento PL/SQL terminado correctamente.
*/

--EJ4

SELECT count(*) FROM productos;

--EJ5

/*
 COUNT(*)
----------
         9
*/

--EJ6

EXEC ver_depart(10); 
--Num depart:10* Nombre dep:CONTABILIDAD* Localidad:SEVILLA

EXEC ver_depart(100); 
--No encontrado departamento

EXEC ver_depart(40); 
--Num depart:40* Nombre dep:PRODUCCION* Localidad:BILBAO

--EJ7

CREATE OR REPLACE PROCEDURE ver_precio(v_num_producto NUMBER)
AS
	v_precio NUMBER;
BEGIN
	SELECT precio_actual INTO v_precio FROM producto
	WHERE producto_no = v_num_producto;
	DBMS_OUTPUT.PUT_LINE('Precio =' || v_precio);
END;

/*
CABECERA:  CREATE OR REPLACE PROCEDURE ver_precio(v_num_producto NUMBER)

NOMBRE: ver_precio

PARÁMETROS: v_num_producto

VARIABLES LOCALES: v_precio

COMIENZO DEL BLOQUE: BEGIN

FINAL DEL BLOQUE: END;

COMIENZO Y FINAL DE DECLARACIONES: AS, BEGIN

COMIENZO Y FINAL DE EJECUTABLE:  	SELECT precio_actual INTO v_precio FROM producto
									WHERE producto_no = v_num_producto;
									DBMS_OUTPUT.PUT_LINE('Precio =' || v_precio);

COMIENZO Y FINAL DE EXCEPCIONES: NO HAY

¿QUE HACE INTO?: ACCEDE A LOS DATOS DEVUELTOS POR NUESTRA CONSULTA

¿QUE HACE WHEN NO_DATA_FOUND?: DEVUELVE UN ERROR SI NO ENCUENTRA DATOS	

¿PORQUÉ NO USA DECLARE Y QUE USA EN SU LUGAR?: PORQUE ES UN PROCEDIMIENTO Y EN ELLOS SE USA 'AS' Y NO 'DECLARE'			
*/
