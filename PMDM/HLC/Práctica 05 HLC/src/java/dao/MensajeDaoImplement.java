/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Mensaje;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.NewHibernateUtil;

public class MensajeDaoImplement implements MensajeDao{

    @Override
    public ArrayList<Mensaje> getMensajes() {
        Session session = null;
        ArrayList<Mensaje> mensajes = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Mensaje");
            mensajes = (ArrayList<Mensaje>) query.list();
        } catch (HibernateException HE) {
            System.err.println(HE.getCause());
            System.err.println("ERROR: getMensajes().");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return mensajes;
    }

    @Override
    public ArrayList<Mensaje> getMensajesUsuario(int id) {
       ArrayList<Mensaje> mensajes = new ArrayList<>();
        ArrayList<Mensaje> filteredList = new ArrayList<>();
        mensajes = getMensajes();
        for (Mensaje m : mensajes) {
            if(m.getCuecodigodestino() == id){
                filteredList.add(m);
            }
        }
        return filteredList;
    }

    @Override
    public Mensaje getMensaje(int id) {
        Mensaje mensaje = null;
        ArrayList<Mensaje> mensajes = getMensajes();
        
        for(Mensaje m: mensajes){
            if(m.getNumero() == id){
                mensaje = m;
                break;
            }
        }
        
        return mensaje;        
    }
    
}
