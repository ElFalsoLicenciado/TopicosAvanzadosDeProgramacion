package Practica2;

import java.util.List;
import javax.swing.SwingWorker;

public class RelojFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.
            getLogger(RelojFrame.class.getName());

    private Hilo hilo = new Hilo();
    private boolean ejecuta = false;
    private int secs = 0;
    private int mins = 0;


    public RelojFrame() {
        initComponents();
        setLocationRelativeTo(null);
        btnPause.setVisible(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTiempo = new javax.swing.JLabel();
        btnPS = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        labelTiempo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTiempo.setText("00:00");

        btnPS.setText("Iniciar");
        btnPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPSActionPerformed(evt);
            }
        });

        btnPause.setText("Pausar");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(btnPS, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnPause)
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPS)
                    .addComponent(btnPause))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPSActionPerformed
        if( ! ejecuta)   {
            ejecuta = true;
            hilo = new Hilo();
            hilo.execute();
            btnPS.setText("Detener");
            btnPause.setVisible(true);
        } else {
            ejecuta = false;            
            hilo.cancel(true);
            btnPS.setText("Iniciar");   
            labelTiempo.setText("00:00");
            mins = 0;
            secs = 0;
            btnPause.setVisible(false);

        }
    }//GEN-LAST:event_btnPSActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if( ! hilo.isCancelled()) {
            hilo.cancel(true);
        }
    }//GEN-LAST:event_formWindowClosed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        ejecuta = false;
        hilo.cancel(true);
        btnPS.setText("Iniciar");
        btnPause.setVisible(false);
    }//GEN-LAST:event_btnPauseActionPerformed

    /**
     * @param args the command line arguments
     */
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
        java.awt.EventQueue.invokeLater(() -> new RelojFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPS;
    private javax.swing.JButton btnPause;
    private javax.swing.JLabel labelTiempo;
    // End of variables declaration//GEN-END:variables


    class Hilo extends SwingWorker{
        @Override // Este no permite alterar la GUI (No deberia)
        protected Object doInBackground() throws Exception { // Funcion run en Thread
            while(ejecuta) {
                publish("");
                Thread.sleep(250);
                secs++;
                if(secs == 60){
                    secs = 0;
                    mins++;
                }
            }
            return "";
        }

        @Override
        protected void process(List chunks) {
            super.process(chunks);
            labelTiempo.setText(String.format("%02d:%02d",mins,secs));
        }
        
        
        
    }
}
