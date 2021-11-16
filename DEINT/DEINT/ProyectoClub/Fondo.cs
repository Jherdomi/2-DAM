using System;
using System.IO;

namespace ProyectoClub
{
    class Fondo
    {
        static void Main(string[] args)
        {
            int op = 0;

            Socio.sociosCreados();

            do{
                mostrarMenu();
                op = pedirOP();
                realizarOP(op);
            }while(op > 0 && op<=5);
        }

        public static void mostrarMenu(){
            Console.WriteLine("MENU");
            Console.WriteLine("--------------------------");
            Console.WriteLine("1.- Alta Ejemplar.");
            Console.WriteLine("2.- Buscar Ejemplar.");
            Console.WriteLine("3.- Prestar Ejemplar.");
            Console.WriteLine("4.- Devolver Ejemplar.");
            Console.WriteLine("5.- Mostrar cliente con ejmeplar un prestado.");
            Console.WriteLine("6.- Salir.");
            Console.WriteLine("--------------------------");
        }

        public static int pedirOP(){
            int respuesta = 0;

            Console.WriteLine("Indique la opcion a realizar: ");
            respuesta = Int32.Parse(Console.ReadLine());

            return respuesta;
        }

        public static void realizarOP(int op){

            switch(op){
                case 1 : 
                    Ejemplar.agregarEjemplar();
                    break;
                case 2:
                    buscarEjemplar();
                    break;
                case 3:
                    prestarEjemplar();
                    break;
                case 4:
                    devolverEjemplar();
                    break;
                case 5:
                    mostrarPrestado();
                    break;
                case 6:
                    Console.WriteLine("Saliendo de la aplicacion.......");
                    break;
            }
        }

        public static void altaVideojuego(){
            
            String titulo;
            String genero;
            String disponible;
            bool bandera;

            do{
                bandera=false;
                Console.WriteLine("\nIntroduzca el titulo del videojuego(Máximo 40 caracteres): ");
                titulo = Console.ReadLine();

                if(titulo.Equals("") || titulo.Length > 40){
                    bandera = true;
                    Console.WriteLine("\nERROR: Titulo incorrecto.");
                }

            }while(bandera);


            do{
                bandera = false;
                Console.WriteLine("\nIntroduzca el genero del videojuego(Máximo 40 caracteres): ");
                genero = Console.ReadLine();

                if(genero.Equals("") || genero.Length > 40){
                    bandera = true;
                    Console.WriteLine("\nERROR: Genero incorrecto.");
                }

            }while(bandera);

            do{
                bandera = false;
                Console.WriteLine("\nIntroduzca si esta disponible el videojuego(Si/No): ");
                disponible = Console.ReadLine();

                if(disponible.Equals("si") || disponible.Equals("no")){
                    bandera = false;
                    
                }else{
                    bandera = true;
                    Console.WriteLine("\nERROR: Informacion incorrecta.");
                }

            }while(bandera);
        }

        public static void altaPelicula(){
            String titulo;
            String genero;
            String disponible;
            bool bandera;

            do{
                bandera=false;
                Console.WriteLine("\nIntroduzca el titulo del videojuego(Máximo 40 caracteres): ");
                titulo = Console.ReadLine();

                if(titulo.Equals("") || titulo.Length > 40){
                    bandera = true;
                    Console.WriteLine("\nERROR: Titulo incorrecto.");
                }

            }while(bandera);


            do{
                bandera = false;
                Console.WriteLine("\nIntroduzca el genero del videojuego(Máximo 40 caracteres): ");
                genero = Console.ReadLine();

                if(genero.Equals("") || genero.Length > 40){
                    bandera = true;
                    Console.WriteLine("\nERROR: Genero incorrecto.");
                }

            }while(bandera);

            do{
                bandera = false;
                Console.WriteLine("\nIntroduzca si esta disponible el videojuego(Si/No): ");
                disponible = Console.ReadLine();

                if(disponible.Equals("si") || disponible.Equals("no")){
                    bandera = false;
                    
                }else{
                    bandera = true;
                    Console.WriteLine("\nERROR: Informacion incorrecta.");
                }

            }while(bandera);
        }

        private static void buscarEjemplar(){

        }

        private static void prestarEjemplar(){

        }

        private static void devolverEjemplar(){

        }

        private static void mostrarPrestado(){

        }

    }
}
