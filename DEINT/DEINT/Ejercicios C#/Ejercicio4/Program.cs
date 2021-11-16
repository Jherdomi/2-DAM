using System;
using System.IO;

namespace Ejercicio4
{
    class Program
    {
        static void Main(string[] args)
        {

            //Guarda los datos de la cabecera del fichero
            byte[] datosCabecera = new byte[128];

            //Variable que guarda la ruta del fichero
            String nombreFichero;

            //Pedimos la ruta del fichero
            //Do..while que controla que se le introduzca algún dato.
            do{
                Console.WriteLine("Indique el nombre del fichero: ");
                nombreFichero = Console.ReadLine();
            }while(nombreFichero.Equals(""));

        

            //Se comprobará la existencia del archivo
            if (File.Exists(nombreFichero))
            {

                //Se creará un flujo de lectura para el fichero
                FileStream fichero = File.OpenRead(nombreFichero);

                //Nos posicionaremos al final del fichero indicado
                fichero.Seek(-128, SeekOrigin.End);

                //Insertaremos los bytes en el array
                for (int i = 0; i < datosCabecera.Length; i++)
                {

                    datosCabecera[i] = (byte)fichero.ReadByte();

                }

                //El título del tema mp3 se encuentra en la posición 3 - 32 bytes
                //Procederemos a leer las 30 bytes desde la posición 3

                string titulo = null;
                for (int t = 3; t <= 32; t++)
                {

                   titulo = titulo + Convert.ToChar(datosCabecera[t]);

                }

                //El autor del tema mp3 se encuentra en la posición 33 - 62 bytes
                string autor = null;
                for (int j = 33; j <= 62; j++)
                {

                    autor = autor + Convert.ToChar(datosCabecera[j]);

                }

                //Cambiará la extensión del fichero actual por uno .txt en el que escribirá el titulo y el autor del archivo mp3
                string nuevoFich = Path.ChangeExtension(nombreFichero, ".txt");
                //Se creará el archivo .txt si no existe. Se abrirá y se reescribirá en el caso de que exista.
                StreamWriter sw = File.CreateText(nuevoFich);

                //Se escribirán los datos en el nuevo fichero .txt
                sw.WriteLine("Titulo del archivo mp3: " + titulo);
                sw.WriteLine("Autor del archivo mp3: " + autor);

                //Se cerrará el flujo de ambos Stream
                sw.Close();
                fichero.Close();

            }
            else{
                Console.WriteLine("ERROR: No existe ese archivo.");
            }
        }
    }
}

