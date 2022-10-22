package Modelo;

import Controlador.*;
import java.io.Serializable;
import javax.swing.JOptionPane;

public class CuentaAhorro extends Cuenta{
    
    //Atributos
    private float interesAnual;
    private String localidad;
    
    //Constructores
    
    public CuentaAhorro(){
        this.setProp("Pepe");
        setNumeroCuenta();
    }
    
    //Constructores que heredan de Cuenta
    public CuentaAhorro(String titular, float saldo, float saldoMin, String fecha, float interes, String localidad){
        super(titular, saldo, saldoMin, fecha);
        setInteresAnual(interes);
        setLocalidad(localidad);
    }
    
    //Métodos Getters and Setters
    public float getInteresAnual() {
        return interesAnual;
    }

    public void setInteresAnual(float interesAnual) {
        try{
            this.interesAnual = interesAnual;
        }catch(NumberFormatException e){
            Excepciones.invalidInteresAnual();
        }
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }   

    @Override
    public String toString(){ //método toString que devuelve la cadena con un identificador segúbn el tipo de cuenta
        String cad = null;
        
        cad = "CA" + ";" + this.getNumeroCuenta() + ";" + this.getProp() + ";" + 
                this.getSaldo() + ";" + this.getSaldoMinimo() + ";" + this.getFecha() + ";" + 
                this.interesAnual + ";" + this.localidad;
        
        return cad;
        
    }
    
    public Boolean mesesPasados(){
        int mesesPasados = CalculoFecha.mesesPasados(this.getFecha());
        
        if(mesesPasados >= 1){
            return true;
        }else{
            return false;
        }
    }
    
    
}
