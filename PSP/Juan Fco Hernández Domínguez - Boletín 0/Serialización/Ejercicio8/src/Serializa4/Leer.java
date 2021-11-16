package Serializa4;

import java.io.*;

public class Leer {

    public static void imprimeMensaje(String mensaje) {
        System.out.print(mensaje + " ");
        System.out.flush();
    }

    public static String dato() {
        String sdato = "";
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader flujoE = new BufferedReader(isr);
            sdato = flujoE.readLine();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return sdato; 
    }

    public static short datoShort() {
        try {
            return Short.parseShort(dato());
        } catch (NumberFormatException e) {
            return Short.MIN_VALUE;
        }
    }

    public static int datoInt(String mensaje) {
        while (true) {
            imprimeMensaje(mensaje);
            try {
                return Integer.parseInt(dato());
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Introduzca un número por favor.");
            }
        }
    }

    public static long datoLong() {
        try {
            return Long.parseLong(dato());
        } catch (NumberFormatException e) {
            return Long.MIN_VALUE; 
        }
    }

    public static float datoFloat() {
        try {
            return Float.parseFloat(dato());
        } catch (NumberFormatException e) {
            return Float.NaN; 
        }
    }

    public static double datoDouble() {
        try {
            return Double.parseDouble(dato());
        } catch (NumberFormatException e) {
            return Double.NaN; 
        }
    }
}
