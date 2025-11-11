package Practica2;

import Practica2.model_layer.models.Contacto;

import javax.swing.*;

public class ContactoPanel extends javax.swing.JPanel {


    private PrincipalFrame frame;
    private Contacto contacto;


    public ContactoPanel() {
        initComponents();
    }
    
    public ContactoPanel(PrincipalFrame frame,Contacto contacto) {
        initComponents();

        this.frame = frame;
        this.contacto = contacto;
        
        labelNombre.setText(contacto.getNombre_contacto());
        labelTelefono.setText(contacto.getTelefono());
        labelCorreo.setText(contacto.getCorreo());
        labelUsuario.setText(
            "Pertenece al usuario: " +
            contacto.getUsuario().getCorreo()
        );
        
        
        if(contacto.getFoto_contacto() != null) {
            try {
                panelImage1.setIcon(
                    new ImageIcon(contacto.getFoto_contacto())
                );
                panelImage1.updateUI();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error");
            }
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        labelNombre = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        labelNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNombre.setText("Nombre del contacto");

        labelTelefono.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        labelTelefono.setText("Telefono del contacto");

        labelCorreo.setForeground(new java.awt.Color(0, 153, 255));
        labelCorreo.setText("Correo del contacto");

        labelUsuario.setText("Contacto de...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(labelTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNombre)
                        .addGap(18, 18, 18)
                        .addComponent(labelTelefono)
                        .addGap(18, 18, 18)
                        .addComponent(labelCorreo)
                        .addGap(18, 18, 18)
                        .addComponent(labelUsuario)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        frame.seleccionarContacto(contacto);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelUsuario;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    // End of variables declaration//GEN-END:variables
}
