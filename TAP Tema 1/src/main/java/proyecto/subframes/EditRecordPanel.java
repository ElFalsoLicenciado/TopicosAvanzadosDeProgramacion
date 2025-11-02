/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyecto.subframes;

import java.awt.Color;

import proyecto.utils.DialogHelper;
import proyecto.utils.Other;
import java.io.File;
import javax.swing.JFileChooser;

public class EditRecordPanel extends javax.swing.JPanel {

    private final String IMG_PATH = "src/main/java/proyecto/resources/";
    private String image = "";
    private int oldStateIndex = -1;

    public EditRecordPanel() {
        initComponents();
        setComboStates();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser("C:\\Users\\User\\Downloads\\Media\\Images");
        buttonGroup1 = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        choicdeGast = new javax.swing.JRadioButton();
        choicePala = new javax.swing.JRadioButton();
        choiceTrad = new javax.swing.JRadioButton();
        choiceLug = new javax.swing.JRadioButton();
        labelTitle = new javax.swing.JLabel();
        panelImage = new org.edisoncor.gui.panel.PanelImage();
        btnSearchImage = new javax.swing.JPanel();
        labelSearchImage = new javax.swing.JLabel();
        fieldTitulo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        labelCrit1 = new javax.swing.JLabel();
        labelCrit3 = new javax.swing.JLabel();
        fieldDescripcion = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        comboStates = new javax.swing.JComboBox<>();
        labelCrit2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(690, 75));
        setPreferredSize(new java.awt.Dimension(690, 75));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(245, 68, 68));
        bg.setMinimumSize(new java.awt.Dimension(762, 600));
        bg.setPreferredSize(new java.awt.Dimension(762, 600));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        choicdeGast.setBackground(new java.awt.Color(245, 68, 68));
        choicdeGast.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        choicdeGast.setForeground(new java.awt.Color(0, 0, 0));
        choicdeGast.setText("Gastronomía");
        choicdeGast.setBorder(null);
        bg.add(choicdeGast, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

        choicePala.setBackground(new java.awt.Color(245, 68, 68));
        choicePala.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        choicePala.setForeground(new java.awt.Color(0, 0, 0));
        choicePala.setText("Palabra");
        choicePala.setBorder(null);
        bg.add(choicePala, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, -1, -1));

        choiceTrad.setBackground(new java.awt.Color(245, 68, 68));
        choiceTrad.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        choiceTrad.setForeground(new java.awt.Color(0, 0, 0));
        choiceTrad.setText("Tradición");
        choiceTrad.setBorder(null);
        bg.add(choiceTrad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        choiceLug.setBackground(new java.awt.Color(245, 68, 68));
        choiceLug.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        choiceLug.setForeground(new java.awt.Color(0, 0, 0));
        choiceLug.setText("Lugar");
        choiceLug.setBorder(null);
        bg.add(choiceLug, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, -1));

        labelTitle.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(0, 0, 0));
        labelTitle.setText("Edit Record");
        bg.add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        panelImage.setBackground(new java.awt.Color(255, 255, 255));
        panelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        panelImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\Programming\\JetBrains\\IntelliJ Projects\\Topicos Avanzados de Programacion\\TAP Tema 1\\src\\main\\java\\proyecto\\resources\\imgnotfound.png")); // NOI18N
        bg.add(panelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, 180));

        btnSearchImage.setBackground(new java.awt.Color(96, 243, 96));
        btnSearchImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelSearchImage.setBackground(new java.awt.Color(51, 51, 51));
        labelSearchImage.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelSearchImage.setForeground(new java.awt.Color(255, 255, 255));
        labelSearchImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSearchImage.setText("BUSCAR");
        labelSearchImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSearchImageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelSearchImageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelSearchImageMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnSearchImageLayout = new javax.swing.GroupLayout(btnSearchImage);
        btnSearchImage.setLayout(btnSearchImageLayout);
        btnSearchImageLayout.setHorizontalGroup(
            btnSearchImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSearchImageLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelSearchImage, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnSearchImageLayout.setVerticalGroup(
            btnSearchImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSearchImageLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelSearchImage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(btnSearchImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        fieldTitulo.setBackground(new java.awt.Color(255, 255, 255));
        fieldTitulo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        fieldTitulo.setForeground(new java.awt.Color(235, 233, 233));
        fieldTitulo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldTitulo.setText("Escribe el título");
        fieldTitulo.setBorder(null);
        fieldTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fieldTituloMousePressed(evt);
            }
        });
        bg.add(fieldTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 210, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 210, 20));

        labelCrit1.setBackground(new java.awt.Color(0, 0, 0));
        labelCrit1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCrit1.setForeground(new java.awt.Color(0, 0, 0));
        labelCrit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit1.setText("Estado");
        bg.add(labelCrit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        labelCrit3.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCrit3.setForeground(new java.awt.Color(0, 0, 0));
        labelCrit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit3.setText("Categoría");
        bg.add(labelCrit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        fieldDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        fieldDescripcion.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        fieldDescripcion.setForeground(new java.awt.Color(235, 233, 233));
        fieldDescripcion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldDescripcion.setText("Escribe la descripción");
        fieldDescripcion.setBorder(null);
        fieldDescripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fieldDescripcionMousePressed(evt);
            }
        });
        bg.add(fieldDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 690, 180));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 690, 20));

        comboStates.setBackground(new java.awt.Color(255, 255, 255));
        comboStates.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        comboStates.setForeground(new java.awt.Color(0, 0, 0));
        comboStates.setBorder(null);
        comboStates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatesActionPerformed(evt);
            }
        });
        bg.add(comboStates, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 210, -1));

        labelCrit2.setBackground(new java.awt.Color(0, 0, 0));
        labelCrit2.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCrit2.setForeground(new java.awt.Color(0, 0, 0));
        labelCrit2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit2.setText("Titulo");
        bg.add(labelCrit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void labelSearchImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSearchImageMouseClicked
        String fileName = null;

        if(jFileChooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            fileName = file.getName();

            System.out.println(fileName);

            if(fileName.endsWith(".png") || fileName.endsWith(".jpg")) {
                String folder = Other.folders[comboStates.getSelectedIndex()];
                if(! Other.copiarArchivo(file.toPath(), IMG_PATH + folder ,fileName)) {
                    panelImage.setIcon(
                            new javax.swing.ImageIcon(IMG_PATH + "imgnotfound.png")
                    );
                    panelImage.setBackground(Color.white);
                    image = "imgnotfound.png";
                }

                System.out.println("Colocando imagen de: " + IMG_PATH + folder + fileName);
                panelImage.setIcon(
                        new javax.swing.ImageIcon(IMG_PATH + folder + fileName)
                );
                panelImage.setBackground(Color.white);
                panelImage.updateUI();

                image = fileName;
            } else {
                DialogHelper.errorMessageDialog(
                        "Debe seleccionar una imagen png o jpg.",
                        "Error de selección."
                );
            }
        }
    }//GEN-LAST:event_labelSearchImageMouseClicked

    private void labelSearchImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSearchImageMouseEntered
        btnSearchImage.setBackground(new Color(146,246,146));
    }//GEN-LAST:event_labelSearchImageMouseEntered

    private void labelSearchImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSearchImageMouseExited
        btnSearchImage.setBackground(new Color(96,243,96));
    }//GEN-LAST:event_labelSearchImageMouseExited

    private void fieldTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldTituloMousePressed
        if (fieldTitulo.getText().equals("Escribe el título")){
            fieldTitulo.setText("");
            fieldTitulo.setForeground(Color.black);
        }
        if (fieldDescripcion.getText().isEmpty()){
            fieldDescripcion.setText("Escribe la descripción");
            fieldDescripcion.setForeground(new Color(170, 185, 185));
        }
    }//GEN-LAST:event_fieldTituloMousePressed

    private void fieldDescripcionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldDescripcionMousePressed
        if (fieldDescripcion.getText().equals("Escribe la descripción")){
            fieldDescripcion.setText("");
            fieldDescripcion.setForeground(Color.black);
        }
        if (fieldTitulo.getText().isEmpty()){
            fieldTitulo.setText("Escribe el título");
            fieldTitulo.setForeground(new Color(170, 185, 185));
        }
    }//GEN-LAST:event_fieldDescripcionMousePressed

    private void comboStatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatesActionPerformed
        int newStateIndex = comboStates.getSelectedIndex();

    if (image != null && !image.isEmpty() && oldStateIndex != -1 && newStateIndex != oldStateIndex) {
        String oldFolder = Other.folders[oldStateIndex];
        String newFolder = Other.folders[newStateIndex];

        boolean movido = Other.moveImage(image, oldFolder, newFolder);

        if (movido) {
            System.out.println("La imagen se movió correctamente.");
        }
    }

    oldStateIndex = newStateIndex;
    }//GEN-LAST:event_comboStatesActionPerformed
    
    
    public void setComboStates(){
        comboStates.setModel(Other.setComboStates());
    }





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btnSearchImage;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton choicdeGast;
    private javax.swing.JRadioButton choiceLug;
    private javax.swing.JRadioButton choicePala;
    private javax.swing.JRadioButton choiceTrad;
    private javax.swing.JComboBox<String> comboStates;
    private javax.swing.JTextField fieldDescripcion;
    private javax.swing.JTextField fieldTitulo;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelCrit1;
    private javax.swing.JLabel labelCrit2;
    private javax.swing.JLabel labelCrit3;
    private javax.swing.JLabel labelSearchImage;
    private javax.swing.JLabel labelTitle;
    private org.edisoncor.gui.panel.PanelImage panelImage;
    // End of variables declaration//GEN-END:variables
}
