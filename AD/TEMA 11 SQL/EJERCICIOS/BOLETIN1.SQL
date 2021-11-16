/*BOLETÍN TEMA 11*/

--EJ1

CREATE OR REPLACE PROCEDURE mostrarDatos (cod_em NUMBER)
AS
	apellido_em	VARCHAR2(30);
	salario_em NUMBER(6);
	nom_de VARCHAR2(15);
BEGIN
	SELECT APELLIDO, SALARIO, DNOMBRE INTO apellido_em, salario_em, nom_de FROM EMPLE E, DEPART D
	WHERE E.DEPT_NO=D.DEPT_NO
	AND EMP_NO = cod_em;
	DBMS_OUTPUT.PUT_LINE('APELLIDO: ' || apellido_em || ' SALARIO: ' || salario_em || ' DEPARTAMENTO: ' || nom_de);
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		RAISE_APPLICATION_ERROR(-20000, 'Este empleado no existe.');
END mostrarDatos;
/

--------------------------------------------------------------------------------------------------------------------------------------

EXEC mostrarDatos(7934);
EXEC mostrarDatos(3456);

--------------------------------------------------------------------------------------------------------------------------------------

--EJ2

CREATE OR REPLACE PROCEDURE borrarEmpleado(cod_em emple.emp_no%TYPE)
AS
	COD_EMPLE EMPLE.EMP_NO%TYPE;
BEGIN
	SELECT EMP_NO INTO COD_EMPLE FROM EMPLE
	WHERE EMP_NO = cod_em;

	DELETE FROM emple 
	WHERE emp_no = cod_em;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		RAISE_APPLICATION_ERROR(-20000, 'Empleado no encontrado');
END borrarEmpleado;



--------------------------------------------------------------------------------------------------------------------------------------

EXEC mostrarDatos(7934);
EXEC mostrarDatos(3456);

--------------------------------------------------------------------------------------------------------------------------------------


CREATE OR REPLACE PROCEDURE cambiarLocalidad(cod_depart NUMBER, localidad VARCHAR2)
AS
	COD_DEPARTAMENTO DEPART.DEPT_NO%TYPE
BEGIN
	SELECT DEPT_NO INTO COD_DEPARTAMENTO FROM DEPART
	WHERE DEPT_NO = cod_depart;

	UPDATE depart SET loc = localidad
	WHERE dept_no = cod_depart;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		RAISE_APPLICATION_ERROR(-20000, 'Departamento no encontrado');
END cambiarLocalidad;

--------------------------------------------------------------------------------------------------------------------------------------

EXEC cambiarLocalidad(10, 'SEVILLA');
EXEC cambiarLocalidad(100, 'SEVILLA');

--------------------------------------------------------------------------------------------------------------------------------------

--EJ3

CREATE OR REPLACE PROCEDURE borrarEmpleado(cod_em emple.emp_no%TYPE)
AS
	num_filas NUMBER(3);
BEGIN
	DELETE FROM emple 
	WHERE emp_no = cod_em;
	num_filas := SQL%ROWCOUNT;
	IF num_filas = 0 THEN
		DBMS_OUTPUT.PUT_LINE('No se ha encontrado ningún empleado.');
	END IF;
END borrarEmpleado;

--------------------------------------------------------------------------------------------------------------------------------------

EXEC borrarEmpleado(3345987);

--------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE cambiarLocalidad(cod_depart NUMBER, localidad VARCHAR2)
AS
	num_filas NUMBER(3);
BEGIN
	UPDATE depart SET loc = localidad
	WHERE dept_no = cod_depart;
	num_filas := SQL%ROWCOUNT;
	IF num_filas = 0 THEN
		DBMS_OUTPUT.PUT_LINE('No se ha encontrado ningún departamento.');
	END IF;
END cambiarLocalidad;

--------------------------------------------------------------------------------------------------------------------------------------

EXEC cambiarLocalidad(12);

--------------------------------------------------------------------------------------------------------------------------------------	

--EJ4

CREATE OR REPLACE PROCEDURE cambiar_dept (num_empleado NUMBER, nuevo_dept NUMBER)
AS
	v_anterior_dept emple.DEPT_NO%TYPE;
	recipiente_dep DEPART.DEPT_NO%TYPE;
BEGIN
	SELECT DEPT_NO INTO v_anterior_dept FROM emple
	WHERE emp_no = num_empleado;
	
	BEGIN
		SELECT DEPT_NO INTO recipiente_dep FROM DEPART
		WHERE DEPT_NO = nuevo_dept;
		
		UPDATE emple SET DEPT_NO = nuevo_dept
		WHERE emp_no = num_empleado;
		
		DBMS_OUTPUT.PUT_LINE(num_empleado||'*Departamento Anterior:'||v_anterior_dept||'*Departamento Nuevo:'||nuevo_dept);
	EXCEPTION
		WHEN NO_DATA_FOUND THEN
		DBMS_OUTPUT.PUT_LINE('No se ha encontrado ningún departamento.');
	END;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		DBMS_OUTPUT.PUT_LINE('No se ha encontrado ningún empleado.');
END cambiar_dept;

--------------------------------------------------------------------------------------------------------------------------------------	

EXEC cambiar_dept(7777, 10);
EXEC cambiar_dept(7902, 90);

--------------------------------------------------------------------------------------------------------------------------------------	

--EJ5

CREATE OR REPLACE PROCEDURE cambiar_departamento (num_empleado NUMBER, nuevo_dept NUMBER)
AS
	num_residuo NUMBER(4) DEFAULT 0;
	v_anterior_dept emple.DEPT_NO%TYPE;
	recipiente_dep DEPART.DEPT_NO%TYPE;
BEGIN
	SELECT DEPT_NO INTO v_anterior_dept FROM emple
	WHERE emp_no = num_empleado;
	
	num_residuo := 1;
	
	SELECT DEPT_NO INTO recipiente_dep FROM DEPART
	WHERE DEPT_NO = nuevo_dept;
	
	UPDATE emple SET DEPT_NO = nuevo_dept
	WHERE emp_no = num_empleado;
	
	DBMS_OUTPUT.PUT_LINE(num_empleado||'*Departamento Anterior:'||v_anterior_dept||'*Departamento Nuevo:'||nuevo_dept);
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		IF num_residuo =  0 THEN
			DBMS_OUTPUT.PUT_LINE('No se ha encontrado ningún empleado.');
		ELSE
			DBMS_OUTPUT.PUT_LINE('No se ha encontrado ningún departamento.');
		END IF;
END cambiar_departamento;

--------------------------------------------------------------------------------------------------------------------------------------	

EXEC cambiar_departamento(7777, 10);
EXEC cambiar_departamento(7902, 90);

--------------------------------------------------------------------------------------------------------------------------------------	

--EJ6

CREATE OR REPLACE FUNCTION busca_empleados (num_empleado NUMBER)
RETURN NUMBER
AS
	v_anterior_dept emple.DEPT_NO%TYPE;
BEGIN
	SELECT DEPT_NO INTO v_anterior_dept FROM emple
	WHERE emp_no = num_empleado;
	RETURN 0;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		RETURN -1;
END busca_empleados;

CREATE OR REPLACE FUNCTION busca_departamentos (nuevo_dept NUMBER)
RETURN NUMBER
AS
	recipiente_dep DEPART.DEPT_NO%TYPE;
BEGIN
	SELECT DEPT_NO INTO recipiente_dep FROM DEPART
	WHERE DEPT_NO = nuevo_dept;
	RETURN 0;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		RETURN -1;
END busca_departamentos;

CREATE OR REPLACE PROCEDURE cambiarDepart (num_empleado NUMBER, nuevo_dept NUMBER)
AS
BEGIN
	
	IF busca_empleados(num_empleado) = -1 THEN 
		DBMS_OUTPUT.PUT_LINE('No se ha encontrado ningún empleado.');
	ELSIF busca_departamentos(nuevo_dept) = -1 THEN
		DBMS_OUTPUT.PUT_LINE('No se ha encontrado ningún departamento.');
	ELSE
		UPDATE emple SET DEPT_NO = nuevo_dept
		WHERE emp_no = num_empleado;
	
		DBMS_OUTPUT.PUT_LINE(num_empleado||'*Departamento Nuevo:'||nuevo_dept);
	END IF;
END cambiarDepart;


--------------------------------------------------------------------------------------------------------------------------------------	

EXEC cambiar_departamento(7777, 10);
EXEC cambiar_departamento(7902, 90);

--------------------------------------------------------------------------------------------------------------------------------------	
