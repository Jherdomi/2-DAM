package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import Controlador.*;
import java.io.Serializable;

/**
 *
 * @author alumno
 */
public class Cuenta implements Serializable{
    
    //Atributos
    private int numeroCuenta; //nunca será introducido por el usuario, ya que toma valores aleatorios entre 0 y 100
    transient String propietario;
    private float saldo;
    private float saldoMinimo;
    private GregorianCalendar fecha;
    
    // Esto es para convertir la fecha de GregorianCalendar a String.
    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    //Constructor
    public Cuenta(String propietario, float saldo, float saldoMinimo, String fecha){
        setNumeroCuenta(); //aquí genero el número de cuenta aleatorio, ya que es el primer constructor
                           //en el que no todo son datos generados por defecto
        setProp(propietario);
        setFecha(fecha);
        setSaldoMinimo(saldoMinimo);
        setSaldo(saldo);
    }
    
    public Cuenta(){
        setNumeroCuenta();
    }

    //Getters y Seters
    
    public float getSaldoMinimo() {
        return saldoMinimo;
    }

    public void setSaldoMinimo(float saldoMinimo) {
        try{
            this.saldoMinimo = saldoMinimo;
        }catch(NumberFormatException e){
            Excepciones.invalidSaldoMin();
        }
        
    }

    
    public void setNumeroCuenta(){ //se genera mediante un número aleatorio
        
        this.numeroCuenta = (int) Math.floor(Math.random()*100);
    }
    
    public int getNumeroCuenta(){
        return this.numeroCuenta;
    }
    
    public void setFecha(String fecha){ //dar formato de fecha
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
        return cambiarFecha(this.fecha);
    }
    
    public void setSaldo(float saldo){
        try{
            if(saldo < this.saldoMinimo){
                Excepciones.saldoMenor();
            }else{
                this.saldo = saldo;
            }
            
        }catch(NumberFormatException e){
            Excepciones.invalidSaldo();
        }
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
    
    //Método toString para hacer pruebas con los constructores
    
    //@Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", propietario=" + propietario + ", saldo=" + saldo + ", saldoMinimo=" + saldoMinimo + ", fecha=" + fecha + ", sdf=" + sdf + '}';
    }
    
    public String cambiarFecha(GregorianCalendar fec){ //método para cambiar la fecha a un string
        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            Date thisDate = fec.getTime();
            return sdf.format(thisDate);
        }
        catch(Exception e) {
            return null;
        }
    }
    
}

