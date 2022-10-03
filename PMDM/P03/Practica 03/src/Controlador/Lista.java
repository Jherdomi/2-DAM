/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;

/*
-Primer Nodo
-Avanza y retrocede la lista
-Añade nodos
*/
public class Lista {
    //Añadimos el nodo inicial y el actual
    private Nodo inicio;
    private Nodo actual;
    
    
    //Funciones que añaden un nodo
    public void agregarNodo(Nodo n){
        /*
        Si el primer elemento es null, significa que no hay elementos 
        y por lo tanto añadimos directamente
        Si no, se añade al principio de la lista
        */
        
        if(this.inicio == null){
            this.inicio = n;
        }else{
            n.setSig(this.inicio);//Hacemos que el inicio pase
            this.inicio.setAnt(n);//Hacemos que el nodo sea el anterior
            this.inicio = n;
            resetarList();
        }
    }
    
    public void crearNodo(Cuenta c){
        /*
        Esta función recoge un objeto genérico y lo introduce a la estructura
        Una vez se crea, se llama a agregarNodo para que se añada a la estructura
        */
        
        Nodo n = new Nodo(c);
        agregarNodo(n);
    }
    
    //Funciones de movilidad entre nodos
    
    public Nodo primero(){
        return inicio;
    }
    
    public Nodo fin(){
        Nodo n = actual;
        while(n.getSig() != null){
            n = n.getSig();
        }
        return n;
    }
    
    public void resetarList(){
        actual = inicio;
    }
    
    public Nodo getActual(){
        return this.actual;
    }
    
    public void sig(){
        //Avanza el dato actual
        actual = actual.getSig();        
    }
    
    public void ant(){
        //Retrocede el dato actual
        actual = actual.getAnt();
    }
    
    public Cuenta getDato(){
        return (Cuenta) actual.getDato();
    }
    
    public boolean tieneSiguiente() {
        return actual.tieneSig();
    }
    
    public boolean tieneAnterior() {
        return actual.tieneAnt();
    }
    
}
