package Controlador;

import Modelo.Banda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BandaDB {
    Statement st = null;
    ResultSet rs = null;

    public Banda getBanda(String banda) {
        Banda b = null;
        try {
            st = Conx.getConnection().createStatement();
            rs = st.executeQuery("select * from banda where nomBanda = '" + banda + "'");
            rs.next();
            b = new Banda(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    DateParse.dateToGregorianCalendar(rs.getDate(5)),
                    rs.getString(6)
            );
        } catch (Exception e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null, ControlErrores.catchError(4));
        } finally {
            Conx.close(rs);
            Conx.close(st);
        }
        return b;
    }
    
    public int selectTotMiembros(String query) {

        int totMiembros = 0;

        try {
            st = Conx.getConnection().createStatement();  //creamos la conexión
            rs = st.executeQuery(query); //ejecutamos el rs y el st
            rs.next(); //pasamos al siguiente (ya que creo que por defecto hay que hacerlo)

            totMiembros = rs.getInt(1); 

            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("ERROR: TotMiembros");
        }
        return totMiembros; //devolvemos la media
    }
    
    public int selectTotTesoros(String query) {

        int totMiembros = 0;

        try {
            st = Conx.getConnection().createStatement();  //creamos la conexión
            rs = st.executeQuery(query); //ejecutamos el rs y el st
            rs.next(); //pasamos al siguiente (ya que creo que por defecto hay que hacerlo)

            totMiembros = rs.getInt(1); 

            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("ERROR: TotMiembros");
        }
        return totMiembros; //devolvemos la media
    }
}
