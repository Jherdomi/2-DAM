set serveroutput on



begin
	for pnum in 0..30
	LOOP
		IF MOD(pnum,2)=0
		THEN
			dbms_output.put_line(pnum);
		END IF;
	END LOOP;
end;

---------------------------------------------------------------------------------

declare
	vsumpares NUMBER(3):=0;
	vsumimpares NUMBER(3):=0;

begin
	for pnum in 0..30
	LOOP
		IF MOD(pnum,2)=0
		THEN
			vsumpares:=pnum+vsumpares;
		END IF;
		IF MOD(pnum,2)!=0
		THEN
			vsumimpares:=pnum+vsumimpares;
		END IF;
	END LOOP;
	
	dbms_output.put_line('Suma de los pares: ' || vsumpares);
	dbms_output.put_line('Suma de los pares: ' || vsumimpares);
end;

---------------------------------------------------------------------------------
create or replace function FNUM
return VARCHAR2
as
	vsuma NUMBER(3):=0;

begin
	for pnum in 0..30
	LOOP
		vsuma:=vsuma+pnum;
	END LOOP;
	
	return('Suma de los 30 primeros numeros: ' || vsuma);
end;


select FNUM from dual;

---------------------------------------------------------------------------------

create or replace procedure inserta (cod number)
as
begin
	insert into emp(empno) values (cod);
end;

exec inserta(1);

---------------------------------------------------------------------------------

create or replace procedure modifica (cod number, nombre VARCHAR2)
as
begin
	UPDATE emp
	set ename=nombre
	where empno=cod;
end;

exec modifica(1, 'PEPE');

---------------------------------------------------------------------------------

create or replace procedure consulta (cod number)
as
	vnombre	VARCHAR2(20);
begin
	select ename into vnombre from emp
	where empno=cod;
	dbms_output.put_line(vnombre);
end;

exec consulta(1);

---------------------------------------------------------------------------------

create or replace procedure borra (cod number)
as
	vnombre	VARCHAR2(20);
begin
	delete emp
	where empno=cod;
end;

exec borra(1);