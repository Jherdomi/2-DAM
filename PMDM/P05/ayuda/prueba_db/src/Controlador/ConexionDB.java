/**
* 
* @author Miguel Maria Vazquez Martinez
* Fifth practice of module PMDM.
* 
*/

package Controlador;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {

    private static Connection con = null;

    public static void open() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");	
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: exception loading driver class");
        }
               
        String url = "jdbc:derby://localhost:1527/empresa";
        try {
            con = DriverManager.getConnection(url,"empresa","empresa");
        } catch (SQLException ex) {
            System.out.println("ERROR: conexion");
        }
        
    }


    public static Connection getConnection() throws SQLException {
        return con;
    } 
    
    public static void close() {
        try {
            con.close();
        } catch (Exception ignored) {}
    } 
}
