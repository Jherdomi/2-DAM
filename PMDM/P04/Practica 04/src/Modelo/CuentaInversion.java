package Modelo;

import Controlador.*;
import java.util.GregorianCalendar;

public class CuentaInversion extends Cuenta{
    
    //Atributos
    private float beneficioPerdida;
    private String localidad;
    
    public CuentaInversion(){
        this.setProp("Pepe");
        setBeneficioPerdida();
        setNumeroCuenta();
    }
    
    //Constructores que heredan de Cuenta
    public CuentaInversion(String titular, float saldo, float saldoMin, String fecha, String localidad){
        
        super(titular, saldo, saldoMin, fecha);
        setLocalidad(localidad);
        setBeneficioPerdida();
    }
    
 
    //Métodos Getters and Setters
    public float getBeneficioPerdida() {
        return beneficioPerdida;
    }

    public void setBeneficioPerdida() {
        try{
            this.beneficioPerdida = random(-10, 10);
        }catch(NumberFormatException e){
            Excepciones.invalidBeneficioPerdida();
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
        
        cad = "CI" + ";" + this.getNumeroCuenta() + ";" + this.getProp() + ";" + 
                this.getSaldo() + ";" + this.getSaldoMinimo() + ";" + this.getFecha() + ";" + 
                this.beneficioPerdida + ";" + this.localidad;
        
        return cad;
        
    }
    
    public Boolean mesesPasados(){
        int mesesPasados = CalculoFecha.mesesPasados(this.getFecha()); //le paso la fecha actual al método mesesPasados del controlador
        
        if(mesesPasados >= 3){
            return true;
        }else{
            return false;
        }
    }
    
    public static int random(int menor, int mayor){ //genero un beneficio o perdida de forma aleatoria
        int pablo= (int)(Math.random()*(mayor-menor+1)+menor);
        return pablo;
        
    }
}
