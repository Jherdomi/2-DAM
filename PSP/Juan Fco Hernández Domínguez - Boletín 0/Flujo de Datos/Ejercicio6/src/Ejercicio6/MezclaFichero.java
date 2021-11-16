package Ejercicio6;

import java.io.*;

public class MezclaFichero {
    
    public static void main(String args[]) {
        
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(flujo);
        
        String rutaArchivo1 = "";
        String rutaArchivo2 = "";
        String rutaMezcla = "";
        
        try {
            System.out.println("Introduzca la ruta al 1º archivo.");
            rutaArchivo1 = lector.readLine();
            System.out.println("Introduzca la ruta al 2º archivo");
            rutaArchivo2 = lector.readLine();
            System.out.println("Introducir la ruta y el nombre del fichero destino");
            rutaMezcla = lector.readLine();
        }
        catch(IOException e) {
            System.out.println("No válido.");
        }
        
        mezclar(rutaArchivo1, rutaArchivo2, rutaMezcla);
    }

    private static void mezclar(String rutaArchivo1, String rutaArchivo2, String rutaMezcla) {
        File    archivo1 = new File(rutaArchivo1),
                archivo2 = new File(rutaArchivo2),
                archMezcla = new File(rutaMezcla);
        
        try {
            
            if (!archMezcla.exists()) archMezcla.createNewFile();
            
            
            BufferedReader  lec1 = new BufferedReader(new FileReader(archivo1)),
                            lec2 = new BufferedReader(new FileReader(archivo2));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archMezcla));
            
            
            String cad1 = lec1.readLine();
            String cad2 = lec2.readLine();
            boolean flag = true;
           
            while (cad1 != null || cad2 != null) {
                if (flag) {
                    if (cad1 != null) {
                        escritor.append(cad1 + "\n");
                        cad1 = lec1.readLine();
                    }
                    flag = false;
                }
                else {
                    if (cad2 != null) {
                        escritor.append(cad2 + "\n");
                        cad2 = lec2.readLine();
                    }
                    flag = true;
                }
            }
            
            lec1.close();
            lec2.close();
            escritor.close();
        }
        catch (IOException e) {
            System.out.println("No válido.");
        }
        
        System.out.println("La mezcla se ha realizado correctamente.");    
    }
}
