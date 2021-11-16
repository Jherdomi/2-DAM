package Serializa4;

public class Nota {
    
    
    private int nota;
    private String materia;

    public Nota(String materia) {
        this.nota=0;
        this.materia=materia;
    }

    public int getNota() {
        return this.nota;
    }

    public void setNota(int valor) {
        this.nota = valor;
    }

    public String getMateria() {
        return this.materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    @Override
    public String toString(){
        return "La nota en " + this.materia + "es " + this.nota;
    }

    
}
