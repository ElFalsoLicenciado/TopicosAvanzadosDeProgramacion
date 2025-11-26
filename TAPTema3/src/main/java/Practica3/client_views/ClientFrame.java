package Practica3.client_views;

import Practica3.model_layer.Detalle;
import Practica3.model_layer.ItemCarrito;
import Practica3.model_layer.Usuario;
import Practica3.model_layer.Venta;
import Practica3.services.VentaServices;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class ClientFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ClientFrame.class.getName());
    private BoxLayout boxLayout;

    private Usuario usuario;
    private Seccion seccion;

    private VentaServices ventaServices = new VentaServices();

    private ArrayList<ItemCarrito> carrito;
    private ArrayList<Venta> ventas;

    public ClientFrame() {
        initComponents();
    }

    public ClientFrame(Usuario u) {
        this.usuario = u;
        ventas = new ArrayList<>();
        carrito = new ArrayList<>();

        seccion = Seccion.CARRITO;

        initComponents();

        boxLayout = new BoxLayout(
                listado,
                BoxLayout.Y_AXIS
        );
        listado.setLayout(boxLayout);


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
        btnAgregar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listado = new javax.swing.JPanel();

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
        setSize(new java.awt.Dimension(534, 399));
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

        listado.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout listadoLayout = new javax.swing.GroupLayout(listado);
        listado.setLayout(listadoLayout);
        listadoLayout.setHorizontalGroup(
            listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        listadoLayout.setVerticalGroup(
            listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(listado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 510, 290));

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
        if (carrito.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos en tu carrito.");
            return;
        }
        try {
            Venta venta = crearVenta();
            venta = ventaServices.addVenta(venta);

            for (ItemCarrito item : carrito) {
                Detalle detalle = crearDetalle(item,venta);
                ventaServices.addDetalle(detalle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        carrito.clear();

        actualizaListado();

    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        new SelectorProductosFrame(this).setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void actualizaListado(){
        listado.removeAll();
        btnAgregar.setVisible(seccion != Seccion.HISTORIAL);
        btnPagar.setVisible(seccion != Seccion.HISTORIAL);

        ventas.clear();

        try {
            switch (seccion) {
                case CARRITO -> {
                    for (ItemCarrito i : carrito) {
                        listado.add(new ItemPanel(this, i));
                        listado.add(new JSeparator());
                    }
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

        listado.updateUI();
    }

    private Venta crearVenta() {
        Venta venta = new Venta();
        LocalDateTime fecha = LocalDateTime.now(); // solo fecha

        try {
            venta.setNumero(ventaServices.numeroDeVentas()+1);
            venta.setId_usuario(usuario.getId_usuario());
            venta.setFecha(fecha.toString());
            venta.setTotal(obtenerTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return venta;
    }

    private Detalle crearDetalle(ItemCarrito i, Venta venta) {
        Detalle detalle = new Detalle();

        detalle.setId_venta(venta.getId_venta());
        detalle.setNumero(venta.getNumero());
        detalle.setId_producto(i.getProducto().getId_producto());
        detalle.setNumero_producto(i.getProducto().getNumero_producto());
        detalle.setCantidad(i.getCantidad());
        detalle.setPrecio_unitario(i.getPrecio());
        detalle.setSubtotal(i.getSubtotal());

        return detalle;
    }

    private double obtenerTotal() {
        double total = 0.0;

        for (ItemCarrito i : carrito) {
            total += i.getSubtotal();
        }
        return total;
    }

    public void verDetalles(Venta venta) {
        new DetallesFrame(venta).setVisible(true);
    }

    public void agregarItem(ItemCarrito i) {
        carrito.add(i);
        actualizaListado();
    }

    public void editarItem(ItemCarrito i) {
        for (ItemCarrito item : carrito)
            if (item.getProducto().getId_producto().equals(i.getProducto().getId_producto())) {
                carrito.set(carrito.indexOf(item), i);
                break;
            }
        actualizaListado();
    }

    public void eliminarItem(ItemCarrito i) {
        carrito.remove(i);
        actualizaListado();
    }

    public ArrayList<ItemCarrito> getCarrito() {
        return carrito;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel listado;
    // End of variables declaration//GEN-END:variables

    public enum Seccion {
        CARRITO, HISTORIAL;
    }

}
