using System;

namespace Ej1
{
    class Program
    {
        static void Main(string[] args)
        {
            
            int numeroPedido;
            int tabla;
            

            do
            {
                Console.WriteLine("Introduzca un numero: ");
                numeroPedido = Int32.Parse(Console.ReadLine());
            } while (numeroPedido<=0);

            Console.WriteLine("Tabla del " + numeroPedido + ".");

            for (int i=1; i<=10; i++)
            {
                tabla = 0;

                tabla = numeroPedido*i;

                Console.WriteLine(numeroPedido + " x " + i + " = " + tabla + ".");

            }

        }
    }
}
