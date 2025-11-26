package Practica3.admin_views;

import Practica3.model_layer.Venta;

public class VentaPanel extends javax.swing.JPanel {

    private Venta venta;

    private AdminFrame frame;

    public VentaPanel() {
        initComponents();
    }

    public VentaPanel(AdminFrame frame, Venta venta) {
        this.venta = venta;
        this.frame = frame;

        initComponents();

        labelFecha.setText(venta.getFecha());
        labelTotal.setText("$"+venta.getTotal());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUsuario = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        labelUsuario.setText("Usuario");
        add(labelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 180, -1));

        labelTotal.setFont(new java.awt.Font("Roboto", 2, 15)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(0, 204, 0));
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotal.setText("Total");
        add(labelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 80, -1));

        labelFecha.setFont(new java.awt.Font("Roboto", 2, 15)); // NOI18N
        labelFecha.setText("Fecha");
        add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        frame.verDetalles(venta);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelUsuario;
    // End of variables declaration//GEN-END:variables
}
