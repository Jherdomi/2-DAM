package javaapplication5;

import java.io.*;
import java.util.*;

public class Main {

    public static void main (String args[]) {
        
        ProcessBuilder test = new ProcessBuilder();

        Map entorno = test.environment();

        System.out.println("Las variables de entorno son:");

        System.out.println(entorno);

        test = new ProcessBuilder("java","Unsaludo", "\"Hola Mundo!!\"");

        List l = test.command();

        Iterator iter = l.iterator();

        System.out.println("Argumentos del comando");

        while (iter.hasNext())

            System.out.println(iter.next());

        test = test.command("CMD","/C","DIR");

        try {

            Process p= test.start();

            InputStream is = p.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader (is));

            String linea;

            while((linea=br.readLine())!=null) 
                System.out.println(linea);

            br.close();

        }catch(Exception e){

            e.printStackTrace();

        }

    }
}
