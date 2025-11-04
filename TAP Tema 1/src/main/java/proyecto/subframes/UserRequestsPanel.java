/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyecto.subframes;


import proyecto.HomePanel;
import proyecto.models.Record;
import proyecto.models.Request;
import proyecto.services.RequestServices;
import proyecto.subframes.panes.ApprobationLogPane;
import proyecto.subframes.panes.ManageRecordPane;

import java.awt.*;
import java.util.ArrayList;

public class UserRequestsPanel extends javax.swing.JPanel {

    private GridLayout gridLayout = new GridLayout(1,1);;
    private ArrayList<Request> userRequests;

    public UserRequestsPanel() {
        initComponents();
    }

    public UserRequestsPanel(ArrayList<Request> userRequests) {
        initComponents();

        panelRequestList.setLayout(gridLayout);
        this.userRequests = userRequests;

        showUserRequests();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelRequestList = new javax.swing.JPanel();

        setBackground(new java.awt.Color(216, 188, 188));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitle.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(114, 114, 114));
        labelTitle.setText("User Requests Panel");
        add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(216, 188, 188));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(216, 188, 188));

        panelRequestList.setBackground(new java.awt.Color(216, 188, 188));
        panelRequestList.setForeground(new java.awt.Color(216, 188, 188));
        jScrollPane1.setViewportView(panelRequestList);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 380));
    }// </editor-fold>//GEN-END:initComponents

    private void showUserRequests(){
        panelRequestList.removeAll();
        gridLayout.setRows(userRequests.size());

        for (Request request : userRequests){
            ApprobationLogPane alp = new ApprobationLogPane(this, request);
            panelRequestList.add(alp);
        }

        panelRequestList.updateUI();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel panelRequestList;
    // End of variables declaration//GEN-END:variables
}
