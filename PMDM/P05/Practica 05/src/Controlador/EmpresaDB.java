package Controlador;

import Modelo.Empresa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Juanfri
 */
public class EmpresaDB {
    private static Statement st = null;
    private static ResultSet rs = null;
    
    public static ArrayList getLista(String query){
        ArrayList<Empresa> lista = new ArrayList<Empresa>();
        try{
            st = Conx.getConnection().createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                       
                Empresa auxEmp = new Empresa(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getDate(4),
                        rs.getString(5)
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
