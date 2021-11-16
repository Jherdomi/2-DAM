package prac3.Lista;

public class Lista {
    
    //Atributos
    private Nodo Principio;
    private Nodo iter;
    
    public void agregarDato(Nodo nodo){
        
        if(Principio == null){
            Principio = nodo;
            resetIter();
        }else{
            nodo.setSiguiente(Principio);
            Principio.setAnterior(nodo);
            Principio = nodo;
            resetIter();
        }
        
    }
    
    public void borrarDato(Nodo nodo){
        
        resetIter();
        while(iter.getSiguiente() != null) {
            if (iter == nodo) {
                iter.getSiguiente().setAnterior(iter.getAnterior());
                iter.getAnterior().setSiguiente(iter.getSiguiente());
                resetIter();
                System.gc();
                break;
            }
            iter = iter.getSiguiente();
        }
        resetIter();
        
    }
    
    public void crearNodo(Nodo nodo){
        Nodo nuevoNodo = new Nodo(nodo);
        agregarDato(nuevoNodo);
    }
    
    public boolean comprobarSiguiente(){
        return iter.comprobarSiguiente();
    }
    
    public boolean comprobarAnterior(){
        return iter.comprobarAnterior();
    }
    
    public void Siguiente(){
        iter = iter.getSiguiente();
    }
    
    public void atras(){
        iter = iter.getAnterior();
    }
    
    public Nodo esPrimero(){
        return Principio;
    }
    
    public Nodo fin() {
        Nodo aux = iter;
        
        while(aux.getSiguiente() != null){
            aux = aux.getSiguiente();
        }
        
        return aux;
    }
    
    public Empleado sacarDatos(){
        return (Empleado) iter.getEmpleado();
    }
    
    public boolean esVacio(){
        return Principio == null;
    }
    
    public void resetIter(){
        iter = Principio;
    }
    
    public Nodo getActual(){
        return this.iter;
    }
    
    
}
