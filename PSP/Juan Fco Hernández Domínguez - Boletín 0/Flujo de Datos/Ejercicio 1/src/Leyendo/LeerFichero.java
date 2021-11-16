package Leyendo;


import java.io.*;


public class LeerFichero {
    File fichero;
    
    public LeerFichero(String archivo){
        fichero = new File(archivo);
        
        if(!fichero.exists()){
            try{
                fichero.createNewFile();
            }catch(IOException e){
                System.out.println("No válido.");
            }
        }
            
    }
    
    public void leer() {
        
        BufferedReader flujo;
        
        try{
            String cad;
            flujo = new BufferedReader(new FileReader(fichero));
            if(fichero.exists()){
                System.out.println("\n\nContenido del fichero: ");
                cad = flujo.readLine();
                while(cad != null){
                    if(!cad.equals("\n")){
                        System.out.println(cad);
                    }
                    
                    cad = flujo.readLine();
                }
            }
            
            flujo.close();
        }catch(FileNotFoundException e){
            System.out.println("ERROR: Archivo no encontrado.");
        }catch(IOException e){
            System.out.println("ERROR: No se ha podido leer el archivo.");
        }
    }
}