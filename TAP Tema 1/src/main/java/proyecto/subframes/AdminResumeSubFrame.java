package proyecto.subframes;

import proyecto.enums.StateNames;
import proyecto.services.RecordServices;
import proyecto.utils.DialogHelper;
import proyecto.utils.Other;

import java.awt.Color;

public class AdminResumeSubFrame extends javax.swing.JPanel {

    public AdminResumeSubFrame() {
        initComponents();

        comboStates.setModel(Other.setComboStates());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        comboStates = new javax.swing.JComboBox<>();
        labelEstado = new javax.swing.JLabel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        panelImage2 = new org.edisoncor.gui.panel.PanelImage();
        btnPDF = new javax.swing.JPanel();
        labelPDF = new javax.swing.JLabel();
        btnExcel = new javax.swing.JPanel();
        labelExcel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitle.setBackground(new java.awt.Color(255, 255, 255));
        labelTitle.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(0, 0, 0));
        labelTitle.setText("Descargar resumen:");
        add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        comboStates.setBackground(new java.awt.Color(221, 211, 255));
        comboStates.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        comboStates.setForeground(new java.awt.Color(0, 0, 0));
        comboStates.setBorder(null);
        add(comboStates, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 300, 30));

        labelEstado.setBackground(new java.awt.Color(255, 255, 255));
        labelEstado.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelEstado.setForeground(new java.awt.Color(0, 0, 0));
        labelEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEstado.setText("Estado");
        add(labelEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        panelImage1.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\Programming\\JetBrains\\IntelliJ Projects\\Topicos Avanzados de Programacion\\TAP Tema 1\\src\\main\\java\\proyecto\\resources\\pdf.png")); // NOI18N

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 160, 170));

        panelImage2.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\Programming\\JetBrains\\IntelliJ Projects\\Topicos Avanzados de Programacion\\TAP Tema 1\\src\\main\\java\\proyecto\\resources\\excel.png")); // NOI18N

        javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
        panelImage2.setLayout(panelImage2Layout);
        panelImage2Layout.setHorizontalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        panelImage2Layout.setVerticalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        add(panelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        btnPDF.setBackground(new java.awt.Color(154, 136, 216));
        btnPDF.setPreferredSize(new java.awt.Dimension(106, 31));

        labelPDF.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelPDF.setForeground(new java.awt.Color(0, 0, 0));
        labelPDF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPDF.setText("GUARDAR");
        labelPDF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPDFMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelPDFMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelPDFMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnPDFLayout = new javax.swing.GroupLayout(btnPDF);
        btnPDF.setLayout(btnPDFLayout);
        btnPDFLayout.setHorizontalGroup(
            btnPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPDFLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnPDFLayout.setVerticalGroup(
            btnPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPDFLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(btnPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 90, -1));

        btnExcel.setBackground(new java.awt.Color(154, 136, 216));
        btnExcel.setPreferredSize(new java.awt.Dimension(106, 31));

        labelExcel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelExcel.setForeground(new java.awt.Color(0, 0, 0));
        labelExcel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelExcel.setText("GUARDAR");
        labelExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelExcelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelExcelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelExcelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnExcelLayout = new javax.swing.GroupLayout(btnExcel);
        btnExcel.setLayout(btnExcelLayout);
        btnExcelLayout.setHorizontalGroup(
            btnExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnExcelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnExcelLayout.setVerticalGroup(
            btnExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnExcelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(btnExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 90, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void labelPDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPDFMouseClicked
        if (comboStates.getSelectedIndex() == 0)  {
            DialogHelper.errorMessageDialog("Por favor, selecciona un estado.", "Error.");
            return;
        }
        RecordServices.getPDF(StateNames.values()[comboStates.getSelectedIndex()-1]);

    }//GEN-LAST:event_labelPDFMouseClicked

    private void labelPDFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPDFMouseEntered
        btnPDF.setBackground(new Color(221,211,255));
    }//GEN-LAST:event_labelPDFMouseEntered

    private void labelPDFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPDFMouseExited
        btnPDF.setBackground(new Color(154, 136, 216));
    }//GEN-LAST:event_labelPDFMouseExited

    private void labelExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelExcelMouseClicked
        RecordServices.getExcel();
    }//GEN-LAST:event_labelExcelMouseClicked

    private void labelExcelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelExcelMouseEntered
        btnExcel.setBackground(new Color(221,211,255));
    }//GEN-LAST:event_labelExcelMouseEntered

    private void labelExcelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelExcelMouseExited
        btnExcel.setBackground(new Color(154, 136, 216));
    }//GEN-LAST:event_labelExcelMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnExcel;
    private javax.swing.JPanel btnPDF;
    private javax.swing.JComboBox<String> comboStates;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelExcel;
    private javax.swing.JLabel labelPDF;
    private javax.swing.JLabel labelTitle;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelImage panelImage2;
    // End of variables declaration//GEN-END:variables
}
