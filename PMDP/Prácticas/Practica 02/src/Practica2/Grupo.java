package Practica2;


import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;


public final class Grupo {
    private static Grupo principio=null;
    private static Grupo actual=null;
    
    
    private static Grupo primero = null;
    private String nombre;
    private final Grupo siguiente;
    private float precio;
    private GregorianCalendar fecha;
    private int disco;
    final SimpleDateFormat valFecha = new SimpleDateFormat("dd/MM/yyyy");
    /*--------------------------------------------------------------------------------------------*/
    public Grupo(String nombre, float precio, String fecha, int disco) {
        
        this.siguiente=principio;
        principio=this; 
        actual=principio;
        
        setNombre(nombre);
        setPrecio(precio);
        setFecha(fecha);
        setDisco(disco);
    }
    /*--------------------------------------------------------------------------------------------*/
    public static void adelante(){
        actual=actual.siguiente;
    }
    
    public static void atras() {
        Grupo aux;
        aux=principio;
        while (aux.siguiente!=actual) {
            aux=aux.siguiente;
        }
        actual=aux;
    }
    /*--------------------------------------------------------------------------------------------*/
    public static String nombreDeActual(){
        return actual.nombre;
    }
    
    public static Float precioDeActual(){
        return actual.precio;
    }
    
    public static String fechaDeActual(){
        return actual.fecha.toString();
    }
    
    public static int numDeActual(){
        return actual.disco;
    }
    
    public static boolean esPrimero(){
        return (actual==principio);
    }
   /*--------------------------------------------------------------------------------------------*/ 
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre=nombre.trim();
    }
    /*--------------------------------------------------------------------------------------------*/ 
    public static void listar() {
        Grupo aux;
        aux=principio;
        while (aux!=null) {
            System.out.println(aux.getNombre()+" / "+aux.getFecha());
            aux=aux.siguiente;
        }
    }
   /*--------------------------------------------------------------------------------------------*/ 
    public String getFecha() {
        return this.fecha.toString();
    }

    public void setFecha(String fecha) {
        
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
    /*--------------------------------------------------------------------------------------------*/
    public float getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(float precio) {   
        this.precio=precio;
    }
    
    /*--------------------------------------------------------------------------------------------*/
    
    public int getDisco() {
        return this.disco;
    }
    
    public void setDisco(int disco) {
        this.disco=disco;
    }
    
     /*--------------------------------------------------------------------------------------------*/
    
    public static Grupo getPrimero() {
        
        return Grupo.primero;
    }
}
