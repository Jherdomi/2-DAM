package javaapplication3;

import java.io.*;

public class Main {
    
    
    public Main() {
    }

    public static void main(String[] args) {
                   Runtime r = Runtime.getRuntime();

            String comando = "NOTEPAD";

            Process p = null;

            try {

                p = r.exec(comando);

            
            InputStream is = p.getInputStream();
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(is)); 

            String linea;

            while ((linea=br.readLine())!=null) 

                System.out.println(linea);

            br.close();

            } catch (Exception e) {

                System.out.println("Error en: "+comando);
                e.printStackTrace();
            }
    }
    
}
