using System;
using System.IO;

namespace Ejercicio3
{
    class Program
    {
        static void Main(string[] args)
        {
            //Variable que contiene el nombre introducido por el usuario
            String nombre;
            //Variable banderanombre
            bool bandera;

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

            //Abrimos el fichero
            using FileStream leer = new FileStream(nombre, FileMode.Open);

            //Creamos una variable que lea los 3 primeros Bytes
            byte[] bytes = new byte[] {(byte) leer.ReadByte(), (byte) leer.ReadByte(), (byte) leer.ReadByte()};

            //Esta variable contiene el texto con los Bytes leídos
            string contenido = System.Text.Encoding.UTF8.GetString(bytes);

            //If que mostrará por pantalla uno de los mensajes de tipo
            if(contenido.Substring(0, 2) == "BM") {
                //Se hace uso de substring ya que se extrae de un archivo bmp
                //solo la B y la M, de esta forma cogemos las dos primeras letras
                Console.WriteLine("Tipo: " + contenido);
            }else if(contenido == "GIF"){
                Console.WriteLine("Tipo: " + contenido);
            }else{
                Console.WriteLine("El archivo no esta en los casos posibles");
            }
            
        }
    }
}
