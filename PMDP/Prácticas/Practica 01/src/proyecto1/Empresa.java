package proyecto1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Empresa {



    
    public Empleado empleado1;
    public Empleado empleado2;
    
    Empresa(Empleado ...empleados) {
        empleado1 = empleados[0];
        empleado2 = empleados[1];
    }
    


    public static int gestionEmpresa(){
        
        int operacion = 0;
        boolean pregunta;
        
        System.out.println("Cargando menú...");
        System.out.println(".................................");
        
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Menú");
        System.out.println("1.- Visualizar sueldo de un empleado.");
        System.out.println("2.- Visualizar nombre de un empleado.");
        System.out.println("3.- Cambiar nombre a un empleado.");
        System.out.println("4.- Cambiar sueldo a un empleado.");
        System.out.println("5.- Visualizar lista de empleados");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
        
        
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(stream);
        
        
                do {
            try {
                pregunta = false;

                System.out.println("Introduzca una opción del menú: ");
                operacion = Integer.parseInt(teclado.readLine());

               
                if ((operacion <= 0) || (operacion > 5)) {
                    System.out.println("ERROR: No ha introducido una opción válida.");
                    pregunta = true;
                }
            }
            catch (IOException e) {
                System.out.println("ERROR: No ha introducido los datos de la manera adecuada.");
                pregunta = true;
            }
        } while (pregunta);
        
        return operacion;
        
    }
    
    public void realizarOperacion(Empleado emp, int opc) {
        switch(opc) {
            case 1 : {
                System.out.println("Sueldo: " + emp.getSalario());
                break;
            }
            case 2 :  {
                System.out.println("Nombre: " + emp.getNombre());
                break;
            }
            case 3 :  {
                emp.setNombre();
                break;
            }
            case 4 :  {
                emp.setSalario();
                break;
            }
            case 5 :  {
                mostrarListado();
               
            }
        }
    }
    
    public void mostrarListado() {
        System.out.println(empleado1);
        System.out.println(empleado2);
    }
}