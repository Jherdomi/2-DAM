package escribiendo;

public class AccesoFichero {
    public static void main(String args[]) {
        String ruta = "C:\\Flujo\\Ejercicio2\\Desktop";
        String archivo = "fichero.txt";
        
        Copia_Ficheros copia = new Copia_Ficheros(ruta, archivo);
    }
}