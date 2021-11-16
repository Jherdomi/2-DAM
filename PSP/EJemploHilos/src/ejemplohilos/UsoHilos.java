package ejemplohilos;

public class UsoHilos {

    public static void main(String[] args) {
        
        String nombre = null;
        
        MiHilo hilo = new MiHilo(nombre);
        
        Thread hiloMIO = new Thread();
        
        hilo.run();
        
    }
    
}
