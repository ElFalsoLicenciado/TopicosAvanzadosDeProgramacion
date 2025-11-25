package Practica3.admin_views;


import Practica3.model_layer.Categoria;
import Practica3.services.CategoriaService;

import javax.swing.*;

public class CategoriaPanel extends javax.swing.JPanel {

    private final CategoriaService service = new CategoriaService();
    private AdminFrame frame;

    private Categoria categoria;

    public CategoriaPanel() {
        initComponents();
    }

    public CategoriaPanel(AdminFrame frame, Categoria categoria) {
        this.categoria = categoria;
        this.frame = frame;

        initComponents();

        labelNombre.setText(categoria.getNombre_categoria());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNombre.setFont(new java.awt.Font("Roboto", 2, 15)); // NOI18N
        labelNombre.setText("Nombre");
        add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));

        label1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        label1.setText("Categoría:");
        add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 180, -1));

        btnEditar.setForeground(new java.awt.Color(0, 102, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 15, 84, -1));

        btnBorrar.setForeground(new java.awt.Color(255, 51, 0));
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 65, 84, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String nombre;
        nombre = JOptionPane.showInputDialog(null, "Dame el nuevo nombre de la categoría: ");
        if (nombre.length() > 2) {
            categoria.setNombre_categoria(nombre);
            try {
                if(service.updateCategoria(categoria))
                    JOptionPane.showMessageDialog(null, "Editado");
            } catch (Exception e) {
                e.printStackTrace();
            }
            repaint();
            frame.actualizaListado("");
            return;
        }
        JOptionPane.showMessageDialog(null, "El nombre es muy corto.");

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try {
            if(service.deleteCategoria(categoria)) {
                frame.actualizaListado("");
                JOptionPane.showMessageDialog(null, "Categoria eliminada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel labelNombre;
    // End of variables declaration//GEN-END:variables
}
