/**
* 
* @author Miguel Maria Vazquez Martinez
* Fifth practice of module PMDM.
* 
*/

package Controlador;

import Modelo.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class EmpleadoDB {
    
    private static Statement st = null;
    private static ResultSet rs = null;
    
     
    public static ArrayList getLista(String query){
        ArrayList<Empleado> lista = new ArrayList<Empleado>();
        try{
            st = ConexionDB.getConnection().createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                       
                Empleado auxEmp = new Empleado( rs.getInt(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getString(4),
                                                rs.getFloat(5),
                                                rs.getFloat(6),
                                                Herramienta.dateToGregorianCalendar(rs.getDate(7))
                );
                
                lista.add(auxEmp);
            }
            rs.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Error consulta 1");
        }        
        return lista;
    }
      
    
}   
