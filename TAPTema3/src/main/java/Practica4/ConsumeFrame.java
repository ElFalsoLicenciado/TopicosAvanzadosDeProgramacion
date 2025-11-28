package Practica4;

import javax.swing.JOptionPane;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;

public class ConsumeFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ConsumeFrame.class.getName());

    public ConsumeFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPost = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnGet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consumir PHP");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPost.setText("Consumir POST");
        btnPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostActionPerformed(evt);
            }
        });
        getContentPane().add(btnPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 60, 180, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 93, 388, 179));

        jLabel1.setText("Valor a enviar:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 200, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 28, 388, -1));

        btnGet.setText("Consumir GET");
        btnGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetActionPerformed(evt);
            }
        });
        getContentPane().add(btnGet, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 60, 190, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostActionPerformed
        try {
            Form form = Form.form();
            form.add("nombre", jTextField1.getText());

            String result = Request.post(
                            "http://localhost/TAP_2025/TAP_U3P4/saludo.php"
                    ).bodyForm(form.build()).execute().returnContent().asString();

            jTextArea1.append(result + "\n");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btnPostActionPerformed

    private void btnGetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetActionPerformed
        try{
            String value = jTextField1.getText();

            String result = Request.get(
                    "http://localhost/TAP_2025/TAP_U3P4/saludoget.php?nombre=" + java.net.URLEncoder.encode(value, "UTF-8")
            ).execute().returnContent().asString();


            jTextArea1.append(result + "\n");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btnGetActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ConsumeFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGet;
    private javax.swing.JButton btnPost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
