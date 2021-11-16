using System;
using System.IO;

namespace Ejercicio1
{
    class Program
    {
        static void Main(string[] args)
        {
            //Variable que contendrá la ruta del fichero
            String fichero;
            //Variable banderanombre
            bool bandera;


            //El bucle do se repetirá siempre y cuando no se le de un valor a la variable fichero de tipo string
            do{
                bandera = false;
                Console.WriteLine("Introduzca la ruta del fichero: ");
                fichero = Console.ReadLine();

                //Comprobamos que el usuario introduzca algún dato
                if(fichero.Equals("")){
                    bandera = true;
                    Console.WriteLine("ERROR: No ha introducido nada");

                }else if(!File.Exists(fichero)){//Comprobamos si existe
                    bandera = true;
                    Console.WriteLine("ERROR: Fichero no encontrado.");      
                }

            }while(bandera);

            //Iniciamos el StreamReader para que lea el contenido
            //del fichero
            using StreamReader lector = new StreamReader(fichero);
            //Variable que mostrará el texto que hay en el fichero
            String texto = lector.ReadLine();
            //Variables que harán la cuenta de las 25 líneas
            //Contador que contará las líneas del fichero
            int contador = 1;
            //Almacena el número máximo de filas que se muestran
            int num = 25;
            //Variable que almacena las páginas
            //(Su uso no es otro que cuando el bucle se repita se muestren
            //las líneas con los números de línea + 25 lineas por
            //página que lleve)
            int pagina = 0;
                

            //Mientras que el fichero tenga texto
            while (texto != null) {
                
                //Mostramos los datos (numero de línea + contenido de esta)
                Console.WriteLine((pagina * num)+(contador + 1) + " " + texto);
                //Sumamos el contador
                //Este es quien cuenta las líneas del fcihero
                contador++;

                //Debido a este contador, si el contador es igual a num
                //es decir, 25, este entrará en el if
                //el cuál mostrará el mensaje indicado
                if (contador == num) {
                    //Mensaje a mostrar al llegar a las 25 líneas
                    Console.Write("\n|Pulse para continuar|\n");
                    //Leemos que pulse una tecla para que se siga el bucle
                    Console.ReadKey();
                    Console.WriteLine("");
                    //Dejamos el contador a 0 de nuevo para que este vuelva
                    //a contar hasta 25 de nuevo, así hasta que se termine
                    //el fichero.
                    contador = 0;
                    //Se suma la página
                    pagina++;
                }

                //Se lee el contenido del fichero
                texto = lector.ReadLine();

            }
            
        }
    }
}
