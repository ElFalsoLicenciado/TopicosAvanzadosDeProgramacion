package proyecto.subframes;

import proyecto.HomePanel;
import proyecto.enums.RecordType;
import proyecto.enums.StateNames;
import proyecto.models.Record;
import proyecto.services.RecordServices;
import proyecto.subframes.panes.SelectRecordPane;
import proyecto.utils.Other;

import java.awt.*;
import java.util.ArrayList;


public class RecordSelectorPanel extends javax.swing.JPanel {

    private HomePanel homePanel;
    private GridLayout gridLayout = new GridLayout(1,1);
    private ArrayList<Record> records;
    private boolean catIsSelected;

    public RecordSelectorPanel() {
        initComponents();
    }

    public RecordSelectorPanel(HomePanel homePanel) {
        initComponents();
        setComboStates();

        this.homePanel = homePanel;

        panelRecordList.setLayout(gridLayout);
        records = RecordServices.getApprovedRecords();
        catIsSelected = false;
        
        if(records.isEmpty()) {
            labelWarn.setVisible(true);
            return;
        }
        
        showReadableRecords();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        recordTypeGroup = new javax.swing.ButtonGroup();
        comboStates = new javax.swing.JComboBox<>();
        choiceTrad = new javax.swing.JRadioButton();
        choiceGast = new javax.swing.JRadioButton();
        choiceLug = new javax.swing.JRadioButton();
        choicePala = new javax.swing.JRadioButton();
        labelCrit1 = new javax.swing.JLabel();
        labelCrit3 = new javax.swing.JLabel();
        btnReset = new javax.swing.JPanel();
        labelReset = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelRecordList = new javax.swing.JPanel();
        labelWarn = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboStates.setBackground(new java.awt.Color(221, 211, 255));
        comboStates.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        comboStates.setForeground(new java.awt.Color(0, 0, 0));
        comboStates.setBorder(null);
        comboStates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatesActionPerformed(evt);
            }
        });
        add(comboStates, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, 30));

        choiceTrad.setBackground(new java.awt.Color(255, 255, 255));
        recordTypeGroup.add(choiceTrad);
        choiceTrad.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choiceTrad.setForeground(new java.awt.Color(0, 0, 0));
        choiceTrad.setText("Tradición");
        choiceTrad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choiceTradActionPerformed(evt);
            }
        });
        add(choiceTrad, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, 30));

        choiceGast.setBackground(new java.awt.Color(255, 255, 255));
        recordTypeGroup.add(choiceGast);
        choiceGast.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choiceGast.setForeground(new java.awt.Color(0, 0, 0));
        choiceGast.setText("Gastronomía");
        choiceGast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choiceGastActionPerformed(evt);
            }
        });
        add(choiceGast, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, 30));

        choiceLug.setBackground(new java.awt.Color(255, 255, 255));
        recordTypeGroup.add(choiceLug);
        choiceLug.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choiceLug.setForeground(new java.awt.Color(0, 0, 0));
        choiceLug.setText("Lugar");
        choiceLug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choiceLugActionPerformed(evt);
            }
        });
        add(choiceLug, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, 30));

        choicePala.setBackground(new java.awt.Color(255, 255, 255));
        recordTypeGroup.add(choicePala);
        choicePala.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choicePala.setForeground(new java.awt.Color(0, 0, 0));
        choicePala.setText("Palabra");
        choicePala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choicePalaActionPerformed(evt);
            }
        });
        add(choicePala, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, 30));

        labelCrit1.setBackground(new java.awt.Color(255, 255, 255));
        labelCrit1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCrit1.setForeground(new java.awt.Color(0, 0, 0));
        labelCrit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit1.setText("Estado");
        add(labelCrit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        labelCrit3.setBackground(new java.awt.Color(255, 255, 255));
        labelCrit3.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCrit3.setForeground(new java.awt.Color(0, 0, 0));
        labelCrit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit3.setText("Categoría");
        add(labelCrit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        btnReset.setBackground(new java.awt.Color(154, 136, 216));
        btnReset.setPreferredSize(new java.awt.Dimension(106, 31));

        labelReset.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelReset.setForeground(new java.awt.Color(0, 0, 0));
        labelReset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelReset.setText("RESET");
        labelReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelResetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelResetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelResetMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnResetLayout = new javax.swing.GroupLayout(btnReset);
        btnReset.setLayout(btnResetLayout);
        btnResetLayout.setHorizontalGroup(
            btnResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnResetLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelReset, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnResetLayout.setVerticalGroup(
            btnResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnResetLayout.createSequentialGroup()
                .addComponent(labelReset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 60, -1));

        labelTitle.setBackground(new java.awt.Color(255, 255, 255));
        labelTitle.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(0, 0, 0));
        labelTitle.setText("Lectura de registros:");
        add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(216, 188, 188));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(216, 188, 188));

        panelRecordList.setBackground(new java.awt.Color(255, 255, 255));
        panelRecordList.setForeground(new java.awt.Color(255, 255, 255));

        labelWarn.setBackground(new java.awt.Color(255, 255, 255));
        labelWarn.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelWarn.setForeground(new java.awt.Color(0, 0, 0));
        labelWarn.setText("NO HAY NINGÚN REGISTRO DISPONIBLE PARA LEER");
        panelRecordList.add(labelWarn);

        jScrollPane1.setViewportView(panelRecordList);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 760, 340));
    }// </editor-fold>//GEN-END:initComponents

    private void labelResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResetMouseClicked
        resetRecords();
    }//GEN-LAST:event_labelResetMouseClicked

    private void labelResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResetMouseEntered
        btnReset.setBackground(new Color(221,211,255));
    }//GEN-LAST:event_labelResetMouseEntered

    private void labelResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResetMouseExited
        btnReset.setBackground(new Color(154, 136, 216));
    }//GEN-LAST:event_labelResetMouseExited

    private void comboStatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatesActionPerformed
        catIsSelected = false;
        choiceGast.setSelected(false);
        choiceLug.setSelected(false);
        choicePala.setSelected(false);
        choiceTrad.setSelected(false);
        applyFilters();
    }//GEN-LAST:event_comboStatesActionPerformed

    private void choiceTradActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choiceTradActionPerformed
        catIsSelected =  true;
        applyFilters();
    }//GEN-LAST:event_choiceTradActionPerformed

    private void choiceGastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choiceGastActionPerformed
        catIsSelected =  true;
        applyFilters();
    }//GEN-LAST:event_choiceGastActionPerformed

    private void choiceLugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choiceLugActionPerformed
        catIsSelected =  true;
        applyFilters();
    }//GEN-LAST:event_choiceLugActionPerformed

    private void choicePalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choicePalaActionPerformed
        catIsSelected =  true;

        applyFilters();
    }//GEN-LAST:event_choicePalaActionPerformed

    public void applyFilters() {

        if (comboStates.getSelectedIndex() == 0 && ! catIsSelected) {
            resetRecords();
            return;
        }
        RecordType type = null;
        StateNames state = null;

        if (choiceGast.isSelected()) type = RecordType.GASTRONOMIA;
        if (choiceTrad.isSelected()) type = RecordType.TRADICION;
        if (choiceLug.isSelected()) type = RecordType.LUGAR;
        if (choicePala.isSelected()) type = RecordType.PALABRA;

        if (comboStates.getSelectedIndex() == 0 && catIsSelected) {
            records = RecordServices.getSpecificTypeRecords(type);
        }

        if (comboStates.getSelectedIndex() != 0) state = StateNames.values()[comboStates.getSelectedIndex() - 1];

        if (comboStates.getSelectedIndex() != 0 && catIsSelected) {
            records = RecordServices.getVerySpecificRecords(state, type);
        }

        if (comboStates.getSelectedIndex() != 0 && ! catIsSelected) {
            records = RecordServices.getSpecificStateRecords(state);
        }
        showReadableRecords();
    }

    public void startLecture(Record record) {
        homePanel.startLecture(record);
    }

    public void resetRecords(){
        comboStates.setSelectedIndex(0);
        choiceGast.setSelected(false);
        choiceLug.setSelected(false);
        choicePala.setSelected(false);
        choiceTrad.setSelected(false);
        catIsSelected = false;
        records = RecordServices.getApprovedRecords();
        showReadableRecords();
    }

    private void showReadableRecords(){
        panelRecordList.removeAll();
        gridLayout.setRows(records.size());

        for (Record record : records){
            SelectRecordPane srp = new SelectRecordPane(this, record);
            panelRecordList.add(srp);
        }

        panelRecordList.updateUI();
    }

    public void setComboStates(){
        comboStates.setModel(Other.setComboStates());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnReset;
    private javax.swing.JRadioButton choiceGast;
    private javax.swing.JRadioButton choiceLug;
    private javax.swing.JRadioButton choicePala;
    private javax.swing.JRadioButton choiceTrad;
    private javax.swing.JComboBox<String> comboStates;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCrit1;
    private javax.swing.JLabel labelCrit3;
    private javax.swing.JLabel labelReset;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelWarn;
    private javax.swing.JPanel panelRecordList;
    private javax.swing.ButtonGroup recordTypeGroup;
    // End of variables declaration//GEN-END:variables
}
