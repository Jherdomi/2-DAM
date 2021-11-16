package Boletin3;

import java.io.*;

public class Ejercicio2 {

    public static void main(String[] args) throws IOException {
        final String comandos[] =  {"java", "-jar", "Boletin3.jar"};
        ProcessBuilder pb = new ProcessBuilder(comandos);
        BufferedReader br;
        Process p;
        String linea;
        try {
            pb.directory(new File("/home/alumno/Documentos/Boletin3/dist/"));
           
            p = pb.start();
            InputStream is = p.getInputStream();
            
            br = new BufferedReader(new InputStreamReader(is));            
            
            while ((linea = br.readLine()) != null) {

                System.out.println(linea);
            }
            br.close();
            
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
