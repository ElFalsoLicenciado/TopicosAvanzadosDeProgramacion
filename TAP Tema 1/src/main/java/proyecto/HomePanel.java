package proyecto;

import proyecto.models.Record;
import proyecto.models.Session;
import proyecto.models.User;
import proyecto.subframes.RecordEditorPanel;
import proyecto.subframes.RecordManagerPanel;
import proyecto.subframes.RecordReaderPanel;
import proyecto.subframes.RecordSelectorPanel;

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
    }

    public HomePanel(LogInPanel logInPanel, Session session) {
        this.logInPanel = logInPanel;
        this.session = session;
        initComponents();
        setLocationRelativeTo(null);
        readRecordPane.setVisible(false);
        editRecordPane.setVisible(false);
        approveRecordPane.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabGroup = new javax.swing.JTabbedPane();
        readTab = new javax.swing.JPanel();
        readRecordPane = new proyecto.subframes.RecordReaderPanel();
        selectRecordPane = new proyecto.subframes.RecordSelectorPanel(this)
        ;
        recordTab = new javax.swing.JPanel();
        recordGroup = new javax.swing.JTabbedPane();
        recordPanel = new javax.swing.JPanel();
        manageRecordsPane = new proyecto.subframes.RecordManagerPanel(this, session.getUserRecords());
        editRecordPane = new proyecto.subframes.RecordEditorPanel();
        requestPanel = new javax.swing.JPanel();
        userRequestsPanel1 = new proyecto.subframes.UserRequestsPanel();
        adminTab = new javax.swing.JPanel();
        approveRecordPane = new proyecto.subframes.RecordApproverPanel();
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

        readRecordPane.setBackground(new java.awt.Color(216, 188, 188));
        readTab.add(readRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 590));
        readTab.add(selectRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 590));

        tabGroup.addTab("Ver registros", readTab);

        recordTab.setBackground(new java.awt.Color(216, 188, 188));
        recordTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recordGroup.setBackground(new java.awt.Color(216, 188, 188));
        recordGroup.setForeground(new java.awt.Color(114, 114, 114));
        recordGroup.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

        recordPanel.setBackground(new java.awt.Color(216, 188, 188));
        recordPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        recordPanel.add(manageRecordsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 550));
        recordPanel.add(editRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));

        recordGroup.addTab("Registros", recordPanel);

        requestPanel.setBackground(new java.awt.Color(216, 188, 188));
        requestPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        requestPanel.add(userRequestsPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));

        recordGroup.addTab("Aprobaciones", requestPanel);

        recordTab.add(recordGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 570));

        tabGroup.addTab("Pestaña de creador", recordTab);

        adminTab.setBackground(new java.awt.Color(216, 188, 188));
        adminTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        adminTab.add(approveRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, -1));
        adminTab.add(adminToolsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

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
                case ADMIN -> recordGroup.remove(requestPanel);
            }
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    public void hideRecordReader(){
        readRecordPane.setVisible(false);
        selectRecordPane.setVisible(true);
    }


    public void hideRecordEditor(){
        editRecordPane.setVisible(false);
        manageRecordsPane.setVisible(true);
    }
    
    public void hideRecordApprover(){
        approveRecordPane.setVisible(false);
        adminToolsPane.setVisible(true);
    }

    public void showRecordReader(){
        readRecordPane.setVisible(true);
        selectRecordPane.setVisible(false);
    }

    public void showRecordEditor(){
        editRecordPane.setVisible(true);
        manageRecordsPane.setVisible(false);
    }

    public void showRecordApprover(){
        approveRecordPane.setVisible(true);
        adminToolsPane.setVisible(false);
    }

    public void createRecord(){
        editRecordPane = new RecordEditorPanel(this, session);

        recordPanel.removeAll();
        recordPanel.add(editRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));

        showRecordEditor();

        recordPanel.revalidate();
        recordPanel.repaint();
    }

    public void editRecord(Record record){
        editRecordPane = new RecordEditorPanel(this, session, record);

        recordPanel.removeAll();
        recordPanel.add(editRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        showRecordEditor();
        recordPanel.revalidate();
        recordPanel.repaint();
    }

    public void endEditing(){
        manageRecordsPane = new RecordManagerPanel(this, session.getUserRecords());
        editRecordPane = new RecordEditorPanel(this, session);

        recordPanel.removeAll();
        recordPanel.add(editRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        recordPanel.add(manageRecordsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        hideRecordEditor();
        recordPanel.revalidate();
        recordPanel.repaint();

        selectRecordPane = new RecordSelectorPanel(this);
        readRecordPane = new RecordReaderPanel();

        readTab.removeAll();
        readTab.add(selectRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        readTab.add(readRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        hideRecordReader();
        readTab.revalidate();
        readTab.repaint();
    }

    public void startLecture(Record record){
        readRecordPane = new RecordReaderPanel(this, record);

        readTab.removeAll();
        readTab.add(readRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        showRecordReader();
        readTab.revalidate();
        readTab.repaint();
    }

    public void endLecture(){
        selectRecordPane = new RecordSelectorPanel(this);

        readTab.removeAll();
        readTab.add(selectRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        hideRecordReader();
        readTab.revalidate();
        readTab.repaint();
    }



    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new HomePanel().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adminTab;
    private proyecto.subframes.AdminPanel adminToolsPane;
    private proyecto.subframes.RecordApproverPanel approveRecordPane;
    private javax.swing.JPanel btnSalir;
    private proyecto.subframes.RecordEditorPanel editRecordPane;
    private javax.swing.JPanel header;
    private proyecto.subframes.RecordManagerPanel manageRecordsPane;
    private proyecto.subframes.RecordReaderPanel readRecordPane;
    private javax.swing.JPanel readTab;
    private javax.swing.JTabbedPane recordGroup;
    private javax.swing.JPanel recordPanel;
    private javax.swing.JPanel recordTab;
    private javax.swing.JPanel requestPanel;
    private proyecto.subframes.RecordSelectorPanel selectRecordPane;
    private javax.swing.JTabbedPane tabGroup;
    private proyecto.subframes.UserRequestsPanel userRequestsPanel1;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
