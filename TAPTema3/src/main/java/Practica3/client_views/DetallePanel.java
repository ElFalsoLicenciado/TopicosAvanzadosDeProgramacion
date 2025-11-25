package Practica3.client_views;

import Practica3.admin_views.*;
import Practica3.model_layer.Detalle;
import Practica3.model_layer.Producto;

import java.util.Base64;
import javax.swing.ImageIcon;

public class DetallePanel extends javax.swing.JPanel {

    private Detalle detalle;

    public DetallePanel() {
        initComponents();
    }

    public DetallePanel(Detalle detalle) {
        this.detalle = new Detalle();

        initComponents();
        Producto producto = detalle.getProducto();

        labelNombre.setText(producto.getNombre_producto());
        labelPrecio.setText("$" + detalle.getPrecio_unitario());
        labelCantidad.setText("" + detalle.getCantidad());

        labelCategoria.setText(
                producto.getCategoria().getNombre_categoria()
                        + "\n - " + producto.getProveedor().getNombre_proveedor()
        );

        labelTotal.setText("$" + detalle.getSubtotal());

        if(producto.getFoto_producto() != null) {
            try {
                byte[] foto = Base64.getDecoder().decode(producto.getFoto_producto());
                panelImage1.setIcon(new ImageIcon(foto));
                panelImage1.updateUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        labelCantidad = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        labelCategoria = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelNombre.setText("Nombre");
        add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        labelCantidad.setText("Cantidad");
        add(labelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        labelPrecio.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        labelPrecio.setForeground(new java.awt.Color(0, 204, 204));
        labelPrecio.setText("Precio");
        add(labelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 65, -1, -1));

        labelCategoria.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        labelCategoria.setForeground(new java.awt.Color(102, 102, 102));
        labelCategoria.setText("Categoria");
        add(labelCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        labelTotal.setFont(new java.awt.Font("Roboto", 2, 15)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(0, 204, 0));
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotal.setText("Total");
        add(labelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 80, -1));

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

        add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelTotal;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    // End of variables declaration//GEN-END:variables
}
