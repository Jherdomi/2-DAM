package Modelo;

public class Arma {
    private int codArma;
    private String nomArma;

    public Arma(int codArma, String nomArma) {
        this.codArma = codArma;
        this.nomArma = nomArma;
    }

    public int getCodArma() {
        return codArma;
    }

    public void setCodArma(int codArma) {
        this.codArma = codArma;
    }

    public String getNomArma() {
        return nomArma;
    }

    public void setNomArma(String nomArma) {
        this.nomArma = nomArma;
    }
    
    
}
