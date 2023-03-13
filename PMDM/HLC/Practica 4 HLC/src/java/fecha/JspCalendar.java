package fecha;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class JspCalendar {
    Calendar  calendar = null;
    private int dia = 21;
    private int mes = 10;
    private int anio = 1997;
    private int dia2 = 30;
    private int mes2 = 12;
    private int anio2 = 2000;
    
    public JspCalendar() {
	calendar = Calendar.getInstance();
	Date trialTime = new Date();
	calendar.setTime(trialTime);
    }

    public int getYear() {
	return calendar.get(Calendar.YEAR);
    }
    
    public String getMonth() {
	int m = getMonthInt();
	String[] months = new String [] { "January", "February", "March",
					"April", "May", "June",
					"July", "August", "September",
					"October", "November", "December" };
	if (m > 12)
	    return "Unknown to Man";
	
	return months[m - 1];

    }

    public String getDay() {
	int x = getDayOfWeek();
	String[] days = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", 
				      "Thursday", "Friday", "Saturday"};

	if (x > 7)
	    return "Unknown to Man";

	return days[x - 1];
    }
    
    public int getMonthInt() {
	return 1 + calendar.get(Calendar.MONTH);
    }

    public String getDate() {
	return getMonthInt() + "/" + getDayOfMonth() + "/" +  getYear();

    }

    public String getTime() {
	return getHour() + ":" + getMinute() + ":" + getSecond();
    }

    public int getDayOfMonth() {
	return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getDayOfYear() {
	return calendar.get(Calendar.DAY_OF_YEAR);
    }

    public int getWeekOfYear() {
	return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public int getWeekOfMonth() {
	return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    public int getDayOfWeek() {
	return calendar.get(Calendar.DAY_OF_WEEK);
    }
     
    public int getHour() {
	return calendar.get(Calendar.HOUR_OF_DAY);
    }
    
    public int getMinute() {
	return calendar.get(Calendar.MINUTE);
    }

    public int getSecond() {
	return calendar.get(Calendar.SECOND);
    }

    public static void main(String args[]) {
	JspCalendar db = new JspCalendar();
	p("date: " + db.getDayOfMonth());
	p("year: " + db.getYear());
	p("month: " + db.getMonth());
	p("time: " + db.getTime());
	p("date: " + db.getDate());
	p("Day: " + db.getDay());
	p("DayOfYear: " + db.getDayOfYear());
	p("WeekOfYear: " + db.getWeekOfYear());
	p("era: " + db.getEra());
	p("ampm: " + db.getAMPM());
	p("DST: " + db.getDSTOffset());
	p("ZONE Offset: " + db.getZoneOffset());
	p("TIMEZONE: " + db.getUSTimeZone());
    }

    private static void p(String x) {
	System.out.println(x);
    }

    public int getEra() {
	return calendar.get(Calendar.ERA);
    }

    public String getUSTimeZone() {
	String[] zones = new String[] {"Hawaii", "Alaskan", "Pacific",
				       "Mountain", "Central", "Eastern"};
	
	return zones[10 + getZoneOffset()];
    }

    public int getZoneOffset() {
	return calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000);
    }

    public int getDSTOffset() {
	return calendar.get(Calendar.DST_OFFSET)/(60*60*1000);
    }
    
    public int getAMPM() {
	return calendar.get(Calendar.AM_PM);
    }
    
    public String SignoZodiaco() {
        String signo = "";

        switch (mes) {
            case 1:
                if (dia > 21) {
                    signo = "ACUARIO";
                } else {
                    signo = "CAPRICORNIO";
                }
                break;
            case 2:
                    if (dia > 19) {
                        signo = "PISCIS";
                    } else {
                        signo = "ACUARIO";
                    }
                    break;
            case 3:
                    if (dia > 20) {
                        signo = "ARIES";
                    } else {
                        signo = "PISCIS";
                    }
                    break;
            case 4:
                    if (dia > 20) {
                        signo = "TAURO";
                    } else {
                        signo = "ARIES";
                    }
                    break;
            case 5:
                    if (dia > 21) {
                        signo = "GEMINIS";
                    } else {
                        signo = "TAURO";
                    }
                    break;
            case 6:
                    if (dia > 20) {
                        signo = "CANCER";
                    } else {
                        signo = "GEMINIS";
                    }
                    break;
            case 7:
                    if (dia > 22) {
                        signo = "LEO";
                    } else {
                        signo = "CANCER";
                    }
                    break;
            case 8:
                    if (dia > 21) {
                        signo = "VIRGO";
                    } else {
                        signo = "LEO";
                    }
                    break;
            case 9:
                    if (dia > 22) {
                        signo = "LIBRA";
                    } else {
                        signo = "VIRGO";
                    }
                    break;
            case 10:
                    if (dia > 22) {
                        signo = "ESCORPION";
                    } else {
                        signo = "LIBRA";
                    }
                    break;
            case 11:
                    if (dia > 21) {
                        signo = "SAGITARIO";
                    } else {
                        signo = "ESCORPION";
                    }
                    break;
            case 12:
                    if (dia > 21) {
                        signo = "CAPRICORNIO";
                    } else {
                        signo = "SAGITARIO";
                    }
            break;
        }
        return signo;
    }
    
    public String calcularEdad() {       
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = dia + "/" + mes + "/" + anio;
        LocalDate fechaNac = LocalDate.parse(fecha, fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        
        return periodo.getYears() + " años, " + periodo.getMonths() + " meses y " + periodo.getDays() + " días";
    }
    
    public String SignoZodiaco2() {
        String signo = "";

        switch (mes2) {
            case 1:
                if (dia2 > 21) {
                    signo = "ACUARIO";
                } else {
                    signo = "CAPRICORNIO";
                }
                break;
            case 2:
                    if (dia2 > 19) {
                        signo = "PISCIS";
                    } else {
                        signo = "ACUARIO";
                    }
                    break;
            case 3:
                    if (dia2 > 20) {
                        signo = "ARIES";
                    } else {
                        signo = "PISCIS";
                    }
                    break;
            case 4:
                    if (dia2 > 20) {
                        signo = "TAURO";
                    } else {
                        signo = "ARIES";
                    }
                    break;
            case 5:
                    if (dia2 > 21) {
                        signo = "GEMINIS";
                    } else {
                        signo = "TAURO";
                    }
                    break;
            case 6:
                    if (dia2 > 20) {
                        signo = "CANCER";
                    } else {
                        signo = "GEMINIS";
                    }
                    break;
            case 7:
                    if (dia2 > 22) {
                        signo = "LEO";
                    } else {
                        signo = "CANCER";
                    }
                    break;
            case 8:
                    if (dia2 > 21) {
                        signo = "VIRGO";
                    } else {
                        signo = "LEO";
                    }
                    break;
            case 9:
                    if (dia2 > 22) {
                        signo = "LIBRA";
                    } else {
                        signo = "VIRGO";
                    }
                    break;
            case 10:
                    if (dia2 > 22) {
                        signo = "ESCORPION";
                    } else {
                        signo = "LIBRA";
                    }
                    break;
            case 11:
                    if (dia2 > 21) {
                        signo = "SAGITARIO";
                    } else {
                        signo = "ESCORPION";
                    }
                    break;
            case 12:
                    if (dia2 > 21) {
                        signo = "CAPRICORNIO";
                    } else {
                        signo = "SAGITARIO";
                    }
            break;
        }
        return signo;
    }
    
    public String calcularEdad2() {       
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = dia2 + "/" + mes2 + "/" + anio2;
        LocalDate fechaNac = LocalDate.parse(fecha, fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        
        return periodo.getYears() + " años, " + periodo.getMonths() + " meses y " + periodo.getDays() + " días";
    }
}

