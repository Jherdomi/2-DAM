/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.*;
import Modelo.*;

/**
 *
 * @author alumno
 */
public class Base extends javax.swing.JPanel {

    public static Lista lista = new Lista();
    public static Lista listaAux;
    private static boolean flagFiltro = false;
    
    
    public Base() {
        initComponents();
        
        antButton.setEnabled(false);
        
        numTextField.setFocusable(false);
        numTextField.setEditable(false);
        
        fecTextField.setFocusable(false);
        fecTextField.setEditable(false);
        
        salTextField.setFocusable(false);
        salTextField.setEditable(false);
        
        propTextField.setFocusable(false);
        propTextField.setEditable(false);
        
        agregarDatos();
        mostrarDatos();
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        numTextField = new javax.swing.JTextField();
        fecTextField = new javax.swing.JTextField();
        salTextField = new javax.swing.JTextField();
        propTextField = new javax.swing.JTextField();
        antButton = new javax.swing.JButton();
        crearButton = new javax.swing.JButton();
        SigButton = new javax.swing.JButton();
        aceButton = new javax.swing.JButton();
        canButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        jLabel1.setText("Cuentas de Banco");

        jLabel2.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 14)); // NOI18N
        jLabel2.setText("Número de Cuenta: ");

        jLabel3.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 14)); // NOI18N
        jLabel3.setText("Fecha de Apertura:");

        jLabel4.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 14)); // NOI18N
        jLabel4.setText("Saldo:");

        jLabel5.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 14)); // NOI18N
        jLabel5.setText("Propietario:");

        numTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numTextFieldActionPerformed(evt);
            }
        });

        antButton.setText("Anterior");
        antButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                antButtonActionPerformed(evt);
            }
        });

        crearButton.setText("Crear");
        crearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearButtonActionPerformed(evt);
            }
        });

        SigButton.setText("Siguiente");
        SigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SigButtonActionPerformed(evt);
            }
        });

        aceButton.setText("Aceptar");
        aceButton.setEnabled(false);
        aceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceButtonActionPerformed(evt);
            }
        });

        canButton.setText("Cancelar");
        canButton.setEnabled(false);
        canButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(antButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(crearButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(SigButton))
                                    .addComponent(fecTextField)
                                    .addComponent(salTextField)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(propTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(aceButton)
                        .addGap(39, 39, 39)
                        .addComponent(canButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(propTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceButton)
                    .addComponent(canButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antButton)
                    .addComponent(crearButton)
                    .addComponent(SigButton))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void numTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numTextFieldActionPerformed

    private void crearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearButtonActionPerformed
        // TODO add your handling code here:
        numTextField.setText("");
        numTextField.setFocusable(true);
        numTextField.setEditable(true);
        
        fecTextField.setText("");
        fecTextField.setFocusable(true);
        fecTextField.setEditable(true);
        
        salTextField.setText("");
        salTextField.setFocusable(true);
        salTextField.setEditable(true);
        
        propTextField.setText("");
        propTextField.setFocusable(true);
        propTextField.setEditable(true);
        
        SigButton.setEnabled(false);
        antButton.setEnabled(false);
        crearButton.setEnabled(false);
        aceButton.setEnabled(true);
        canButton.setEnabled(true);
    }//GEN-LAST:event_crearButtonActionPerformed

    private void canButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canButtonActionPerformed
        // TODO add your handling code here:
        numTextField.setFocusable(false);
        numTextField.setEditable(false);
        
        fecTextField.setFocusable(false);
        fecTextField.setEditable(false);
        
        salTextField.setFocusable(false);
        salTextField.setEditable(false);
        
        propTextField.setFocusable(false);
        propTextField.setEditable(false);
        SigButton.setEnabled(true);
        crearButton.setEnabled(true);
        aceButton.setEnabled(false);
        canButton.setEnabled(false);
        
        mostrarDatos();
    }//GEN-LAST:event_canButtonActionPerformed

    private void antButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_antButtonActionPerformed
        // TODO add your handling code here:
        if (flagFiltro) 
            retroceder(listaAux);
        else 
            retroceder(lista);
    }//GEN-LAST:event_antButtonActionPerformed

    private void SigButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SigButtonActionPerformed
        // TODO add your handling code here:
        if (flagFiltro) 
            avanzar(listaAux);
        else 
            avanzar(lista);
    }//GEN-LAST:event_SigButtonActionPerformed

    private void aceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceButtonActionPerformed
        // TODO add your handling code here:
        
        String num = numTextField.getText();
        String fec = fecTextField.getText();
        String sal = salTextField.getText();
        String prop = propTextField.getText();
        
//        if("".equals(num) && "".equals(fec) && "".equals(sal) && "".equals(prop)){
//            lista.crearNodo(new Cuenta());
//        }else if("".equals(num) && "".equals(sal) && "".equals(prop)){
//            lista.crearNodo(new Cuenta(
//                    Integer.parseInt(numTextField.getText()),
//                    fecTextField.getText(),
//                    Float.parseFloat(salTextField.getText()),
//                    propTextField.getText()
//            ));
//        }else{
//            lista.crearNodo(new Cuenta(
//                    Integer.parseInt(numTextField.getText()),
//                    Float.parseFloat(salTextField.getText()),
//                    propTextField.getText()
//            ));
//        }
        
        if("".equals(num) && "".equals(fec) && "".equals(sal) && "".equals(prop)){
            lista.crearNodo(new Cuenta());
        }else if("".equals(fec)){
            lista.crearNodo(new Cuenta(
                    Integer.parseInt(numTextField.getText()),
                    Float.parseFloat(salTextField.getText()),
                    propTextField.getText()
            ));
        }else{
            lista.crearNodo(new Cuenta(
                    Integer.parseInt(numTextField.getText()),
                    fecTextField.getText(),
                    Float.parseFloat(salTextField.getText()),
                    propTextField.getText()
            ));
            
        }
        
        numTextField.setFocusable(false);
        numTextField.setEditable(false);
        
        fecTextField.setFocusable(false);
        fecTextField.setEditable(false);
        
        salTextField.setFocusable(false);
        salTextField.setEditable(false);
        
        propTextField.setFocusable(false);
        propTextField.setEditable(false);
        SigButton.setEnabled(true);
        crearButton.setEnabled(true);
        aceButton.setEnabled(false);
        canButton.setEnabled(false);
        
        
        mostrarDatos();
    }//GEN-LAST:event_aceButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SigButton;
    private javax.swing.JButton aceButton;
    private javax.swing.JButton antButton;
    private javax.swing.JButton canButton;
    private javax.swing.JButton crearButton;
    private javax.swing.JTextField fecTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField numTextField;
    private javax.swing.JTextField propTextField;
    private javax.swing.JTextField salTextField;
    // End of variables declaration//GEN-END:variables
    
    public void mostrarDatos(){
        numTextField.setText(String.valueOf(lista.getDato().getNumero()));
        fecTextField.setText(lista.getDato().getFecha());
        salTextField.setText(String.valueOf(lista.getDato().getSaldo()));
        propTextField.setText(lista.getDato().getProp());
    }
    
    public void agregarDatos(){
        lista.crearNodo(new Cuenta());
        lista.crearNodo(new Cuenta(2, 12.0f, "Manuel"));
        lista.crearNodo(new Cuenta(3, 14.5f, "Rosa"));
        lista.crearNodo(new Cuenta(4, "12/12/2020", 123.23f, "Pepe"));
    }

   private void retroceder(Lista lista) {
        if (!lista.tieneAnterior())
            antButton.setEnabled(false);
        else {
            lista.ant();
            if (!SigButton.isEnabled())
                SigButton.setEnabled(true);
            if (!lista.tieneAnterior())
                antButton.setEnabled(false);
            mostrarDatos();
        }
    }

    private void avanzar(Lista lista) {
        if (!lista.tieneSiguiente()) 
            SigButton.setEnabled(false);
        else {
            lista.sig();
            if (!lista.tieneSiguiente())
                SigButton.setEnabled(false);
            if (!antButton.isEnabled())
                antButton.setEnabled(true);
            mostrarDatos();
        }
    }
    
}


