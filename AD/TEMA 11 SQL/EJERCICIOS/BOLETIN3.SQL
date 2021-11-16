/*BOLETÍN 3*/

--EJ1

CREATE OR REPLACE FUNCTION diff_precio
RETURN NUMBER
AS
	calculo NUMBER(12);
BEGIN
	SELECT MAX(PRECIO_UNI)-MIN(PRECIO_UNI) INTO calculo FROM PRODUCTOS;
	
	RETURN calculo;
END diff_precio;

----------------------------------------------------------------------------------------------------------------

SELECT diff_precio FROM DUAL;

----------------------------------------------------------------------------------------------------------------

--EJ2

CREATE OR REPLACE PROCEDURE mostrar_datos
AS
	dni VARCHAR2(4);
	nomb_cl VARCHAR2(15);
	poblac VARCHAR2(15);
BEGIN
	SELECT NIF, NOMBRE, DOMICILIO INTO dni, nomb_cl, poblac FROM CLIENTES
	WHERE DOMICILIO = 'LAS ROZAS'
	AND NIF NOT IN (SELECT NIF FROM VENTAS);

	
	DBMS_OUTPUT.PUT_LINE('NIF: '||dni||' NOMBRE: '||nomb_cl||' POBLACION: '||poblac);
END mostrar_datos;

----------------------------------------------------------------------------------------------------------------

EXEC mostrar_datos;

----------------------------------------------------------------------------------------------------------------

--EJ3

CREATE OR REPLACE PROCEDURE sumar_ventas(cod_product PRODUCTOS.COD_PRODUCTO%TYPE)
AS
	var NUMBER(2);
BEGIN
	SELECT COD_PRODUCTO INTO var FROM PRODUCTOS
	WHERE COD_PRODUCTO=cod_product;

	INSERT INTO VENTAS
	SELECT NIF, var, SYSDATE, 10 FROM CLIENTES;
	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		DBMS_OUTPUT.PUT_LINE('Producto inexistente.');
END sumar_ventas;

----------------------------------------------------------------------------------------------------------------

EXEC sumar_ventas(1);
EXEC sumar_ventas(10);

----------------------------------------------------------------------------------------------------------------

--EJ4

CREATE OR REPLACE PROCEDURE mostrar_producto
AS
	cod_prod PRODUCTOS.COD_PRODUCTO%TYPE;
	descrip PRODUCTOS.DESCRIPCION%TYPE;
	lin PRODUCTOS.LINEA_PRODUCTO%TYPE;
	precio PRODUCTOS.PRECIO_UNI%TYPE;
	stck PRODUCTOS.STOCK%TYPE;
	cuenta NUMBER(2);
BEGIN
						
	SELECT COD_PRODUCTO, COUNT(*) INTO cod_prod, cuenta FROM VENTAS
	HAVING COUNT(*)=(SELECT MAX(COUNT(*)) FROM VENTAS
					GROUP BY COD_PRODUCTO)
	GROUP BY COD_PRODUCTO;
	
	SELECT DESCRIPCION, LINEA_PRODUCTO, PRECIO_UNI, STOCK INTO descrip, lin, precio,stck FROM PRODUCTOS
	WHERE COD_PRODUCTO=cod_prod;
						
	DBMS_OUTPUT.PUT_LINE(cod_prod||'*'||descrip||'*'||lin||'*'||precio||'*'||stck);
END mostrar_producto;

----------------------------------------------------------------------------------------------------------------

EXEC mostrar_producto;

----------------------------------------------------------------------------------------------------------------

--EJ5

CREATE OR REPLACE FUNCTION calcular_resta(cod_em EMPLE.EMP_NO%TYPE)
RETURN NUMBER
AS
	emple_cod EMPLE.EMP_NO%TYPE;
	salario_em NUMBER(9);
	resta NUMBER(7);
	depart NUMBER(2);
BEGIN
	SELECT EMP_NO, SALARIO, DEPT_NO INTO emple_cod, salario_em, depart FROM EMPLE
	WHERE EMP_NO = cod_em;
	
	SELECT (MAX(SALARIO)-salario_em) INTO resta FROM EMPLE
	WHERE DEPT_NO=depart;
	
	RETURN resta;
	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		RETURN -1;
END calcular_resta;

----------------------------------------------------------------------------------------------------------------

SELECT calcular_resta(7934) FROM DUAL;
SELECT calcular_resta(7839) FROM DUAL;
SELECT calcular_resta(7902) FROM DUAL;
SELECT calcular_resta(1111) FROM DUAL;

----------------------------------------------------------------------------------------------------------------

--EJ6

CREATE OR REPLACE PROCEDURE calcular_porcentaje(num NUMBER, salida OUT NUMBER)
AS
	num_empleado NUMBER(2);
BEGIN

	SELECT COUNT(*) INTO num_empleado FROM EMPLE;
	
	salida := ((num*100)/num_empleado);
	
END calcular_porcentaje;

----------------------------------------------------------------------------------------------------------------

DECLARE
  VAR NUMBER;
BEGIN
  calcular_porcentaje(2, VAR);
  DBMS_OUTPUT.PUT_LINE('El porcentaje es: '||VAR||'%');
END;

----------------------------------------------------------------------------------------------------------------

DECLARE
  VAR NUMBER;
BEGIN
  calcular_porcentaje(14, VAR);
  DBMS_OUTPUT.PUT_LINE('El porcentaje es: '||VAR||'%');
END;

----------------------------------------------------------------------------------------------------------------