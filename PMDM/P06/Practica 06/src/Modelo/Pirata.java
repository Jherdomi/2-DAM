package Modelo;

import Controlador.DateParse;
import java.util.Date;
import java.util.GregorianCalendar;

public class Pirata {
    private int codPirata;
    private String nomPirata;
    private String apePirata;
    private GregorianCalendar fechaIncorporacion;
    private String foto;
    private int asesinatos;
    private int capitan;
    private int codigoBanda;
    private int codigoArma;
    
    public String error = "";

    public Pirata(int codPirata, String nomPirata, String apePirata, GregorianCalendar fechaIncorporacion, String foto, int asesinatos, int capitan, int codigoBanda, int codigoArma) {
        this.codPirata = codPirata;
        this.nomPirata = nomPirata;
        this.apePirata = apePirata;
        this.fechaIncorporacion = fechaIncorporacion;
        this.foto = foto;
        this.asesinatos = asesinatos;
        this.capitan = capitan;
        this.codigoBanda = codigoBanda;
        this.codigoArma = codigoArma;
    }

    public int getCodPirata() {
        return codPirata;
    }

    public void setCodPirata(int codPirata) {
        this.codPirata = codPirata;
    }

    public String getNomPirata() {
        return nomPirata;
    }

    public void setNomPirata(String nomPirata) {
        this.nomPirata = nomPirata;
    }

    public String getApePirata() {
        return apePirata;
    }

    public void setApePirata(String apePirata) {
        this.apePirata = apePirata;
    }

    public GregorianCalendar getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(GregorianCalendar fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getAsesinatos() {
        return asesinatos;
    }

    public void setAsesinatos(int asesinatos) {
        this.asesinatos = asesinatos;
    }

    public int getCapitan() {
        return capitan;
    }

    public void setCapitan(int capitan) {
        this.capitan = capitan;
    }

    public int getCodigoBanda() {
        return codigoBanda;
    }

    public void setCodigoBanda(int codigoBanda) {
        this.codigoBanda = codigoBanda;
    }

    public int getCodigoArma() {
        return codigoArma;
    }

    public void setCodigoArma(int codigoArma) {
        this.codigoArma = codigoArma;
    }
    
    public String getFechaString() {
        return DateParse.gregorianCalendarToString(fechaIncorporacion);
    }
    
    public String getError(){
        return error;
    }
    
    @Override
    public String toString() {
        return codPirata + ", '" + nomPirata + "', '" + apePirata + "', '" + getFechaString() + "', " + foto + ", " + asesinatos + ", " + capitan + ", " + codigoBanda + ", " + codigoArma;
    }
}
