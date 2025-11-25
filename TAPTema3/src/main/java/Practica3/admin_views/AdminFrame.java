package Practica3.admin_views;

import Practica3.model_layer.*;
import Practica3.services.CategoriaService;
import Practica3.services.ProductoService;
import Practica3.services.ProveedorService;
import Practica3.services.VentaServices;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;


public class AdminFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminFrame.class.getName());

    private Usuario usuario;
    private BoxLayout boxLayout;
    private final ProductoService productoService = new ProductoService();
    private final CategoriaService categoriaService = new CategoriaService();
    private final ProveedorService proveedorService = new ProveedorService();
    private final VentaServices ventaService = new VentaServices();

    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Proveedor> proveedores = new ArrayList<>();
    private ArrayList<Categoria> categorias = new ArrayList<>();
    private ArrayList<Venta> ventas = new ArrayList<>();
    private Seccion seleccion;

    public AdminFrame() {
        initComponents();
    }

    public AdminFrame(Usuario u) {
        this.usuario = u;
        seleccion = Seccion.PRODUCTOS;

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
        item3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        item4 = new javax.swing.JMenuItem();
        btnGestion = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        labelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listado = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();

        item1.setText("Productos");
        item1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(item1);

        item2.setText("Categorias");
        item2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(item2);

        item3.setText("Proveedores");
        item3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(item3);
        jPopupMenu1.add(jSeparator1);

        item4.setText("Ventas");
        item4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item4ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(item4);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin Tienda");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnGestion.setText("Gestión");
        btnGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo producto");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        labelTitle.setText("Listado de productos:");

        javax.swing.GroupLayout listadoLayout = new javax.swing.GroupLayout(listado);
        listado.setLayout(listadoLayout);
        listadoLayout.setHorizontalGroup(
            listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );
        listadoLayout.setVerticalGroup(
            listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(listado);

        btnBuscar.setText("Buscar...");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGestion)
                    .addComponent(btnNuevo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitle)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionActionPerformed
        jPopupMenu1.show(
                btnGestion,
                btnGestion.getLocation().x + btnGestion.getSize().width - 5,
                btnGestion.getLocation().y - 5
        );
    }//GEN-LAST:event_btnGestionActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        actualizaListado("");
    }//GEN-LAST:event_formWindowOpened

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String message = "";
        switch (seleccion) {
            case PRODUCTOS -> message = "Producto:";
            case CATEGORIAS -> message = "Categorias:";
            case PROVEEDORES -> message = "Proveedores:";
            case VENTAS -> message = "Ventas:";
        }
        String buscar = JOptionPane.showInputDialog(message);
        actualizaListado(buscar);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        switch (seleccion) {
            case PRODUCTOS -> new ProductoFormFrame(this, null).setVisible(true);
            case CATEGORIAS -> {
                Categoria categoria = new Categoria();
                String nombre = JOptionPane.showInputDialog(null, "Nombre categoria:");

                if (nombre.length() < 2) {
                    JOptionPane.showMessageDialog(null, "Nombre de la categoria muy corto.");
                    return;
                }
                categoria.setNombre_categoria(nombre);
                try {
                    categoriaService.addCategoria(categoria);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case PROVEEDORES -> new ProveedorFormFrame(this, null).setVisible(true);
        }
        actualizaListado("");

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void item1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item1ActionPerformed
        seleccion = Seccion.PRODUCTOS;
        labelTitle.setText("Listado de productos");
        btnNuevo.setText("Nuevo producto");
        actualizaListado("");
    }//GEN-LAST:event_item1ActionPerformed

    private void item2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item2ActionPerformed
        seleccion = Seccion.CATEGORIAS;
        labelTitle.setText("Listado de categorías");
        btnNuevo.setText("Nueva categoría");
        actualizaListado("");
    }//GEN-LAST:event_item2ActionPerformed

    private void item4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item4ActionPerformed
        seleccion = Seccion.VENTAS;
        labelTitle.setText("Listado de ventas");
        actualizaListado("");
    }//GEN-LAST:event_item4ActionPerformed

    private void item3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item3ActionPerformed
        seleccion = Seccion.PROVEEDORES;
        labelTitle.setText("Listado de proveedores");
        btnNuevo.setText("Nuevo proveedor");
        actualizaListado("");
    }//GEN-LAST:event_item3ActionPerformed

    public void actualizaListado(String buscar) {
        listado.removeAll();

        btnNuevo.setVisible(seleccion != Seccion.VENTAS);
        btnBuscar.setVisible(seleccion != Seccion.VENTAS);

        productos.clear();
        categorias.clear();
        proveedores.clear();
        ventas.clear();

        try {
            switch (seleccion) {
                case PRODUCTOS -> {
                    productos = productoService.getProductos(buscar);
                    for (Producto p : productos) {
                        listado.add(new ProductoPanel(this, p));
                        listado.add(new javax.swing.JSeparator());
                    }
                }

                case CATEGORIAS -> {
                    categorias = categoriaService.showCategorias(buscar);
                    for (Categoria c : categorias) {
                        listado.add(new CategoriaPanel(this, c));
                        listado.add(new javax.swing.JSeparator());

                    }
                }

                case PROVEEDORES -> {
                    proveedores = proveedorService.showProveedores(buscar);
                    for (Proveedor p : proveedores) {
                        listado.add(new ProveedorPanel(this, p));
                        listado.add(new javax.swing.JSeparator());

                    }
                }

                case VENTAS -> {
                    ventas = ventaService.getVentas();
                    for (Venta v : ventas) {
                        listado.add(new VentaPanel(this, v));
                        listado.add(new javax.swing.JSeparator());
                    }
//                    listado.add(); uwu
                }
            }

            listado.updateUI();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar el listado");
        }
    }

    public void verDetalles(Venta venta) {
        new DetallesFrame(venta).setVisible(true);
    }

    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AdminFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGestion;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JMenuItem item1;
    private javax.swing.JMenuItem item2;
    private javax.swing.JMenuItem item3;
    private javax.swing.JMenuItem item4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel listado;
    // End of variables declaration//GEN-END:variables

    public enum Seccion {
        PRODUCTOS,
        CATEGORIAS,
        PROVEEDORES,
        VENTAS
    }
}

