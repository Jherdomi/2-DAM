
package proyecto1;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Empleado {
    
    private String nombreEmpleado;
    private int salario;
    private static int salarioMax;
    
    public Empleado(String nombre, int salarioMax) {
        
        this.nombreEmpleado = nombre;
        Empleado.salarioMax = salarioMax;

    }
    
    public Empleado(String nombre, int salario, int salarioMax) {
        
        this.nombreEmpleado = nombre;
        
        this.salario = salario;
        Empleado.salarioMax = salarioMax;

    }
  
    
    public void setNombre(String nombre) {
        
        this.nombreEmpleado = nombre;
        
    }
    
    public void setNombre() {
        
        boolean bandera;
        
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(stream);
        
        do {
            try {
                
                bandera = false;

                System.out.println("Introduzca un nombre para el empleado: ");
                this.nombreEmpleado = teclado.readLine();
                
            }
            catch (IOException e) {
                
                System.out.println("ERROR: No ha introducido los datos adecuadamente.");
                bandera = true;
                
            }
            
        } while (bandera);
    }
    
    public void setSalario(int salario) {
        if (salario < Empleado.salarioMax)
            this.salario = salario;
        else 
            System.out.println("ERROR: El salario no ha de superar el salario máximo.");
    }
    
    public void setSalario() {
        
        boolean bandera;
        
        
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(stream);
        
        
        do {
            try {
                bandera = false;
                
                System.out.println("Introduzca un salario para el empleado: ");
                salario = Integer.parseInt(teclado.readLine());

                
                if ((salario > salarioMax) || (salario < 0)) {
                    
                    System.out.println("Error: El sueldo introducido no es válido");
                    bandera = true;
                    
                }
            }
            catch (IOException e) {
                
                System.out.println("\nError en la entrada de datos.");
                bandera = true;
            }
            
        } while (bandera);
    }
    
    public void setSueldoMaximo(int sueldoMaximo) {
        Empleado.salarioMax = sueldoMaximo;
    }
    
    public String getNombre() {
        return this.nombreEmpleado;
    }
    
    public int getSalario() {
        return this.salario;
    }
    
    public int getMax() {
        return Empleado.salarioMax;
    }
    
    @Override
    public String toString() {
        String cad = this.nombreEmpleado + "*" + this.salario + "*" + Empleado.salarioMax;
        
        return cad; 
    }
}
