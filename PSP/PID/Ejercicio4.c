#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>

void main(void){
	pid_t id_actual, id_padre, pid;

	pid = fork();

	if (pid==-1){//Hubo error
		printf("Hubo un problema de impotencia al crear el hijo.");
		exit(-1);
	}
	//Si todo va bien y se crea el hijo tenemos que hacer
	//que el programa ejecute un código con distinto para cada
	//proceso
	if(pid==0){//Nos encontramos en el hijo
		printf("\n\tSoy el proceso hijo.");
		printf("\nMi PID es %d, y el de mi papa es %d.", getpid(),getppid());
	} else {//Nos encontramos en el padre
		id_actual=wait(NULL);
		printf("\n\tYo soy el padre de la criatura:");
		printf("\n\tMi PID es %d, el de mi padre(abuelo de la criatura) es %d.", getpid(), getppid());
		printf("\n\tMi hijio si es de verdad mi hijo deberia tener el PID %d.",pìd);
	}
	
	exit(0);
	}
}
