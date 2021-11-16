package Directorios;

import java.io.*;

public class copiarDirectorio {
    public static void main(String args[]) {
        
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(flujo);
        
        try {
            System.out.println("Introduce la ruta en la que se encuentra: ");
            String rutaEncuentra = lector.readLine();
            System.out.println("Introduce la ruta deseada: ");
            String rutaFinal = lector.readLine();
            
            copiarRama(rutaEncuentra, rutaFinal);
            
            lector.close();
            flujo.close();
        }
        catch(IOException ex) {System.out.println("No válido.");}
    }
    
    public static void copiarRama(String rutaOrigen, String rutaDestino) {
        File    origen = new File(rutaOrigen),
                destino = new File(rutaDestino),
                actual = new File(rutaOrigen);
        
        if (!destino.exists()) {
            try {destino.createNewFile();}
            catch(Exception e) {System.out.println("No válido.");}
        }
        
        copiarDirectorio.copiarDirectorio(actual, destino);
        
    }

    private static void copiarDirectorio(File actual, File destino) {
        for(File f: actual.listFiles()) {
            if(f.isDirectory()) {
                File des = new File(destino.getPath() + "\\" + f.getName());
                if(!des.exists()) {
                    try {des.mkdir();}
                    catch(Exception ex) {System.out.println("No válido.");}
                }
                
                copiarDirectorio(f, des);
            }
            if(f.isFile())
                copiarArchivo(f, destino);
        }
    }

    private static void copiarArchivo(File f, File destino) {
        File copia = new File(destino.getPath() + "\\" + f.getName());
        
        if (!copia.exists()) {
            try {
                copia.createNewFile();
            }
            catch(Exception e) {System.out.println("No válido.");}
        }
        
        try {
            FileInputStream lector = new FileInputStream(f);
            FileOutputStream escritor = new FileOutputStream(copia);
            
            escritor.write(lector.readAllBytes());
            
            lector.close();
            escritor.close();
        }
        
        catch (Exception ex) {System.out.println("No válido.");}
    }
}
