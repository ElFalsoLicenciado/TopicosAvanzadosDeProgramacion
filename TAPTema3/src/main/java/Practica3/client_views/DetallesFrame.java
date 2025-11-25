package Practica3.client_views;


import Practica3.model_layer.Detalle;
import Practica3.model_layer.Venta;

import javax.swing.*;

public class DetallesFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.
            getLogger(DetallesFrame.class.getName());

    private Venta venta;

    public DetallesFrame() {
        initComponents();
    }

    public DetallesFrame(Venta venta) {
        this.venta = venta;

        initComponents();

        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        listado = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitle.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        labelTitle.setText("Listado de productos vendidos");
        getContentPane().add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        javax.swing.GroupLayout listadoLayout = new javax.swing.GroupLayout(listado);
        listado.setLayout(listadoLayout);
        listadoLayout.setHorizontalGroup(
            listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );
        listadoLayout.setVerticalGroup(
            listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        getContentPane().add(listado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, -1, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        actualizaListado();
    }//GEN-LAST:event_formWindowOpened

    private void actualizaListado() {
        listado.removeAll();

        for (Detalle d : venta.getDetalles()) {
            listado.add(new DetallePanel(d));
            listado.add(new JSeparator());
        }
        listado.updateUI();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new DetallesFrame().
                setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel listado;
    // End of variables declaration//GEN-END:variables
}
