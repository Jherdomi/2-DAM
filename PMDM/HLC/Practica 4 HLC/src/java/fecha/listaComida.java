package fecha;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class listaComida {    
    private String nombre;
    private String foto;
    private int calorias;
    private  GregorianCalendar fecha;
    public String pais;
   
    public listaComida(){
        
    }

    public listaComida(String nombre, String foto, int calorias, GregorianCalendar fechaInvencion) {
        this.nombre = nombre;
        this.foto = foto;
        this.calorias = calorias;
        this.fecha = fechaInvencion;
    }
    
    public String getFecha() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = dateFormat.format(fecha.getTime());
        
        return fechaFormateada;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }    

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
