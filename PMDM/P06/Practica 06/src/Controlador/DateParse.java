package Controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateParse {
    public static String gregorianCalendarToString(Calendar fecha){         
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
        return formatDate.format(fecha.getTime());        
    }    
    
    public static GregorianCalendar dateToGregorianCalendar(Date fecha){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fecha);
        return gc;
    }
    
    public static GregorianCalendar stringToCalendar(String fecha) throws ParseException{         
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
        Date date = formatDate.parse(fecha);
        
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        return gc;
    }   
}
