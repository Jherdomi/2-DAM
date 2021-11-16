package javaapplication2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class JavaApplication2 {

    public printOutput getStreamWrapper(InputStream is, String type) {

        return new printOutput(is, type);
        

    }

    public static void main(String[] args) {

        Runtime rt = Runtime.getRuntime();
        JavaApplication2 rte = new JavaApplication2();
        printOutput errorReported, outputMessage;
        Process p = null;

        try {

            Process proc = rt.exec("mkdir /home/alumno/carpetita");

        } catch (IOException e) {

            e.printStackTrace();

            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader (new InputStreamReader(is));
            String linea;
        }

        try {

            Process proc = rt.exec("ls -ltra /home/alumno ");
            
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader (new InputStreamReader(is));
            String linea;

        } catch (IOException e) {

            e.printStackTrace(); 

        }

        try {

            Process proc = rt.exec("ping google.es");
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader (new InputStreamReader(is));
            String linea;

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    private class printOutput extends Thread {

        InputStream is = null;

        printOutput(InputStream is, String type) {

            this.is = is;

        }

        public void run() {

            String s = null;

            try {

                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                while ((s = br.readLine()) != null) {
                    System.out.println(s);
                }

            } catch (IOException ioe) {

                ioe.printStackTrace();

            }

        }

    }
}