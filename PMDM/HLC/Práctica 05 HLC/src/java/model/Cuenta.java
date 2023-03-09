package model;
// Generated 01-mar-2023 14:15:11 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

public class Cuenta  implements java.io.Serializable {


     private int codigo;
     private String email;
     private Date fechaalta;
     private Integer maximomensajes;
     private BigDecimal costemensajeextra;
     private Integer usunumero;

    public Cuenta() {
    }

	
    public Cuenta(int codigo) {
        this.codigo = codigo;
    }
    public Cuenta(int codigo, String email, Date fechaalta, Integer maximomensajes, BigDecimal costemensajeextra, Integer usunumero) {
       this.codigo = codigo;
       this.email = email;
       this.fechaalta = fechaalta;
       this.maximomensajes = maximomensajes;
       this.costemensajeextra = costemensajeextra;
       this.usunumero = usunumero;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getFechaalta() {
        return this.fechaalta;
    }
    
    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }
    public Integer getMaximomensajes() {
        return this.maximomensajes;
    }
    
    public void setMaximomensajes(Integer maximomensajes) {
        this.maximomensajes = maximomensajes;
    }
    public BigDecimal getCostemensajeextra() {
        return this.costemensajeextra;
    }
    
    public void setCostemensajeextra(BigDecimal costemensajeextra) {
        this.costemensajeextra = costemensajeextra;
    }
    public Integer getUsunumero() {
        return this.usunumero;
    }
    
    public void setUsunumero(Integer usunumero) {
        this.usunumero = usunumero;
    }




}


