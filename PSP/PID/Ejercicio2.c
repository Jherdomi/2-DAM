#include<stdio.h>
#include<unistd.h>

void main(){

	printf("Ejemplo de uso de execl():");
	printf("\n\tListado del directorio actual.");
	execl("/bin/ls","ls","-l",(char *)NULL);
	printf("\nEsta instruccion no se llega a ejecutar");
}
