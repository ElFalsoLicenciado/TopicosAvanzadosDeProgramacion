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
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class ProductoFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.
            getLogger(ProductoFrame.class.getName());

    
    private Producto producto;
    private ArrayList<Categoria> categorias;
    private ArrayList<Proveedor> proveedores;
    private String fotoBase64 = null;
    private String nombreFoto = null;
    
    private ProductoService service = new ProductoService();
    
    public ProductoFrame() {
        initComponents();
    }

    public ProductoFrame(Producto producto) {
        this.producto = producto;
        
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        btnCambiarFoto = new javax.swing.JButton();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        fieldNombreProducto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spinnerPrecio = new javax.swing.JSpinner();
        spinnerCantidad = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboProveedor = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCambiarFoto.setText("Cambiar foto...");
        btnCambiarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarFotoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCambiarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 170, -1, -1));

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        getContentPane().add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 140));

        fieldNombreProducto.setBorder(null);
        getContentPane().add(fieldNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 190, 30));

        jLabel1.setText("Nombre de producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jLabel2.setText("Precio");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        jLabel3.setText("Cantidad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, -1));

        spinnerPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.1d));
        getContentPane().add(spinnerPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        spinnerCantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        getContentPane().add(spinnerCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        jLabel4.setText("Categoria");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCategoria.setBorder(null);
        getContentPane().add(comboCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 130, 30));

        jLabel5.setText("Proveedor");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        comboProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboProveedor.setBorder(null);
        getContentPane().add(comboProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 170, 30));

        btnGuardar.setText("Guardar producto");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try{
            categorias = new CategoriaService().showCategorias();
            proveedores = new ProveedorService().showProveedores();
            
            comboCategoria.removeAll();
            for(Categoria c : categorias) {
                comboCategoria.addItem(c.getNombre_categoria());
            }
            
            comboProveedor.removeAll();
            for(Proveedor p : proveedores) {
                comboProveedor.addItem(p.getNombre_proveedor());
            }
            
            if(producto != null){
                fieldNombreProducto.setText(producto.getNombre_producto());
                spinnerPrecio.setValue(producto.getPrecio());
                spinnerCantidad.setValue(producto.getCantidad());
                
                int index = 0;
                
                for(Categoria c : categorias) {
                    if(c.getId_categoria().equals(producto.getId_categoria()))
                    {
                        comboCategoria.setSelectedIndex(index);
                        break;
                    }
                    index++;
                }
                
                index = 0;
                for(Proveedor p : proveedores) {
                    if(p.getId_proveedor().equals(producto.getId_categoria()))
                    {
                        comboProveedor.setSelectedIndex(index);
                        break;
                    }
                    index++;
                }
            
            }
            
        }catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar informacion");
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnCambiarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarFotoActionPerformed
        if(jFileChooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                if(jFileChooser1.getSelectedFile().length() > 512000) {
                    throw new Exception("Error, foto muy grande");
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        boolean esNuevo = false;
        if(producto == null){
            producto = new Producto();
            esNuevo = true;
        }
        try{
            producto.setNombre_producto(fieldNombreProducto.getText());

            producto.setPrecio((Double) spinnerPrecio.getValue());
            producto.setCantidad((int) spinnerCantidad.getValue());

            producto.setId_categoria(
                    categorias.get(comboCategoria.getSelectedIndex()).getId_categoria()
            );

            producto.setId_proveedor(
                    proveedores.get(comboProveedor.getSelectedIndex()).getId_proveedor()
            );

            producto.setFoto_producto(fotoBase64);
            producto.setNombre_foto_producto(nombreFoto);
            
            if(esNuevo) {
                if(service.addProducto(producto)) {
                    
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.
                    getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ProductoFrame().setVisible(
                true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarFoto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboProveedor;
    private javax.swing.JTextField fieldNombreProducto;
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
