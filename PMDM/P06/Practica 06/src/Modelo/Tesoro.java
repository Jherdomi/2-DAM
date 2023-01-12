package Modelo;

public class Tesoro {
    
    private int codTesoro;
    private String nomTesoro;
    private int bandaPertenece;

    public Tesoro(int codTesoro, String nomTesoro, int bandaPertenece) {
        this.codTesoro = codTesoro;
        this.nomTesoro = nomTesoro;
        this.bandaPertenece = bandaPertenece;
    }

    public int getCodTesoro() {
        return codTesoro;
    }

    public void setCodTesoro(int codTesoro) {
        this.codTesoro = codTesoro;
    }

    public String getNomTesoro() {
        return nomTesoro;
    }

    public void setNomTesoro(String nomTesoro) {
        this.nomTesoro = nomTesoro;
    }

    public int getBandaPertenece() {
        return bandaPertenece;
    }

    public void setBandaPertenece(int bandaPertenece) {
        this.bandaPertenece = bandaPertenece;
    }
    
    
}
