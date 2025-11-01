/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tarea1;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class ComputadoraPanel extends javax.swing.JPanel {
    private final Random selAleatorio = new Random();
    private final String IMG_PATH = "src/main/java/tarea1/images/";
    private final String black = IMG_PATH + "black.png";
    private final String[] imagenes =
    {
        IMG_PATH + "Capitan.png",   //0
        IMG_PATH + "br.jpg",        //1
        IMG_PATH + "dulan.png",     //2
        IMG_PATH + "fgeed.jpg",     //3
        IMG_PATH + "hd.jpg",        //4
        IMG_PATH + "horne.png",     //5
        IMG_PATH + "shrimp.jpg",    //6
        IMG_PATH + "troll.gif",     //7
        IMG_PATH + "weed.jpg",      //8
        IMG_PATH + "michael.jpg",   //9
        IMG_PATH + "roy.png",       //10
        IMG_PATH + "damn.png",      //11
        IMG_PATH + "jimbo.jpg",     //12
        IMG_PATH + "chadsigma.png", //13
        IMG_PATH + "mew.png",       //14
        IMG_PATH + "fgeed2.jpg"     //15
        
    };

    private String img;
    private int secs, mins;
    float cobro;
    private int tipo;
    private boolean run;

    
    CiberFrame frame;
    
    Hilo tipoThread;
    SwingW tipoSwingWorker;
    Runn tipoRunnable;
    Timer tipoTimerTask;

    
    public ComputadoraPanel() {
        initComponents();
        int secs = 0;
        int mins = 0;
    }
    
    public ComputadoraPanel(CiberFrame frame,int tipo) {
        initComponents();
        this.tipo = tipo;
        this.frame = frame;
        secs = 0;
        mins = 0;
        run = false;

        imageSelector();   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monitorImage = new org.edisoncor.gui.panel.PanelImage();
        desktop = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        labelTiempo = new javax.swing.JLabel();
        btnSesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelCuota = new javax.swing.JLabel();

        monitorImage.setIcon(new javax.swing.ImageIcon(IMG_PATH + "pc.png"));

        desktop.setIcon(new javax.swing.ImageIcon(black));
        desktop.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout monitorImageLayout = new javax.swing.GroupLayout(monitorImage);
        monitorImage.setLayout(monitorImageLayout);
        monitorImageLayout.setHorizontalGroup(
            monitorImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monitorImageLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        monitorImageLayout.setVerticalGroup(
            monitorImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monitorImageLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Tiempo");

        labelTiempo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelTiempo.setText("--:--");

        btnSesion.setText("Iniciar");
        btnSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSesionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Cuota");

        labelCuota.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelCuota.setText("$--.--");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCuota)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSesion)
                            .addGap(208, 208, 208))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(monitorImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(82, 82, 82)))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(labelTiempo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTiempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(monitorImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSesion)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCuota)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSesionActionPerformed
        if (! run){
            run = true;
            btnSesion.setText("Cobrar");
            switch (tipo) {
                case 0 -> {
                    tipoThread = new Hilo();
                    tipoThread.start();
                }
                case 1 -> {
                    tipoSwingWorker = new SwingW();
                    tipoSwingWorker.execute();
                }
                case 2 -> {
                    tipoRunnable = new Runn();
                    Thread thread = new Thread(tipoRunnable);
                    thread.start();
                }
                case 3 -> {
                    tipoTimerTask = new Timer();
                    tipoTimerTask.start();
                }
                default -> System.out.println("xd");
            }
        } else {

            switch (tipo) {
                case 0 -> {
                    tipoThread = new Hilo();
                }
                case 1 -> {
                    tipoSwingWorker.cancel(true);
                }
                case 2 -> {
                    tipoRunnable = new Runn();
                }
                case 3 -> {
                    tipoTimerTask.stop();
                }
                default -> System.out.println("xd");
            }

            run = false;
            btnSesion.setText("Iniciar");
            
            try
            {
                File file = new File("C:\\Users\\User\\Documents\\Programming\\JetBrains\\IntelliJ Projects\\Topicos Avanzados de Programacion\\TAP Tema 1\\src\\main\\java\\Practica4\\extras\\money.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(
                    null,
                    String.format("Cobro por sesion: \n$%1$,.2f", cobro),
                    "Sesion terminada",
                    JOptionPane.INFORMATION_MESSAGE
            );
            frame.updateTotal(cobro);

            labelTiempo.setText("--:--");
            labelCuota.setText("$--.--");
            cobro = 0;
            mins = 0;
            secs = 0;

            desktop.setIcon(new javax.swing.ImageIcon(black));
            desktop.updateUI();
        }


    }//GEN-LAST:event_btnSesionActionPerformed


    private void imageSelector(){
        if( (secs == 0 ||(secs % 5)==0) && run){
            img =  imagenes[selAleatorio.nextInt(imagenes.length-1)];

            desktop.setIcon(new javax.swing.ImageIcon(img));
            desktop.updateUI();

            System.out.println(img);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSesion;
    private org.edisoncor.gui.panel.PanelImage desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelCuota;
    private javax.swing.JLabel labelTiempo;
    private org.edisoncor.gui.panel.PanelImage monitorImage;
    // End of variables declaration//GEN-END:variables

    
    
    
    
    class Hilo extends Thread {

        @Override
        public void run() {
            while (run) {
                try {
                    updateTimeAndQuota();
                    Thread.sleep(250);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    class SwingW extends SwingWorker{

        @Override
        protected Object doInBackground() throws Exception {
            while(run) {
                imageSelector();
                publish("");
                Thread.sleep(250);
                secs++;
                cobro = (float) ((mins*6) + (secs * 0.1));
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
            labelCuota.setText(String.format("$%1$,.2f", cobro));
        }
        
        
    }

    class Runn implements Runnable {
        @Override
        public void run() {
            while (run) {
                try {
                    updateTimeAndQuota();
                    Thread.sleep(250);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Timer {

        private java.util.Timer timer;

        public void start() {
            timer = new java.util.Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    updateTimeAndQuota();
                    }
            }, 0, 250);
        }

        public void stop() {
            if (timer != null) timer.cancel();
        }
    }

    private void updateTimeAndQuota(){
        imageSelector();
        secs++;
        cobro = (float) ((mins*6) + (secs * 0.1));
        if (secs == 60) {
            secs = 0;
            mins++;
        }
        labelTiempo.setText(String.format("%02d:%02d",mins,secs));
        labelCuota.setText(String.format("$%1$,.2f", cobro));

    }

}
