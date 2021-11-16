package Leyendo;

public class Acceso_Fichero {
    
    public static void main(String[] args) {
        String archivo = "C:\\Flujo\\Leyendo\\fichero.txt";
        LeerFichero accediendo = new LeerFichero(archivo);
        accediendo.leer();
    }
}

