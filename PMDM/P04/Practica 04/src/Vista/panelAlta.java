/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.*;
import Modelo.*;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class panelAlta extends javax.swing.JPanel {

    private panelPresentacion pres;
    private Lista lista;
    String tipCom;
    
    /**
     * Creates new form panelAlta
     */
    public panelAlta() {
        initComponents();
        pres = new panelPresentacion();
    }
    
    public panelAlta(Lista l){
        super();
        initComponents();
        this.lista = l;
        numTextField.setText("POR DEFECTO.");
        numTextField.setFocusable(false);
        numTextField.setFocusable(false);
        add2TextField.show(true);
        comBox.show(false);
        tipCom = "Semestral";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tipoBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        add1Label = new javax.swing.JLabel();
        add2Label = new javax.swing.JLabel();
        numTextField = new javax.swing.JTextField();
        titTextField = new javax.swing.JTextField();
        salTextField = new javax.swing.JTextField();
        salMinTextField = new javax.swing.JTextField();
        fecTextField = new javax.swing.JTextField();
        add1TextField = new javax.swing.JTextField();
        add2TextField = new javax.swing.JTextField();
        aceButton = new javax.swing.JButton();
        canButton = new javax.swing.JButton();
        comBox = new javax.swing.JComboBox<>();

        setForeground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Agregar Cuenta");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Número de Cuenta:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Titular:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Saldo:");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Saldo Mínimo:");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Fecha de Apertura:");

        tipoBox.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        tipoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ahorro", "Inversión", "Corriente" }));
        tipoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoBoxActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Tipo de Cuenta:");

        add1Label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        add1Label.setText("Interés Anual:");

        add2Label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        add2Label.setText("Localidad:");

        numTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        titTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        titTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titTextFieldActionPerformed(evt);
            }
        });

        salTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        salMinTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        fecTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        add1TextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        add2TextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        aceButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        aceButton.setText("Aceptar");
        aceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceButtonActionPerformed(evt);
            }
        });

        canButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        canButton.setText("Cancelar");
        canButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canButtonActionPerformed(evt);
            }
        });

        comBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semestral", "Anual" }));
        comBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(add1Label)
                            .addComponent(add2Label)
                            .addComponent(aceButton))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecTextField)
                            .addComponent(add1TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(canButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(add2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(salTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(salMinTextField)
                            .addComponent(numTextField))))
                .addGap(91, 91, 91))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(titTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(salTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(salMinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fecTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add1Label)
                    .addComponent(add1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add2Label)
                    .addComponent(add2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceButton)
                    .addComponent(canButton))
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void titTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titTextFieldActionPerformed

    private void canButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canButtonActionPerformed
        // TODO add your handling code here:
        tipoBox.setSelectedIndex(0);
        titTextField.setText("");
        salTextField.setText("");
        salMinTextField.setText("");
        fecTextField.setText("");
        add1TextField.setText("");
        add2TextField.setText("");
        comBox.setSelectedIndex(0);
        
    }//GEN-LAST:event_canButtonActionPerformed

    private void aceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceButtonActionPerformed
        // TODO add your handling code here:
        
        
        
        if(tipoBox.getSelectedIndex() == 0){
            
            CuentaAhorro ca = new CuentaAhorro(titTextField.getText(),
                    Float.valueOf(salTextField.getText()),
                    Float.valueOf(salMinTextField.getText()),
                    fecTextField.getText(),
                    Float.valueOf(add1TextField.getText()),
                    add2TextField.getText()
            );
            
            lista.insertarNodo(ca.getNumeroCuenta(), ca);

            
        }else if(tipoBox.getSelectedIndex() == 1){
            
            CuentaInversion ci = new CuentaInversion(titTextField.getText(),
                    Float.valueOf(salTextField.getText()),
                    Float.valueOf(salMinTextField.getText()),
                    fecTextField.getText(),
                    add2TextField.getText()
            );
            
            lista.insertarNodo(ci.getNumeroCuenta(), ci);
            add1TextField.setText("RANDOM.");

                    
        }else if(tipoBox.getSelectedIndex() == 2){
            
            CuentaCorriente cc = new CuentaCorriente(titTextField.getText(),
                    Float.valueOf(salTextField.getText()),
                    Float.valueOf(salMinTextField.getText()),
                    fecTextField.getText(),
                    Float.valueOf(add1TextField.getText()),
                    tipCom
            );
            
            lista.insertarNodo(cc.getNumeroCuenta(), cc);
        }

        JOptionPane.showMessageDialog(null, "Se ha añadido la cuenta de manera correcta.");
        
        tipoBox.setSelectedIndex(0);
        titTextField.setText("");
        salTextField.setText("");
        salMinTextField.setText("");
        fecTextField.setText("");
        add1TextField.setText("");
        add2TextField.setText("");
    }//GEN-LAST:event_aceButtonActionPerformed

    private void tipoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoBoxActionPerformed
        // TODO add your handling code here:
        if(tipoBox.getSelectedIndex() == 0){
            
            add1Label.setText("Interés Anual:");
            add2Label.setText("Localidad:");
            add2TextField.show(true);
            comBox.show(false);
            
        }else if(tipoBox.getSelectedIndex() == 1){
            
            add1Label.setText("Beneficio Pérdida:");
            add2Label.setText("Localidad:");
            add2TextField.show(true);
            comBox.show(false);
            add1TextField.setText("RANDOM.");        
            
        }else if(tipoBox.getSelectedIndex() == 2){
            
            add1Label.setText("Comisión:");
            add2Label.setText("Tipo Comisión:");
            add2TextField.show(false);
            comBox.show(true);
        }
    }//GEN-LAST:event_tipoBoxActionPerformed

    private void comBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBoxActionPerformed
        // TODO add your handling code here:
        if(comBox.getSelectedIndex() == 0){
            tipCom = "Semestral";
        }else if(comBox.getSelectedIndex() == 1){
            tipCom = "Anual";
        }
    }//GEN-LAST:event_comBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceButton;
    private javax.swing.JLabel add1Label;
    private javax.swing.JTextField add1TextField;
    private javax.swing.JLabel add2Label;
    private javax.swing.JTextField add2TextField;
    private javax.swing.JButton canButton;
    private javax.swing.JComboBox<String> comBox;
    private javax.swing.JTextField fecTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField numTextField;
    private javax.swing.JTextField salMinTextField;
    private javax.swing.JTextField salTextField;
    private javax.swing.JComboBox<String> tipoBox;
    private javax.swing.JTextField titTextField;
    // End of variables declaration//GEN-END:variables
}
