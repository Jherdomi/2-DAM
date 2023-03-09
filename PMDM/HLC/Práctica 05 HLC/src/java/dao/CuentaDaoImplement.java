/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Cuenta;
import persistence.NewHibernateUtil;
import java.util.ArrayList;
import java.util.Objects;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class CuentaDaoImplement implements CuentaDao {

    @Override
    public ArrayList<Cuenta> getCuentas() {
        Session session = null;
        ArrayList<Cuenta> cuentas = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Cuenta");
            cuentas = (ArrayList<Cuenta>) query.list();
        } catch (HibernateException HE) {
            System.err.println(HE.getCause());
            System.err.println("ERROR: getCuentas().");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return cuentas;
    }

    @Override
    public double getRecargo(int numero) {
        double recargo = 0;
        ArrayList<Cuenta> lista = getCuentaByUsuario(numero);
        
        recargo = Math.abs((lista.size() - lista.get(0).getMaximomensajes())* lista.get(0).getCostemensajeextra().doubleValue());
        
        return recargo;
    }

    @Override
    public ArrayList<Cuenta> getCuentaByUsuario(Integer usuarioNumero) {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        ArrayList<Cuenta> filteredList = new ArrayList<>();
        cuentas = getCuentas();
        for (Cuenta c : cuentas) {
            if (Objects.equals(c.getUsunumero(), usuarioNumero)) {
                filteredList.add(c);
            }
        }
        return filteredList;
    }

    @Override
    public String getEmail(int id) {
        String email = null;
        ArrayList<Cuenta> cuentas = getCuentas();
        
        for(Cuenta c: cuentas){
            if(c.getCodigo() == id){
                email = c.getEmail();
                break;
            }
        }
        
        return email;
    }

}
