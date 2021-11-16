package ejemplohilos;

import java.io.*;

class MiHilo implements Runnable {
        
        String nombreHilo;
        int cont = 1;
        Thread hilo;
    
        MiHilo(String nombre){
            
            this.nombreHilo = nombre;
            
            
        }

        @Override
        public void run(){
            
                
            try {
                InputStreamReader stream = new InputStreamReader(System.in);
                BufferedReader teclado = new BufferedReader(stream);
                
                System.out.println("Introduzca un nombre para el hilo: ");
                this.nombreHilo = teclado.readLine();
                
                for (int i = 0; i < 10; i++){
                    System.out.println(nombreHilo + " es: " + cont);
                    cont++;
                }
            } catch (IOException ex) {
                System.out.println("No Valido.");
            }
                

            
        }
    }
