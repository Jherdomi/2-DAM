/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;


/**
 *
 * @author alumno
 */
public class Nodo<T> {
    
    //Atributos
    private T dato; //Objeto genérico de cuenta
    private int clave; //Índice
    
    
    //Constructor
    public Nodo(int indice, T dato){
        clave = indice;
        this.dato = dato;
    }
    
    /*Getters y Setters*/
    public void setDato(T dato){
        this.dato = dato;
    }
    
    public T getDato(){
        return this.dato;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }


}
