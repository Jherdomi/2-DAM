package prac3.Lista;


public class Nodo<Empleado> {
    
    //Atributos
    private Empleado objeto;
    private Nodo Siguiente;
    private Nodo Anterior;
    
    //Constructor
    public Nodo(Empleado obj){
        this.objeto = obj;
    }
    
    /***********************************************************************************/
    
    public void setEmpleado(Empleado obj){
        this.objeto = obj;
    }
    
    public Empleado getEmpleado(){
        return this.objeto;
    }
    
    /***********************************************************************************/
    
    public void setSiguiente(Nodo sig){
        this.Siguiente = sig;
    }
    
    public Nodo getSiguiente(){
        return this.Siguiente;
    }
    
    /***********************************************************************************/
    
    public void setAnterior(Nodo ant){
        this.Anterior = ant;
    }
    
    public Nodo getAnterior(){
        return this.Anterior;
    }
    
    /***********************************************************************************/
    
    public boolean comprobarSiguiente(){
        return this.Siguiente != null;
    }
    
    public boolean comprobarAnterior(){
        return this.Anterior != null;
    }
}
