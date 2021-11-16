 -- Rupturas de secuencia con variables de acoplamiento
create or replace procedure emple1
as
	v_dept depart.dept_no%type;
	cursor c1 is select distinct dept_no from emple;
	
	cursor c2 is select apellido from emple
		where dept_no = v_dept;
begin
	for v1 in c1 loop
		dbms_output.put_line(chr(10)||v1.dept_no);
		v_dept := v1.dept_no;
		for v2 in c2 loop
			dbms_output.put_line(chr(9)||v2.apellido);
		end loop;
	end loop;
end;


-- Ruptura de secuencia con cursores con parametros
create or replace procedure emple2
as
	cont number;
	cursor c1 
		is select distinct dept_no from emple;
	cursor c2(pdep depart.dept_no%type) 
		is select apellido from emple
		where dept_no = pdep;
begin
	for v1 in c1 loop
		cont:=0;
		dbms_output.put_line(chr(10)||v1.dept_no);
		for v2 in c2(v1.dept_no) loop
			dbms_output.put_line(chr(9)||v2.apellido);
			cont := cont+1;
		end loop;
		dbms_output.put_line('Numero de empleados: '||cont);
	end loop;
end;

---------------------------------------------------------------------------------------------------------------------------

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

---------------------------------------------------------------------------------------------------------------------------

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





