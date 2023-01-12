package Controlador;

import Modelo.Tesoro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class TesoroDB {
    private Statement st = null; //procesa una sentencia sql y obtiene los resultados de la misma
    private ResultSet rs = null; //contiene todas las filas de la sentencia sql

    public Tesoro leer() {
        Tesoro tesoro = null;
        try {
            tesoro = new Tesoro(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3)
            );
        } catch (SQLException e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null, ControlErrores.catchError(4));
        }
        return tesoro;
    }

    public Tesoro Inicializar(String query) {
        Tesoro tesoro = null;
        try {
            st = Conx.getConnection().createStatement(); //creamos la conexión
            rs = st.executeQuery(query); //ejecutamnos el result set y el statement
            rs.next();
            tesoro = new Tesoro(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3)
            );
        } catch (SQLException e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null, ControlErrores.catchError(4));
        }
        return tesoro; //devuelvo la lista que se ha creado, con todos los datos de la tabla de la BBDD
    }

    public Tesoro Siguiente() throws SQLException {
        rs.next();
        return leer();
    }

    public Tesoro Anterior() throws SQLException {
        rs.previous();
        return leer();
    }

    public Tesoro Primero() throws SQLException {
        while (!rs.isFirst()) {
            rs.previous();
        }
        return leer();
    }

    public Tesoro Ultimo() throws SQLException {
        while (!rs.isLast()) {
            rs.next();
        }
        return leer();
    }

    public boolean hasNext() throws SQLException {
        if (rs.isLast()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasPrev() throws SQLException {
        if (rs.isFirst()) {
            return false;
        } else {
            return true;
        }
    }
    public void cerrar(){
        try {
            rs.close();
            st.close();
        } catch (SQLException e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null, ControlErrores.catchError(5));
        }
    }
}
