using System;

namespace DEINT
{
    class Program
    {
        static void Main(string[] args){

            int numeroPedido;
            int num = 2;
            int cont;
            int i;
            

            do{
                Console.WriteLine("Introduzca un numero: ");
                numeroPedido = Int32.Parse(Console.ReadLine());
            }while(numeroPedido<=0); 

            Console.WriteLine("El numero 1 es primo.");

            while (num<=numeroPedido)
            {
                cont = 1;

                for(i=2; i<num; i++)
                {

                    if (num % i == 0)
                    {
                        cont++;
                        break;
                    }
                }

                if (cont == 1)
                {
                    Console.WriteLine("El numero " + i + " es primo.");
                }

                num++;
                
            }
            
        }
    }
}
