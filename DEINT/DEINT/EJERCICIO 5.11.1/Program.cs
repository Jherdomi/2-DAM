using System;

namespace EJERCICIO_5._11._1
{
    class Program
    {
        static void Main(string[] args)
        {
            
            int resultado=0;
            String cad;
            int error = 0;

            cad=pedirCadena();

            string[] suma = cad.Trim().Split(" ");

            error = controlarErrores(suma);

            if(error == 1) {
                Console.WriteLine("ERROR: " + error);
                Environment.Exit(error);
            }

            

            resultado = calcularSuma(suma);
            mostrarResultado(resultado, suma);         
        }

        static string pedirCadena(){
            
            Console.WriteLine("Introduzca la suma: ");
            String cad =   Console.ReadLine();

            return cad;
        }

        static int calcularSuma(String[] suma){
            
            int resultado=0;
            
            for (int i=1; i < suma.Length; i++)
            {
                resultado=int.Parse(suma[i])+resultado;
                
            }

            return resultado;
        }


        static int controlarErrores(String[] suma){
            if (suma[0] != "suma") {
                Console.WriteLine("ERROR: Debe introducir primero la palabra suma.");
                return -1;
            }else{
                if (suma.Length==1){
                    Console.WriteLine("ERROR: No hay suificientes datos.");
                    return 1;
                    

                }
            }

            return 0;
        }

        static void mostrarResultado(int resul, String[] suma){
            if (suma.Length>=2){
                Console.WriteLine(resul);
            }   
        }
    }
}
