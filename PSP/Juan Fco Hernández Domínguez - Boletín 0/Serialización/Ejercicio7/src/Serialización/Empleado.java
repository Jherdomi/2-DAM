package Serialización;

import java.io.Serializable;

public class Empleado implements Serializable {
    
    
    private String nombre;
    private int sueldo;
    private static int sueldoMaximo;
    
   
    Empleado(String nombre, int sueldo, int sueldoMaximo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        Empleado.sueldoMaximo = sueldoMaximo;
    }
  
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setSueldo(int sueldo) {
        if (sueldo < Empleado.sueldoMaximo)
            this.sueldo = sueldo;
        else System.out.println("El sueldo no ha de superar el sueldo máximo.");
    }
    
    public void setSueldoMaximo(int sueldoMaximo) {
        Empleado.sueldoMaximo = sueldoMaximo;
    }
  
    
    public String getNombre() {
        return this.nombre;
    }
    
    public int getSueldo() {
        return this.sueldo;
    }
    
    public int getSueldoMaximo() {
        return Empleado.sueldoMaximo;
    }
  
    @Override
    public String toString() {
        return this.nombre + "-" + this.sueldo + "-" + Empleado.sueldoMaximo;
    }
}