package Practica3.admin_views;

import Practica3.model_layer.Proveedor;
import Practica3.services.ProveedorService;

import javax.swing.*;

public class ProveedorPanel extends javax.swing.JPanel {
    
    
    private final ProveedorService service = new ProveedorService();
    private AdminFrame frame;

    private Proveedor proveedor;

    
    public ProveedorPanel() {
        initComponents();
    }

    public ProveedorPanel(AdminFrame frame, Proveedor proveedor) {
        this.proveedor = proveedor;
        this.frame = frame;

        initComponents();

        labelNombre.setText(proveedor.getNombre_proveedor());

        labelSurte.setText(proveedor.getFecha_surte());

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelSurte = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSurte.setFont(new java.awt.Font("Roboto", 2, 15)); // NOI18N
        labelSurte.setText("Fecha de surte");
        add(labelSurte, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));

        labelNombre.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        labelNombre.setText("Nombre: ");
        add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 180, -1));

        btnEditar.setForeground(new java.awt.Color(0, 102, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 15, 84, -1));

        btnBorrar.setForeground(new java.awt.Color(255, 51, 0));
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 65, 84, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        new ProveedorFormFrame(frame, proveedor).setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try {
            if (service.deleteProveedor(proveedor)) {
                frame.actualizaListado("");
                JOptionPane.showMessageDialog(null, "Proveedor eliminado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelSurte;
    // End of variables declaration//GEN-END:variables
}
