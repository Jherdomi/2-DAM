using System;
using System.IO;

namespace ProyectoClub
{
    class Ejemplar{

        public static void agregarEjemplar(){

              String tipo;
              bool bandera;

              //Esta función pedirá el tipo del ejemplar.
              //Además, iniciará el alta de ese tipo de ejemplar.

              do{
                  Console.WriteLine("\nIntroduzca el tipo de ejemplar (Videojuego/Pelicula): ");
                  tipo = Console.ReadLine();

                 bandera = true;

                    if (tipo.Equals("Videojuego")) {
                        bandera = false;
                        Fondo.altaVideojuego();
                    }else if (tipo.Equals("Pelicula")){
                        bandera = false;
                        Fondo.altaPelicula();
                    }else{
                        Console.WriteLine("\nERROR: Introuzca: [Videojuego o Pelicula].");
                    }

             }while(bandera);

        }
    }
}