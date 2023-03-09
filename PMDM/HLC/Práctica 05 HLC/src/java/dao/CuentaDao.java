/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Cuenta;
import java.util.ArrayList;
public interface CuentaDao {

    public ArrayList<Cuenta> getCuentas();
    public ArrayList<Cuenta> getCuentaByUsuario(Integer usuarioNumero);
    public double getRecargo(int numero);
    public String getEmail(int id);

}
