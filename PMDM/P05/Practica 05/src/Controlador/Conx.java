package Controlador;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conx {
    
    /*
    Clase para la conexion con la base de datos
    */
    private static final Conx ref = new Conx();
    
    public Conx(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        }catch(ClassNotFoundException e){
            System.out.println("ERROR: Fallo del driver.");
        }
    }
    
    public static Connection getConnection() throws SQLException {
        String ruta = "jdbc:derby://localhost:1527/Juanfri";
        return DriverManager.getConnection(ruta, "Juanfri", "Juanfri");
    }
    
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (Exception ignored) {
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (Exception ignored) {
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (Exception ignored) {
        }
    }
    
    public static boolean conexionBD(String nombre, String contraseña) {
        
        Connection cn = null;
        PreparedStatement pst;
        ResultSet rs;
        
        try {

            // Se inicializa a null
            String usuarioCorrecto = null;
            String contraseñaCorrecta = null;

            // Realizar la conexion SQL 
            cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Juanfri", "Juanfri", "Juanfri");

            // Ejecutar la consulta
            pst = cn.prepareStatement("SELECT nomEmpresa,contrasena FROM empresa WHERE nomEmpresa = ?");
            pst.setString(1, nombre);
            rs = pst.executeQuery();

            // Solo se obtiene el primer registro (Si existe)
            if (rs.next()) {
                usuarioCorrecto = rs.getString(1);
                contraseñaCorrecta = rs.getString(2);
            }
                        
            // Si se ha obtenido un usuario y password y ademas esta es coincidente
            if (usuarioCorrecto !=null && contraseña!=null && contraseña.equals(contraseñaCorrecta)) {
                JOptionPane.showMessageDialog(null, "Conexión realizada correctamente.");
                return true;
                
            } else {
                JOptionPane.showMessageDialog(null, "ERROR: Datos incorrectos");
                System.out.println("Error");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);  
            return false;
        } finally {
            try{
                cn.close();
            }catch(Exception e){
                System.err.println("Error: ");
                e.printStackTrace();
            }
        }  
    }
    
}
