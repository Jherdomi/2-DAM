package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author alumno
 */
public class Trabajador {
    
    private int codTrabajador;
    private String nomTrabajador;
    private String apeTrabajador;
    private String fotoTrabajador;
    private float salario;
    private Date fechaAlta;
    private int codEmpresa;
    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    
    public Trabajador(int codTrabajador, String nomTrabajador, String apeTrabajador, String fotoTrabajador, float salario, Date fechaAlta, int codEmpresa) {
        setCodTrabajador(codTrabajador);
        setNomTrabajador(nomTrabajador);
        setApeTrabajador(apeTrabajador);
        setFotoTrabajador(fotoTrabajador);
        setSalario(salario);
        setFechaAlta(fechaAlta);
        setCodEmpresa(codEmpresa);
    }

    public int getCodTrabajador() {
        return codTrabajador;
    }

    public void setCodTrabajador(int codTrabajador) {
        this.codTrabajador = codTrabajador;
    }

    public String getNomTrabajador() {
        return nomTrabajador;
    }

    public void setNomTrabajador(String nomTrabajador) {
        this.nomTrabajador = nomTrabajador;
    }

    public String getApeTrabajador() {
        return apeTrabajador;
    }

    public void setApeTrabajador(String apeTrabajador) {
        this.apeTrabajador = apeTrabajador;
    }

    public String getFotoTrabajador() {
        return fotoTrabajador;
    }

    public void setFotoTrabajador(String fotoTrabajador) {
        this.fotoTrabajador = fotoTrabajador;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fecha) {
        this.fechaAlta = fecha;
    }

    public int getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }
        
    @Override
    public String toString(){
        return "T" + "*" + this.codEmpresa + "*" + this.nomTrabajador + "*" + 
                this.apeTrabajador +"*"+ this.fotoTrabajador +"*"+ this.salario
                + "*" + this.fechaAlta+ "*" + this.codEmpresa;
    }
}
