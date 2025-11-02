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
        manageRecordsPanel.setVisible(false);
    }

    public HomePanel(LogInPanel logInPanel, Session session) {
        this.logInPanel = logInPanel;
        this.session = session;
        initComponents();
        setLocationRelativeTo(null);
        manageRecordsPanel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabGroup = new javax.swing.JTabbedPane();
        readTab = new javax.swing.JPanel();
        readRecordsPanel = new proyecto.subframes.ReadRecordsPanel();
        manageTab = new javax.swing.JPanel();
        manageRecordsPanel = new proyecto.subframes.ManageRecordsPanel();
        editRecordPanel = new proyecto.subframes.EditRecordPanel();
        adminTab = new javax.swing.JPanel();
        adminToolsPanel = new proyecto.subframes.AdminToolsPanel();
        header = new javax.swing.JPanel();
        btnSalir = new javax.swing.JPanel();
        x = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        tabGroup.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

        javax.swing.GroupLayout readTabLayout = new javax.swing.GroupLayout(readTab);
        readTab.setLayout(readTabLayout);
        readTabLayout.setHorizontalGroup(
            readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(readRecordsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
        readTabLayout.setVerticalGroup(
            readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(readRecordsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );

        tabGroup.addTab("Ver registros", readTab);

        manageTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        manageTab.add(manageRecordsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 760, 525));
        manageTab.add(editRecordPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 530));

        tabGroup.addTab("Administrar registros", manageTab);

        javax.swing.GroupLayout adminTabLayout = new javax.swing.GroupLayout(adminTab);
        adminTab.setLayout(adminTabLayout);
        adminTabLayout.setHorizontalGroup(
            adminTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminToolsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
        adminTabLayout.setVerticalGroup(
            adminTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminToolsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );

        tabGroup.addTab("Moderación", adminTab);

        getContentPane().add(tabGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, 560));

        header.setBackground(new java.awt.Color(102, 102, 102));
        header.setForeground(new java.awt.Color(102, 102, 102));
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
            .addGroup(btnSalirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(x, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
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
                .addContainerGap(721, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    tabGroup.remove(manageTab);
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
    private proyecto.subframes.AdminToolsPanel adminToolsPanel;
    private javax.swing.JPanel btnSalir;
    private proyecto.subframes.EditRecordPanel editRecordPanel;
    private javax.swing.JPanel header;
    private proyecto.subframes.ManageRecordsPanel manageRecordsPanel;
    private javax.swing.JPanel manageTab;
    private proyecto.subframes.ReadRecordsPanel readRecordsPanel;
    private javax.swing.JPanel readTab;
    private javax.swing.JTabbedPane tabGroup;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
