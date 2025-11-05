/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyecto.subframes;

import proyecto.HomePanel;
import proyecto.models.Request;
import proyecto.services.RequestServices;
import proyecto.subframes.panes.AdminRecordPane;

import java.awt.*;
import java.util.ArrayList;

public class AdminPanel extends javax.swing.JPanel {

    private HomePanel homePanel;
    private GridLayout gridLayout = new GridLayout(1,1);
    private ArrayList<Request> requests;

    public AdminPanel() {
        initComponents();
    }

    public AdminPanel(HomePanel homePanel) {
        initComponents();

        this.homePanel = homePanel;

        panelRequestList.setLayout(gridLayout);
        requests = RequestServices.getRequests();

        showRequests();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelRequestList = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(216, 188, 188));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(216, 188, 188));

        panelRequestList.setBackground(new java.awt.Color(255, 255, 255));
        panelRequestList.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(panelRequestList);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 770, 420));

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
            AdminRecordPane arp = new AdminRecordPane(this, request);
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
    private javax.swing.JPanel panelRequestList;
    // End of variables declaration//GEN-END:variables
}
