package Practica3.client_views;

import Practica3.model_layer.Usuario;
import Practica3.model_layer.Venta;
import Practica3.services.VentaServices;

import javax.swing.*;
import java.util.ArrayList;


public class ClientFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ClientFrame.class.getName());
    
    private Usuario usuario;
    private Seccion seccion;

    private VentaServices ventaServices = new VentaServices();

    private ArrayList<Venta> ventas;

    public ClientFrame() {
        initComponents();
    }

    public ClientFrame(Usuario u) {
        this.usuario = u;
        
        initComponents();
        
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        item1 = new javax.swing.JMenuItem();
        item2 = new javax.swing.JMenuItem();
        btnGestion = new javax.swing.JButton();
        labelTitle = new javax.swing.JLabel();
        listado = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();

        item1.setText("Carrito");
        item1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(item1);

        item2.setText("Historial");
        item2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(item2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGestion.setText("Menu");
        btnGestion.setBorder(null);
        btnGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 30));

        labelTitle.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        labelTitle.setText("Productos en carrito");
        getContentPane().add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        javax.swing.GroupLayout listadoLayout = new javax.swing.GroupLayout(listado);
        listado.setLayout(listadoLayout);
        listadoLayout.setHorizontalGroup(
            listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        listadoLayout.setVerticalGroup(
            listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(listado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 490, 300));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionActionPerformed
        jPopupMenu1.show(
            btnGestion,
            btnGestion.getLocation().x + btnGestion.getSize().width - 5,
            btnGestion.getLocation().y - 5
        );
    }//GEN-LAST:event_btnGestionActionPerformed

    private void item1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item1ActionPerformed
        seccion = Seccion.CARRITO;
        labelTitle.setText("Productos en tu carrito:");
        actualizaListado();
    }//GEN-LAST:event_item1ActionPerformed

    private void item2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item2ActionPerformed
        seccion = Seccion.HISTORIAL;
        labelTitle.setText("Listado de compras:");
        actualizaListado();
    }//GEN-LAST:event_item2ActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void actualizaListado(){
        listado.removeAll();
        btnAgregar.setVisible(seccion != Seccion.HISTORIAL);
        btnPagar.setVisible(seccion != Seccion.HISTORIAL);

        ventas.clear();


        try {
            switch (seccion) {
                case CARRITO -> {

                }
                case HISTORIAL -> {
                    ventas = ventaServices.getVentasUsuario(usuario.getId_usuario());
                    for (Venta v : ventas) {
                        listado.add(new VentaPanel(this, v));
                        listado.add(new JSeparator());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verDetalles(Venta venta) {
        new DetallesFrame(venta).setVisible(true);
    }

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ClientFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGestion;
    private javax.swing.JButton btnPagar;
    private javax.swing.JMenuItem item1;
    private javax.swing.JMenuItem item2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel listado;
    // End of variables declaration//GEN-END:variables

    public enum Seccion {
        CARRITO, HISTORIAL;
    }

}
