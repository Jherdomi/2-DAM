package Controlador;

import Modelo.Arma;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ArmaDB {
    
    private static Statement st = null;
    private static ResultSet rs = null;

    public static ArrayList getLista(String query) {
        ArrayList<Arma> lista = new ArrayList<Arma>();
        try {
            st = Conx.getConnection().createStatement(); 
            rs = st.executeQuery(query);

            while (rs.next()) { 

                
                Arma a = new Arma(
                        rs.getInt(1),
                        rs.getString(2)
                );

                lista.add(a); 
            }

            
            rs.close();
            st.close();
        } catch (SQLException e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null, ControlErrores.catchError(4));
        }
        return lista; 
    }
}
