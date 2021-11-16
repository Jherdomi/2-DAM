package Boletin3;

import java.io.*;
import static java.lang.Runtime.getRuntime;

public class Ejercicio4 {
    public static void main(String[] args) {
        Runtime r = getRuntime();
        Process cmd;
        String cad;
        
        try {
            cmd = r.exec("cmd /c echo Introduzca una cadena: ");
            
            BufferedReader lector = new BufferedReader(new InputStreamReader(cmd.getInputStream()));
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println(lector.readLine());
            cad = teclado.readLine();
            
            System.out.println("La cadena es: ");
            System.out.println(cad);
            
            lector.close();
            teclado.close();
        } catch (IOException ex) {
            System.out.println("No valido.");
        }
    }
}
