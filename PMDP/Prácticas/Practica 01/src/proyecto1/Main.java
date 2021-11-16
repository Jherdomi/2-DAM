
package proyecto1;


public class Main {
    


    public static void main(String[] args) {
        
        Empleado empleado1 = new Empleado("Juan Pérez Martín", 1200, 3000);
        Empleado empleado2 = new Empleado("Rosa Nigeria Larios", 1500, 3500);
        
        int operacion=0;
        
      
        
        System.out.println("Entrando en la gestión de empleados de la empresa.");

        Empresa empresa = new Empresa(empleado1, empleado2);
        
        
        
        do {
             operacion = Empresa.gestionEmpresa();
             empresa.realizarOperacion(empleado1, operacion);
             
        
             operacion = Empresa.gestionEmpresa();
             empresa.realizarOperacion(empleado2, operacion);
   
            
        }while(operacion != 5);

      
       
       
             
    }
}