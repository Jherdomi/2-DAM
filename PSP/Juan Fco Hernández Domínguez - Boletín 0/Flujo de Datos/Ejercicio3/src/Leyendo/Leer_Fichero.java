package Leyendo;

import java.io.*;

public class Leer_Fichero {
    File fichero;
    
    
    public Leer_Fichero(String archivo) {
        fichero = new File(archivo);
        
        if (!fichero.exists()) try {
            fichero.createNewFile();
        } catch (IOException ex) {
            System.out.println("No válido.");
        }
    }
    
    public void leer() {
        BufferedReader flujo;
        try {
            String cad;
            flujo = new BufferedReader(new FileReader(fichero));
            if (fichero.exists())
            {
                System.out.println("\n\nInformación del fichero: ");
                cad = flujo.readLine();
                while (cad != null)
                {
                    if (!cad.equals("\n"))
                        System.out.println(cad);
                    
                    cad = flujo.readLine();
                }
            }
            flujo.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: archivo inexistente.");
        } catch (IOException ex) {
            System.out.println("ERROR: No se ha podido leer el archivo.");
        }
    }
    
    
}
