package proyecto.subframes;

import java.awt.Color;
import proyecto.utils.Other;


public class RecordSelectorPanel extends javax.swing.JPanel {
    
    public RecordSelectorPanel() {
        initComponents();
        setComboStates();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        recordTypeGroup = new javax.swing.ButtonGroup();
        comboStates = new javax.swing.JComboBox<>();
        choiceTrad = new javax.swing.JRadioButton();
        choicdeGast = new javax.swing.JRadioButton();
        choiceLug = new javax.swing.JRadioButton();
        choicePala = new javax.swing.JRadioButton();
        labelCrit1 = new javax.swing.JLabel();
        labelCrit3 = new javax.swing.JLabel();
        btnReset = new javax.swing.JPanel();
        labelReset = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelRecordList = new javax.swing.JPanel();

        setBackground(new java.awt.Color(216, 188, 188));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboStates.setBackground(new java.awt.Color(255, 255, 255));
        comboStates.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        comboStates.setForeground(new java.awt.Color(235, 233, 233));
        comboStates.setBorder(null);
        add(comboStates, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 40));

        choiceTrad.setBackground(new java.awt.Color(216, 188, 188));
        recordTypeGroup.add(choiceTrad);
        choiceTrad.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choiceTrad.setForeground(new java.awt.Color(235, 233, 233));
        choiceTrad.setText("Tradición");
        add(choiceTrad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, 30));

        choicdeGast.setBackground(new java.awt.Color(216, 188, 188));
        recordTypeGroup.add(choicdeGast);
        choicdeGast.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choicdeGast.setForeground(new java.awt.Color(235, 233, 233));
        choicdeGast.setText("Gastronomía");
        add(choicdeGast, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, 30));

        choiceLug.setBackground(new java.awt.Color(216, 188, 188));
        recordTypeGroup.add(choiceLug);
        choiceLug.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choiceLug.setForeground(new java.awt.Color(235, 233, 233));
        choiceLug.setText("Lugar");
        add(choiceLug, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, 30));

        choicePala.setBackground(new java.awt.Color(216, 188, 188));
        recordTypeGroup.add(choicePala);
        choicePala.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choicePala.setForeground(new java.awt.Color(235, 233, 233));
        choicePala.setText("Palabra");
        add(choicePala, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, -1, 30));

        labelCrit1.setBackground(new java.awt.Color(0, 0, 0));
        labelCrit1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCrit1.setForeground(new java.awt.Color(114, 114, 114));
        labelCrit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit1.setText("Estado");
        add(labelCrit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        labelCrit3.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCrit3.setForeground(new java.awt.Color(114, 114, 114));
        labelCrit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit3.setText("Categoría");
        add(labelCrit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));

        btnReset.setBackground(new java.awt.Color(96, 243, 96));
        btnReset.setPreferredSize(new java.awt.Dimension(106, 31));

        labelReset.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelReset.setForeground(new java.awt.Color(255, 255, 255));
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

        add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 60, -1));

        labelTitle.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(114, 114, 114));
        labelTitle.setText("Record Selector Panel");
        add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(216, 188, 188));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(216, 188, 188));

        panelRecordList.setBackground(new java.awt.Color(216, 188, 188));
        panelRecordList.setForeground(new java.awt.Color(216, 188, 188));
        jScrollPane1.setViewportView(panelRecordList);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 760, 340));
    }// </editor-fold>//GEN-END:initComponents

    private void labelResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResetMouseClicked

    }//GEN-LAST:event_labelResetMouseClicked

    private void labelResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResetMouseEntered
        btnReset.setBackground(new Color(146,246,146));
    }//GEN-LAST:event_labelResetMouseEntered

    private void labelResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResetMouseExited
        btnReset.setBackground(new Color(96,243,96));
    }//GEN-LAST:event_labelResetMouseExited


    public void setComboStates(){
        comboStates.setModel(Other.setComboStates());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnReset;
    private javax.swing.JRadioButton choicdeGast;
    private javax.swing.JRadioButton choiceLug;
    private javax.swing.JRadioButton choicePala;
    private javax.swing.JRadioButton choiceTrad;
    private javax.swing.JComboBox<String> comboStates;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCrit1;
    private javax.swing.JLabel labelCrit3;
    private javax.swing.JLabel labelReset;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel panelRecordList;
    private javax.swing.ButtonGroup recordTypeGroup;
    // End of variables declaration//GEN-END:variables
}
