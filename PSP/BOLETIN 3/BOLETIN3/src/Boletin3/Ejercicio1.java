package Boletin3;

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        
        Runtime r = Runtime.getRuntime();
        Process p = null;
        String ruta = "/home/alumno";
        
        try {
            p = r.exec("ls -a " + ruta);

            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            
            while ((linea = br.readLine()) != null) {
                
                System.out.println(linea);
            }
            
            br.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
