/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Usuario;
import java.util.ArrayList;

public interface UsuarioDao {
    public ArrayList<Usuario> getUsuarios();
    public ArrayList<Usuario> getUsuarios(String user, String password);
    public ArrayList<Usuario> getUsuariosConWhere(String user, String password);
    public void insertUsuario(Usuario usuario);
    public void editUsuario(Usuario usuario);
    public void deleteUsuario(Usuario usuario);
    public String nombreUsuario(int id);
    
}
