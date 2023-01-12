package Modelo;

public class Asignacion {
    private int pirata;
    private int arma;
    private float coste;

    public Asignacion(int pirata, int arma, float coste) {
        this.pirata = pirata;
        this.arma = arma;
        this.coste = coste;
    }

    public int getPirata() {
        return pirata;
    }

    public void setPirata(int pirata) {
        this.pirata = pirata;
    }

    public int getArma() {
        return arma;
    }

    public void setArma(int arma) {
        this.arma = arma;
    }

    public float getCoste() {
        return coste;
    }

    public void setCoste(float coste) {
        this.coste = coste;
    }
    
    
}
