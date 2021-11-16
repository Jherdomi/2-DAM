package javaapplication4;

import java.io.*;

public class Main {
    

    public Main() {
    }

    public static void main(String[] args) {

        Runtime r = Runtime.getRuntime();
        String comando="CMD /C DATE ";

               Process p=null;

               try {

                   p=r.exec(comando);


                   OutputStream os = p.getOutputStream();
                   os.write("15/10/21".getBytes());
                   os.flush(); 

                   InputStream is = p.getInputStream();
                   BufferedReader br = new BufferedReader (new InputStreamReader(is));
                   String linea;

                   while((linea=br.readLine())!=null)

                   System.out.println(linea);
                   br.close();

               } catch (Exception e) { 
                   e.printStackTrace();
               }

               int exitVal;

               try {

                   exitVal = p.waitFor();
                   System.out.println("Valor de salida: " + exitVal);

               } catch (InterruptedException e){
                   e.printStackTrace();

               }

    }
    
}
