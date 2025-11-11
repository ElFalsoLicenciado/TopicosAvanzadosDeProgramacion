package proyecto;

import proyecto.models.Record;
import proyecto.models.Request;
import proyecto.models.Session;
import proyecto.models.User;
import proyecto.subframes.*;

import java.awt.*;

public class HomeFrame extends javax.swing.JFrame {

    int xMouse, yMouse;
    private LogInFrame logInPanel;
    private Session session;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.
            getLogger(HomeFrame.class.getName());

    public HomeFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public HomeFrame(LogInFrame logInPanel, Session session) {
        this.logInPanel = logInPanel;
        this.session = session;
        initComponents();
        setLocationRelativeTo(null);
        hideRecordApprover();
        hideRecordEditor();
        hideRecordReader();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabGroup = new javax.swing.JTabbedPane();
        readTab = new javax.swing.JPanel();
        selectRecordPane = new proyecto.subframes.RecordSelectorSubFrame(this)
        ;
        readRecordPane = new proyecto.subframes.RecordReaderSubFrame();
        recordTab = new javax.swing.JPanel();
        recordGroup = new javax.swing.JTabbedPane();
        recordPanel = new javax.swing.JPanel();
        manageRecordsPane = new proyecto.subframes.RecordManagerSubFrame(this, session.getUserRecords());
        editRecordPane = new proyecto.subframes.RecordEditorSubFrame();
        requestPanel = new javax.swing.JPanel();
        userRequestsPane = new proyecto.subframes.UserRequestsSubFrame(session.getUserRequests());
        adminTab = new javax.swing.JPanel();
        adminGroup = new javax.swing.JTabbedPane();
        approvalPanel = new javax.swing.JPanel();
        adminToolsPane = new proyecto.subframes.AdminApprovalSubFrame(this);
        approveRecordPane = new proyecto.subframes.RecordApproverSubFrame();
        resumePanel = new javax.swing.JPanel();
        adminResumePane = new proyecto.subframes.AdminResumeSubFrame();
        header = new javax.swing.JPanel();
        btnSalir = new javax.swing.JPanel();
        x = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(214, 232, 255));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(804, 625));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabGroup.setBackground(new java.awt.Color(255, 255, 255));
        tabGroup.setForeground(new java.awt.Color(0, 0, 0));
        tabGroup.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

        readTab.setBackground(new java.awt.Color(255, 255, 255));
        readTab.setForeground(new java.awt.Color(255, 255, 255));
        readTab.setPreferredSize(new java.awt.Dimension(870, 500));
        readTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        readTab.add(selectRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));
        readTab.add(readRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        tabGroup.addTab("Ver registros", readTab);

        recordTab.setBackground(new java.awt.Color(255, 255, 255));
        recordTab.setForeground(new java.awt.Color(255, 255, 255));
        recordTab.setPreferredSize(new java.awt.Dimension(860, 550));
        recordTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recordGroup.setBackground(new java.awt.Color(255, 255, 255));
        recordGroup.setForeground(new java.awt.Color(0, 0, 0));
        recordGroup.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

        recordPanel.setBackground(new java.awt.Color(255, 255, 255));
        recordPanel.setForeground(new java.awt.Color(255, 255, 255));
        recordPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        recordPanel.add(manageRecordsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 510));

        editRecordPane.setForeground(new java.awt.Color(255, 255, 255));
        recordPanel.add(editRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 510));

        recordGroup.addTab("Registros", recordPanel);

        requestPanel.setBackground(new java.awt.Color(255, 255, 255));
        requestPanel.setForeground(new java.awt.Color(255, 255, 255));
        requestPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        requestPanel.add(userRequestsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 510));

        recordGroup.addTab("Aprobaciones", requestPanel);

        recordTab.add(recordGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        tabGroup.addTab("Pestaña de creador", recordTab);

        adminTab.setBackground(new java.awt.Color(255, 255, 255));
        adminTab.setForeground(new java.awt.Color(255, 255, 255));
        adminTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminGroup.setBackground(new java.awt.Color(255, 255, 255));
        adminGroup.setForeground(new java.awt.Color(0, 0, 0));
        adminGroup.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

        approvalPanel.setBackground(new java.awt.Color(255, 255, 255));
        approvalPanel.setForeground(new java.awt.Color(255, 255, 255));
        approvalPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        approvalPanel.add(adminToolsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 520));
        approvalPanel.add(approveRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 520));

        adminGroup.addTab("Aprobaciones", approvalPanel);

        resumePanel.setBackground(new java.awt.Color(255, 255, 255));
        resumePanel.setForeground(new java.awt.Color(255, 255, 255));
        resumePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        resumePanel.add(adminResumePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 520));

        adminGroup.addTab("Resumen", resumePanel);

        adminTab.add(adminGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        tabGroup.addTab("Moderación", adminTab);

        getContentPane().add(tabGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 800, 590));

        header.setBackground(new java.awt.Color(214, 232, 255));
        header.setForeground(new java.awt.Color(216, 188, 188));
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

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 761, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
        );

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 80));

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
        btnSalir.setBackground(new Color(214,232,255));
        x.setForeground(Color.black);
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

    public void startLecture(Record record){
        readRecordPane = new RecordReaderSubFrame(this, record);

        readTab.removeAll();
        readTab.add(readRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        showRecordReader();
        readTab.revalidate();
        readTab.repaint();
    }

    public void endLecture(){
        selectRecordPane = new RecordSelectorSubFrame(this);

        readTab.removeAll();
        readTab.add(selectRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        hideRecordReader();
        readTab.revalidate();
        readTab.repaint();
    }

    public void createRecord(){
        editRecordPane = new RecordEditorSubFrame(this, session);

        recordPanel.removeAll();
        recordPanel.add(editRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));

        showRecordEditor();

        recordPanel.revalidate();
        recordPanel.repaint();
    }

    public void editRecord(Record record){
        editRecordPane = new RecordEditorSubFrame(this, session, record);

        recordPanel.removeAll();
        recordPanel.add(editRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        showRecordEditor();
        recordPanel.revalidate();
        recordPanel.repaint();
    }

    public void inspectRequest(Request request){
        approveRecordPane = new RecordApproverSubFrame(this, request);

        approvalPanel.removeAll();
        approvalPanel.add(approveRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        showRecordApprover();
        approvalPanel.revalidate();
        approvalPanel.repaint();

    }

    public void endEditing(){
        manageRecordsPane = new RecordManagerSubFrame(this, session.getUserRecords());
        editRecordPane = new RecordEditorSubFrame();

        recordPanel.removeAll();
        recordPanel.add(editRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        recordPanel.add(manageRecordsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        hideRecordEditor();
        recordPanel.revalidate();
        recordPanel.repaint();

        userRequestsPane = new UserRequestsSubFrame(session.getUserRequests());

        requestPanel.removeAll();
        requestPanel.add(userRequestsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        requestPanel.revalidate();
        requestPanel.repaint();

        selectRecordPane = new RecordSelectorSubFrame(this);
        readRecordPane = new RecordReaderSubFrame();

        readTab.removeAll();
        readTab.add(selectRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        readTab.add(readRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        hideRecordReader();
        readTab.revalidate();
        readTab.repaint();

        adminToolsPane = new AdminApprovalSubFrame(this);
        approveRecordPane = new RecordApproverSubFrame();

        approvalPanel.removeAll();
        approvalPanel.add(adminToolsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        approvalPanel.add(approveRecordPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));
        hideRecordApprover();
        approvalPanel.revalidate();
        approvalPanel.repaint();
    }

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new HomeFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane adminGroup;
    private proyecto.subframes.AdminResumeSubFrame adminResumePane;
    private javax.swing.JPanel adminTab;
    private proyecto.subframes.AdminApprovalSubFrame adminToolsPane;
    private javax.swing.JPanel approvalPanel;
    private proyecto.subframes.RecordApproverSubFrame approveRecordPane;
    private javax.swing.JPanel btnSalir;
    private proyecto.subframes.RecordEditorSubFrame editRecordPane;
    private javax.swing.JPanel header;
    private proyecto.subframes.RecordManagerSubFrame manageRecordsPane;
    private proyecto.subframes.RecordReaderSubFrame readRecordPane;
    private javax.swing.JPanel readTab;
    private javax.swing.JTabbedPane recordGroup;
    private javax.swing.JPanel recordPanel;
    private javax.swing.JPanel recordTab;
    private javax.swing.JPanel requestPanel;
    private javax.swing.JPanel resumePanel;
    private proyecto.subframes.RecordSelectorSubFrame selectRecordPane;
    private javax.swing.JTabbedPane tabGroup;
    private proyecto.subframes.UserRequestsSubFrame userRequestsPane;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
