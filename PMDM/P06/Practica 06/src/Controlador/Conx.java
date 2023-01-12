package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conx {
    
    private static final Conx ref = new Conx();

    public Conx() {
        try {
            Class.forName("com.mysql.jdbc.Driver");  
        } catch (ClassNotFoundException e) {
//            ControlErrores.writeError(e);
            System.out.println("ERROR: exception loading driver class");
        }
    }
    
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/practica06juanfri?zeroDateTimeBehavior=convertToNull";
        return DriverManager.getConnection(url, "root", "1234");
    }
    
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (Exception e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null,ControlErrores.catchError(5));
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (Exception e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null,ControlErrores.catchError(5));
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null,ControlErrores.catchError(5));
        }
    }
    
    //Método que se encarga de validar la conexión del usuario a la BBDD y activar los paneles
    
    public static boolean inicioSesionBD(String nombre, String contraseña) {
        
        Connection cn = null;
        PreparedStatement pst;
        ResultSet rs;
        
        try {

            // Se inicializa a null
            String usuarioCorrecto = null;
            String contraseñaCorrecta = null;

            // Realizar la conexion SQL 
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica06juanfri?zeroDateTimeBehavior=convertToNull", "root", "1234");

            // Ejecutar la consulta
            pst = cn.prepareStatement("SELECT nomBanda,contraseña FROM banda WHERE nomBanda = ?");
            pst.setString(1, nombre);
            rs = pst.executeQuery();

            // Solo se obtiene el primer registro (Si existe)
            if (rs.next()) {
                usuarioCorrecto = rs.getString(1);
                contraseñaCorrecta = rs.getString(2);
            }
                        
            // Si se ha obtenido un usuario y password y ademas esta es coincidente
            if (usuarioCorrecto !=null && contraseña!=null && contraseña.equals(contraseñaCorrecta)) {
                JOptionPane.showMessageDialog(null, "Conectado. Datos introducidos correctamente");
                return true;
                
            } else {
                //Error 1 llamado, error de inicio de sesion de la clase de control de errores
                JOptionPane.showMessageDialog(null, ControlErrores.catchError(1));
                return false;
            }

        } catch (Exception e) {
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null,ControlErrores.catchError(13));
            return false;
        } finally {
            try{
                cn.close();
            }catch(Exception e){
            ControlErrores.writeError(e);
            JOptionPane.showMessageDialog(null,ControlErrores.catchError(13));
            }
        }
    }
}
