package Leyendo;

public class Acceso_Fichero {
    public static void main(String args[]) {
        String archivo = "C:\\Flujo\\Ejercicio3\\fichero.txt";
        Leer_Fichero accediendo = new Leer_Fichero(archivo);
        accediendo.leer();
    }
}
