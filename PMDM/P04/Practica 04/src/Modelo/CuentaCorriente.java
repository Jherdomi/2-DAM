package Modelo;

import Controlador.*;

public class CuentaCorriente extends Cuenta {
    
    //Atributos
    private float comisionMantenimiento;    
    private String tipoComision;
    
    public CuentaCorriente(){
        this.setProp("Pepe");
        setNumeroCuenta();
    }
    
    //Constructores que heredan de Cuenta    
    public CuentaCorriente(String titular, float saldo, float saldoMin, String fecha, float comisionMantenimiento, String tipoComision){
        super(titular, saldo, saldoMin, fecha);
        setComision(comisionMantenimiento);
        setTipoComision(tipoComision);
    }   

    //Métodos Getters and Setters    
    public float getComision() {
        return comisionMantenimiento;
    }

    public void setComision(float comisionMantenimiento) {
        try{
            this.comisionMantenimiento = comisionMantenimiento;
        }catch(NumberFormatException e){
            Excepciones.invalidComision();
        }
    }

    public String getTipoComision() {
        return tipoComision;
    }

    public void setTipoComision(String tipoComision) {
        this.tipoComision = tipoComision;
    }   

    @Override
    public String toString(){ //método toString que devuelve la cadena con un identificador segúbn el tipo de cuenta
        String cad = null;
        
        cad = "CC" + ";" + this.getNumeroCuenta() + ";" + this.getProp() + ";" + 
                this.getSaldo() + ";" + this.getSaldoMinimo() + ";" + this.getFecha() + ";" + 
                this.comisionMantenimiento + ";" + this.tipoComision;
        
        return cad;
        
    }
    
    public Boolean mesesPasados(){
        int mesesPasados = CalculoFecha.mesesPasados(this.getFecha()); //le paso la fecha actual al método mesesPasados del controlador
        String tip = this.tipoComision;
        
        //Y hago los respectivos cálculos
        
        if("Semestral".equals(tip) && mesesPasados >= 6){
            return true;
        }else if("Anual".equals(tip) && mesesPasados >= 12) {
            return true;
        }else{
            return false;
        }
    }
    
}
