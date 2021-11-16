package escribiendo;

import java.io.*;


public class LeerFichero {
    File fichero;
    
    
    public LeerFichero(String archivo) {
        this.fichero = new File(archivo);
        
        if (!this.fichero.exists()) try {
            this.fichero.createNewFile();
        } catch (IOException e) {
            System.out.println("No válido.");
        }
    }
    
    public LeerFichero(File archivo) {
        this.fichero = archivo;
    }
    
    public void lee() {
        BufferedReader flujo;
        try {
            String cad;
            flujo = new BufferedReader(new FileReader(fichero));
            if (fichero.exists())
            {
                cad = flujo.readLine();
                while (cad != null)
                {
                    if (!cad.equals("\n"))
                        System.out.println(cad);
                    
                    cad = flujo.readLine();
                }
            }
            flujo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo inexsistente.");
        } catch (IOException e) {
            System.out.println("ERROR: No se ha podido escribir.");
        }
    }
    
    
}
