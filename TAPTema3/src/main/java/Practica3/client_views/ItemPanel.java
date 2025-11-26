package Practica3.client_views;

import Practica3.model_layer.ItemCarrito;
import Practica3.model_layer.Producto;

public class ItemPanel extends javax.swing.JPanel {

    private ClientFrame frame;

    private ItemCarrito item;


    public ItemPanel() {
        initComponents();
    }

    public ItemPanel(ClientFrame frame, ItemCarrito item){
        this.frame = frame;
        this.item = item;

        initComponents();

        Producto producto = item.getProducto();

        labelNombre.setText(producto.getNombre_producto());

        labelCategoria.setText(producto.getCategoria().getNombre_categoria());

        labelPrecio.setText("$" + item.getPrecio());

        labelCantidad.setText("" + item.getCantidad());

        updateUI();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        labelCategoria = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        labelCantidad = new javax.swing.JLabel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelNombre.setText("Nombre");
        add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 6, 180, -1));

        labelCategoria.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        labelCategoria.setForeground(new java.awt.Color(102, 102, 102));
        labelCategoria.setText("Categoria");
        add(labelCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 30, 155, -1));

        labelPrecio.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        labelPrecio.setForeground(new java.awt.Color(0, 204, 204));
        labelPrecio.setText("Precio");
        add(labelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 65, 180, -1));

        labelCantidad.setText("Cantidad");
        add(labelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 90, 180, -1));

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

        btnEditar.setForeground(new java.awt.Color(0, 102, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        btnBorrar.setForeground(new java.awt.Color(255, 51, 0));
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        new SelectorProductosFrame(frame, item, item.getProducto()).setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        frame.eliminarItem(item);
    }//GEN-LAST:event_btnBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrecio;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    // End of variables declaration//GEN-END:variables
}
