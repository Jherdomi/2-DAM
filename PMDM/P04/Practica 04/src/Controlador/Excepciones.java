//Clase creada con la finalidad 
//de controlar las posibles excepciones que se puedan producir en el programa

package Controlador;

import javax.swing.JOptionPane;

public final class Excepciones extends Exception {
    
    public static void invalidSaldo() {
        JOptionPane.showInternalMessageDialog(null, "\n\tError - Saldo no válido. Formato inválido.");
    }
    
    public static void invalidSaldoMin() {
        JOptionPane.showInternalMessageDialog(null, "\n\tError - Saldo no mínimo no válido. Formato inválido.");
    }
    
    public static void invalidComision() {
        JOptionPane.showInternalMessageDialog(null, "\n\tError - Comisión no válida. Formato inválido.");
    }
    
    public static void invalidInteresAnual() {
        JOptionPane.showInternalMessageDialog(null, "\n\tError -Interés Anual no válido. Formato inválido.");
    }

    public static void invalidBeneficioPerdida() {
        JOptionPane.showInternalMessageDialog(null, "\n\tError -Interés Beneficio/Pérdida no válido. Formato inválido.");
    }
    
    public static void invalidFecha() {
        JOptionPane.showInternalMessageDialog(null, "\n\tError -Fecha no válida. Formato inválido.");
    }
    
    public static void saldoMenor(){
        JOptionPane.showInternalMessageDialog(null, "\n\tError -Saldo Menor que saldo mínimo.");
    }
}
