/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import static Modelo.CuentaInversion.random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class Lista<T> {
    
    Nodo list[]; //Array de datos
    
    
    public Lista(int x){
        list = new Nodo[x]; //Establecer el tamaño del array
    }
    
    public int nodoVacio(){ //recorre la lista
        
        for(int i  = 0; i<this.getList().length;i++){
            
            if(this.getList()[i] == null){
                return i; //de vuelve la posición en la que se puede insertar datos
            }
            
        }
        
        return this.getList().length; //si no de vuelve la longitud de la lista
    }
    
    //Funciones que crea y añade un nodo
    public void insertarNodo(int indice, T objeto){ //función que inserta un nodo
        
        Nodo n = new Nodo(indice, objeto); //se le pasa un indice y una cuenta
        list[this.nodoVacio()] = n; //se inserta el nodo, en la posición vacía
        
    }
    
    public void mostrarLista(){ //Mostramos la lista 
        for(int i = 0; i < this.nodoVacio(); i++){
            
            System.out.println(this.getList()[i].getDato().toString());
            
        }
    }

    //Métodos getters y setters de la clase nodo
    
    public Nodo[] getList() {
        return list;
    }

    public void setList(Nodo[] list) {
        this.list = list;
    }
    
    //Método que rellena la lista con 100000 posiciones
    
    public void rellenarLista(Lista lista){
        Lista nueva = new Lista(100000); //creo una nueva lista de 10000 posiciones
        for(int i = 0; i < lista.nodoVacio(); i++){
            nueva.getList()[i] = lista.getList()[i]; //a la nueva lista, le asigno el nodo obtenidos la lista
        }
        nueva.completar(); //una vez recorrida la lista, completo con más cuentas
        this.setList(nueva.getList()); //establezco una nueva posición de la lista
    }
    
    public ArrayList<Nodo> getArray(){ //método que devuelve un arayList como Array
        return new ArrayList(Arrays.asList(this.getList()));
    }

    private void completar() { //método que creqa cuentas aleatorias 
        
        for(int i = this.nodoVacio(); i < this.list.length; i++){
            switch(random(1,3)){
                case 1:
                    CuentaAhorro ca = new CuentaAhorro();
                    this.insertarNodo(ca.getNumeroCuenta(), (T) ca);
                    break;
                case 2: 
                    CuentaInversion ci = new CuentaInversion();
                    this.insertarNodo(ci.getNumeroCuenta(), (T) ci);
                    break;
                case 3:
                    CuentaCorriente cc = new CuentaCorriente();
                    this.insertarNodo(cc.getNumeroCuenta(), (T) cc);
                    break;
            }
        }   
    }
    
    public void ordenarLista(Lista l){
        Nodo aux[] = new Nodo[10];
        for (int x = 0; x < l.getList().length; x++) {
            // Aquí "y" se detiene antes de llegar
            // a length - 1 porque dentro del for, accedemos
            // al siguiente elemento con el índice actual + 1
            for (int y = 0; y < l.getList().length - 1; y++) {
                int elementoActual = l.getList()[y].getClave(),
                    elementoSiguiente = l.getList()[y + 1].getClave();
                if (elementoActual > elementoSiguiente) {
                    // Intercambiar
                    aux[0] = l.getList()[y];
                    l.getList()[y] = l.getList()[y+1];
                    l.getList()[y + 1] = aux[0];
                }   
            }
            
        }
        
        this.setList(l.getList());
    }
}
