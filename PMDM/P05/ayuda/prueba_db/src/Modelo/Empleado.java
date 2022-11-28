package Modelo;

import Controlador.Herramienta;
import java.util.GregorianCalendar;


public class Empleado {
    private int numero;
    private String nombre;
    private String apellido;
    private String foto;
    private float salario;
    private float salarioMaximo;
    private GregorianCalendar fechaAlta;
    
    
    public Empleado(int numero, String nombre, String apellido, String foto, float salario, float salarioMaximo, GregorianCalendar fechaAlta){
        this.numero=numero;
        this.nombre=nombre;
        this.apellido=apellido;
        this.foto=foto;
        this.salario=salario;
        this.salarioMaximo=salarioMaximo;
        this.fechaAlta=fechaAlta;
    }

  
    
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the salario
     */
    public float getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }

    /**
     * @return the salarioMaximo
     */
    public float getSalarioMaximo() {
        return salarioMaximo;
    }

    /**
     * @param salarioMaximo the salarioMaximo to set
     */
    public void setSalarioMaximo(float salarioMaximo) {
        this.salarioMaximo = salarioMaximo;
    }

    /**
     * @return the fechaAlta
     */
    public GregorianCalendar getFechaAlta() {
        return fechaAlta;
    }

    /**
     * @param fechaAlta the fechaAlta to set
     */
    public void setFechaAlta(GregorianCalendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    @Override
    public String toString(){           
        return Integer.toString(this.numero)+"-"+
                                this.nombre+"-"+
                                this.apellido+"-"+
                                Float.toString(this.salario)+"-"+
                                Float.toString(this.salarioMaximo)+"-"+
                                Herramienta.gregorianCalendarToString(fechaAlta);
    }
}
