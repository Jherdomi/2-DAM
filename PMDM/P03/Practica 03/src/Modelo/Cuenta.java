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
    
    public Cuenta(){
        this.contador++;
        this.numero = this.contador;
        setFecha(toString(new GregorianCalendar()));
        this.saldo = 0;
        this.propietario = "Jefe";
    }
    
    public Cuenta(int numero, float saldo, String propietario){
        this();
        setNumero(numero);
        setSaldo(saldo);
        setProp(propietario);
        
    }
    
    public Cuenta(int numero, String fecha, float saldo, String propietario){
        this(numero, saldo, propietario);
        setFecha(fecha); 
    }
    
    public void setNumero(int numero){
        
        this.numero = numero;
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
    
    public static String toString(GregorianCalendar cal)
    {
        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            Date thisDate = cal.getTime();
            return sdf.format(thisDate);
        }
        catch(Exception e) {
            return null;
        }
    }
    
    
}

