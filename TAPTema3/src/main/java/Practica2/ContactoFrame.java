/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Practica2;

import Practica2.model_layer.models.Contacto;
import Practica2.model_layer.models.Usuario;
import Practica2.model_layer.services.ContactoService;

import java.awt.*;
import java.nio.file.Files;
import javax.swing.*;


public class ContactoFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.
            getLogger(ContactoFrame.class.getName());

    private PrincipalFrame frame;
    private Usuario usuario;
    private Contacto contacto;
    private boolean editing;


    public ContactoFrame() {
        initComponents();
    }

    public ContactoFrame(PrincipalFrame frame, Usuario usuario) throws HeadlessException {
        initComponents();
        setLocationRelativeTo(null);

        this.frame = frame;
        this.usuario = usuario;
        contacto = new Contacto();
        editing = false;
        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\Users\\User\\Downloads\\Media\\Images"));

    }

    public ContactoFrame(PrincipalFrame frame, Contacto contacto) {
        initComponents();
        setLocationRelativeTo(null);

        this.frame = frame;
        this.usuario = contacto.getUsuario();
        this.contacto = contacto;

        fieldNombre.setText(contacto.getNombre_contacto());
        fieldTelefono.setText(contacto.getTelefono());
        fieldCorreo.setText(contacto.getCorreo());

        if (contacto.getFoto_contacto() != null) {
            updateFoto(contacto.getFoto_contacto());
        }
        editing = true;
        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\Users\\User\\Downloads\\Media\\Images"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        btnCambiarFoto = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldTelefono = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fieldCorreo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        getContentPane().add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 150, -1));

        btnCambiarFoto.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnCambiarFoto.setText("Cambiar foto...");
        btnCambiarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarFotoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCambiarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 150, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 6, 20, 247));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("Nombre completo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 15, 190, -1));

        fieldNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        getContentPane().add(fieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 182, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Telefono:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 81, 190, -1));

        fieldTelefono.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        getContentPane().add(fieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 182, -1));

        btnGuardar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 182, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Correo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 190, -1));

        fieldCorreo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        getContentPane().add(fieldCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 182, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateFoto(byte[] bytesImage) {
        try {
            panelImage1.setIcon(
                    new ImageIcon(bytesImage)
            );
            panelImage1.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");
        }
    }

    private void btnCambiarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarFotoActionPerformed
        if(jFileChooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                byte[] foto = Files.readAllBytes(
                        jFileChooser1.getSelectedFile().toPath()
                );
                contacto.setFoto_contacto(foto);
                updateFoto(foto);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error");
            }
        }
    }//GEN-LAST:event_btnCambiarFotoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        contacto.setNombre_contacto(fieldNombre.getText());
        contacto.setTelefono(fieldTelefono.getText());
        contacto.setCorreo(fieldCorreo.getText());


        try {
            ContactoService service = new ContactoService();

            if ( ! editing){
                contacto.setId_usuario(usuario.getId_usuario());
                contacto.setUsuario(usuario);
                if(service.addContacto(contacto)) {
                    JOptionPane.showMessageDialog(null,"Nuevo contacto agregado.");
                } else throw new Exception();

            }
            else {
                if (service.editContacto(contacto)) {
                    JOptionPane.showMessageDialog(null, "Contacto actualizado.");
                } else throw new Exception();
            }
            frame.resetFrame();
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al guardar");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.
                    getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ContactoFrame().setVisible(
                true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarFoto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField fieldCorreo;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldTelefono;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    // End of variables declaration//GEN-END:variables
}
