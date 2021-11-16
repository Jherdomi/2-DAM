package javaapplication2;

import static java.lang.Runtime.getRuntime;

public class Main {
    

    public Main() {
    }
    

    public static void main(String[] args) {
        Runtime r = getRuntime();
        
        String comando = "notepad.exe";
        Process p;
        
        try{
            
            p = r.exec(comando);
            
        }catch(Exception e){
            System.out.println("ERROR en: " + comando);
            e.printStackTrace();
        }
        
    }
    
}
