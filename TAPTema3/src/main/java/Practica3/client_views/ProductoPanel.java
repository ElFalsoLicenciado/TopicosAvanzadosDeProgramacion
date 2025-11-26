package Practica3.client_views;

import Practica3.model_layer.Producto;

import java.util.Base64;
import javax.swing.*;


public class ProductoPanel extends javax.swing.JPanel {

    private SelectorProductosFrame frame;

    private Producto producto;

    public ProductoPanel() {
        initComponents();
    }

    public ProductoPanel(SelectorProductosFrame frame, Producto producto) {
        this.producto = producto;
        this.frame = frame;

        initComponents();

        labelNombre.setText(producto.getNombre_producto());
        labelPrecio.setText("$" + producto.getPrecio());
        labelCantidad.setText("" + producto.getCantidad());

        labelCategoria.setText(
                producto.getCategoria().getNombre_categoria()
                        + "\n - " + producto.getProveedor().getNombre_proveedor()
        );

        if(producto.getFoto_producto() != null) {
            try {
                byte[] foto = Base64.getDecoder().decode(producto.getFoto_producto());
                panelImage1.setIcon(new ImageIcon(foto));
                panelImage1.updateUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        updateUI();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        labelNombre = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        labelCantidad = new javax.swing.JLabel();
        labelCategoria = new javax.swing.JLabel();

        setForeground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        labelNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelNombre.setText("Nombre");
        add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 5, 180, -1));

        labelPrecio.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        labelPrecio.setForeground(new java.awt.Color(0, 204, 204));
        labelPrecio.setText("Precio");
        add(labelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 62, 180, -1));

        labelCantidad.setText("Cantidad");
        add(labelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 90, 180, -1));

        labelCategoria.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        labelCategoria.setForeground(new java.awt.Color(102, 102, 102));
        labelCategoria.setText("Categoria");
        add(labelCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, 155, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        frame.seleccionarProducto(producto);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrecio;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    // End of variables declaration//GEN-END:variables
}
