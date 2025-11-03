package proyecto.subframes.panes;

import java.awt.Color;

public class ManageRecordPane extends javax.swing.JPanel {

    /**
     * Creates new form UserRecordsManage
     */
    public ManageRecordPane() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage = new org.edisoncor.gui.panel.PanelImage();
        btnBorrar = new javax.swing.JPanel();
        labelBorrar = new javax.swing.JLabel();
        btnEditar = new javax.swing.JPanel();
        labelEditar = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        labelEstado = new javax.swing.JLabel();
        labelCat = new javax.swing.JLabel();

        setBackground(new java.awt.Color(216, 188, 188));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelImage.setBackground(new java.awt.Color(255, 255, 255));
        panelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        panelImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\Programming\\JetBrains\\IntelliJ Projects\\Topicos Avanzados de Programacion\\TAP Tema 1\\src\\main\\java\\proyecto\\resources\\imgnotfound.png")); // NOI18N
        add(panelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 160, 140));

        btnBorrar.setBackground(new java.awt.Color(96, 243, 96));
        btnBorrar.setPreferredSize(new java.awt.Dimension(106, 31));

        labelBorrar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelBorrar.setForeground(new java.awt.Color(193, 110, 110));
        labelBorrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBorrar.setText("BORRAR");
        labelBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBorrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelBorrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelBorrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnBorrarLayout = new javax.swing.GroupLayout(btnBorrar);
        btnBorrar.setLayout(btnBorrarLayout);
        btnBorrarLayout.setHorizontalGroup(
            btnBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBorrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnBorrarLayout.setVerticalGroup(
            btnBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBorrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 90, -1));

        btnEditar.setBackground(new java.awt.Color(96, 243, 96));
        btnEditar.setPreferredSize(new java.awt.Dimension(106, 31));

        labelEditar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelEditar.setForeground(new java.awt.Color(255, 255, 255));
        labelEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEditar.setText("EDITAR");
        labelEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelEditarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnEditarLayout = new javax.swing.GroupLayout(btnEditar);
        btnEditar.setLayout(btnEditarLayout);
        btnEditarLayout.setHorizontalGroup(
            btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnEditarLayout.setVerticalGroup(
            btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 90, -1));

        labelTitulo.setBackground(new java.awt.Color(0, 0, 0));
        labelTitulo.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(114, 114, 114));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Titulo");
        add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        labelEstado.setBackground(new java.awt.Color(0, 0, 0));
        labelEstado.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelEstado.setForeground(new java.awt.Color(114, 114, 114));
        labelEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEstado.setText("Estado");
        add(labelEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        labelCat.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCat.setForeground(new java.awt.Color(114, 114, 114));
        labelCat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCat.setText("Categoría");
        add(labelCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void labelEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEditarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_labelEditarMouseClicked

    private void labelEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEditarMouseEntered
        btnEditar.setBackground(new Color(146,246,146));
    }//GEN-LAST:event_labelEditarMouseEntered

    private void labelEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEditarMouseExited
        btnEditar.setBackground(new Color(96,243,96));
    }//GEN-LAST:event_labelEditarMouseExited

    private void labelBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBorrarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_labelBorrarMouseClicked

    private void labelBorrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBorrarMouseEntered
        btnBorrar.setBackground(new Color(146,246,146));
    }//GEN-LAST:event_labelBorrarMouseEntered

    private void labelBorrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBorrarMouseExited
        btnBorrar.setBackground(new Color(96,243,96));
    }//GEN-LAST:event_labelBorrarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnBorrar;
    private javax.swing.JPanel btnEditar;
    private javax.swing.JLabel labelBorrar;
    private javax.swing.JLabel labelCat;
    private javax.swing.JLabel labelEditar;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelTitulo;
    private org.edisoncor.gui.panel.PanelImage panelImage;
    // End of variables declaration//GEN-END:variables
}
