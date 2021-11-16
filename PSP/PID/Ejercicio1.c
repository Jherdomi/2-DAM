#include<stdio.h>
#include<stdlib.h>

void main(){
	printf("Ejemplo de uso de system():");
	printf("\n\tListado de directorio actual y envio a un fichero:");
	printf("%d",system("ls>ficherosalida.txt"));
	printf("\n\tAbrimos con nano el fichero ...");
	printf("%d",system("nano ficherosalida.txt"));
	printf("Este comando es erroneo: %d", system("msword"));
	printf("\n\tFin del programa");

}
