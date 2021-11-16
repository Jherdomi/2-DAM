package Boletin3;

import java.io.*;
import static java.lang.Runtime.getRuntime;

public class Ejercicio3 {
    public static void main(String[] args) {
        Runtime r = getRuntime();
        Process cmd;
        String standardOut;
        String standardErr;
        String date;
        
        try {
            cmd = r.exec("cmd /c date");
            
            InputStream is = cmd.getInputStream();
            InputStream es = cmd.getErrorStream();
            OutputStream os = cmd.getOutputStream();
            
            BufferedReader stdout = new BufferedReader(new InputStreamReader(is));
            BufferedReader stderr = new BufferedReader(new InputStreamReader(is));
            
            os.write("15-06-18".getBytes());
            os.flush();
            os.close();

            while ((standardOut = stdout.readLine()) != null)
                System.out.println(standardOut);
            
            while ((standardErr = stderr.readLine()) != null)
                System.out.println(standardErr);
            
            
            stdout.close();
            stderr.close();
            //stdin.close();
        } catch (IOException ex) {
            System.out.println("No valido.");
            ex.printStackTrace();
        }
    }
}
