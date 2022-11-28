package Controlador;

import Modelo.Trabajador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TrabajadorDB {
    

    private static Statement st = null; //procesa una sentencia sql y obtiene los resultados de la misma
    private static ResultSet rs = null; //contiene todas las filas de la sentencia sql

    //método encargado de de sacar en una lista, los elementos de la tabla articulos
    public static ArrayList getLista(String query) {
        ArrayList<Trabajador> lista = new ArrayList<Trabajador>();
        try {
            st = Conx.getConnection().createStatement(); //creamos la conexión
            rs = st.executeQuery(query); //ejecutamnos el result set y el statement

            while (rs.next()) { //mientras haya una siguiente fila

                Trabajador auxT = new Trabajador(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5),
                        rs.getDate(6),
                        rs.getInt(7)
                );

                lista.add(auxT);
            }

            //cierro el rs y el st
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error consulta 1");
        }
        return lista; //devuelvo la lista que se ha creado, con todos los datos de la tabla de la BBDD
    }

    //método que actualiza los elementos de la tabla
    
    public static void updateTrabajador(String query) {
        try {
            st = Conx.getConnection().createStatement(); //creamos la conexión
            int rs = st.executeUpdate(query); //ejecutamos el update
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos" + e);
        }
    }
    
    static float selectSuma(String query) {

        float sumSalario = 0;

        try {
            st = Conx.getConnection().createStatement();  //creamos la conexión
            rs = st.executeQuery(query); //ejecutamos el rs y el st
            rs.next(); //pasamos al siguiente (ya que creo que por defecto hay que hacerlo)

            sumSalario = rs.getFloat(1); 

            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error calculo media");
        }
        return sumSalario; //devolvemos la media
    }
}
