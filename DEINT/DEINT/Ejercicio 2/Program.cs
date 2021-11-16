using System;

namespace Ejercicio_2
{
    class Program
    {
        static void Main(string[] args)
        {

            int edad;
            
            try{
                Console.WriteLine("Dime tu edad: ");
                edad = Int32.Parse(Console.ReadLine());
            }catch (FormatException)
            {
                Console.WriteLine("El número no es válido");
            }

            Console.WriteLine("Dime tu edad: ");
            string fecnac;
            fecnac = Console.ReadLine();

            


        }
    }
}
