package proyecto.subframes;

import proyecto.HomeFrame;
import proyecto.models.Request;
import proyecto.services.RequestServices;
import proyecto.subframes.panels.AdminRecordPanel;

import java.awt.*;
import java.util.ArrayList;

public class AdminApprovalSubFrame extends javax.swing.JPanel {

    private HomeFrame homePanel;
    private GridLayout gridLayout = new GridLayout(1,1);
    private ArrayList<Request> requests;

    public AdminApprovalSubFrame() {
        initComponents();
    }

    public AdminApprovalSubFrame(HomeFrame homePanel) {
        initComponents();

        this.homePanel = homePanel;

        panelRequestList.setLayout(gridLayout);
        requests = RequestServices.getRequests();
        
        if(requests.isEmpty()) {
            labelTitle1.setVisible(true);
            return;
        }
        
        showRequests();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelRequestList = new javax.swing.JPanel();
        labelTitle1 = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(216, 188, 188));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(216, 188, 188));

        panelRequestList.setBackground(new java.awt.Color(255, 255, 255));
        panelRequestList.setForeground(new java.awt.Color(255, 255, 255));

        labelTitle1.setBackground(new java.awt.Color(255, 255, 255));
        labelTitle1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelTitle1.setForeground(new java.awt.Color(0, 0, 0));
        labelTitle1.setText("NO SE HA CREADO NINGUNA APROBACIÓN.");
        panelRequestList.add(labelTitle1);

        jScrollPane1.setViewportView(panelRequestList);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 770, 380));

        labelTitle.setBackground(new java.awt.Color(255, 255, 255));
        labelTitle.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(0, 0, 0));
        labelTitle.setText("Registros a aprobar:");
        add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    private void showRequests() {
        panelRequestList.removeAll();
        gridLayout.setRows(requests.size());

        for (Request request : requests) {
            AdminRecordPanel arp = new AdminRecordPanel(this, request);
            panelRequestList.add(arp);
        }

        panelRequestList.updateUI();
    }

    public void inspectRequest(Request request) {
        homePanel.inspectRequest(request);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelTitle1;
    private javax.swing.JPanel panelRequestList;
    // End of variables declaration//GEN-END:variables
}
