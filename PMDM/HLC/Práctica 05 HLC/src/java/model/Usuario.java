package model;
// Generated 01-mar-2023 14:15:11 by Hibernate Tools 4.3.1


import java.util.Date;


public class Usuario  implements java.io.Serializable {


     private int numero;
     private String nombre;
     private String apellido;
     private String password;
     private Date fechanacimiento;
     private String foto;

    public Usuario() {
    }

	
    public Usuario(int numero) {
        this.numero = numero;
    }
    public Usuario(int numero, String nombre, String apellido, String password, Date fechanacimiento, String foto) {
       this.numero = numero;
       this.nombre = nombre;
       this.apellido = apellido;
       this.password = password;
       this.fechanacimiento = fechanacimiento;
       this.foto = foto;
    }
   
    public int getNumero() {
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getFechanacimiento() {
        return this.fechanacimiento;
    }
    
    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    public String getFoto() {
        return this.foto;
    }
    
    public void setFoto(String foto) {
        this.foto = foto;
    }




}


