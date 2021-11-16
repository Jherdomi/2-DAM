	
	Descripci�n de las tablas:
	==========================

HABILIDADES
-----------
# COD_HA	CHAR(5)		C�digo Habilidad
  DESC_HA	VARCHAR2(30)	Descripci�n de Habilidad (O) (U)

CENTROS
-------
# COD_CE	CHAR(4)		C�digo del Centro
* DIRECTOR_CE	NUMBER(6)	Director del Centro
  NOMB_CE	VARCHAR2(30)	Nombre del Centro (O)
  DIRECC_CE	VARCHAR2(50)	Direcci�n del Centro (O)
  POBLAC_CE	VARCHAR2(15)	Poblaci�n del Centro (O)

DEPARTAMENTOS
-------------
# COD_DE	CHAR(5)		C�digo del Departamento
* DIRECTOR_DE	NUMBER(6)	Director del Departamento
* DEPTJEFE_DE	CHAR(5)		Departamento del que depende
* CENTRO_DE	CHAR(4)		Centro trabajo (O)
  NOMB_DE	VARCHAR2(40)	Nombre del Departamento (O)
  PRESUP_DE	NUMBER(11)	Presupuesto del Departamento (O)
  TIPODIR_DE	CHAR(1)		Tipo de Director del Departamento (O)

EMPLEADOS
---------
# COD_EM	NUMBER(6)	C�digo del Empleado
* DEPT_EM	CHAR(5)		Departamento del Empleado (O)
  EXTTEL_EM	CHAR(9)		Extensi�n telef�nica
  FECINC_EM	DATE		Fecha de incorporaci�n del Empleado (O)
  FECNAC_EM	DATE		Fecha de nacimiento del Empleado (O)
  DNI_EM	VARCHAR2(9)	DNI del Empleado (U)
  NOMB_EM	VARCHAR2(40)	Nombre del Empleado (O)
  NUMHIJ_EM	NUMBER(2)	N�mero de hijos del Empleado (O)
  SALARIO_EM	NUMBER(9)	Salario Anual del Empleado (O)

HIJOS
-----
#*PADRE_HI	NUMBER(6)	C�digo del Empleado
# NUMHIJ_HI	NUMBER(2)	N�mero del hijo del Empleado
  FECNAC_HI	DATE		Fecha de nacimiento del Hijo (O)
  NOMB_HI	VARCHAR2(40)	Nombre del Hijo (O)

HABIEMPL
-----------
#*CODHA_HE	CHAR(5)		C�digo de la Habilidad
#*CODEM_HE	NUMBER(6)	C�digo del Empleado


Nota: 
	# PRIMARY KEY
	* FOREIGN KEY
	(O) Obligatorio
	(U) �nico
