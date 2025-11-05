package proyecto.subframes.panes;

import java.awt.Color;
import java.awt.event.KeyEvent;
import proyecto.subframes.RecordApproverPanel;
import proyecto.utils.DialogHelper;


public class WriteReasonPane extends javax.swing.JFrame {
    
    RecordApproverPanel recordApproverPanel;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.
            getLogger(WriteReasonPane.class.getName());


    public WriteReasonPane() {
        initComponents();
    }
    
    public WriteReasonPane(RecordApproverPanel recordApproverPanel){
        initComponents();
        setLocationRelativeTo(null);
        
        this.recordApproverPanel = recordApproverPanel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldMotivo = new javax.swing.JTextArea();
        btnTerminar = new javax.swing.JPanel();
        labelTerminar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JPanel();
        labelCancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(216, 188, 188));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setForeground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitle.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(0, 0, 0));
        labelTitle.setText("Escribe el motivo:");
        bg.add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        fieldMotivo.setBackground(new java.awt.Color(221, 211, 255));
        fieldMotivo.setColumns(20);
        fieldMotivo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        fieldMotivo.setForeground(new java.awt.Color(0, 0, 0));
        fieldMotivo.setLineWrap(true);
        fieldMotivo.setRows(5);
        fieldMotivo.setText("Motivo");
        fieldMotivo.setWrapStyleWord(true);
        fieldMotivo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldMotivoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldMotivoFocusLost(evt);
            }
        });
        fieldMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldMotivoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(fieldMotivo);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 53, 400, 221));

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

        bg.add(btnTerminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 90, -1));

        btnCancelar.setBackground(new java.awt.Color(154, 136, 216));
        btnCancelar.setPreferredSize(new java.awt.Dimension(106, 31));

        labelCancelar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelCancelar.setForeground(new java.awt.Color(0, 0, 0));
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

        bg.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelTerminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTerminarMouseClicked
        getTextFromMotivo();
    }//GEN-LAST:event_labelTerminarMouseClicked

    private void labelTerminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTerminarMouseEntered
        btnTerminar.setBackground(new Color(221,211,255));
    }//GEN-LAST:event_labelTerminarMouseEntered

    private void labelTerminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTerminarMouseExited
        btnTerminar.setBackground(new Color(154, 136, 216));
    }//GEN-LAST:event_labelTerminarMouseExited

    private void labelCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCancelarMouseClicked
        recordApproverPanel.getReasonFromForm("");
        this.dispose();
    }//GEN-LAST:event_labelCancelarMouseClicked

    private void labelCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCancelarMouseEntered
        btnCancelar.setBackground(new Color(221,211,255));
    }//GEN-LAST:event_labelCancelarMouseEntered

    private void labelCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCancelarMouseExited
        btnCancelar.setBackground(new Color(154, 136, 216));
    }//GEN-LAST:event_labelCancelarMouseExited

    private void fieldMotivoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldMotivoFocusGained
        if (fieldMotivo.getText().equals("Motivo")){
            fieldMotivo.setText("");
            fieldMotivo.setForeground(Color.white);
        }
    }//GEN-LAST:event_fieldMotivoFocusGained

    private void fieldMotivoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldMotivoFocusLost
        if (fieldMotivo.getText().isEmpty()){
            fieldMotivo.setText("Motivo");
            fieldMotivo.setForeground(new Color(235,233,233));
        }
    }//GEN-LAST:event_fieldMotivoFocusLost

    private void fieldMotivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldMotivoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            getTextFromMotivo();
        }
    }//GEN-LAST:event_fieldMotivoKeyPressed
    
    private void getTextFromMotivo(){
        if (! fieldMotivo.getText().isEmpty()) {
            recordApproverPanel.getReasonFromForm(fieldMotivo.getText());
            this.dispose();
            return;
        }
        DialogHelper.errorMessageDialog("El motivo esta vacío, escribe uno.", "Campo vacío.");
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.
                    getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new WriteReasonPane().setVisible(
                true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btnCancelar;
    private javax.swing.JPanel btnTerminar;
    private javax.swing.JTextArea fieldMotivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCancelar;
    private javax.swing.JLabel labelTerminar;
    private javax.swing.JLabel labelTitle;
    // End of variables declaration//GEN-END:variables
}
