package Controlador;

import Modelo.Pirata;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class PirataDB {
    private Statement st = null; //procesa una sentencia sql y obtiene los resultados de la misma
    private ResultSet rs = null; //contiene todas las filas de la sentencia sql

    public Pirata leer() {
        Pirata p = null;
        try {
            p = new Pirata(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                DateParse.dateToGregorianCalendar(rs.getDate(4)),
                rs.getString(5),
                rs.getInt(6),
                rs.getInt(7),
                rs.getInt(8),
                rs.getInt(9)
            );
        } catch (SQLException e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null, ControlErrores.catchError(4));
        }
        
        return p;
    }

    public String leerString() {
        String cadena = "";
        try {
            cadena += rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(8);
        } catch (SQLException e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null, ControlErrores.catchError(4));
        }
        return cadena;
    }

    public String InicializarString(String codigo) {
        String cadena = "";
        try {
            st = Conx.getConnection().createStatement(); //creamos la conexión
            rs = st.executeQuery("select * from pirata, banda where pirata.codigoBanda=banda.codBanda and banda.nomBanda = '" + codigo + "'"); //ejecutamnos el result set y el statement
            cadena = Siguiente();
        } catch (SQLException e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null, ControlErrores.catchError(6));
        }
        return cadena;
    }

    public String Siguiente() throws SQLException {
        rs.next();
        return leerString();
    }

    public boolean hasNext() throws SQLException {
        if (rs.isLast()) {
            return false;
        } else {
            return true;
        }
    }

    public void cerrar() {
        try {
            rs.close();
            st.close();
        } catch (SQLException e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null, ControlErrores.catchError(4));
        }
    }

    public Pirata leerI(int index) throws SQLException {
        
        int row = rs.getRow();
        while (index != row) {
            rs.previous();
            row = rs.getRow();
        }
        Pirata p = leer();
        return p;
    }

    public void insertPirata(String query) throws SQLException {
        try {
            st = Conx.getConnection().createStatement(); //creamos la conexión
            st.executeUpdate(query); //ejecutamos el update
        } catch (SQLException e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null, ControlErrores.catchError(7));
        } finally {
            st.close();
        }
    }

    public int findCodigoPirata() {
        int contador = 1;
        boolean flag = false;
        try {
            st = Conx.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); //creamos la conexión
            rs = st.executeQuery("Select * from pirata order by codPirata"); //ejecutamos el update
            rs.next();
            if (contador < rs.getInt(1)) {
                return contador;
            }
            while (!flag) {
                if (contador == rs.getInt(1)) {
                    rs.next();
                    contador++;
                }
                if (contador < rs.getInt(1)) {
                    return contador;
                }
                if (rs.isLast()) {
                    return contador + 1;
                }
            }
        } catch (SQLException e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null, ControlErrores.catchError(8));
        } finally {
            Conx.close(rs);
            Conx.close(st);
        }
        return 99;//ERROR QUE HAY QUE CONTROLAR
    }

    public void updatePirata(String query) {
        try {
            st = Conx.getConnection().createStatement(); //creamos la conexión
            st.executeUpdate(query); //ejecutamos el update
        } catch (SQLException e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null, ControlErrores.catchError(2));
        } finally {
            Conx.close(st);
        }
    }

    public void borrarAsig(String p){
        try {
            st = Conx.getConnection().createStatement(); //creamos la conexión
            st.executeUpdate("Delete from asignacion where pirata = " + p); //ejecutamos el update
        } catch (SQLException e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null, ControlErrores.catchError(9));
        } finally {
            Conx.close(st);
        }
    }
    
    public void borrar(String p) {
        try {
            st = Conx.getConnection().createStatement(); //creamos la conexión
            st.executeUpdate("Delete from pirata where codPirata = " + p); //ejecutamos el update
        } catch (SQLException e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null, ControlErrores.catchError(9));
        } finally {
            Conx.close(st);
        }
    }
}
