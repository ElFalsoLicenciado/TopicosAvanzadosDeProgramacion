/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyecto.subframes;

import proyecto.HomePanel;
import proyecto.models.Record;
import proyecto.services.UserServices;
import proyecto.utils.Other;

import java.awt.Color;

public class RecordReaderPanel extends javax.swing.JPanel {


    private HomePanel homePanel;

    public RecordReaderPanel() {
        initComponents();
    }

    public RecordReaderPanel(HomePanel homePanel, Record record) {
        initComponents();

        this.homePanel = homePanel;

        String author = UserServices.searchForUser(record.getAuthorId());
        if (author.isEmpty()) author = "Sin autor";

        labelTituloYAutor.setText(String.format("%s de: %s.", record.getTitle(), author));

        String state = Other.getStateNames()[record.getState().ordinal()];
        String type = Other.getTypes()[record.getRecordType().ordinal()];

        labelEstado.setText(
                "Estado: "  + state
        );
        
        labelCategoria.setText(
                "Categoría: " + type
        );

        fieldDescripcion.setText(record.getDescription());

        panelImage.setIcon( new javax.swing.ImageIcon(record.getImageUrl()));
        updateUI();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        panelImage = new org.edisoncor.gui.panel.PanelImage();
        labelTituloYAutor = new javax.swing.JLabel();
        labelEstado = new javax.swing.JLabel();
        btnSalir = new javax.swing.JPanel();
        x = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        fieldDescripcion = new javax.swing.JTextArea();
        labelCategoria = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setForeground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(762, 600));
        bg.setPreferredSize(new java.awt.Dimension(762, 600));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitle.setBackground(new java.awt.Color(255, 255, 255));
        labelTitle.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(0, 0, 0));
        labelTitle.setText("Record Lecture Panel");
        bg.add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panelImage.setBackground(new java.awt.Color(255, 255, 255));
        panelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        panelImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\Programming\\JetBrains\\IntelliJ Projects\\Topicos Avanzados de Programacion\\TAP Tema 1\\src\\main\\java\\proyecto\\resources\\imgnotfound.png")); // NOI18N
        bg.add(panelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 190, 180));

        labelTituloYAutor.setBackground(new java.awt.Color(255, 255, 255));
        labelTituloYAutor.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelTituloYAutor.setForeground(new java.awt.Color(0, 0, 0));
        labelTituloYAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTituloYAutor.setText("Titulo");
        bg.add(labelTituloYAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        labelEstado.setBackground(new java.awt.Color(255, 255, 255));
        labelEstado.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelEstado.setForeground(new java.awt.Color(0, 0, 0));
        labelEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEstado.setText("Estado");
        bg.add(labelEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));

        btnSalir.setBackground(new java.awt.Color(102, 102, 102));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        x.setBackground(new java.awt.Color(0, 0, 0));
        x.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        x.setForeground(new java.awt.Color(0, 0, 0));
        x.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x.setText("<--");
        x.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        x.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                xMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                xMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnSalirLayout = new javax.swing.GroupLayout(btnSalir);
        btnSalir.setLayout(btnSalirLayout);
        btnSalirLayout.setHorizontalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(x, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );
        btnSalirLayout.setVerticalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(x, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        bg.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, -1, -1));

        fieldDescripcion.setEditable(false);
        fieldDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        fieldDescripcion.setColumns(20);
        fieldDescripcion.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        fieldDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        fieldDescripcion.setLineWrap(true);
        fieldDescripcion.setRows(5);
        fieldDescripcion.setText("Descripción");
        fieldDescripcion.setWrapStyleWord(true);
        fieldDescripcion.setBorder(null);
        fieldDescripcion.setCaretColor(new java.awt.Color(0, 0, 0));
        fieldDescripcion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        fieldDescripcion.setEnabled(false);
        jScrollPane2.setViewportView(fieldDescripcion);

        bg.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 760, 220));

        labelCategoria.setBackground(new java.awt.Color(255, 255, 255));
        labelCategoria.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCategoria.setForeground(new java.awt.Color(0, 0, 0));
        labelCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCategoria.setText("Categoría");
        bg.add(labelCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, -1, -1));

        add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void xMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseClicked
        homePanel.endLecture();
    }//GEN-LAST:event_xMouseClicked

    private void xMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseEntered
        btnSalir.setBackground(Color.red);
        x.setForeground(Color.white);
    }//GEN-LAST:event_xMouseEntered

    private void xMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseExited
        btnSalir.setBackground(new Color(102,102,102));
        x.setForeground(Color.black);
    }//GEN-LAST:event_xMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btnSalir;
    private javax.swing.JTextArea fieldDescripcion;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelTituloYAutor;
    private org.edisoncor.gui.panel.PanelImage panelImage;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
