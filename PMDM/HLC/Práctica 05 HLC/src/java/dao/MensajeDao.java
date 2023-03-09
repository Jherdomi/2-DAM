/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Mensaje;


public interface MensajeDao {
    public ArrayList<Mensaje> getMensajes();
    public ArrayList<Mensaje> getMensajesUsuario(int id);
    public Mensaje getMensaje(int id);
}
