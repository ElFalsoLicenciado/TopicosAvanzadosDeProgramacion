package Tarea1;


import Tarea1.model_layer.models.Compositor;

import javax.swing.*;

public class ItemCompositor extends javax.swing.JPanel {

    private Formulario formulario;
    private Compositor compositor;
    
    public ItemCompositor() {
        initComponents();
    }

    public ItemCompositor(Formulario formulario, Compositor compositor) {
        initComponents();

        this.formulario = formulario;
        this.compositor = compositor;

        labelNombre.setText(compositor.getNombre_compositor());

        labelEpoca.setText(compositor.getEpoca().toString());

        labelComposiciones.setText("" + compositor.getNum_composiciones());

        switch (compositor.isVive()) {
            case true -> labelVivo.setText("Vivo.");
            case false -> labelVivo.setText("Difunto");
        }

        if(compositor.getFoto_compositor() != null) {
            updateFoto(compositor.getFoto_compositor());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenido = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelEpoca = new javax.swing.JLabel();
        labelComposiciones = new javax.swing.JLabel();
        labelVivo = new javax.swing.JLabel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenido.setBackground(new java.awt.Color(255, 255, 255));
        contenido.setForeground(new java.awt.Color(255, 255, 255));
        contenido.setToolTipText("");
        contenido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contenido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contenidoMouseClicked(evt);
            }
        });
        contenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNombre.setBackground(new java.awt.Color(255, 255, 255));
        labelNombre.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(0, 0, 0));
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombre.setText("Nombre");
        contenido.add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        labelEpoca.setBackground(new java.awt.Color(255, 255, 255));
        labelEpoca.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        labelEpoca.setForeground(new java.awt.Color(0, 0, 0));
        labelEpoca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEpoca.setText("Epoca");
        contenido.add(labelEpoca, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        labelComposiciones.setBackground(new java.awt.Color(255, 255, 255));
        labelComposiciones.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        labelComposiciones.setForeground(new java.awt.Color(0, 0, 0));
        labelComposiciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelComposiciones.setText("Num. de composiciones");
        contenido.add(labelComposiciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        labelVivo.setBackground(new java.awt.Color(255, 255, 255));
        labelVivo.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        labelVivo.setForeground(new java.awt.Color(0, 0, 0));
        labelVivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVivo.setText("¿Vivo?");
        contenido.add(labelVivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));
        contenido.add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 16, 190, 180));

        add(contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 240));
    }// </editor-fold>//GEN-END:initComponents

    private void contenidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contenidoMouseClicked
        formulario.setCompositor(compositor);
    }//GEN-LAST:event_contenidoMouseClicked

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenido;
    private javax.swing.JLabel labelComposiciones;
    private javax.swing.JLabel labelEpoca;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelVivo;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    // End of variables declaration//GEN-END:variables
}
