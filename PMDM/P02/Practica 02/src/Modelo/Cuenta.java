package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author alumno
 */
public class Cuenta {
    
    private int numero;
    private GregorianCalendar fecha;
    private float saldo;
    private String propietario;
    
    //Contador que añade el numero a las cuentas
    private static int contador = 0;
    
    // Esto es para convertir la fecha de GregorianCalendar a String.
    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    //Atributos parra el movimiento
    private Cuenta next = null; // Equivalente al siguiente nodo
    private Cuenta prev = null; // Equivalente al anterior nodo
    private static Cuenta first = null; // El primer nodo
    
    public Cuenta(String fecha, float saldo, String propietario){
        
         if (first == null) {
             first = this;
         } else {
            this.next = Cuenta.first;
            this.next.setPrevious(this);
            Cuenta.first = this;
        }
        
        contador++;
        
        this.numero = contador;
        setFecha(fecha);
        setSaldo(saldo);
        setProp(propietario);
    }
    
    public void setNumero(){
        
        this.numero = this.contador;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public void setFecha(String fecha){
        this.fecha = new GregorianCalendar(
                Integer.parseInt(fecha.substring(6, 10)),
                Integer.parseInt(fecha.substring(3, 5)) - 1, // Porque el calendario va de 0 a 11
                Integer.parseInt(fecha.substring(0, 2))) {
                    @Override
                    public String toString()
                    {
                        Date thisDate = this.getTime();
                        return sdf.format(thisDate);
                    }
        };
    }
    
    public String getFecha(){
        return this.fecha.toString();
    }
    
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
    
    public float getSaldo(){
        return this.saldo;
    }
    
    public void setProp(String prop){
        this.propietario = prop;
    }
    
    public String getProp(){
        return this.propietario;
    }
    
    public static Cuenta getFirst() {
        return Cuenta.first;
    }
    
    public void setPrevious(Cuenta prev) {
        this.prev = prev;
    }
    
    public Cuenta getPrevious() {
        return this.prev;
    }
    
    public void setNext(Cuenta next) {
        this.next = next;
    }
    
    public Cuenta getNext() {
        return this.next;
    }
    
    
    
    
}

