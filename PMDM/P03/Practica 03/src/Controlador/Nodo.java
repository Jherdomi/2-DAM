/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


/**
 *
 * @author alumno
 */
public class Nodo<T> {
    
    //Atributos
    private T dato;
    private Nodo sig;
    private Nodo ant;
    
    //Constructor
    public Nodo(T dato){
        this.dato = dato;
        
    }
    
    public Nodo(T dato, Nodo sig, Nodo ant){
        this.dato = dato;
        this.sig = null;
        this.ant = null;
    }
    
    /*Getters y Setters*/
    
    public void setDato(T dato){
        this.dato = dato;
    }
    
    public T getDato(){
        return this.dato;
    }
    
    public void setSig(Nodo sig){
        this.sig = sig;
    }
    
    public Nodo getSig(){
        return this.sig;
    }
    
    public void setAnt(Nodo ant){
        this.ant = ant;
    }
    
    public Nodo getAnt(){
        return this.ant;
    }
    
    /*Método Boolean que determinan ue hay nodo siguiente o anterior*/
    
    //Servirán para saber cuando no hay datos antes o después del nodo 
    //actual en la vista
    
    public boolean tieneSig(){
        return this.sig != null;
    }
    
    public boolean tieneAnt(){
        return this.ant != null;
    }
    
}
