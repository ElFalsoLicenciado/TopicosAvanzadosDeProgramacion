/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Practica4;

import Practica4.models.Producto;
import Practica4.services.ProductoService;
import java.awt.Color;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author michael
 */
public class InventarioFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InventarioFrame.class.getName());
    
    private final String IMG_PATH = "src/main/java/Practica4/images/";
    
    private String imagen = "";
    
    private Producto producto;
    private ArrayList<Producto> listaProductos;

    private TiendaFrame frame;
    
    /**
     * Creates new form InventarioFrame
     */
    public InventarioFrame() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        jPanel1.setVisible(false);
    }

    public InventarioFrame(TiendaFrame frame) {
        this.frame = frame;

        initComponents();

        setLocationRelativeTo(null);

        jPanel1.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser("C:\\Users\\User\\Downloads\\Media\\Images");
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        btnSeleccionar = new javax.swing.JButton();
        spinnerPrecio = new javax.swing.JSpinner();
        spinnerCantidad = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fieldNombreProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnGuardarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Control de inventario");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Productos registrados:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("imagen_del_producto");

        panelImage1.setBackground(new java.awt.Color(255, 204, 204));
        panelImage1.setForeground(new java.awt.Color(255, 204, 204));
        panelImage1.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\Programming\\JetBrains\\IntelliJ Projects\\Topicos Avanzados de Programacion\\TAP Tema 1\\src\\main\\java\\Practica4\\images\\imgnotfound.png")); // NOI18N

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        btnSeleccionar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSeleccionar.setText("Buscar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        spinnerPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.1d));

        spinnerCantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Precio");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Cantidad");

        fieldNombreProducto.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nombre del producto");

        btnGuardarProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardarProducto.setText("Guardar");
        btnGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 172, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
                    .addComponent(fieldNombreProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(btnGuardarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarProducto)
                    .addComponent(btnSeleccionar))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnAgregar))
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        String fileName = null;
        if(jFileChooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            fileName = file.getName();
            
            System.out.println(fileName);
            
            // Validar que sea una imagen
            if(fileName.endsWith(".png") || fileName.endsWith(".jpg")) {
                // Se copia la imagen al proyecto
                if(!copiarArchivo(file.toPath(), fileName)) {
                    panelImage1.setIcon(
                        new javax.swing.ImageIcon(IMG_PATH + fileName)
                    );
                    panelImage1.setBackground(Color.white);
                    imagen = "no_image_2.png";
                }
                
                // La imagen se coloca en el panelImage
                System.out.println("Colocando imagen de: " + IMG_PATH + fileName);
                panelImage1.setIcon(
                    new javax.swing.ImageIcon(IMG_PATH + fileName)
                );
                panelImage1.setBackground(Color.white);
                panelImage1.updateUI();
                
                imagen = fileName;
            } else {
                JOptionPane.showMessageDialog(null,"Debe seleccionar una imagen png o jpg");
            }
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        jPanel1.setVisible(true);
        limpiarComponentes();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Leer los registros de productos
        listaProductos = ProductoService.getLista();
        // Si hay productos se colocan en el comboBox}
        actualizaProductos();
        jPanel1.setVisible(false);
    }//GEN-LAST:event_formWindowOpened
    
    
    private void btnGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProductoActionPerformed
        String errores = "";
        if(fieldNombreProducto.getText().length() < 3) {
            errores += "\nEl nombre debe tener al menos 3 letras";
            fieldNombreProducto.setBackground(Color.yellow);
        }
        if(errores.isEmpty()) {
            producto.setNombreProducto(fieldNombreProducto.getText());
            producto.setCantidad((int) spinnerCantidad.getValue());
            producto.setPrecio((Double) spinnerPrecio.getValue());
            
            if(imagen == null || imagen.isEmpty()) imagen = "no_image_2.png";
            
            producto.setFotoProducto(imagen);
            
            boolean aux =  false;
            for(Producto p : listaProductos){
                if(producto.getId().equalsIgnoreCase(p.getId())) {
                    listaProductos.set(listaProductos.indexOf(p),producto);
                    aux = true;
                }
            }
            
            if(! aux) listaProductos.add(producto);
            
            if(ProductoService.writeProductos(listaProductos)) {
                JOptionPane.showMessageDialog(null,"Guardado");
                actualizaProductos();
                jPanel1.setVisible(false);
                frame.actualizarListado();
            } else {
                JOptionPane.showMessageDialog(null,"Error al Guardar");
            }
        } else {
            JOptionPane.showMessageDialog(
                null,
                "Debe corregir los siguientes errores:\n" + errores
            );
        }
        limpiarComponentes();
    }//GEN-LAST:event_btnGuardarProductoActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // Se valida que tenga un producto seleccionado
        if(jComboBox1.getSelectedIndex() > -1) {
            producto = listaProductos.get(
                jComboBox1.getSelectedIndex()
            );
            // Se muestran los valores
            jPanel1.setVisible(true);
            fieldNombreProducto.setText(
                producto.getNombreProducto()
            );
            spinnerCantidad.setValue(producto.getCantidad());
            spinnerPrecio.setValue(producto.getPrecio());
            // Se coloca la imagen del producto
            if( ! producto.getFotoProducto().isEmpty() || ! (producto.getFotoProducto() == null)) {
                imagen = producto.getFotoProducto();
            }
            panelImage1.setIcon(
                new javax.swing.ImageIcon(
                        IMG_PATH + producto.getFotoProducto())
            );
            panelImage1.updateUI();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private boolean copiarArchivo(Path original, String copiado)
    {
        boolean result = false;
        try {
            Path path = Paths.get(IMG_PATH + copiado);
            Files.copy(original, path, StandardCopyOption.REPLACE_EXISTING);
            
            System.out.println("Se copio correctamente: " + path.toString());
            
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");
        }
        return result;
    }
    
    private void actualizaProductos() {
        if(listaProductos.size() > 0) {
            jComboBox1.removeAllItems();
            for(Producto p : listaProductos) {
                jComboBox1.addItem(p.getNombreProducto());
            }
        }
        jComboBox1.setSelectedIndex(-1);
    }
    
    private void limpiarComponentes()
    {
        imagen = "no_image_2.png";
        
        producto = new Producto();
        fieldNombreProducto.setText("");
        spinnerCantidad.setValue(0);
        spinnerPrecio.setValue(0);
        
        panelImage1.setIcon(
                new javax.swing.ImageIcon(
                IMG_PATH + "no_image_2.png"
                )
        );
        panelImage1.updateUI();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new InventarioFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGuardarProducto;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JTextField fieldNombreProducto;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JSpinner spinnerCantidad;
    private javax.swing.JSpinner spinnerPrecio;
    // End of variables declaration//GEN-END:variables
}
