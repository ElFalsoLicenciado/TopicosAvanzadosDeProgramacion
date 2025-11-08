/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tarea1;

import Tarea1.model_layer.models.Compositor;
import Tarea1.model_layer.models.CompositorService;
import Tarea1.model_layer.models.Epoca;
import java.awt.Color;
import java.nio.file.Files;
import javax.swing.*;


public class EditorDeCompositores extends javax.swing.JFrame {




    private static final java.util.logging.Logger logger = java.util.logging.Logger.
            getLogger(EditorDeCompositores.class.getName());
    int xMouse, yMouse;
    private final Color COLOR1 = new Color(154, 136, 216);
    private final Color COLOR2 = new Color(221,211,255);
    private Formulario formulario;
    private Compositor compositor;
    private boolean newLog;
    private byte [] image;


    public EditorDeCompositores() {
        initComponents();
    }

    public EditorDeCompositores(Formulario formulario) {
        initComponents();
        setLocationRelativeTo(null);

        comboEpocas.setModel(setComboEpocas());

        this.formulario =  formulario;
        compositor = null;
        newLog = true;
        image = null;

        labelTitle.setText("Crear.");

        panelImage1.setIcon(
                new ImageIcon("src/main/java/Tarea1/resources/imgnotfound.png")
        );
    }

    public EditorDeCompositores(Formulario formulario,Compositor compositor) {
        initComponents();
        setLocationRelativeTo(null);

        comboEpocas.setModel(setComboEpocas());

        this.formulario =  formulario;
        this.compositor = compositor;
        newLog = false;

        fieldTitulo.setText(compositor.getNombre_compositor());

        int aux = compositor.getEpoca().ordinal()+1;
        System.out.println(aux);

        comboEpocas.setSelectedIndex(aux);

        aux = compositor.getNum_composiciones();
//        System.out.println(aux);

        spinnerComposiciones.setValue((Object) compositor.getNum_composiciones());

        switch (compositor.isVive()) {
            case true -> choiceYes.setSelected(true);
            case false -> choiceNo.setSelected(true);
        }

        image = compositor.getFoto_compositor();

        if(image != null) {
            updateFoto(compositor.getFoto_compositor());
        }


        labelTitle.setText("Editar.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupAlive = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        contenido = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        btnTerminar = new javax.swing.JPanel();
        labelTerminar = new javax.swing.JLabel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        comboEpocas = new javax.swing.JComboBox<>();
        labelCrit2 = new javax.swing.JLabel();
        fieldTitulo = new javax.swing.JTextField();
        labelCrit1 = new javax.swing.JLabel();
        labelCrit4 = new javax.swing.JLabel();
        choiceYes = new javax.swing.JRadioButton();
        choiceNo = new javax.swing.JRadioButton();
        spinnerComposiciones = new javax.swing.JSpinner();
        labelCrit3 = new javax.swing.JLabel();
        btnSearchImage = new javax.swing.JPanel();
        labelSearchImage = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        btnSalir = new javax.swing.JPanel();
        x = new javax.swing.JLabel();

        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\Users\\User\\Documents\\Programming\\JetBrains\\IntelliJ Projects\\Topicos Avanzados de Programacion\\TAPTema3\\src\\main\\java\\Tarea1\\resources"));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenido.setBackground(new java.awt.Color(255, 255, 255));
        contenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitle.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(0, 0, 0));
        labelTitle.setText("Editor");
        contenido.add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnTerminar.setBackground(new java.awt.Color(154, 136, 216));
        btnTerminar.setPreferredSize(new java.awt.Dimension(106, 31));

        labelTerminar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelTerminar.setForeground(new java.awt.Color(0, 0, 0));
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

        contenido.add(btnTerminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 90, -1));

        panelImage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );

        contenido.add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 300, 370));

        comboEpocas.setBackground(new java.awt.Color(221, 211, 255));
        comboEpocas.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        comboEpocas.setForeground(new java.awt.Color(0, 0, 0));
        comboEpocas.setBorder(null);
        contenido.add(comboEpocas, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 300, 40));

        labelCrit2.setBackground(new java.awt.Color(255, 255, 255));
        labelCrit2.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        labelCrit2.setForeground(new java.awt.Color(0, 0, 0));
        labelCrit2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit2.setText("Epoca");
        contenido.add(labelCrit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        fieldTitulo.setBackground(new java.awt.Color(221, 211, 255));
        fieldTitulo.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        fieldTitulo.setForeground(new java.awt.Color(102, 102, 102));
        fieldTitulo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldTitulo.setText("Escribe el nombre");
        fieldTitulo.setBorder(null);
        fieldTitulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldTituloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldTituloFocusLost(evt);
            }
        });
        contenido.add(fieldTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 300, 40));

        labelCrit1.setBackground(new java.awt.Color(255, 255, 255));
        labelCrit1.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        labelCrit1.setForeground(new java.awt.Color(0, 0, 0));
        labelCrit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit1.setText("Nombre");
        contenido.add(labelCrit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        labelCrit4.setBackground(new java.awt.Color(255, 255, 255));
        labelCrit4.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        labelCrit4.setForeground(new java.awt.Color(0, 0, 0));
        labelCrit4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit4.setText("¿Vivo?");
        contenido.add(labelCrit4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, -1));

        choiceYes.setBackground(new java.awt.Color(255, 255, 255));
        groupAlive.add(choiceYes);
        choiceYes.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        choiceYes.setForeground(new java.awt.Color(0, 0, 0));
        choiceYes.setText("Si");
        choiceYes.setBorder(null);
        contenido.add(choiceYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, -1, -1));

        choiceNo.setBackground(new java.awt.Color(255, 255, 255));
        groupAlive.add(choiceNo);
        choiceNo.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        choiceNo.setForeground(new java.awt.Color(0, 0, 0));
        choiceNo.setText("No");
        choiceNo.setBorder(null);
        contenido.add(choiceNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, -1, -1));

        spinnerComposiciones.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        spinnerComposiciones.setModel(new javax.swing.SpinnerNumberModel(1, 0, 100, 1));
        spinnerComposiciones.setBorder(null);
        contenido.add(spinnerComposiciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, 30));

        labelCrit3.setBackground(new java.awt.Color(255, 255, 255));
        labelCrit3.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        labelCrit3.setForeground(new java.awt.Color(0, 0, 0));
        labelCrit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrit3.setText("Num. de composiciones");
        contenido.add(labelCrit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));

        btnSearchImage.setBackground(new java.awt.Color(154, 136, 216));
        btnSearchImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelSearchImage.setBackground(new java.awt.Color(51, 51, 51));
        labelSearchImage.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelSearchImage.setForeground(new java.awt.Color(0, 0, 0));
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

        contenido.add(btnSearchImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, -1));

        getContentPane().add(contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 668, 510));

        header.setBackground(new java.awt.Color(214, 232, 255));
        header.setForeground(new java.awt.Color(214, 232, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(214, 232, 255));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        x.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        x.setForeground(new java.awt.Color(0, 0, 0));
        x.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x.setText("X");
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

        header.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, -1, -1));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelTerminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTerminarMouseClicked
        String mistakes = "";
        if (fieldTitulo.getText().equals("Escribe el nombre")) mistakes += "No dejes el nombre en blanco.\n";

        if (comboEpocas.getSelectedIndex() == 0) mistakes += "Por favor, selecciona una época.\n";

        if (groupAlive.getSelection() == null) mistakes += "Por favor, especifica si esta vivo o no.\n";

        if (mistakes.isEmpty()) {
            String nombre_compositor = fieldTitulo.getText();
            Epoca epoca = Epoca.values()[comboEpocas.getSelectedIndex()-1];
            int num_composiciones = (int) spinnerComposiciones.getValue();
            Boolean isAlive = choiceYes.isSelected();

            try {
                if (newLog) {
                    if (CompositorService.create(image, nombre_compositor, epoca, num_composiciones, isAlive)) {
                        formulario.updatePanel();
                        this.dispose();
                        return;
                    }
                }
                else {
                    if (CompositorService.update(compositor.getId_compositor(), image, nombre_compositor, epoca, num_composiciones, isAlive)){
                        formulario.updatePanel();
                        this.dispose();
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(null,mistakes, "Tienes errores.", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_labelTerminarMouseClicked

    private void labelTerminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTerminarMouseEntered
        btnTerminar.setBackground(COLOR2);
    }//GEN-LAST:event_labelTerminarMouseEntered

    private void labelTerminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTerminarMouseExited
        btnTerminar.setBackground(COLOR2);
    }//GEN-LAST:event_labelTerminarMouseExited

    private void xMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseClicked
        this.dispose();
    }//GEN-LAST:event_xMouseClicked

    private void xMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseEntered
        btnSalir.setBackground(Color.red);
        x.setForeground(Color.white);
    }//GEN-LAST:event_xMouseEntered

    private void xMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseExited
        btnSalir.setBackground(new Color(214,232,255));
        x.setForeground(Color.black);
    }//GEN-LAST:event_xMouseExited

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void fieldTituloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldTituloFocusGained
        focusTitulo();
    }//GEN-LAST:event_fieldTituloFocusGained

    private void fieldTituloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldTituloFocusLost
        unfocusTitulo();
    }//GEN-LAST:event_fieldTituloFocusLost

    private void labelSearchImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSearchImageMouseClicked
        if(jFileChooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                byte[] foto = Files.readAllBytes(
                        jFileChooser1.getSelectedFile().toPath()
                );
                image = foto;
                updateFoto(foto);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error");
            }
        }
    }//GEN-LAST:event_labelSearchImageMouseClicked

    private void labelSearchImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSearchImageMouseEntered
        btnSearchImage.setBackground(new Color(221,211,255));
    }//GEN-LAST:event_labelSearchImageMouseEntered

    private void labelSearchImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSearchImageMouseExited
        btnSearchImage.setBackground(new Color(154, 136, 216));
    }//GEN-LAST:event_labelSearchImageMouseExited


    public static DefaultComboBoxModel<String> setComboEpocas(){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Selecciona una epoca.");
        for (Epoca epoca : Epoca.values()) {
            String displayName = epoca.name().replace("_", " ");
            model.addElement(displayName);
        }
        return model;
    }

    public static String[] getEpocas() {
        String[] epocas = new String[Epoca.values().length];

        for (int i = 0; i < Epoca.values().length; i++) {
            epocas[i] = Epoca.values()[i].name();
        }
        return epocas;
    }


    private void focusTitulo(){
        if (fieldTitulo.getText().equals("Escribe el nombre")){
            fieldTitulo.setText("");
            fieldTitulo.setForeground(Color.black);
        }
    }

    private void unfocusTitulo(){
        if (fieldTitulo.getText().isEmpty()){
            fieldTitulo.setText("Escribe el nombre");
            fieldTitulo.setForeground(new Color(102,102,102));
        }
    }

    private void updateFoto(byte[] bytesImage) {
        try {
            panelImage1.setIcon(
                    new ImageIcon(bytesImage)
            );
            panelImage1.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");
        }
    }

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new EditorDeCompositores().setVisible(
                true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnSalir;
    private javax.swing.JPanel btnSearchImage;
    private javax.swing.JPanel btnTerminar;
    private javax.swing.JRadioButton choiceNo;
    private javax.swing.JRadioButton choiceYes;
    private javax.swing.JComboBox<String> comboEpocas;
    private javax.swing.JPanel contenido;
    private javax.swing.JTextField fieldTitulo;
    private javax.swing.ButtonGroup groupAlive;
    private javax.swing.JPanel header;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel labelCrit1;
    private javax.swing.JLabel labelCrit2;
    private javax.swing.JLabel labelCrit3;
    private javax.swing.JLabel labelCrit4;
    private javax.swing.JLabel labelSearchImage;
    private javax.swing.JLabel labelTerminar;
    private javax.swing.JLabel labelTitle;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JSpinner spinnerComposiciones;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
