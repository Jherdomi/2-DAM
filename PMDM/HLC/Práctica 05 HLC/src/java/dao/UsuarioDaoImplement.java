package dao;

import model.Usuario;
import persistence.NewHibernateUtil;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDaoImplement implements UsuarioDao{

    @Override
    public ArrayList<Usuario> getUsuarios() {
        Session session = null;
        ArrayList<Usuario> usuarios = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Usuario");
            usuarios = (ArrayList<Usuario>) query.list();
        } catch (HibernateException HE){
            System.err.println(HE.getCause());
            System.err.println("ERROR: getUsuarios().");
        } finally {
            if (session != null){
                session.close();
            }
        }
        return usuarios;
    }
    
    @Override
    public ArrayList<Usuario> getUsuarios(String user, String password){
        ArrayList<Usuario> filteredList = new ArrayList<>();
        ArrayList<Usuario> usuarios = getUsuarios();
        for (Usuario usu: usuarios){
            if(usu.getNombre().equals(user) && usu.getPassword().equals(password)){
                filteredList.add(usu);
            }
        }
        return filteredList;
    }
    
    @Override
    public ArrayList<Usuario> getUsuariosConWhere(String user, String password){
        Session session = null;
        ArrayList<Usuario> usuarios = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Usuario where nombre =:user and password =:password");
            query.setParameter("user", user);
            query.setParameter("password", password);
            //String hql="Select log.userId from Login log where log.username=:username and log.password=:password"
            usuarios = (ArrayList<Usuario>) query.list();
        } catch (HibernateException HE){
            System.err.println(HE.getCause());
            System.err.println("ERROR: getUsuariosConWhere().");
        } finally {
            if (session != null){
                session.close();
            }
        }
        return usuarios;
    }
    

    @Override
    public void insertUsuario(Usuario usuario) {
        Session session = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
        } catch (HibernateException HE){
            System.err.println(HE.getMessage());
            System.err.println("ERROR: insertUsuarios().");
            session.getTransaction().rollback();
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public void editUsuario(Usuario usuario) {
        Session session = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(usuario);
            session.getTransaction().commit();
        } catch (HibernateException HE){
            System.err.println(HE.getMessage());
            System.err.println("ERROR: editUsuarios().");
            session.getTransaction().rollback();
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        Session session = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(usuario);
            session.getTransaction().commit();
        } catch (HibernateException HE){
            System.err.println(HE.getMessage());
            System.err.println("ERROR: deleteUsuarios().");
            session.getTransaction().rollback();
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public String nombreUsuario(int id) {
        String nombre = null;
        ArrayList<Usuario> usuarios = getUsuarios();
        
        for(Usuario u: usuarios){
            if(u.getNumero() == id){
                nombre = u.getNombre();
                break;
            }
        }
        
        return nombre;
        
    }
}
