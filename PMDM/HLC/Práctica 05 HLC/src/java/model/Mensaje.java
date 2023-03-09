package model;
// Generated 01-mar-2023 14:15:11 by Hibernate Tools 4.3.1


import java.util.Date;

public class Mensaje  implements java.io.Serializable {


     private int numero;
     private String asunto;
     private String contenido;
     private Integer leido;
     private Date fecha;
     private Integer cuecodigoorigen;
     private Integer cuecodigodestino;

    public Mensaje() {
    }

	
    public Mensaje(int numero) {
        this.numero = numero;
    }
    public Mensaje(int numero, String asunto, String contenido, Integer leido, Date fecha, Integer cuecodigoorigen, Integer cuecodigodestino) {
       this.numero = numero;
       this.asunto = asunto;
       this.contenido = contenido;
       this.leido = leido;
       this.fecha = fecha;
       this.cuecodigoorigen = cuecodigoorigen;
       this.cuecodigodestino = cuecodigodestino;
    }
   
    public int getNumero() {
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getAsunto() {
        return this.asunto;
    }
    
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public String getContenido() {
        return this.contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public Integer getLeido() {
        return this.leido;
    }
    
    public void setLeido(Integer leido) {
        this.leido = leido;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Integer getCuecodigoorigen() {
        return this.cuecodigoorigen;
    }
    
    public void setCuecodigoorigen(Integer cuecodigoorigen) {
        this.cuecodigoorigen = cuecodigoorigen;
    }
    public Integer getCuecodigodestino() {
        return this.cuecodigodestino;
    }
    
    public void setCuecodigodestino(Integer cuecodigodestino) {
        this.cuecodigodestino = cuecodigodestino;
    }




}


