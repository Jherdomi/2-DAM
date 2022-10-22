
//Clase creada con la finalidad de controlar los meses que pasan desde la fecha de una cuenta
//Hasta el mes actual

package Controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class CalculoFecha {
    public static int mesesPasados(String fecha1){ //recibe por parametro la fecha de la cuenta
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //sdf, fromato que le vamos a dar a la fecha
        try {
            Date date1 = sdf.parse(fecha1); //la fehca de la cuenta
            Date date2 = new Date();  //objeto tipo date que va a almacenar la fecha actual

            long meses = (date2.getTime() - date1.getTime())/86400000/30; //calculo de la fecha. getTime devuelve milisegundos
                                                                          //por se divide, para ajustarloa meses
            return (int) meses; //devuelve, como casting a entero, el numero de meses transcurridos
        } catch (ParseException ex) {
            
        }
        return 0;
    }

}
