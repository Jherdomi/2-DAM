package Controlador;

import Modelo.Empresa;
import Modelo.Trabajador;
import java.sql.*;
import java.util.ArrayList;

public class Gestor {
    
    
    //clase que controla la interacción con la BBDD
    //consultas, conexiones, etc.
    ResultSet rs = null;
    

    
    public ArrayList<Empresa> extractEmpresa(String sql) {

        //Extrae los datos de un ResultSet en una sentencia SQL y lo devuelve como ArrayList
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Empresa> list = new ArrayList<Empresa>();

        try {
            conn = Conx.getConnection();
            /* Los resultSet puede ser (Primer par�metro de createStatement):
            - Por defecto (lineal o no arrastable / Sólo hacia adelante) -> ResultSet.TYPE_FORWARD_ONLY
            - Insensible a los cambios de la BDs -> ResultSet.TYPE_SCROLL_INSENSITIVE 
            - Sensible a los cambios de la BDs -> Con ResultSet.TYPE_SCROLL_SENSITIVE
            El segundo parametro de createStatement establece el tipo de concurrencia
             */
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new Empresa(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getDate(4),
                        rs.getString(5)
                ));
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error en Gestor.extractEmpresa()");
        } finally {
            Conx.close(rs);
            Conx.close(stmt);
            Conx.close(conn);
        }

        return list;
    }
    
    public ArrayList<Trabajador> extractTrabajador(String sql) {

        //Extrae los datos de un ResultSet originado de una sentencia SQL y lo
        //devuelve en forma de ArrayList.
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Trabajador> list = new ArrayList<Trabajador>();

        try {
            conn = Conx.getConnection();
            /* Los resultSet puede ser (Primer par�metro de createStatement):
            - Por defecto (lineal o no arrastable / Sólo hacia adelante) -> ResultSet.TYPE_FORWARD_ONLY
            - Insensible a los cambios de la BDs -> ResultSet.TYPE_SCROLL_INSENSITIVE 
            - Sensible a los cambios de la BDs -> Con ResultSet.TYPE_SCROLL_SENSITIVE
            El segundo par�metro de createStatement establece el tipo de concurrencia
             */
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new Trabajador(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5),
                        rs.getDate(6),
                        rs.getInt(7)
                ));
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error en Gestor.extractTrabajador(): " + e);
        } finally {
            Conx.close(rs);
            Conx.close(stmt);
            Conx.close(conn);
        }

        return list;
    }
    
    public Trabajador inicialDetalle(String sql) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Conx.getConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            rs.next();
            Trabajador art = new Trabajador(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getFloat(5),
                    rs.getDate(6),
                    rs.getInt(7)
            );
            return art;
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error en Gestor.inicialDetalle()" + e);
        } finally {
            /*ConexionBD.close(rs);
            ConexionBD.close(stmt);
            ConexionBD.close(conn);
            Mantenemos el resultset abierto para realizar operaciones dentro de vistadetalle*/
        }
        return null;
    }
    
    public Trabajador sig() throws SQLException {
        rs.next();
        Trabajador art = new Trabajador(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getFloat(5),
                rs.getDate(6),
                rs.getInt(7)
        );
        return art;
    }

    //Método que muestra el anterior articulo
    
    public Trabajador ant() throws SQLException {
        rs.previous();
        Trabajador art = new Trabajador(
                rs.getInt(1), 
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getFloat(5),
                rs.getDate(6),
                rs.getInt(7)
        );
        return art;
    }
    
    //compruebo si hay un elemento anterior
    
    public boolean comprobarAnt() throws SQLException {
        if (rs.previous() == false) {
            rs.next();
            return false;
        } else {
            rs.next();
            return true;
        }
    }
    
    //compruebo si hay un elemento siguiente
    
    public boolean comprobarSig() throws SQLException {
        if (rs.next() == false) {
            rs.previous();
            return false;
        } else {
            rs.previous();
            return true;
        }
    }
    
    //metodo que que hace un update en la tabla (fecha y precio, pero necesita recibir tmb la primary key)
    
    public void modificarTrabajador(int codigo, String fecha, String salario) {
        String query;
        query = "update trabajador set salario = " + salario + ", fechaAlta = '" + fecha + "' where codTrabajador = " + codigo;
        TrabajadorDB.updateTrabajador(query);
    }
    
    //método que calcula la media de precios de los articulos
    
    public float calcularSuma(String codigo) {
        String query;
        query = "select sum(salario) from trabajador where codEmpresa = " + codigo;

        return TrabajadorDB.selectSuma(query);

    }
    
}
