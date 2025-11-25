package Practica3.admin_views;

import Practica3.model_layer.Proveedor;
import Practica3.services.ProveedorService;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ProveedorFormFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.
            getLogger(ProveedorFormFrame.class.getName());

    private Proveedor proveedor;

    private ProveedorService service = new ProveedorService();
    private AdminFrame frame = new AdminFrame();


    public ProveedorFormFrame() {
        initComponents();
    }

    public ProveedorFormFrame(AdminFrame frame, Proveedor proveedor) {
        this.proveedor = proveedor;
        this.frame = frame;

        initComponents();

        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboDay = new javax.swing.JComboBox<>();
        comboMonth = new javax.swing.JComboBox<>();
        fieldYear = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Año");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 70, -1));
        getContentPane().add(fieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 226, -1));

        btnSave.setText("Guardar proveedor");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre del proveedor:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 20, 150, -1));

        getContentPane().add(comboDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        getContentPane().add(comboMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));
        getContentPane().add(fieldYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Fecha de surte:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 150, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Dia");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 60, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Mes");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 60, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        boolean esNuevo = false;
        if(proveedor == null) {
            esNuevo = true;
            proveedor = new Proveedor();
        }


        try {
            proveedor.setNombre_proveedor(
                fieldName.getText()
            );

            String date = String.format("%s-%s-%s", fieldYear.getText(), comboMonth.getSelectedItem(), comboDay.getSelectedItem());
            System.out.println("Fecha: "+date);

            proveedor.setFecha_surte(date);

            if(esNuevo) {
                if(service.addProveedor(proveedor)) {
                    JOptionPane.showMessageDialog(null,"Guardado");
                } else throw new Exception();
            } else {
                if(service.editProveedor(proveedor)) {
                    JOptionPane.showMessageDialog(null,"Editado");
                } else throw new Exception();
            }
            frame.actualizaListado("");
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al guardar");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        for (int i = 1; i <= 31; i ++) {
            comboDay.addItem(""+i);
        }

        for (int i = 1; i <= 12; i ++) {
            comboMonth.addItem(""+i);
        }

        if (proveedor != null) {
            fieldName.setText(proveedor.getNombre_proveedor());

            String date = proveedor.getFecha_surte();
            // 2 0 2 5 - 0 1 - 0 1
            // 1 2 3 4 5 6 7 8 9 10

            System.out.println(date.substring(8,10));
            int day = Integer.parseInt(date.substring(8,10));

            comboDay.setSelectedIndex(day-1);

            System.out.println(date.substring(5,7));
            int month = Integer.parseInt(date.substring(5,7));

            comboMonth.setSelectedIndex(month-1);

            System.out.printf("%s - %s\n", day, month);

            fieldYear.setText(date.substring(0,4));
        }

    }//GEN-LAST:event_formWindowOpened


    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ProveedorFormFrame().
                setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboDay;
    private javax.swing.JComboBox<String> comboMonth;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
