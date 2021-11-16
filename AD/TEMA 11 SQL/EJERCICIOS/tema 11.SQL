/*ACTIVIDADES TEMA 11*/

/*ACTIVIDADES PROPUESTAS 1*/

DECLARE
	Num1 NUMBER(8,2):=0
	Num2 NUMBER(8,2):=0;
	Num3 NUMBER(8,2) NOT NULL;
	Cantidad INTEGER(3);
	Precio, Descuento NUMBER(6);
	Num4 Num1%ROWTYPE;
	Dto CONSTANT INTEGER;
BEGIN
END;

/*
FALTA EL ";" EN LA DECLARACIÓN DE Num1.
Num4 NO HA SIDO DECLARADO.
Precio Y Descuento HAN DE INICIALIZARSE POR SEPARADO.
Num1%ROWTYPE DEBE IR EN EL BLOQUE (BEGIN...END;)
*/

/*CASO PRÁCTICO 1*/

--EJ1

DECLARE
	v_empleado_no NUMBER(4,0);
	v_c_empleados NUMBER(2);
	v_aumento NUMBER(7) DEFAULT 0;
	v_oficio VARCHAR2(10);
BEGIN
	v_empleado_no := &vt_empno;

	SELECT oficio INTO v_oficio FROM emple
	WHERE emp_no = v_empleado_no;
	
	IF v_oficio = 'PRESIDENTE' THEN
		v_aumento := 30;
	END IF;
	
	SELECT COUNT(*) INTO v_c_empleados FROM emple
	WHERE dir = v_empleado_no;
	
	IF v_c_empleados = 0 THEN
		v_aumento := v_aumento+50;
	ELSIF v_c_empleados = 1 THEN
		v_aumento := v_aumento+80;
	ELSIF v_c_empleados = 2 THEN
		v_aumento := v_aumento+100;
	ELSIF v_c_empleados = 3 THEN
		v_aumento := v_aumento+110;
	END IF;
	
	UPDATE emple SET salario = salario + v_aumento
	WHERE emp_no = v_empleado_no;
	
	DBMS_OUTPUT.PUT_LINE(v_aumento);
END;

--EJ2

DECLARE
	v_empleado_no NUMBER(4,0);
	v_c_empleados NUMBER(2);
	v_aumento NUMBER(7) DEFAULT 0;
	v_oficio VARCHAR2(10);
BEGIN
	v_empleado_no := &vt_empno;

	SELECT oficio INTO v_oficio FROM emple
	WHERE emp_no = v_empleado_no;
	
	IF v_oficio = 'PRESIDENTE' THEN
		v_aumento := 30;
	END IF;
	
	SELECT COUNT(*) INTO v_c_empleados FROM emple
	WHERE dir = v_empleado_no;
	
	CASE
	WHEN v_c_empleados = 0 THEN
		v_aumento := v_aumento+50;
	WHEN v_c_empleados = 1 THEN
		v_aumento := v_aumento+80;
	WHEN v_c_empleados = 2 THEN
		v_aumento := v_aumento+100;
	ELSE 
		v_aumento := v_aumento+110;
	END CASE;
	
	UPDATE emple SET salario = salario + v_aumento
	WHERE emp_no = v_empleado_no;
	
	DBMS_OUTPUT.PUT_LINE(v_aumento);
END;

--EJ3

DECLARE
	v_empleado_no NUMBER(4,0);
	v_c_empleados NUMBER(2);
	v_aumento NUMBER(7) DEFAULT 0;
	v_oficio VARCHAR2(10);
BEGIN
	v_empleado_no := &vt_empno;

	SELECT oficio INTO v_oficio FROM emple
	WHERE emp_no = v_empleado_no;
	
	IF v_oficio = 'PRESIDENTE' THEN
		v_aumento := 30;
	END IF;
	
	SELECT COUNT(*) INTO v_c_empleados FROM emple
	WHERE dir = v_empleado_no;
	
	CASE v_c_empleados
	WHEN 0 THEN
		v_aumento := v_aumento+50;
	WHEN 1 THEN
		v_aumento := v_aumento+80;
	WHEN 2 THEN
		v_aumento := v_aumento+100;
	ELSE 
		v_aumento := v_aumento+110;
	END CASE;
	
	UPDATE emple SET salario = salario + v_aumento
	WHERE emp_no = v_empleado_no;
	
	DBMS_OUTPUT.PUT_LINE(v_aumento);
END;

/*CASO PRÁCTICO 2*/

DECLARE
	v_apellidos VARCHAR2(25);
	v_1apel VARCHAR2(25);
	v_caracter CHAR;
	v_posicion INTEGER := 1;
BEGIN
	v_apellidos := '&vs_apellidos';
	
	v_caracter := SUBSTR(v_apellidos, v_posicion,1);
	WHILE v_caracter BETWEEN 'A' ANS 'Z' LOOP
		v_1apel := v_1apel || v_caracter;
		v_posicion := v_posicion + 1;
		v_caracter := SUBSTR(v_apellidos, v_posicion,1);
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('1er Apellido: ' || v_1apel || '*');
END;

--CON BUCLE LOOP

DECLARE
	v_apellidos VARCHAR2(25);
	v_1apel VARCHAR2(25);
	v_caracter CHAR;
	v_posicion INTEGER := 1;
BEGIN
	v_apellidos := '&vs_apellidos';
	
	v_caracter := SUBSTR(v_apellidos, v_posicion,1);
	LOOP
		v_caracter := SUBSTR(v_apellidos, v_posicion,1);
		EXIT WHEN v_caracter NOT BETWEEN 'A' ANS 'Z';
		v_1apel := v_1apel || v_caracter;
		v_posicion := v_posicion + 1;
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('1er Apellido: ' || v_1apel || '*');
END;

/*CASO PRÁCTICO 3*/

--USANDO FOR

DECLARE
	r_cadena VARCHAR2(10);
BEGIN
	FOR i IN REVERSE 1..LENGTH('HOLA') LOOP
		r_cadena := r_cadena || SUBSTR('HOLA', i, 1);
	END LOOP;
	DBMS_OUTPUT.PUT_LINE(r_cadena);
END;

--USANDO WHILE

DECLARE
	r_cadena VARCHAR2(10);
	i BINARY_INTEGER;
BEGIN
	i := LENGTH('HOLA');
	WHILE i >= 1 LOOP
		r_cadena := r_cadena || SUBSTR('HOLA', i, 1);
		i := i - 1;
	END LOOP;
	DBMS_OUTPUT.PUT_LINE(r_cadena);
END;

/*ACTIVIDADES PROPUESTAS 2*/

DECLARE
	r_cadena VARCHAR2(10);
	i BINARY_INTEGER;
BEGIN
	i := LENGTH('HOLA');
	LOOP 
		r_cadena := r_cadena || SUBSTR('HOLA', i, 1);
		i := i - 1;	
	EXIT WHEN i = 0;
	END LOOP;
	DBMS_OUTPUT.PUT_LINE(r_cadena);
END;

/*CASO PRÁCTICO 4*/

CREATE OR REPLACE PROCEDURE cambiar_oficio (
	num_empleado NUMBER, nuevo_oficio VARCHAR2)
AS
	v_anterior_oficio emple.oficio%TYPE;
BEGIN
	SELECT oficio INTO v_anterior_oficio FROM emple
	WHERE emp_no = num_empleado;
	
	UPDATE emple SET oficio = nuevo_oficio
	WHERE emp_no = num_empleado;
	
	DBMS_OUTPUT.PUT_LINE(num_empleado||'*Oficio Anterior:'||v_anterior_oficio||'*Oficio Nuevo:'||nuevo_oficio);
END cambiar_oficio;

----------------------------------------------------------------------------------------------------------------------------------

EXEC cambiar_oficio(7902, 'DIRECTOR');

/*ACTIVIDADES PROPUESTAS 3*/

CREATE OR REPLACE PROCEDURE cambiar_dept (
	num_empleado NUMBER, nuevo_dept NUMBER)
AS
	v_anterior_dept emple.DEPT_NO%TYPE;
BEGIN
	SELECT DEPT_NO INTO v_anterior_dept FROM emple
	WHERE emp_no = num_empleado;
	
	UPDATE emple SET DEPT_NO = nuevo_dept
	WHERE emp_no = num_empleado;
	
	DBMS_OUTPUT.PUT_LINE(num_empleado||'*Departamento Anterior:'||v_anterior_dept||'*Departamento Nuevo:'||nuevo_dept);
END cambiar_dept;

----------------------------------------------------------------------------------------------------------------------------------

EXEC cambiar_dept(7902, 10);

/*
7902*Departamento Anterior:20*Departamento Nuevo:10
*/

/*ACTIVIDADES PROPUESTAS 4*/

PROCEDURE crear_depart (
	v_num_dept depart.dept_no%TYPE,
	v_dnombre depart.dnombre%TYPE DEFAULT 'PROVISIONAL',
	v_loc depart.loc%TYPE DEFAULT 'PROVISIONAL')
IS
BEGIN
	INSERT INTO depart
	VALUES (v_num_dept, v_dnombre, v_loc);
END crear_depart;

