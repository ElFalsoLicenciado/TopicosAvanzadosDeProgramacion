package Practica3.admin_views;

import Practica3.model_layer.Categoria;
import Practica3.model_layer.Producto;
import Practica3.model_layer.Proveedor;
import Practica3.services.CategoriaService;
import Practica3.services.ProductoService;
import Practica3.services.ProveedorService;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ProductoFormFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ProductoFormFrame.class.getName());
    
    private Producto producto;
    private ArrayList<Categoria> categorias;
    private ArrayList<Proveedor> proveedores;
    
    private ProductoService service = new ProductoService();
    private AdminFrame frame;
    
    private String fotoBase64 = null;
    private String nombreFoto = null;

    public ProductoFormFrame() {
        initComponents();
    }
    
    public ProductoFormFrame(AdminFrame frame, Producto producto) {
        this.producto = producto;
        this.frame = frame;

        initComponents();
        
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        btnCambiarFoto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fieldNombreProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spinnerPrecio = new javax.swing.JSpinner();
        spinnerCantidad = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboProveedor = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Guardar producto");
        setSize(new java.awt.Dimension(400, 362));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        btnCambiarFoto.setText("Cambiar foto...");
        btnCambiarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarFotoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre del producto:");

        jLabel2.setText("Precio:");

        jLabel3.setText("Cantidad:");

        spinnerPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 9999.0d, 2.5d));

        spinnerCantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, 9999, 1));

        jLabel4.setText("Categoria:");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Proveedor:");

        comboProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Guardar producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCambiarFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldNombreProducto)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(spinnerPrecio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spinnerCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(comboProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCambiarFoto)
                            .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            categorias = new CategoriaService().showCategorias("");
            proveedores = new ProveedorService().showProveedores("");
            
            comboCategoria.removeAllItems();
            for(Categoria c : categorias) {
                comboCategoria.addItem(c.getNombre_categoria());
            }
            
            comboProveedor.removeAllItems();
            for(Proveedor p : proveedores) {
                comboProveedor.addItem(p.getNombre_proveedor());
            }
            
            // Si existe producto, cargamos datos
            if(producto != null) {
                fieldNombreProducto.setText(producto.getNombre_producto());
                spinnerCantidad.setValue(producto.getCantidad());
                spinnerPrecio.setValue(producto.getPrecio());
                
                int index = 0;
                for(Categoria c : categorias) {
                    if(c.getId_categoria().equals(producto.getId_categoria())) {
                        comboCategoria.setSelectedIndex(index);
                        break;
                    }
                    index++;
                }
                
                index = 0;
                for(Proveedor p : proveedores) {
                    if(p.getId_proveedor().equals(producto.getId_proveedor())) {
                        comboProveedor.setSelectedIndex(index);
                        break;
                    }
                    index++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al cargar info");
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnCambiarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarFotoActionPerformed
        if(jFileChooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                System.out.println("Size: " + jFileChooser1.getSelectedFile().length());
                if(jFileChooser1.getSelectedFile().length() > 512000) {
                    throw new Exception("Error foto muy grande");
                }
                
                byte[] foto = Files.readAllBytes(
                    jFileChooser1.getSelectedFile().toPath()
                );
                
                nombreFoto = jFileChooser1.getSelectedFile().getName();
                
                fotoBase64 = Base64.getEncoder().encodeToString(foto);
                
                panelImage1.setIcon(new ImageIcon(foto));
                panelImage1.updateUI();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error");
            }
        }
    }//GEN-LAST:event_btnCambiarFotoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean esNuevo = false;
        boolean error = false;
        if(producto == null) {
            esNuevo = true;
            producto = new Producto();
        }
        
        if (categorias.get(comboCategoria.getSelectedIndex()).getId_categoria().isEmpty() || categorias.get(comboCategoria.getSelectedIndex()).getId_categoria() == null) {
            JOptionPane.showMessageDialog(null,"La categoria esta vacia.");
            error = true;
        }
        if (proveedores.get(comboProveedor.getSelectedIndex()).getId_proveedor().isEmpty() || proveedores.get(comboProveedor.getSelectedIndex()).getId_proveedor() == null)
        {
            JOptionPane.showMessageDialog(null,"El proveedor esta vacia.");
            error = true;
        }

        if (error){
            return;
        }
        try {
            if (esNuevo) producto.setId_producto("");

            producto.setNombre_producto(
                fieldNombreProducto.getText()
            );
            producto.setPrecio((Double) spinnerPrecio.getValue());
            producto.setCantidad((int) spinnerCantidad.getValue());
            producto.setId_categoria(
                categorias.get(comboCategoria.getSelectedIndex())
                    .getId_categoria()
            );
            producto.setId_proveedor(
                proveedores.get(comboProveedor.getSelectedIndex())
                    .getId_proveedor()
            );
            producto.setFoto_producto(fotoBase64);
            producto.setNombre_foto_producto(nombreFoto);
            
            if(esNuevo) {
                if(service.addProducto(producto)) {
                    JOptionPane.showMessageDialog(null,"Guardado");
                } else throw new Exception();
            } else {
                if(service.addProducto(producto)) {
                    JOptionPane.showMessageDialog(null,"Editado");
                } else throw new Exception();
            }
            frame.actualizaListado("");
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al guardar");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ProductoFormFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarFoto;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboProveedor;
    private javax.swing.JTextField fieldNombreProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JSpinner spinnerCantidad;
    private javax.swing.JSpinner spinnerPrecio;
    // End of variables declaration//GEN-END:variables
}
