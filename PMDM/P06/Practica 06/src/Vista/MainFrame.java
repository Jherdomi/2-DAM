/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Conx;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juanfri
 */
public class MainFrame extends javax.swing.JFrame {

    public panelConexion conexion;
    public panelAcercaDe datos;
    public panelCerrar cerrar;
    public panelVisualizarBanda banda;
    public panelVisualizarArma arma;
    public panelVisualizarTesoro tesoro;
    public panelVisualizarPirata pirata;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() throws SQLException {
        setLocationRelativeTo(null);
        banda = new panelVisualizarBanda();
        tesoro = new panelVisualizarTesoro();
        pirata = new panelVisualizarPirata(this);
        initComponents();
        
        loginMenu.setEnabled(true);
        logoutMenu.setEnabled(false);
        datosItem.setEnabled(false);
        visualizarItem.setEnabled(false);
        
        Conx.getConnection();
        Conx.close(Conx.getConnection());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loginMenu = new javax.swing.JMenuItem();
        logoutMenu = new javax.swing.JMenuItem();
        datosItem = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        visualizarItem = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Conexión");

        loginMenu.setText("Log in");
        loginMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginMenuActionPerformed(evt);
            }
        });
        jMenu1.add(loginMenu);

        logoutMenu.setText("Log out");
        logoutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuActionPerformed(evt);
            }
        });
        jMenu1.add(logoutMenu);

        jMenuBar1.add(jMenu1);

        datosItem.setText("Acerca De");

        jMenuItem3.setText("Datos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        datosItem.add(jMenuItem3);

        jMenuBar1.add(datosItem);

        visualizarItem.setText("Visualizar");

        jMenuItem1.setText("Visualizar Banda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        visualizarItem.add(jMenuItem1);

        jMenuItem2.setText("Visualizar Piratas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        visualizarItem.add(jMenuItem2);

        jMenuItem4.setText("Visualizar Tesoros");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        visualizarItem.add(jMenuItem4);

        jMenuItem5.setText("Visualizar Armas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        visualizarItem.add(jMenuItem5);

        jMenuBar1.add(visualizarItem);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginMenuActionPerformed
        // TODO add your handling code here:
        conexion = new panelConexion(); //creamos el panel de inicio de sesión
        //lo mostramos con un JOptionPane
        JOptionPane.showMessageDialog(null, conexion, "Introduzca el usuario y la contraseña", 0);

        //llamo al método que me valida las conexiones del usuario, y le paso por parametros, los valores del panel inicioSesion
        if (Conx.inicioSesionBD(conexion.getUsuario(), conexion.getContra())) {
            arma = new panelVisualizarArma(conexion.getUsuario());
            tesoro.inicializar(conexion.getUsuario());
            loginMenu.setEnabled(false);
            logoutMenu.setEnabled(true);
            datosItem.setEnabled(true);
            visualizarItem.setEnabled(true);
            banda.mostrarDatos(conexion.getUsuario());
        }
    }//GEN-LAST:event_loginMenuActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        datos = new panelAcercaDe();
        setContentPane(datos);
        this.pack();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void logoutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuActionPerformed
        // TODO add your handling code here:
        loginMenu.setEnabled(true);
        logoutMenu.setEnabled(false);
        datosItem.setEnabled(false);
        visualizarItem.setEnabled(false);
        cerrar = new panelCerrar();
        setContentPane(cerrar);
        this.pack();
        
    }//GEN-LAST:event_logoutMenuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        setContentPane(banda);
        this.pack();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        setContentPane(arma);
        this.pack();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        pirata.mostrarLista(conexion.getUsuario());
        setContentPane(pirata);
        this.pack();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        setContentPane(tesoro);
        tesoro.inicializar(conexion.getUsuario());
        this.pack();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu datosItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem loginMenu;
    private javax.swing.JMenuItem logoutMenu;
    private javax.swing.JMenu visualizarItem;
    // End of variables declaration//GEN-END:variables
}
