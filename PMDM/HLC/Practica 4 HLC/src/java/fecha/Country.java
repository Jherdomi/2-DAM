package fecha;

import java.util.*;
import java.text.SimpleDateFormat;

public class Country {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlagImage() {
        return flagImage;
    }

    public void setFlagImage(String flagImage) {
        this.flagImage = flagImage;
    }

    public int getContribution() {
        return contribution;
    }

    public void setContribution(int contribution) {
        this.contribution = contribution;
    }

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public String parseDate(GregorianCalendar cal) {
        try {
            Date thisDate = cal.getTime();
            return sdf.format(thisDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String getEntryDate() {
        return parseDate(entryDate);
    }

    public void setEntryDate(GregorianCalendar entryDate) {
        this.entryDate = entryDate;
    }

    public Country(String name, String flagImage, int contribution, GregorianCalendar entryDate){
        this.name = name;
        this.flagImage = flagImage;
        this.contribution = contribution;
        this.entryDate = entryDate;
    }

    private String name = "";
    private String flagImage = "";
    private int contribution = 0;
    private GregorianCalendar entryDate;

}
