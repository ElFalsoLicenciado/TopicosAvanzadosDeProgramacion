package proyecto.subframes;

import proyecto.HomePanel;
import proyecto.models.Record;
import proyecto.subframes.panes.ManageRecordPane;

import java.awt.*;
import java.util.ArrayList;

public class RecordManagerPanel extends javax.swing.JPanel {

    private HomePanel homePanel;
    private GridLayout gridLayout = new GridLayout(1,1);
    private ArrayList<Record> userRecords;

    public RecordManagerPanel() {
        initComponents();
    }

    public RecordManagerPanel(HomePanel homePanel, ArrayList<Record> userRecords) {
        initComponents();

        this.homePanel = homePanel;

        panelRecordList.setLayout(gridLayout);
        this.userRecords = userRecords;

        showUserRecords();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrear = new javax.swing.JPanel();
        labelCrear = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelRecordList = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        labelSubtitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(216, 188, 188));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCrear.setBackground(new java.awt.Color(96, 243, 96));
        btnCrear.setPreferredSize(new java.awt.Dimension(106, 31));

        labelCrear.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelCrear.setForeground(new java.awt.Color(255, 255, 255));
        labelCrear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrear.setText("CREAR");
        labelCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCrearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelCrearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelCrearMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnCrearLayout = new javax.swing.GroupLayout(btnCrear);
        btnCrear.setLayout(btnCrearLayout);
        btnCrearLayout.setHorizontalGroup(
            btnCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCrearLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnCrearLayout.setVerticalGroup(
            btnCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCrearLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 90, -1));

        jScrollPane1.setBackground(new java.awt.Color(216, 188, 188));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(216, 188, 188));

        panelRecordList.setBackground(new java.awt.Color(216, 188, 188));
        panelRecordList.setForeground(new java.awt.Color(216, 188, 188));
        jScrollPane1.setViewportView(panelRecordList);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 780, 410));

        labelTitle.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(114, 114, 114));
        labelTitle.setText("Manage Panel");
        add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        labelSubtitle.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelSubtitle.setForeground(new java.awt.Color(114, 114, 114));
        labelSubtitle.setText("Tus registros:");
        add(labelSubtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void labelCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCrearMouseClicked
        homePanel.createRecord();
    }//GEN-LAST:event_labelCrearMouseClicked

    private void labelCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCrearMouseEntered
        btnCrear.setBackground(new Color(146,246,146));
    }//GEN-LAST:event_labelCrearMouseEntered

    private void labelCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCrearMouseExited
        btnCrear.setBackground(new Color(96,243,96));
    }//GEN-LAST:event_labelCrearMouseExited

    private void showUserRecords(){
        panelRecordList.removeAll();
        gridLayout.setRows(userRecords.size());

        for (Record record : userRecords){
            ManageRecordPane mrp = new ManageRecordPane(this, record);
            panelRecordList.add(mrp);
        }

        panelRecordList.updateUI();
    }

    public void editRecord(Record record){
        homePanel.editRecord(record);
    }

    public void change() {
        homePanel.endEditing();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnCrear;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCrear;
    private javax.swing.JLabel labelSubtitle;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel panelRecordList;
    // End of variables declaration//GEN-END:variables
}
