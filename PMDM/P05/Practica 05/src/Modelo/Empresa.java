package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author alumno
 */
public class Empresa {
    private int codEmpresa;
    private String nomEmpresa;
    private static float totSal;
    private Date fechaCreacion;
    private String contraseña;
    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    
    public Empresa(int codEm, String nomEm, float totSal, Date fecha, String contra){
        setCodEmpresa(codEm);
        setNomEmpresa(nomEm);
        setTotSal(totSal);
        setFechaCreacion(fecha);
        setContraseña(contra);
        
    }

    public int getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public static float getTotSal() {
        return totSal;
    }

    public static void setTotSal(float totSal) {
        Empresa.totSal = totSal;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fecha) {
        this.fechaCreacion = fecha;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    @Override
    public String toString(){
        return "E" + "*" + this.codEmpresa + "*" + this.nomEmpresa + "*" + 
                Empresa.totSal +"*"+ this.fechaCreacion +"*"+ this.contraseña;
    }
}
