/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author bosque
 */
public class Herramienta { 
  
    public static String gregorianCalendarToString(GregorianCalendar fecha){         
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatDate.format(fecha.getTime());        
    }    
    
    public static GregorianCalendar dateToGregorianCalendar(Date fecha){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fecha);
        return gc;
    }
    
    
     

}
