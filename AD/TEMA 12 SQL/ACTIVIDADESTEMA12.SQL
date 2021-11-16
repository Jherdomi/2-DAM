/*ACTIVIDADES TEMA 12*/

/*CASO PRÁCTICO 1*/

DECLARE 
	CURSOR	C1 IS SELECT apellido FROM EMPLE
					WHERE DEPT_NO=20;
	v_apellido VARCHAR2(10);
BEGIN
	OPEN C1;
		LOOP
			FETCH C1 INTO v_apellido;
			DBMS_OUTPUT.PUT_LINE(TO_CHAR(C1%ROWCOUNT, '99.')||v_apellido);
			EXIT WHEN C1%NOTFOUND;
		END LOOP;
	CLOSE C1;
END;				

---------------------------------------------------------------------------------------------------------

1.SANCHEZ
2.JIMENEZ
3.GIL
4.ALONSO
5.FERNANDEZ
5.FERNANDEZ

---------------------------------------------------------------------------------------------------------

/*ACTIVIDAD PROPUESTA 1*/

DECLARE 
	CURSOR	C1 IS SELECT apellido FROM EMPLE
					WHERE DEPT_NO=20;
	v_apellido VARCHAR2(10);
BEGIN
	OPEN C1;
		LOOP
			FETCH C1 INTO v_apellido;
			EXIT WHEN C1%NOTFOUND;
			DBMS_OUTPUT.PUT_LINE(TO_CHAR(C1%ROWCOUNT, '99.')||v_apellido);
		END LOOP;
	CLOSE C1;
END;

---------------------------------------------------------------------------------------------------------



---------------------------------------------------------------------------------------------------------

/*CASO PRÁCTICO 2*/

CREATE OR REPLACE PROCEDURE ver_emple_por_dept (dep VARCHAR2)
AS
	v_dept NUMBER(2);
	CURSOR C1 IS SELECT apellido FROM EMPLE
				WHERE DEPT_NO = v_dept;
	v_apellido VARCHAR2(10);
BEGIN
	v_dept := dep;
	OPEN C1;
		FETCH C1 INTO v_apellido;
		WHILE C1%FOUND LOOP
			DBMS_OUTPUT.PUT_LINE(v_apellido);
			FETCH C1 INTO v_apellido;
		END LOOP;
	CLOSE C1;
END ver_emple_por_dept;
---------------------------------------------------------------------------------------------------------

EXEC ver_emple_por_dept(30);

ARROYO
SALA
MARTIN
NEGRO
TOVAR
JIMENO

---------------------------------------------------------------------------------------------------------

/*ACTIVIDAD PROPUESTA 2*/

CREATE OR REPLACE PROCEDURE recibeCad (cad_intr VARCHAR2)
AS
	v_nom VARCHAR2(10);
	CURSOR C1 IS SELECT apellido, EMP_NO FROM EMPLE
				WHERE APELLIDO = v_nom;
	v_apellido VARCHAR2(10);
	v_num NUMBER(4);
	cont NUMBER(3);
BEGIN
	v_nom := cad_intr;
	OPEN C1;
		FETCH C1 INTO v_apellido, v_num;
		WHILE C1%FOUND LOOP
			DBMS_OUTPUT.PUT_LINE(v_apellido||'*'||v_num);
			FETCH C1 INTO v_apellido, v_num;
		END LOOP;
		cont := C1%ROWCOUNT;
		DBMS_OUTPUT.PUT_LINE('NUMERO DE FILAS: '||cont);
	CLOSE C1;
END recibeCad;

---------------------------------------------------------------------------------------------------------

EXEC recibeCad('PEPE');
EXEC recibeCad('SANCHEZ');

---------------------------------------------------------------------------------------------------------

/*ACTIVIDADES COMPLEMENTARIAS*/

--EJ1

CREATE OR REPLACE PROCEDURE mostrarDatos
AS
	CURSOR C1 IS SELECT APELLIDO, FECHA_ALT FROM EMPLE
						ORDER BY APELLIDO;
	v_apellido VARCHAR(10);
	v_fecha DATE;
BEGIN
	OPEN C1;
		FETCH C1 INTO v_apellido, v_fecha;
		WHILE C1%FOUND LOOP
			DBMS_OUTPUT.PUT_LINE(v_apellido||'*'||v_fecha);
			FETCH C1 INTO v_apellido, v_fecha;
		END LOOP;
	CLOSE C1;
END mostrarDatos;

---------------------------------------------------------------------------------------------------------

EXEC mostrarDatos;

---------------------------------------------------------------------------------------------------------

--EJ2

CREATE OR REPLACE PROCEDURE EJERCICIO2
AS
	CURSOR C1 IS SELECT DNOMBRE, COUNT(EMP_NO) FROM EMPLE E, DEPART D
				WHERE E.DEPT_NO=D.DEPT_NO
				GROUP BY DNOMBRE;
	v_nom VARCHAR2(20);
	cont NUMBER(2);
BEGIN
	OPEN C1;
		FETCH C1 INTO v_nom, cont;
		WHILE C1%FOUND LOOP
			DBMS_OUTPUT.PUT_LINE(v_nom||'*'||cont);
			FETCH C1 INTO v_nom, cont;
		END LOOP;
	CLOSE C1;
END EJERCICIO2;

---------------------------------------------------------------------------------------------------------

EXEC EJERCICIO2;

---------------------------------------------------------------------------------------------------------

--EJ3

CREATE OR REPLACE PROCEDURE verDatos 
AS
	CURSOR C1 IS SELECT APELLIDO, SALARIO FROM EMPLE
					ORDER BY SALARIO DESC;
	v_apellido VARCHAR2(10);
	v_salario NUMBER(9);
	cont NUMBER(2);
BEGIN
	OPEN C1;
		FETCH C1 INTO v_apellido, v_salario;
		WHILE C1%FOUND LOOP
			DBMS_OUTPUT.PUT_LINE(v_apellido||'*'||v_salario);
			FETCH C1 INTO v_apellido, v_salario;
			cont := C1%ROWCOUNT;
			EXIT WHEN cont = 6;
		END LOOP;
	CLOSE C1;
END verDatos;

---------------------------------------------------------------------------------------------------------

EXEC verDatos;

---------------------------------------------------------------------------------------------------------

/*CASO PRÁCTICO 3*/

DECLARE	
	CURSOR c_emple IS SELECT apellido, fecha_alt FROM EMPLE
						ORDER BY fecha_alt;
BEGIN
	FOR v_reg_emp IN c_emple LOOP
		DBMS_OUTPUT.PUT_LINE(v_reg_emp.apellido||'*'||v_reg_emp.fecha_alt);
	END LOOP;
END;

---------------------------------------------------------------------------------------------------------

ARROYO*20/02/80
SANCHEZ*17/12/80
SALA*22/02/81
JIMENEZ*02/04/81
NEGRO*01/05/81
CEREZO*09/06/81
TOVAR*08/09/81
ALONSO*23/09/81
MARTIN*29/09/81
GIL*09/11/81
REY*17/11/81
JIMENO*03/12/81
FERNANDEZ*03/12/81
MUÑOZ*23/01/82

---------------------------------------------------------------------------------------------------------

DECLARE
	CURSOR c_emple IS SELECT apellido, fecha_alt FROM EMPLE
						ORDER BY fecha_alt;
	v_reg_emp c_emple%ROWTYPE;
BEGIN
	OPEN c_emple;
	
		FETCH c_emple INTO v_reg_emp;
		WHILE c_emple%FOUND LOOP
			DBMS_OUTPUT.PUT_LINE(v_reg_emp.apellido||'*'||v_reg_emp.fecha_alt);
			FETCH c_emple INTO v_reg_emp;		
		END LOOP;
		
	
	CLOSE c_emple;
END;

---------------------------------------------------------------------------------------------------------

ARROYO*20/02/80
SANCHEZ*17/12/80
SALA*22/02/81
JIMENEZ*02/04/81
NEGRO*01/05/81
CEREZO*09/06/81
TOVAR*08/09/81
ALONSO*23/09/81
MARTIN*29/09/81
GIL*09/11/81
REY*17/11/81
JIMENO*03/12/81
FERNANDEZ*03/12/81
MUÑOZ*23/01/82

---------------------------------------------------------------------------------------------------------

/*ACTIVIDAD PROPUESTA 3*/

CREATE OR REPLACE PROCEDURE recibeCad (cad_intr VARCHAR2)
AS
	v_nom VARCHAR2(10);
	CURSOR C1 IS SELECT apellido, EMP_NO FROM EMPLE
				WHERE APELLIDO = v_nom;
	cont NUMBER(3) DEFAULT 0;
BEGIN
	v_nom := cad_intr;
	
	FOR I IN C1 LOOP
		DBMS_OUTPUT.PUT_LINE(I.apellido||'*'||I.EMP_NO);
		cont:=cont+1;
	END LOOP;
	
	DBMS_OUTPUT.PUT_LINE('NUMERO DE FILAS: '||cont);
END recibeCad;

---------------------------------------------------------------------------------------------------------

EXEC recibeCad('PEPE');
EXEC recibeCad('SANCHEZ');

---------------------------------------------------------------------------------------------------------

/*CASO PRÁCTICO 4*/

CREATE OR REPLACE PROCEDURE listar_emple
AS
	CURSOR C1 IS SELECT apellido, salario, DEPT_NO FROM EMPLE
						ORDER BY DEPT_NO, apellido;
						
	vr_emp C1%ROWTYPE;
	dep_ant EMPLE.DEPT_NO%TYPE DEFAULT 0;
	cont_emple NUMBER(4) DEFAULT 0;
	sum_sal NUMBER(9,2) DEFAULT 0;
	tot_emple NUMBER(4) DEFAULT 0;
	tot_sal NUMBER(10,2) DEFAULT 0;
BEGIN
	OPEN C1;
		LOOP
			FETCH C1 INTO vr_emp;
			
			/*Si es el primer fetch iniciamos dep_ant*/
			IF C1%ROWCOUNT = 1 THEN
				dep_ant := vr_emp.DEPT_NO;
			END IF;
			
			/*Comprobación nuevo depart (o finalización) y resumen del anterior e inicialización de contadores
			y acumuladores parciales*/
			IF dep_ant <> vr_emp.DEPT_NO OR C1%NOTFOUND THEN
				DBMS_OUTPUT.PUT_LINE('***DEPTO: '||dep_ant||' NUM EMPLEADOS: '||cont_emple||' SUM SALARIOS: '||sum_sal);
				dep_ant := vr_emp.DEPT_NO;
				tot_emple := tot_emple + cont_emple;
				tot_sal := tot_sal + sum_sal;
				cont_emple := 0;
				sum_sal := 0;
			END IF;
			EXIT WHEN C1%NOTFOUND; /*Condición de salida del bucle*/
			
			/*Escribir Líneas de detalle incrementar y acumular */
			DBMS_OUTPUT.PUT_LINE(RPAD(vr_emp.apellido, 10)||'*'||LPAD(TO_CHAR(vr_emp.salario, '999,999'), 12));
			cont_emple := cont_emple +1;
			sum_sal := sum_sal + vr_emp.salario;
			
			END LOOP;
	CLOSE C1;
	
	/*Escribir totales informe*/
	DBMS_OUTPUT.PUT_LINE(' ****** NUMERO TOTAL DE EMPLEADOS: '||tot_emple||' TOTAL SALARIOS: '||tot_sal);
	
END listar_emple;

---------------------------------------------------------------------------------------------------------

EXEC listar_emple;

CEREZO    *     318,500
MUÑOZ     *     169,000
REY       *     650,000
***DEPTO: 10 NUM EMPLEADOS: 3 SUM SALARIOS: 1137500
ALONSO    *     143,000
FERNANDEZ *     390,000
GIL       *     390,000
JIMENEZ   *     386,750
SANCHEZ   *     104,000
***DEPTO: 20 NUM EMPLEADOS: 5 SUM SALARIOS: 1413750
ARROYO    *     208,000
JIMENO    *     123,500
MARTIN    *     162,500
NEGRO     *     370,500
SALA      *     162,500
TOVAR     *     195,000
***DEPTO: 30 NUM EMPLEADOS: 6 SUM SALARIOS: 1222000
****** NUMERO TOTAL DE EMPLEADOS: 14 TOTAL SALARIOS: 3773250

---------------------------------------------------------------------------------------------------------

/*ACTIVIDAD PROPUESTA 4*/

CREATE OR REPLACE PROCEDURE listar_emple
AS
	CURSOR C1 IS SELECT apellido, salario, DEPT_NO FROM EMPLE
						ORDER BY DEPT_NO, apellido;
	dep_ant EMPLE.DEPT_NO%TYPE DEFAULT 0;
	cont_emple NUMBER(4) DEFAULT 0;
	sum_sal NUMBER(9,2) DEFAULT 0;
	tot_emple NUMBER(4) DEFAULT 0;
	tot_sal NUMBER(10,2) DEFAULT 0;
BEGIN	
	FOR vr_emp IN C1 LOOP
		IF C1%ROWCOUNT = 1 THEN
				dep_ant := vr_emp.DEPT_NO;
		END IF;
			
		IF dep_ant <> vr_emp.DEPT_NO OR C1%NOTFOUND THEN
			DBMS_OUTPUT.PUT_LINE('***DEPTO: '||dep_ant||' NUM EMPLEADOS: '||cont_emple||' SUM SALARIOS: '||sum_sal);
			dep_ant := vr_emp.DEPT_NO;
			tot_emple := tot_emple + cont_emple;
			tot_sal := tot_sal + sum_sal;
			cont_emple := 0;
			sum_sal := 0;
		END IF;
		EXIT WHEN C1%NOTFOUND;
		
		DBMS_OUTPUT.PUT_LINE(RPAD(vr_emp.apellido, 10)||'*'||LPAD(TO_CHAR(vr_emp.salario, '999,999'), 12));
		cont_emple := cont_emple +1;
		sum_sal := sum_sal + vr_emp.salario;
	END LOOP;
	
	/*Escribir totales informe*/
	DBMS_OUTPUT.PUT_LINE(' ****** NUMERO TOTAL DE EMPLEADOS: '||tot_emple||' TOTAL SALARIOS: '||tot_sal);
	
END listar_emple;

---------------------------------------------------------------------------------------------------------

EXEC listar_emple;

CEREZO    *     318,500
MUÑOZ     *     169,000
REY       *     650,000
***DEPTO: 10 NUM EMPLEADOS: 3 SUM SALARIOS: 1137500
ALONSO    *     143,000
FERNANDEZ *     390,000
GIL       *     390,000
JIMENEZ   *     386,750
SANCHEZ   *     104,000
***DEPTO: 20 NUM EMPLEADOS: 5 SUM SALARIOS: 1413750
ARROYO    *     208,000
JIMENO    *     123,500
MARTIN    *     162,500
NEGRO     *     370,500
SALA      *     162,500
TOVAR     *     195,000
****** NUMERO TOTAL DE EMPLEADOS: 8 TOTAL SALARIOS: 2551250

---------------------------------------------------------------------------------------------------------

/*ACTIVIDAD PROPUESTA 5*/

CREATE OR REPLACE PROCEDURE incrmSAL(cod_dept DEPART.DEPT_NO%TYPE, num NUMBER)
AS
	CURSOR C1 IS SELECT apellido, salario, ROWID FROM EMPLE
				WHERE DEPT_NO = cod_dept;
	vc_reg_emp C1%ROWTYPE;
	v_salario NUMBER(10);
	
BEGIN
	OPEN C1;
	
		WHILE C1%FOUND LOOP
			FETCH C1 INTO vc_reg_emp;
			
			v_salario := vc_reg_emp.salario + num;
			UPDATE EMPLE
			SET salario = salario + v_salario
			WHERE ROWID = vc_reg_emp.ROWID;
			
			DBMS_OUTPUT.PUT_LINE('EMPLEADO: '||vc_reg_emp.apellido||' SALARIO: '||vc_reg_emp.salario);
			
			FETCH C1 INTO vc_reg_emp;
			
		END LOOP;
	CLOSE C1;
END incrmSAL;

---------------------------------------------------------------------------------------------------------

EXEC incrmSAL(10, 15);

---------------------------------------------------------------------------------------------------------

/*ACTIVIDADES COMPLEMENTARIAS*/

--EJ4

CREATE OR REPLACE PROCEDURE mostrarEmpleado
AS
	CURSOR C1 IS SELECT apellido, oficio, salario FROM emple
	ORDER BY oficio, salario;
	vr_emple C1%ROWTYPE;
	oficio_ant EMPLE.OFICIO%TYPE;
	i NUMBER;
BEGIN
	OPEN C1;
		oficio_ant:='*';
		FETCH C1 INTO vr_emple;
		
		WHILE C1%FOUND LOOP
			
			IF oficio_ant <> vr_emple.oficio THEN
				oficio_ant := vr_emple.oficio;
				i := 1;
			END IF;
			
			IF i <= 2 THEN
			
			DBMS_OUTPUT.PUT_LINE(vr_emple.oficio||' * '||vr_emple.apellido||' * ' ||vr_emple.salario);
			
			END IF;
			
			FETCH C1 INTO vr_emple;
			i:=I+1;
			
		END LOOP;
		
	CLOSE C1;
	
END mostrarEmpleado;

---------------------------------------------------------------------------------------------------------

EXEC mostrarEmpleado;

---------------------------------------------------------------------------------------------------------

--EJ5

CREATE OR REPLACE PROCEDURE insertarDepart(nom_dept DEPART.DNOMBRE%TYPE, localidad DEPART.LOC%TYPE)
AS
	CURSOR C1 IS SELECT dnombre FROM depart 
				WHERE dnombre = nom_dept;
	vr_emple C1%ROWTYPE;
	dept DEPART.DNOMBRE%TYPE; 
	loca DEPART.LOC%TYPE;
	v_ulti_num DEPART.DEPT_NO%TYPE;
	error NUMBER(1) DEFAULT 0;
BEGIN
	OPEN C1;
		FETCH C1 INTO vr_emple;
		
		
		SELECT dnombre INTO dept FROM depart 
		WHERE dnombre = nom_dept;
			
		error := 1;
			
		SELECT LOC INTO loca FROM DEPART
		WHERE LOC = localidad;

		SELECT MAX(DEPT_NO) INTO v_ulti_num FROM DEPART;
     	
		DBMS_OUTPUT.PUT_LINE((v_ulti_num+10)|| dept || loca);
			
		FETCH C1 INTO vr_emple;
				
		INSERT INTO DEPART 
		VALUES ((TRUNC(v_ulti_num, -1)+10), dept, loca);
		
	CLOSE C1;
	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		IF error = 0 THEN
			DBMS_OUTPUT.PUT_LINE('ERROR: Nombre de departamento no encontrado.');
		ELSIF error = 1 THEN
			DBMS_OUTPUT.PUT_LINE('ERROR: Locaclidad no encontrada.');
		END IF;
END insertarDepart;

---------------------------------------------------------------------------------------------------------

EXEC insertarDepart('PEPE', 'SEVILLA');
EXEC insertarDepart('CONTABILIDAD', 'ANTONIO');
EXEC insertarDepart('CONTABILIDAD', 'SEVILLA');

---------------------------------------------------------------------------------------------------------

--EJ6

CREATE OR REPLACE PROCEDURE subirSalario(num_depar emple.dept_no%TYPE, importe NUMBER, porcentaje NUMBER)
AS
	CURSOR c_sal IS SELECT salario, ROWID FROM emple 
					WHERE dept_no = num_depar;
	vr_sal c_sal%ROWTYPE;
	v_imp_pct NUMBER(10);
BEGIN
	OPEN c_sal;
		FETCH c_sal INTO vr_sal;
		WHILE c_sal%FOUND LOOP

			v_imp_pct :=GREATEST((vr_sal.salario/100)*porcentaje, v_imp_pct);
		
			UPDATE EMPLE SET SALARIO=SALARIO + v_imp_pct
			WHERE ROWID = vr_sal.rowid;

			FETCH c_sal INTO vr_sal;
		END LOOP;
	CLOSE c_sal;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		DBMS_OUTPUT.PUT_LINE('ERROR: Datos no encontrados.');
END subirSalario;

---------------------------------------------------------------------------------------------------------

EXEC subirSalario(10, 15, 20);

---------------------------------------------------------------------------------------------------------

/*ACTIVIDAD PROPUESTA 4 (RUPTURAS DE SECUENCIA)*/

CREATE OR REPLACE PROCEDURE listar_emple
AS
	CURSOR C1 IS SELECT DISTINCT DEPT_NO FROM EMPLE
						ORDER BY DEPT_NO;
	
	CURSOR C2(pdep DEPART.DEPT_NO%TYPE) IS SELECT APELLIDO, SALARIO FROM EMPLE
											WHERE DEPT_NO = pdep;
	contador NUMBER;
	tot_sal NUMBER(10,2) DEFAULT 0;
	sum_sal NUMBER(9,2) DEFAULT 0;
	tot_emple NUMBER(4) DEFAULT 0;
	cont_emple NUMBER(4) DEFAULT 0;
BEGIN	
	FOR V1 IN C1 LOOP
		
		contador := 0;
		
		FOR V2 IN C2(V1.DEPT_NO) LOOP
			DBMS_OUTPUT.PUT_LINE(CHR(9)||V2.APELLIDO||'*'||V2.SALARIO);
			contador := contador + 1;
			sum_sal := sum_sal + V2.SALARIO;
		END LOOP;
		
		cont_emple := contador;
		tot_sal := tot_sal + sum_sal;
		tot_emple := tot_emple + cont_emple;
		
		DBMS_OUTPUT.PUT_LINE(CHR(10)||V1.DEPT_NO||'*'||'NUMERO DE EMPLEADOS: '||contador||'*'||'SUMA DE SALARIOS: '||sum_sal);
		
		cont_emple := 0;
		sum_sal := 0;
		
	END LOOP;
	
	DBMS_OUTPUT.PUT_LINE(' ****** NUMERO TOTAL DE EMPLEADOS: '||tot_emple||' TOTAL SALARIOS: '||tot_sal);
	
END listar_emple;

---------------------------------------------------------------------------------------------------------

EXEC listar_emple;

---------------------------------------------------------------------------------------------------------

/*ACTIVIDAD COMPLEMENTARIA 4 (RUPTURAS DE SECUENCIA)*/

CREATE OR REPLACE PROCEDURE mostrarEmpleado
AS
	CURSOR C1 IS SELECT DISTINCT oficio FROM emple
	ORDER BY oficio;
	CURSOR C2(pdep EMPLE.OFICIO%TYPE) IS SELECT APELLIDO, SALARIO FROM EMPLE
											WHERE OFICIO = pdep;
	
BEGIN
	FOR V1 IN C1 LOOP
		
		DBMS_OUTPUT.PUT_LINE(CHR(10)||V1.OFICIO);
		
		FOR V2 IN C2(V1.OFICIO) LOOP
			DBMS_OUTPUT.PUT_LINE(CHR(9)||V2.APELLIDO||'*'||V2.SALARIO);
			
		END LOOP;
	END LOOP;
END mostrarEmpleado;