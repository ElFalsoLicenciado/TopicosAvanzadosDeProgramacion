package proyecto.subframes.panes;

import proyecto.models.Record;
import proyecto.services.RecordServices;
import proyecto.subframes.RecordManagerPanel;
import proyecto.utils.DialogHelper;
import proyecto.utils.Other;

import java.awt.Color;

public class ManageRecordPane extends javax.swing.JPanel {


    private Record record;
    private RecordManagerPanel recordManagerPanel;

    public ManageRecordPane(RecordManagerPanel recordManagerPanel, Record record) {
        initComponents();

        this.recordManagerPanel = recordManagerPanel;
        this.record = record;

        labelTitulo.setText(record.getTitle());

        String state = Other.getStateNames()[record.getState().ordinal()];
        String type = Other.getTypes()[record.getRecordType().ordinal()];

        labelEstadoYCategoria.setText(
                String.format("Estado: %s. Categoría: %s.", state, type)
        );
        String isPublic;
        if (record.isPublic()) isPublic = "Si";

        else isPublic = "No";

        labelPublico.setText(
                String.format("Público: %s.", isPublic)
        );

        panelImage.setIcon( new javax.swing.ImageIcon(record.getImageUrl()));
        updateUI();
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
        labelEstadoYCategoria = new javax.swing.JLabel();
        labelPublico = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelImage.setBackground(new java.awt.Color(255, 255, 255));
        panelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        panelImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\Programming\\JetBrains\\IntelliJ Projects\\Topicos Avanzados de Programacion\\TAP Tema 1\\src\\main\\java\\proyecto\\resources\\imgnotfound.png")); // NOI18N
        add(panelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 160, 140));

        btnBorrar.setBackground(new java.awt.Color(154, 136, 216));
        btnBorrar.setPreferredSize(new java.awt.Dimension(106, 31));

        labelBorrar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelBorrar.setForeground(new java.awt.Color(255, 0, 51));
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

        add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 128, 90, -1));

        btnEditar.setBackground(new java.awt.Color(154, 136, 216));
        btnEditar.setPreferredSize(new java.awt.Dimension(106, 31));

        labelEditar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelEditar.setForeground(new java.awt.Color(0, 0, 0));
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

        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 128, 90, -1));

        labelTitulo.setBackground(new java.awt.Color(0, 0, 0));
        labelTitulo.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(0, 0, 0));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Titulo");
        add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        labelEstadoYCategoria.setBackground(new java.awt.Color(0, 0, 0));
        labelEstadoYCategoria.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelEstadoYCategoria.setForeground(new java.awt.Color(0, 0, 0));
        labelEstadoYCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEstadoYCategoria.setText("Estado y categoría");
        add(labelEstadoYCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 75, -1, -1));

        labelPublico.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelPublico.setForeground(new java.awt.Color(0, 0, 0));
        labelPublico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPublico.setText("Público");
        add(labelPublico, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 135, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void labelEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEditarMouseClicked
        recordManagerPanel.editRecord(record);
    }//GEN-LAST:event_labelEditarMouseClicked

    private void labelEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEditarMouseEntered
        btnEditar.setBackground(new Color(221,211,255));
    }//GEN-LAST:event_labelEditarMouseEntered

    private void labelEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEditarMouseExited
        btnEditar.setBackground(new Color(154, 136, 216));
    }//GEN-LAST:event_labelEditarMouseExited

    private void labelBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBorrarMouseClicked
        if (DialogHelper.warnConfirmDialog("¿Estás seguro?", "Advertencia") == 0) {
            record.setDeleted();
            RecordServices.deleteRecord(record);
            recordManagerPanel.deleteRecord();
        }
    }//GEN-LAST:event_labelBorrarMouseClicked

    private void labelBorrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBorrarMouseEntered
        btnBorrar.setBackground(new Color(221,211,255));
    }//GEN-LAST:event_labelBorrarMouseEntered

    private void labelBorrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBorrarMouseExited
        btnBorrar.setBackground(new Color(154, 136, 216));
    }//GEN-LAST:event_labelBorrarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnBorrar;
    private javax.swing.JPanel btnEditar;
    private javax.swing.JLabel labelBorrar;
    private javax.swing.JLabel labelEditar;
    private javax.swing.JLabel labelEstadoYCategoria;
    private javax.swing.JLabel labelPublico;
    private javax.swing.JLabel labelTitulo;
    private org.edisoncor.gui.panel.PanelImage panelImage;
    // End of variables declaration//GEN-END:variables
}
