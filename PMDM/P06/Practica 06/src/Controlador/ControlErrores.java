package Controlador;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlErrores {

    public static String catchError(int error) {
        String errorMensaje = "Error " + error + ": ";
        switch (error) {
            case 1:
                return errorMensaje += "ERROR: Datos incorrectos";
            case 2:
                return errorMensaje += "ERROR: al actualizar los datos";
            case 3:
                return errorMensaje += "ERROR: al seleccionar los datos";
            case 4:
                return errorMensaje += "ERROR: al recoger los datos";
            case 5:
                return errorMensaje += "ERROR: al cerar";
            case 6:
                return errorMensaje += "ERROR: al inicializar los datos";
            case 7:
                return errorMensaje += "ERROR: al insertar los datos";
            case 8:
                return errorMensaje += "ERROR: al buscar el último dorsal";
            case 9:
                return errorMensaje += "ERROR: al borrar los datos";
            case 10:
                return errorMensaje += "ERROR: Longitud de cadena incorrecta";
            case 11:
                return errorMensaje += "ERROR: Valor de entero incorrecto";
            case 12:
                return errorMensaje += "ERROR: No hay jugadores que listar";
            case 13:
                return errorMensaje += "ERROR: No se ha podido arrancar la BD";
            default:
                return errorMensaje += "ERROR: Un error insesperado ha ocurrido";
        }
    }

    public static void writeError(Exception error) {
        OutputStream archivoError = null;
        String fullReport = new SimpleDateFormat("HH:mm:ss  dd/MM/YYYY").format(new java.util.Date()) + " " + error.getMessage();
        try {
            archivoError = new FileOutputStream("./src/Errores/Error.txt");
            Writer out = new BufferedWriter(new OutputStreamWriter(archivoError));
            out.write(fullReport);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControlErrores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControlErrores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                archivoError.close();
            } catch (IOException ex) {
                Logger.getLogger(ControlErrores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Este try catch no puede ser controlado por la clase error debido a la posibilidad de que cause un bucle infinito
}
