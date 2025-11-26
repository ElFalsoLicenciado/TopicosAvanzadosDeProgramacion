package Practica3.client_views;

import Practica3.model_layer.ItemCarrito;
import Practica3.model_layer.Producto;
import Practica3.services.ProductoService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class SelectorProductosFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.
            getLogger(SelectorProductosFrame.class.getName());

    private BoxLayout boxLayout;

    private ClientFrame frame;
    private ArrayList<Producto> productos;
    private Producto seleccion;
    private ItemCarrito itemCarrito;
    private boolean nuevo;

    public SelectorProductosFrame() {
        initComponents();
    }

    public SelectorProductosFrame(ClientFrame frame) {
        this.frame = frame;
        productos = new ArrayList<>();
        seleccion = new Producto();
        itemCarrito = new ItemCarrito();

        initComponents();

        setLocationRelativeTo(null);

        boxLayout = new BoxLayout(
                listado,
                BoxLayout.Y_AXIS
        );
        listado.setLayout(boxLayout);


        btnAgregar.setVisible(false);
        jLabel3.setVisible(false);
        spinnerCantidad.setVisible(false);
        nuevo = true;

        mostrarProductos();
    }

    public SelectorProductosFrame(ClientFrame frame, ItemCarrito itemCarrito, Producto seleccion) {
        this.frame = frame;
        this.seleccion = seleccion;
        this.itemCarrito = itemCarrito;

        initComponents();

        setLocationRelativeTo(null);

        boxLayout = new BoxLayout(
                listado,
                BoxLayout.Y_AXIS
        );
        listado.setLayout(boxLayout);


        btnAgregar.setText("Guardar");
        btnAgregar.setVisible(true);
        jLabel3.setVisible(true);
        jLabel3.setText("Editar item de carrito:");
        spinnerCantidad.setVisible(true);
        spinnerCantidad.setValue(itemCarrito.getCantidad());

        nuevo = false;

        mostrarProducto();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        spinnerCantidad = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listado = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(565, 537));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitle.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        labelTitle.setText("Productos disponibles:");
        getContentPane().add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, -1, -1));

        spinnerCantidad.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        spinnerCantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, 9999, 1));
        spinnerCantidad.setBorder(null);
        getContentPane().add(spinnerCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel3.setText("Cantidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        listado.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout listadoLayout = new javax.swing.GroupLayout(listado);
        listado.setLayout(listadoLayout);
        listadoLayout.setHorizontalGroup(
            listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        listadoLayout.setVerticalGroup(
            listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(listado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 530, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int cantidad = (Integer) spinnerCantidad.getValue();
        double precio = seleccion.getPrecio();
        double subtotal = cantidad * precio;

        if (cantidad > seleccion.getCantidad()) {
            JOptionPane.showMessageDialog(null, "No puedes comprar mas productos de los que hay!");
            return;
        }

        if (cantidad == 0) {
            JOptionPane.showMessageDialog(null, "No puedes comprar 0 productos !");
            return;
        }

        itemCarrito.setCantidad(cantidad);
        itemCarrito.setProducto(seleccion);
        itemCarrito.setPrecio(precio);
        itemCarrito.setSubtotal(subtotal);

        if (nuevo) frame.agregarItem(itemCarrito);
        else frame.editarItem(itemCarrito);

        dispose();

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    public void mostrarProductos() {
        listado.removeAll();

        try {
            ArrayList<Producto> seleccionados = new ArrayList<>();

            for (ItemCarrito i : frame.getCarrito()) {
                seleccionados.add(i.getProducto());
            }

            productos = new ProductoService().getProductos("");

            Set<String> idsSeleccionados = seleccionados.stream()
                    .map(Producto::getId_producto)
                    .collect(Collectors.toSet());



            for (Producto p : productos) {
                if (! idsSeleccionados.contains(p.getId_producto())) {
                    listado.add(new ProductoPanel(this, p));
                    listado.add(new javax.swing.JSeparator());
                }
            }

            listado.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarProducto(){
        listado.add(new ProductoPanel(this, seleccion));
        listado.updateUI();
    }

    public void seleccionarProducto(Producto p) {
        seleccion = p;

        btnAgregar.setVisible(true);
        jLabel3.setVisible(true);
        spinnerCantidad.setVisible(true);

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new SelectorProductosFrame().
                setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel listado;
    private javax.swing.JSpinner spinnerCantidad;
    // End of variables declaration//GEN-END:variables
}
