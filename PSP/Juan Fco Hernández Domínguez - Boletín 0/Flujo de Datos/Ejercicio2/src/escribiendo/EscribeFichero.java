package escribiendo;

import java.io.*;

public class EscribeFichero {
    File fichero;
    
    public EscribeFichero(String archivo) {
        fichero = new File(archivo);
        
        if (!fichero.exists()) try {
            fichero.createNewFile();
        } catch (IOException ex) {
            System.out.println("ERROR: No válido.");
        }
    }
    
    public void escribe() {
        BufferedWriter flujo;
        try {
            flujo = new BufferedWriter(new FileWriter(fichero));
            if (fichero.exists())
            {
                for (int i = 0; i < 10; i++ ) {
                    String cad = "Línea " + (i) + "\n";
                    flujo.append(cad.subSequence(0, cad.length()));
                }
            }
            flujo.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: Archivo inexistente.");
        } catch (IOException ex) {
            System.out.println("ERROR: No se ha podido escribir.");
        }
    }
}
