package prac3.Lista;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Empleado {
    
    //Atributos
    private String nombre;
    private GregorianCalendar fecha;
    private float salario;
    private int numdepart;
    private static float sueldoMax;
    final SimpleDateFormat valFecha = new SimpleDateFormat("dd/MM/yyyy");

    
    /*******************************************************************************************************************************/
    
    //Constructores
    Empleado(String nombre, float sueldoMax){
        this.nombre = nombre;
        this.fecha = new GregorianCalendar();
        Empleado.sueldoMax = sueldoMax;
    }
    
    Empleado(String nombre, float salario, GregorianCalendar fecha, float sueldoMax, int numdepart) {
        this.nombre = nombre;
        this.salario = salario;
        this.fecha = fecha;
        this.numdepart = numdepart;
        Empleado.sueldoMax = sueldoMax;
    }
    
    Empleado(String nombre, float salario, GregorianCalendar fecha, int numdepart) {
        this.nombre = nombre;
        this.salario = salario;
        this.fecha = fecha;
        this.numdepart = numdepart;
    }
    
    /*******************************************************************************************************************************/
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    /*******************************************************************************************************************************/
    
    public float getSalario(){
        return this.salario;
    }
    
    public void setSalario(float salario){
        this.salario=salario;
    }
    
    
    public float getSalarioMax(){
        return this.sueldoMax;
    }
    
    /*******************************************************************************************************************************/
    
    public String getFecha(){
        return this.fecha.toString();
    }
    
    public void setFecha(String fecha){
        
        this.fecha = new GregorianCalendar(
        Integer.parseInt(fecha.substring(6, 10)),
        Integer.parseInt(fecha.substring(3, 5)) - 1,
        Integer.parseInt(fecha.substring(0, 2))) {
             @Override
             public String toString()
             {
                  Date thisDate = this.getTime();
                  return valFecha.format(thisDate);
             }
       };
    }
    
    /*******************************************************************************************************************************/
    
    public int getDepart(){
        return this.numdepart;
    }
    
    public void setDepart(int numdepart){
        this.numdepart=numdepart;
    }
    
    /*******************************************************************************************************************************/
   
    
}
