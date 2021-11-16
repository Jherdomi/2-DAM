package escribiendo;

import java.io.*;


public class Copia_Ficheros {
    File copiaFichero;
    
    public Copia_Ficheros(String ruta, String nombreFichero) {
        File ficheroOriginal = new File(ruta + "\\" + nombreFichero);
        this.copiaFichero = new File(ruta + "\\" 
                + nombreFichero.substring(0, nombreFichero.length() - 4)
                + "-copia.txt");
        
        if (!this.copiaFichero.exists() || !ficheroOriginal.exists()) try {
            this.copiaFichero.createNewFile();
            ficheroOriginal.createNewFile();
        } catch (IOException ex) {
            System.out.println("Oops.");
        }
        /**
         * Tenemos que crear dos flujos:
         * Uno para leer del archivo que queremos copiar.
         * Otro para escribir en el archivo al que queremos copiar.
         */
        copiarFichero(ficheroOriginal, copiaFichero);
        
        System.out.println("Archivo original: " + nombreFichero);
        LeerFichero original = new LeerFichero(ficheroOriginal);
        original.lee();
        
        System.out.println("Archivo copia: " + this.copiaFichero.getName());
        LeerFichero copia = new LeerFichero(this.copiaFichero);
        copia.lee();
    }

    private void copiarFichero(File fichero, File copiaFichero) {
        BufferedWriter flujoEscritura;
        BufferedReader flujoLectura;
        try {
            String cadena;
            flujoLectura = new BufferedReader(new FileReader(fichero));
            
            flujoEscritura = new BufferedWriter(new FileWriter(copiaFichero));
            if (fichero.exists())
            {
                    
                cadena = flujoLectura.readLine();
                while (cadena != null)
                {
                    flujoEscritura.append(cadena.subSequence(0, cadena.length()) + "\n");
                    cadena = flujoLectura.readLine();
                }
            }
            flujoLectura.close();
            flujoEscritura.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: Archivo inexistente.");
        } catch (IOException ex) {}
    }
}