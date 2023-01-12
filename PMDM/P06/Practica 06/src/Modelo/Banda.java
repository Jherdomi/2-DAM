package Modelo;

import Controlador.DateParse;
import java.util.Date;
import java.util.GregorianCalendar;

public class Banda {
    private int codBanda;
    private String nomBanda;
    private int totMiembros;
    private int numTesoros;
    private GregorianCalendar fechaCreacion;
    private String contrasena;

    public Banda(int codBanda, String nomBanda, int totMiembros, int numTesoros, GregorianCalendar fechaCreacion, String contrasena) {
        this.codBanda = codBanda;
        this.nomBanda = nomBanda;
        this.totMiembros = totMiembros;
        this.numTesoros = numTesoros;
        this.fechaCreacion = fechaCreacion;
        this.contrasena = contrasena;
    }

    public int getCodBanda() {
        return codBanda;
    }

    public void setCodBanda(int codBanda) {
        this.codBanda = codBanda;
    }

    public String getNomBanda() {
        return nomBanda;
    }

    public void setNomBanda(String nomBanda) {
        this.nomBanda = nomBanda;
    }

    public int getTotMiembros() {
        return totMiembros;
    }

    public void setTotMiembros(int totMiembros) {
        this.totMiembros = totMiembros;
    }

    public int getNumTesoros() {
        return numTesoros;
    }

    public void setNumTesoros(int numTesoros) {
        this.numTesoros = numTesoros;
    }

    public GregorianCalendar getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(GregorianCalendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public String fechaToString(){
          return DateParse.gregorianCalendarToString(fechaCreacion);
    }
    
}
