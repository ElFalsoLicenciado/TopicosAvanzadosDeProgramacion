package proyecto.subframes.panes;

import proyecto.services.UserServices;
import proyecto.subframes.RecordSelectorPanel;
import proyecto.utils.Other;
import proyecto.models.Record;

public class SelectRecordPane extends javax.swing.JPanel {

    private Record record;
    private RecordSelectorPanel recordSelectorPanel;

    public SelectRecordPane(RecordSelectorPanel recordSelectorPanel, Record record) {
        initComponents();

        this.recordSelectorPanel = recordSelectorPanel;
        this.record = record;

        labelTitulo.setText(record.getTitle());

        String state = Other.getStateNames()[record.getState().ordinal()];
        String type = Other.getTypes()[record.getRecordType().ordinal()];

        labelEstadoYCategoria.setText(
                String.format("Estado: %s. Categoría: %s.", state, type)
        );
        String author = UserServices.searchForUser(record.getAuthorId());
        if (author.isEmpty()) author = "Sin autor";

        labelUsuario.setText(
                String.format("Creador: %s.", author)
        );

        panelImage.setIcon( new javax.swing.ImageIcon(record.getImageUrl()));
        updateUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage = new org.edisoncor.gui.panel.PanelImage();
        labelTitulo = new javax.swing.JLabel();
        labelEstadoYCategoria = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
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
        labelTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        labelEstadoYCategoria.setBackground(new java.awt.Color(0, 0, 0));
        labelEstadoYCategoria.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelEstadoYCategoria.setForeground(new java.awt.Color(0, 0, 0));
        labelEstadoYCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEstadoYCategoria.setText("Estado y categoría");
        add(labelEstadoYCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 75, -1, -1));

        labelUsuario.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(0, 0, 0));
        labelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsuario.setText("Usuario");
        add(labelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 135, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        recordSelectorPanel.startLecture(record);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelEstadoYCategoria;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsuario;
    private org.edisoncor.gui.panel.PanelImage panelImage;
    // End of variables declaration//GEN-END:variables
}
