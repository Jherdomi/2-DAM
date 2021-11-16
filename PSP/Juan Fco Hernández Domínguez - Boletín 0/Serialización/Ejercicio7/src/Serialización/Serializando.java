package Serialización;

import java.io.*;

public class Serializando implements Serializable {
    
    public static void main(String args[]) {
        
        File info = new File("C:\\Flujo\\Ejercicio7\\empleados.dat");
        
        if (!info.exists()) try {
            info.createNewFile();
        } catch (IOException ex) {
            System.out.println("No válido.");
        }
        
        Empleado emp1 = new Empleado("Juan López", 1500, 2000);
        
        try {
            
            ObjectOutputStream escribirFichero = new ObjectOutputStream(
            new FileOutputStream(info));
            escribirFichero.writeObject(emp1);
            escribirFichero.close();
            
          
            ObjectInputStream recuperarFichero = new ObjectInputStream(
            new FileInputStream(info));
            Empleado personal_recuperado = (Empleado) recuperarFichero.readObject();
            recuperarFichero.close();
            
            
            System.out.println(personal_recuperado);
        }
        catch(Exception ex) {System.out.println("No válido.");}
    }
}
