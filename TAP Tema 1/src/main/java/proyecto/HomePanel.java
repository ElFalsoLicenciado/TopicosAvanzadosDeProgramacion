package proyecto;

import proyecto.models.Session;
import proyecto.models.User;
import proyecto.subframes.*;

import java.awt.Color;

public class HomePanel extends javax.swing.JFrame {
    
    int xMouse, yMouse;
    private LogInPanel logInPanel;
    private Session session;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.
            getLogger(HomePanel.class.getName());

    public HomePanel() {
        initComponents();
        setLocationRelativeTo(null);
        manageRecordsPane.setVisible(false);
    }

    public HomePanel(LogInPanel logInPanel, Session session) {
        this.logInPanel = logInPanel;
        this.session = session;
        initComponents();
        setLocationRelativeTo(null);
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabGroup = new javax.swing.JTabbedPane();
        readTab = new javax.swing.JPanel();
        selectRecordPane = new proyecto.subframes.RecordSelectorPanel();
        recordReaderPane = new proyecto.subframes.RecordReaderPanel();
        recordTab = new javax.swing.JPanel();
        recordGroup = new javax.swing.JTabbedPane();
        recordPanel = new javax.swing.JPanel();
        editRecordPane = new proyecto.subframes.RecordEditorPanel();
        manageRecordsPane = new proyecto.subframes.RecordManagerPanel();
        requestPanel = new javax.swing.JPanel();
        adminTab = new javax.swing.JPanel();
        adminToolsPane = new proyecto.subframes.AdminPanel();
        header = new javax.swing.JPanel();
        btnSalir = new javax.swing.JPanel();
        x = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(216, 188, 188));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabGroup.setBackground(new java.awt.Color(216, 188, 188));
        tabGroup.setForeground(new java.awt.Color(114, 114, 114));
        tabGroup.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

        readTab.setBackground(new java.awt.Color(216, 188, 188));
        readTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        readTab.add(selectRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 812, 530));

        recordReaderPane.setBackground(new java.awt.Color(216, 188, 188));
        readTab.add(recordReaderPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 540));

        tabGroup.addTab("Ver registros", readTab);

        recordTab.setBackground(new java.awt.Color(216, 188, 188));
        recordTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recordGroup.setBackground(new java.awt.Color(216, 188, 188));
        recordGroup.setForeground(new java.awt.Color(114, 114, 114));
        recordGroup.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

        recordPanel.setBackground(new java.awt.Color(216, 188, 188));
        recordPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        recordPanel.add(editRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));
        recordPanel.add(manageRecordsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

        recordGroup.addTab("Registros", recordPanel);

        requestPanel.setBackground(new java.awt.Color(216, 188, 188));
        requestPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        recordGroup.addTab("Aprobaciones", requestPanel);

        recordTab.add(recordGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 570));

        tabGroup.addTab("Pestaña de creador", recordTab);

        adminTab.setBackground(new java.awt.Color(216, 188, 188));
        adminTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        adminTab.add(adminToolsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 812, 530));

        tabGroup.addTab("Moderación", adminTab);

        getContentPane().add(tabGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, 560));

        header.setBackground(new java.awt.Color(216, 188, 188));
        header.setForeground(new java.awt.Color(216, 188, 188));
        header.setOpaque(false);
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

        btnSalir.setBackground(new java.awt.Color(102, 102, 102));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        x.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
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

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 721, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
        );

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void xMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseClicked
        this.dispose();
    }//GEN-LAST:event_xMouseClicked

    private void xMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseEntered
        btnSalir.setBackground(Color.red);
        x.setForeground(Color.white);
    }//GEN-LAST:event_xMouseEntered

    private void xMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseExited
        btnSalir.setBackground(new Color(102,102,102));
        x.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_xMouseExited

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        logInPanel.reopenLogIn();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            User currentUser = session.getUser();
            switch (currentUser.getUserType()) {
                case USER -> tabGroup.remove(adminTab);
                case GUEST -> {
                    tabGroup.remove(recordTab);
                    tabGroup.remove(adminTab);
                }
            }
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new HomePanel().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adminTab;
    private proyecto.subframes.AdminPanel adminToolsPane;
    private javax.swing.JPanel btnSalir;
    private proyecto.subframes.RecordEditorPanel editRecordPane;
    private javax.swing.JPanel header;
    private proyecto.subframes.RecordManagerPanel manageRecordsPane;
    private javax.swing.JPanel readTab;
    private javax.swing.JTabbedPane recordGroup;
    private javax.swing.JPanel recordPanel;
    private proyecto.subframes.RecordReaderPanel recordReaderPane;
    private javax.swing.JPanel recordTab;
    private javax.swing.JPanel requestPanel;
    private proyecto.subframes.RecordSelectorPanel selectRecordPane;
    private javax.swing.JTabbedPane tabGroup;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
