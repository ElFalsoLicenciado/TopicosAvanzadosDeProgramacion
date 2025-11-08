package proyecto.subframes;

import proyecto.HomePanel;
import proyecto.enums.RequestStatus;
import proyecto.models.Record;
import proyecto.models.Request;
import proyecto.services.RequestServices;
import proyecto.services.UserServices;
import proyecto.subframes.panes.WriteReasonPane;
import proyecto.utils.Other;

import java.awt.Color;

public class RecordApproverPanel extends javax.swing.JPanel {

    private HomePanel homePanel;
    private Request request;

    public RecordApproverPanel() {
        initComponents();
    }

    public RecordApproverPanel(HomePanel homePanel, Request request) {
        initComponents();

        this.homePanel = homePanel;
        this.request = request;

        Record record = request.getRecord();

        if (record != null) {

            fieldTitulo.setText(record.getTitle());

            String state = Other.getStateNames()[record.getState().ordinal()];
            String type = Other.getTypes()[record.getRecordType().ordinal()];

            fieldEstado.setText(state);
            fieldCategoria.setText(type);
            fieldDescripcion.setText(record.getDescription());

            switch (request.getStatus()){
                case APPROVED -> {
                    labelReason.setText("Aprobado.");
                    labelAprove.setVisible(false);
                    btnApprove.setVisible(false);
                    btnDeny.setVisible(false);
                }
                case REJECTED -> {
                    labelReason.setText("Denegado, razón: " + request.getReason());
                    labelAprove.setVisible(false);
                    btnApprove.setVisible(false);
                    btnDeny.setVisible(false);
                }
                case CANCELED -> {
                    labelReason.setText("Registro eliminado." + request.getReason());
                    labelAprove.setVisible(false);
                    btnApprove.setVisible(false);
                    btnDeny.setVisible(false);
                }

                case WAITING -> {
                    labelReason.setVisible(false);
                }
            }

            String author;
            if (UserServices.searchForUser(record.getAuthorId()).isEmpty()) author = "Sin autor";
            else author = "Autor: " + UserServices.searchForUser(record.getAuthorId());

            labelUsuario.setText(author);

            panelImage.setIcon( new javax.swing.ImageIcon(record.getImageUrl()));
            updateUI();
            labelTitle.setText("Inspeccionar aprobación");

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupCat = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        panelImage = new org.edisoncor.gui.panel.PanelImage();
        fieldEstado = new javax.swing.JTextField();
        labelAprove = new javax.swing.JLabel();
        labelCrit3 = new javax.swing.JLabel();
        labelCrit1 = new javax.swing.JLabel();
        btnApprove = new org.edisoncor.gui.panel.PanelImage();
        btnDeny = new org.edisoncor.gui.panel.PanelImage();
        fieldTitulo = new javax.swing.JTextField();
        labelCrit2 = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        fieldCategoria = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        fieldDescripcion = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        labelReason = new javax.swing.JTextArea();
        btnSalir = new javax.swing.JPanel();
        x = new javax.swing.JLabel();

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
        labelTitle.setText("Admin Record Panel");
        bg.add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panelImage.setBackground(new java.awt.Color(255, 255, 255));
        panelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        panelImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\Programming\\JetBrains\\IntelliJ Projects\\Topicos Avanzados de Programacion\\TAP Tema 1\\src\\main\\java\\proyecto\\resources\\imgnotfound.png")); // NOI18N
        bg.add(panelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 190, 180));

        fieldEstado.setBackground(new java.awt.Color(221, 211, 255));
        fieldEstado.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        fieldEstado.setForeground(new java.awt.Color(102, 102, 102));
        fieldEstado.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldEstado.setText("Estado");
        fieldEstado.setBorder(null);
        fieldEstado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        fieldEstado.setEnabled(false);
        bg.add(fieldEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 300, -1));

        labelAprove.setBackground(new java.awt.Color(255, 255, 255));
        labelAprove.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        labelAprove.setForeground(new java.awt.Color(0, 0, 0));
        labelAprove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAprove.setText("¿Aprobar?");
        bg.add(labelAprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 250, 150));

        labelCrit3.setBackground(new java.awt.Color(255, 255, 255));
        labelCrit3.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCrit3.setForeground(new java.awt.Color(0, 0, 0));
        labelCrit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit3.setText("Categoría");
        bg.add(labelCrit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        labelCrit1.setBackground(new java.awt.Color(255, 255, 255));
        labelCrit1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCrit1.setForeground(new java.awt.Color(0, 0, 0));
        labelCrit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit1.setText("Titulo");
        bg.add(labelCrit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        btnApprove.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\Programming\\JetBrains\\IntelliJ Projects\\Topicos Avanzados de Programacion\\TAP Tema 1\\src\\main\\java\\proyecto\\resources\\aprove.png")); // NOI18N
        btnApprove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnApproveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnApproveLayout = new javax.swing.GroupLayout(btnApprove);
        btnApprove.setLayout(btnApproveLayout);
        btnApproveLayout.setHorizontalGroup(
                btnApproveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 30, Short.MAX_VALUE)
        );
        btnApproveLayout.setVerticalGroup(
                btnApproveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 30, Short.MAX_VALUE)
        );

        bg.add(btnApprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 30, 30));

        btnDeny.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\Programming\\JetBrains\\IntelliJ Projects\\Topicos Avanzados de Programacion\\TAP Tema 1\\src\\main\\java\\proyecto\\resources\\cancel.png")); // NOI18N
        btnDeny.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDenyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnDenyLayout = new javax.swing.GroupLayout(btnDeny);
        btnDeny.setLayout(btnDenyLayout);
        btnDenyLayout.setHorizontalGroup(
                btnDenyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 30, Short.MAX_VALUE)
        );
        btnDenyLayout.setVerticalGroup(
                btnDenyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 30, Short.MAX_VALUE)
        );

        bg.add(btnDeny, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 30, 30));

        fieldTitulo.setBackground(new java.awt.Color(221, 211, 255));
        fieldTitulo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        fieldTitulo.setForeground(new java.awt.Color(102, 102, 102));
        fieldTitulo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldTitulo.setText("Título");
        fieldTitulo.setBorder(null);
        fieldTitulo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        fieldTitulo.setEnabled(false);
        bg.add(fieldTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 300, -1));

        labelCrit2.setBackground(new java.awt.Color(255, 255, 255));
        labelCrit2.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCrit2.setForeground(new java.awt.Color(0, 0, 0));
        labelCrit2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit2.setText("Estado");
        bg.add(labelCrit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        labelUsuario.setBackground(new java.awt.Color(255, 255, 255));
        labelUsuario.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(0, 0, 0));
        labelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsuario.setText("Usuario");
        bg.add(labelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        fieldCategoria.setBackground(new java.awt.Color(221, 211, 255));
        fieldCategoria.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        fieldCategoria.setForeground(new java.awt.Color(0, 0, 0));
        fieldCategoria.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldCategoria.setText("Categoría");
        fieldCategoria.setBorder(null);
        fieldCategoria.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        fieldCategoria.setEnabled(false);
        bg.add(fieldCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 300, -1));

        jScrollPane2.setBorder(null);

        fieldDescripcion.setEditable(false);
        fieldDescripcion.setBackground(new java.awt.Color(221, 211, 255));
        fieldDescripcion.setColumns(20);
        fieldDescripcion.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        fieldDescripcion.setForeground(new java.awt.Color(235, 233, 233));
        fieldDescripcion.setLineWrap(true);
        fieldDescripcion.setRows(5);
        fieldDescripcion.setText("Descripción");
        fieldDescripcion.setWrapStyleWord(true);
        fieldDescripcion.setBorder(null);
        fieldDescripcion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        fieldDescripcion.setEnabled(false);
        jScrollPane2.setViewportView(fieldDescripcion);

        bg.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 780, 210));

        labelReason.setEditable(false);
        labelReason.setBackground(new java.awt.Color(255, 255, 255));
        labelReason.setColumns(20);
        labelReason.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        labelReason.setLineWrap(true);
        labelReason.setRows(5);
        labelReason.setWrapStyleWord(true);
        labelReason.setBorder(null);
        jScrollPane1.setViewportView(labelReason);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 200, 130));

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

        add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void btnApproveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApproveMouseClicked
        if(RequestServices.setRequestStatus(request, RequestStatus.APPROVED, "")) homePanel.endEditing();
    }//GEN-LAST:event_btnApproveMouseClicked

    private void btnDenyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDenyMouseClicked
        new WriteReasonPane(this).setVisible(true);
    }//GEN-LAST:event_btnDenyMouseClicked

    private void xMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseClicked
        homePanel.endEditing();
    }//GEN-LAST:event_xMouseClicked

    private void xMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseEntered
        btnSalir.setBackground(Color.red);
        x.setForeground(Color.white);
    }//GEN-LAST:event_xMouseEntered

    private void xMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseExited
        btnSalir.setBackground(new Color(102,102,102));
        x.setForeground(Color.black);
    }//GEN-LAST:event_xMouseExited

    public void getReasonFromForm(String reason){
        if (! reason.isEmpty()) {
            if (RequestServices.setRequestStatus(request, RequestStatus.REJECTED, reason)) homePanel.endEditing();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private org.edisoncor.gui.panel.PanelImage btnApprove;
    private org.edisoncor.gui.panel.PanelImage btnDeny;
    private javax.swing.JPanel btnSalir;
    private javax.swing.JTextField fieldCategoria;
    private javax.swing.JTextArea fieldDescripcion;
    private javax.swing.JTextField fieldEstado;
    private javax.swing.JTextField fieldTitulo;
    private javax.swing.ButtonGroup groupCat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAprove;
    private javax.swing.JLabel labelCrit1;
    private javax.swing.JLabel labelCrit2;
    private javax.swing.JLabel labelCrit3;
    private javax.swing.JTextArea labelReason;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelUsuario;
    private org.edisoncor.gui.panel.PanelImage panelImage;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
