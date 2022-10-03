/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg01;

/**
 *
 * @author alumno
 */
public class Automovil {
    
    private String marca;
    private String modelo;
    private int precio;
    
    /*****************************************************************************/
    
    public Automovil(String Marca, String Modelo){
        this.marca = Marca;
        this.modelo = Modelo;
        this.precio = 0;
    }
    
    public Automovil(String Marca, String Modelo, int Precio){
        this.marca = Marca;
        this.modelo = Modelo;
        this.precio = Precio;
    }
    
    /*****************************************************************************/
    
    public void setMarca(String Marca){
        this.marca = Marca;
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    public void setModelo(String Modelo){
        this.modelo = Modelo;
    }
    
    public String getModelo(){
        return this.modelo;
    }
    
    public void setPrecio(int Precio){
        this.precio = Precio;
    }
    
    public int getPrecio(){
        return this.precio;
    }
    
    /*****************************************************************************/
    
    @Override
    public String toString(){
        
        String cad = this.marca + "*" + this.modelo + "*" + this.precio;
        
        return cad;
        
    }
}


