using System;
using System.IO;

namespace Ejercicio2
{
    class Program 
    {
        static void Main(string[] args)
        { 

            String nombre; //Variable que tiene la ruta del fichero
            int num; //Variable que guarda el byte del fichero
            FileStream fichero; //Variable que lee el fichero
            bool bandera;//Variable banderanombre

            //El bucle do se repetirá siempre y cuando no se le de un valor a la variable fichero de tipo string
            do{
                bandera = false;
                Console.WriteLine("Introduzca la ruta del fichero: ");
                nombre = Console.ReadLine();

                //Comprobamos que el usuario introduzca algún dato
                if(nombre.Equals("")){
                    bandera = true;
                    Console.WriteLine("ERROR: No ha introducido nada");

                }else if(!File.Exists(nombre)){//Comprobamos si existe
                    bandera = true;
                    Console.WriteLine("ERROR: Fichero no encontrado.");      
                }

            }while(bandera);
            

            //Cambia la extensión actual del fichero por ".out" y abrimos el fichero
            string ficheroCopia = Path.ChangeExtension(nombre, ".out"); fichero = File.OpenRead(nombre); 
            //Crea o Reemplaza el archivo .out, dependiendo de si existe o no
            StreamWriter copia = File.AppendText(ficheroCopia);
                    
            //Leemos y almacenamos el primer byte
            num = fichero.ReadByte(); 

            //Para que se lea y escriba hasta que llegue al final del fichero (-1 determina el final de este)
            while(num != -1){

                char letra = Convert.ToChar((byte) num); //Se cambia de byte a char para meterlo en .out
                copia.Write(letra); //Metemos los char en el fichero
                num = fichero.ReadByte(); //Se lee otro byte

            }

            copia.Close(); //Cerramos el flujo
            fichero.Close(); //Cerramos el fichero
            Console.WriteLine("Fichero leido con exito.");
    
        }
    }
}