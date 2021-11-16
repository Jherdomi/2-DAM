/*BOLETÍN 2*/

--EJ1

CREATE OR REPLACE FUNCTION unidades_vendidas (cod_prod VENTAS.COD_PRODUCTO%TYPE)
RETURN NUMBER
AS
	prod NUMBER(2);
	uni_vend NUMBER(2);
BEGIN

	SELECT COD_PRODUCTO INTO prod FROM PRODUCTOS
	WHERE COD_PRODUCTO = cod_prod;
	
	SELECT NVL(SUM(UNIDADES), 0) INTO uni_vend FROM VENTAS
	WHERE COD_PRODUCTO = cod_prod;
	
	RETURN uni_vend;
	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		RETURN -1;
END unidades_vendidas;

--------------------------------------------------------------------------------------------------------------------------------------

SELECT unidades_vendidas(11) FROM DUAL;
SELECT unidades_vendidas(2) FROM DUAL;
SELECT unidades_vendidas(1) FROM DUAL;

--------------------------------------------------------------------------------------------------------------------------------------

--EJ2

CREATE OR REPLACE PROCEDURE venderUnidades(p_producto PRODUCTOS.COD_PRODUCTO%TYPE, p_total OUT NUMBER)
AS
	prod NUMBER(2);
	uni_vend NUMBER(2);
BEGIN
	SELECT COD_PRODUCTO INTO prod FROM PRODUCTOS
	WHERE COD_PRODUCTO = p_producto;
	
	SELECT NVL(SUM(UNIDADES), 0) INTO uni_vend FROM VENTAS
	WHERE COD_PRODUCTO = p_producto;

	p_total:=uni_vend;
	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		DBMS_OUTPUT.PUT_LINE(-1);
END venderUnidades;

--------------------------------------------------------------------------------------------------------------------------------------

DECLARE
  VAR NUMBER;
BEGIN
  venderUnidades(2, VAR);
  DBMS_OUTPUT.PUT_LINE(VAR);
END;

-------------------------------------------

DECLARE
  VAR NUMBER;
BEGIN
  venderUnidades(11, VAR);
  DBMS_OUTPUT.PUT_LINE(VAR);
END;

-------------------------------------------

DECLARE
  VAR NUMBER;
BEGIN
  venderUnidades(1, VAR);
  DBMS_OUTPUT.PUT_LINE(VAR);
END;

--------------------------------------------------------------------------------------------------------------------------------------

--EJ3

CREATE OR REPLACE PROCEDURE mostrarDatos(doc_principal CLIENTES.NIF%TYPE, fecha_venta VENTAS.FECHA%TYPE)
AS
	dni VARCHAR2(4);
	fechas VARCHAR2(10);
	nomb_cl VARCHAR2(15);
	desc_produc VARCHAR2(30);
	uni_vend NUMBER(2);
	error NUMBER(1) DEFAULT 0;
BEGIN
	SELECT NIF INTO dni FROM CLIENTES
	WHERE NIF = doc_principal;
	
	error := 1;
	
	SELECT NOMBRE, DESCRIPCION, UNIDADES INTO nomb_cl, desc_produc, uni_vend FROM CLIENTES C, PRODUCTOS P, VENTAS V
	WHERE C.NIF = doc_principal AND FECHA = fecha_venta
	AND P.COD_PRODUCTO=V.COD_PRODUCTO
	AND C.NIF=V.NIF;
	
	DBMS_OUTPUT.PUT_LINE('Nombre: '||nomb_cl||' Descripcion: '||desc_produc||' Ventas: '||uni_vend);
	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		IF error = 0 THEN
			DBMS_OUTPUT.PUT_LINE('No existe ese cliente.');
		ELSE
			DBMS_OUTPUT.PUT_LINE('Este cliente no tiene ventas de ese día.');
		END IF;
END mostrarDatos;

--------------------------------------------------------------------------------------------------------------------------------------

EXEC mostrarDatos('333C', '22/09/97');
EXEC mostrarDatos('123G', '22/09/97');
EXEC mostrarDatos('333C', '22/09/01');

--------------------------------------------------------------------------------------------------------------------------------------

--EJ4
CREATE OR REPLACE FUNCTION ventasRealizadas(doc_principal CLIENTES.NIF%TYPE)
RETURN NUMBER
AS
	dni VARCHAR2(4);
	uni_vend NUMBER(3);
BEGIN
	SELECT NIF INTO dni FROM CLIENTES
	WHERE NIF = doc_principal;
	
	SELECT NVL(SUM(UNIDADES), 0) INTO uni_vend FROM VENTAS
	WHERE NIF = doc_principal;
	
	RETURN uni_vend;
	
EXCEPTION
	WHEN NO_DATA_FOUND THEN	
		RETURN -1;
END ventasRealizadas;

--------------------------------------------------------------------------------------------------------------------------------------

SELECT ventasRealizadas('333C') FROM DUAL;
SELECT ventasRealizadas('999I') FROM DUAL;
SELECT ventasRealizadas('111C') FROM DUAL;

--------------------------------------------------------------------------------------------------------------------------------------

--EJ5

CREATE OR REPLACE FUNCTION ventas_hechas(nomb_cl CLIENTES.NOMBRE%TYPE)
RETURN NUMBER
AS
	nombre VARCHAR2(15);
	uni_vend NUMBER(3);
BEGIN
	SELECT NOMBRE INTO NOMBRE FROM CLIENTES
	WHERE NOMBRE = nomb_cl;
	
	SELECT NVL(SUM(UNIDADES), 0) INTO uni_vend FROM VENTAS V, CLIENTES C
	WHERE V.NIF=C.NIF
	AND NOMBRE = nomb_cl;
	
	RETURN uni_vend;
	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		RETURN -1;
END ventas_hechas;

--------------------------------------------------------------------------------------------------------------------------------------

SELECT ventas_hechas('ANDRES') FROM DUAL;
SELECT ventas_hechas('ANTONIO') FROM DUAL;
SELECT ventas_hechas('ELENA') FROM DUAL;

--------------------------------------------------------------------------------------------------------------------------------------