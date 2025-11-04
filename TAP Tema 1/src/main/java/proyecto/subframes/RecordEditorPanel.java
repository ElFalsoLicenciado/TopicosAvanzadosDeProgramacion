/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyecto.subframes;

import java.awt.Color;

import proyecto.HomePanel;
import proyecto.enums.RecordType;
import proyecto.enums.StateNames;
import proyecto.enums.UserType;
import proyecto.models.Record;
import proyecto.models.Session;
import proyecto.services.RecordServices;
import proyecto.services.RequestServices;
import proyecto.utils.DialogHelper;
import proyecto.utils.Other;
import java.io.File;
import javax.swing.JFileChooser;

public class RecordEditorPanel extends javax.swing.JPanel {

    private HomePanel homePanel;
    private Session session;
    private Record record;

    private final String IMG_PATH = "src/main/java/proyecto/resources/";
    private File imgFile = null;

    public RecordEditorPanel() {
        initComponents();
    }

    public RecordEditorPanel(HomePanel homePanel, Session session) {
        initComponents();
        setComboStates();

        this.homePanel = homePanel;
        this.session = session;
        record = null;
        imgFile = new File(IMG_PATH+ "imgnotfound.png");
    }

    public RecordEditorPanel(HomePanel homePanel, Session session, Record record) {
        initComponents();
        setComboStates();

        this.homePanel = homePanel;
        this.session = session;
        this.record = record;

        fieldTitulo.setText(record.getTitle());
        fieldTitulo.setForeground(Color.black);

        fieldDescripcion.setText(record.getDescription());
        fieldDescripcion.setForeground(Color.black);

        switch (record.getRecordType()) {
            case LUGAR -> choiceLug.setSelected(true);
            case TRADICION -> choiceTrad.setSelected(true);
            case PALABRA -> choicePala.setSelected(true);
            case GASTRONOMIA -> choiceGast.setSelected(true);
        }

        comboStates.setSelectedIndex(record.getState().ordinal()+1);

        imgFile = new File(record.getImageUrl());
        panelImage.setIcon(
                new javax.swing.ImageIcon(imgFile.getAbsolutePath())
        );
        panelImage.updateUI();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser("C:\\Users\\User\\Downloads\\Media\\Images");
        catGroup = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        choiceGast = new javax.swing.JRadioButton();
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
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldDescripcion = new javax.swing.JTextArea();
        labelCrit3 = new javax.swing.JLabel();
        comboStates = new javax.swing.JComboBox<>();
        labelCrit2 = new javax.swing.JLabel();
        btnTerminar = new javax.swing.JPanel();
        labelTerminar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JPanel();
        labelCancelar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(216, 188, 188));
        setMinimumSize(new java.awt.Dimension(690, 75));
        setPreferredSize(new java.awt.Dimension(690, 75));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(216, 188, 188));
        bg.setMinimumSize(new java.awt.Dimension(762, 600));
        bg.setPreferredSize(new java.awt.Dimension(762, 600));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        choiceGast.setBackground(new java.awt.Color(216, 188, 188));
        catGroup.add(choiceGast);
        choiceGast.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choiceGast.setForeground(new java.awt.Color(235, 233, 233));
        choiceGast.setText("Gastronomía");
        choiceGast.setBorder(null);
        bg.add(choiceGast, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, -1, -1));

        choicePala.setBackground(new java.awt.Color(216, 188, 188));
        catGroup.add(choicePala);
        choicePala.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choicePala.setForeground(new java.awt.Color(235, 233, 233));
        choicePala.setText("Palabra");
        choicePala.setBorder(null);
        bg.add(choicePala, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));

        choiceTrad.setBackground(new java.awt.Color(216, 188, 188));
        catGroup.add(choiceTrad);
        choiceTrad.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choiceTrad.setForeground(new java.awt.Color(235, 233, 233));
        choiceTrad.setText("Tradición");
        choiceTrad.setBorder(null);
        bg.add(choiceTrad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        choiceLug.setBackground(new java.awt.Color(216, 188, 188));
        catGroup.add(choiceLug);
        choiceLug.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choiceLug.setForeground(new java.awt.Color(235, 233, 233));
        choiceLug.setText("Lugar");
        choiceLug.setBorder(null);
        bg.add(choiceLug, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

        labelTitle.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(114, 114, 114));
        labelTitle.setText("Record Panel");
        bg.add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panelImage.setBackground(new java.awt.Color(255, 255, 255));
        panelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        panelImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\Programming\\JetBrains\\IntelliJ Projects\\Topicos Avanzados de Programacion\\TAP Tema 1\\src\\main\\java\\proyecto\\resources\\imgnotfound.png")); // NOI18N
        bg.add(panelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 170));

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

        bg.add(btnSearchImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        fieldTitulo.setBackground(new java.awt.Color(255, 255, 255));
        fieldTitulo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        fieldTitulo.setForeground(new java.awt.Color(235, 233, 233));
        fieldTitulo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldTitulo.setText("Escribe el título");
        fieldTitulo.setBorder(null);
        fieldTitulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldTituloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldTituloFocusLost(evt);
            }
        });
        bg.add(fieldTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 300, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 300, 20));

        labelCrit1.setBackground(new java.awt.Color(0, 0, 0));
        labelCrit1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCrit1.setForeground(new java.awt.Color(114, 114, 114));
        labelCrit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit1.setText("Estado");
        bg.add(labelCrit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 760, 20));

        fieldDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        fieldDescripcion.setColumns(20);
        fieldDescripcion.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        fieldDescripcion.setLineWrap(true);
        fieldDescripcion.setRows(5);
        fieldDescripcion.setText("Escribe la descripción\n");
        fieldDescripcion.setWrapStyleWord(true);
        fieldDescripcion.setBorder(null);
        fieldDescripcion.setDisabledTextColor(new java.awt.Color(235, 233, 233));
        fieldDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldDescripcionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldDescripcionFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(fieldDescripcion);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 760, 150));

        labelCrit3.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCrit3.setForeground(new java.awt.Color(114, 114, 114));
        labelCrit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit3.setText("Categoría");
        bg.add(labelCrit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        comboStates.setBackground(new java.awt.Color(255, 255, 255));
        comboStates.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        comboStates.setForeground(new java.awt.Color(235, 233, 233));
        comboStates.setBorder(null);
        bg.add(comboStates, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 300, -1));

        labelCrit2.setBackground(new java.awt.Color(0, 0, 0));
        labelCrit2.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelCrit2.setForeground(new java.awt.Color(114, 114, 114));
        labelCrit2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit2.setText("Titulo");
        bg.add(labelCrit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        btnTerminar.setBackground(new java.awt.Color(96, 243, 96));
        btnTerminar.setPreferredSize(new java.awt.Dimension(106, 31));

        labelTerminar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelTerminar.setForeground(new java.awt.Color(255, 255, 255));
        labelTerminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTerminar.setText("TERMINAR");
        labelTerminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelTerminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTerminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelTerminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelTerminarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnTerminarLayout = new javax.swing.GroupLayout(btnTerminar);
        btnTerminar.setLayout(btnTerminarLayout);
        btnTerminarLayout.setHorizontalGroup(
            btnTerminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTerminarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnTerminarLayout.setVerticalGroup(
            btnTerminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTerminarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(btnTerminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 90, -1));

        btnCancelar.setBackground(new java.awt.Color(96, 243, 96));
        btnCancelar.setPreferredSize(new java.awt.Dimension(106, 31));

        labelCancelar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelCancelar.setForeground(new java.awt.Color(255, 255, 255));
        labelCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCancelar.setText("CANCELAR");
        labelCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelCancelarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnCancelarLayout = new javax.swing.GroupLayout(btnCancelar);
        btnCancelar.setLayout(btnCancelarLayout);
        btnCancelarLayout.setHorizontalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCancelarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnCancelarLayout.setVerticalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCancelarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 90, -1));

        add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void labelSearchImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSearchImageMouseClicked
        String fileName = null;

        if(jFileChooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            fileName = file.getName();

            System.out.println(fileName);

            if(fileName.endsWith(".png") || fileName.endsWith(".jpg")) {
                panelImage.setIcon(
                        new javax.swing.ImageIcon(file.getPath())
                );
                imgFile = new File(file.getPath());
                panelImage.setBackground(Color.white);
                panelImage.updateUI();
            } else {
                DialogHelper.errorMessageDialog(
                        "Debe seleccionar una imagen png o jpg.",
                        "Error de selección."
                );
            }
        }
    }//GEN-LAST:event_labelSearchImageMouseClicked

    private String copyImage(File file, String fileName) {
        String img;
        String folder = Other.folders[comboStates.getSelectedIndex()-1];
        if(! Other.copiarArchivo(file.toPath(), IMG_PATH + folder ,fileName)) {
            panelImage.setIcon(
                    new javax.swing.ImageIcon(IMG_PATH + "imgnotfound.png")
            );
            panelImage.setBackground(Color.white);
            img = IMG_PATH + "imgnotfound.png";
        }

        System.out.println("Colocando imagen de: " + IMG_PATH + folder + fileName);
        panelImage.setIcon(
                new javax.swing.ImageIcon(IMG_PATH + folder + fileName)
        );
        panelImage.setBackground(Color.white);
        panelImage.updateUI();

        img = IMG_PATH + folder + fileName;

        return img;
    }

    private void labelSearchImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSearchImageMouseEntered
        btnSearchImage.setBackground(new Color(146,246,146));
    }//GEN-LAST:event_labelSearchImageMouseEntered

    private void labelSearchImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSearchImageMouseExited
        btnSearchImage.setBackground(new Color(96,243,96));
    }//GEN-LAST:event_labelSearchImageMouseExited

    private void labelTerminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTerminarMouseClicked
        String mistakes = "";
        if (fieldTitulo.getText().equals("Escribe el título")) mistakes += "No dejes el título en blanco.\n";

        if (fieldDescripcion.getText().equals("Escribe la descripción"))
            mistakes += "No dejes el descripción en blanco.\n";

        if (comboStates.getSelectedIndex() == 0) mistakes += "Por favor, selecciona un estado.\n";

        if (catGroup.getSelection() == null) mistakes += "Por favor, seleccionar una categoría.\n";

        if (mistakes.isEmpty()) {
            String userId = session.getUser().getUserID();
            StateNames state = StateNames.values()[comboStates.getSelectedIndex()-1];
            RecordType type = null;
            boolean isPublic = false;
            String image = copyImage(imgFile, imgFile.getName());

            if (choiceGast.isSelected()) type = RecordType.GASTRONOMIA;
            if (choiceTrad.isSelected()) type = RecordType.TRADICION;
            if (choiceLug.isSelected()) type = RecordType.LUGAR;
            if (choicePala.isSelected()) type = RecordType.PALABRA;

            if (session.getUser().getUserType() == UserType.ADMIN)
                isPublic = true;
            if (record == null) {
                record = new Record(
                        userId,
                        state,
                        type,
                        isPublic,
                        fieldTitulo.getText(),
                        fieldDescripcion.getText(),
                        image
                );
            }else{
                String recordId = record.getRecordId();
                record = new Record(
                        recordId,
                        userId,
                        state,
                        type,
                        isPublic,
                        fieldTitulo.getText(),
                        fieldDescripcion.getText(),
                        image
                );
            }
            if(RecordServices.saveRecord(record)) {
                if (! isPublic ) RequestServices.createRequest(record);
                homePanel.endEditing();
                return;
            }
        }
        DialogHelper.errorMessageDialog(mistakes, "Tienes errores.");

    }//GEN-LAST:event_labelTerminarMouseClicked

    private void labelTerminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTerminarMouseEntered
        btnTerminar.setBackground(new Color(146,246,146));
    }//GEN-LAST:event_labelTerminarMouseEntered

    private void labelTerminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTerminarMouseExited
        btnTerminar.setBackground(new Color(96,243,96));
    }//GEN-LAST:event_labelTerminarMouseExited

    private void labelCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCancelarMouseClicked
        homePanel.endEditing();
    }//GEN-LAST:event_labelCancelarMouseClicked

    private void labelCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCancelarMouseEntered
        btnCancelar.setBackground(new Color(146,246,146));
    }//GEN-LAST:event_labelCancelarMouseEntered

    private void labelCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCancelarMouseExited
        btnCancelar.setBackground(new Color(96,243,96));
    }//GEN-LAST:event_labelCancelarMouseExited

    private void fieldTituloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldTituloFocusGained
        focusTitulo();
    }//GEN-LAST:event_fieldTituloFocusGained

    private void fieldTituloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldTituloFocusLost
        unfocusTitulo();
    }//GEN-LAST:event_fieldTituloFocusLost

    private void fieldDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldDescripcionFocusGained
        focusDescripcion();
    }//GEN-LAST:event_fieldDescripcionFocusGained

    private void fieldDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldDescripcionFocusLost
        unfocusDescripcion();
    }//GEN-LAST:event_fieldDescripcionFocusLost
    
    private void focusTitulo(){
        if (fieldTitulo.getText().equals("Escribe el título")){
            fieldTitulo.setText("");
            fieldTitulo.setForeground(Color.black);
        }
    }
    
    private void focusDescripcion(){
        if (fieldDescripcion.getText().equals("Escribe la descripción")){
            fieldDescripcion.setText("");
            fieldDescripcion.setForeground(Color.black);
        }
    }
    
    private void unfocusTitulo(){
        if (fieldTitulo.getText().isEmpty()){
            fieldTitulo.setText("Escribe el título");
            fieldTitulo.setForeground(new Color(204,204,204));
        }
    }
    
    private void unfocusDescripcion(){
        if (fieldDescripcion.getText().isEmpty()){
            fieldDescripcion.setText("Escribe la descripción");
            fieldDescripcion.setForeground(new Color(204,204,204));
        }
    }
    

    public void setComboStates(){
        comboStates.setModel(Other.setComboStates());
    }





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btnCancelar;
    private javax.swing.JPanel btnSearchImage;
    private javax.swing.JPanel btnTerminar;
    private javax.swing.ButtonGroup catGroup;
    private javax.swing.JRadioButton choiceGast;
    private javax.swing.JRadioButton choiceLug;
    private javax.swing.JRadioButton choicePala;
    private javax.swing.JRadioButton choiceTrad;
    private javax.swing.JComboBox<String> comboStates;
    private javax.swing.JTextArea fieldDescripcion;
    private javax.swing.JTextField fieldTitulo;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelCancelar;
    private javax.swing.JLabel labelCrit1;
    private javax.swing.JLabel labelCrit2;
    private javax.swing.JLabel labelCrit3;
    private javax.swing.JLabel labelSearchImage;
    private javax.swing.JLabel labelTerminar;
    private javax.swing.JLabel labelTitle;
    private org.edisoncor.gui.panel.PanelImage panelImage;
    // End of variables declaration//GEN-END:variables
}
