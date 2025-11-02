package proyecto.subframes;

import proyecto.enums.StateNames;
import proyecto.utils.Other;

import javax.swing.*;
import java.util.Arrays;

public class ReadRecordsPanel extends javax.swing.JPanel {
    
    public ReadRecordsPanel() {
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

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboStates.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        comboStates.setBorder(null);
        add(comboStates, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 210, -1));

        recordTypeGroup.add(choiceTrad);
        choiceTrad.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choiceTrad.setText("Tradición");
        choiceTrad.setBorder(null);
        add(choiceTrad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        recordTypeGroup.add(choicdeGast);
        choicdeGast.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choicdeGast.setText("Gastronomía");
        choicdeGast.setBorder(null);
        add(choicdeGast, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        recordTypeGroup.add(choiceLug);
        choiceLug.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choiceLug.setText("Lugar");
        choiceLug.setBorder(null);
        add(choiceLug, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        recordTypeGroup.add(choicePala);
        choicePala.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choicePala.setText("Palabra");
        choicePala.setBorder(null);
        add(choicePala, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, -1, -1));

        labelCrit1.setBackground(new java.awt.Color(0, 0, 0));
        labelCrit1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCrit1.setForeground(new java.awt.Color(0, 0, 0));
        labelCrit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit1.setText("Estado");
        add(labelCrit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        labelCrit3.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCrit3.setForeground(new java.awt.Color(0, 0, 0));
        labelCrit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit3.setText("Categoría");
        add(labelCrit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    public void setComboStates(){
        comboStates.setModel(Other.setComboStates());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton choicdeGast;
    private javax.swing.JRadioButton choiceLug;
    private javax.swing.JRadioButton choicePala;
    private javax.swing.JRadioButton choiceTrad;
    private javax.swing.JComboBox<String> comboStates;
    private javax.swing.JLabel labelCrit1;
    private javax.swing.JLabel labelCrit3;
    private javax.swing.ButtonGroup recordTypeGroup;
    // End of variables declaration//GEN-END:variables
}
