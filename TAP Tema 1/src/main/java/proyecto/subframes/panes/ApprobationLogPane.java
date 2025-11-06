/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyecto.subframes.panes;

import proyecto.enums.RequestStatus;
import proyecto.models.Request;
import proyecto.models.Record;
import proyecto.services.RecordServices;
import proyecto.subframes.UserRequestsPanel;
import proyecto.utils.Other;


public class ApprobationLogPane extends javax.swing.JPanel {

    Request request;
    UserRequestsPanel userRequestsPanel;

    public ApprobationLogPane() {
        initComponents();
    }

    public ApprobationLogPane(UserRequestsPanel userRequestsPanel, Request request) {
        initComponents();

        this.userRequestsPanel = userRequestsPanel;
        this.request = request;
        Record record = RecordServices.getRecord(request.getRecordId());
        if (record != null) {
            labelTitulo.setText(record.getTitle());

            String state = Other.getStateNames()[record.getState().ordinal()];
            String type = Other.getTypes()[record.getRecordType().ordinal()];

            labelEstadoYCategoria.setText(
                    String.format("Estado: %s. Categoría: %s.", state, type)
            );

            switch (request.getStatus()){
                case WAITING -> labelStatus.setText("Esperando aprobación.");
                case APPROVED -> labelStatus.setText("Aprobado.");
                case REJECTED -> labelStatus.setText("Denegado, razón: " + request.getReason());
                case CANCELED -> labelStatus.setText("Registro eliminado.");
            }

            panelImage.setIcon( new javax.swing.ImageIcon(record.getImageUrl()));
            updateUI();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage = new org.edisoncor.gui.panel.PanelImage();
        labelTitulo = new javax.swing.JLabel();
        labelEstadoYCategoria = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelImage.setBackground(new java.awt.Color(255, 255, 255));
        panelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        panelImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\Programming\\JetBrains\\IntelliJ Projects\\Topicos Avanzados de Programacion\\TAP Tema 1\\src\\main\\java\\proyecto\\resources\\imgnotfound.png")); // NOI18N
        add(panelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 160, 140));

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
        add(labelEstadoYCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        labelStatus.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelStatus.setForeground(new java.awt.Color(0, 0, 0));
        labelStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStatus.setText("Status");
        add(labelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 135, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelEstadoYCategoria;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelTitulo;
    private org.edisoncor.gui.panel.PanelImage panelImage;
    // End of variables declaration//GEN-END:variables
}
