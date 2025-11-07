package Tarea1;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Tarea1.model_layer.models.Compositor;
import Tarea1.model_layer.models.CompositorService;
import org.pushingpixels.radiance.theming.api.RadianceThemingCortex;
import org.pushingpixels.radiance.theming.api.skin.ModerateSkin;
import org.pushingpixels.radiance.theming.api.skin.RadianceModerateLookAndFeel;


public class Formulario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.
            getLogger(Formulario.class.getName());
    int xMouse, yMouse;
    private final Color COLOR1 = new Color(154, 136, 216);
    private final Color COLOR2 = new Color(221,211,255);
    private Compositor compositor;
    private GridLayout gridLayout = new GridLayout(1, 1);
    
    
    public Formulario() {
        initComponents();
        setLocationRelativeTo(null);
        getCompositores();
        
        compositor = null;
        btnBorrar.setVisible(false);
        btnEditar.setVisible(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenido = new javax.swing.JPanel();
        herramientas = new javax.swing.JPanel();
        btnEditar = new javax.swing.JPanel();
        labelEditar = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JPanel();
        labelNuevo = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JPanel();
        labelBorrar = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDeObjetos = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        btnSalir = new javax.swing.JPanel();
        x = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenido.setBackground(new java.awt.Color(255, 255, 255));
        contenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        herramientas.setBackground(new java.awt.Color(255, 255, 255));
        herramientas.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        herramientas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditar.setBackground(new java.awt.Color(154, 136, 216));
        btnEditar.setPreferredSize(new java.awt.Dimension(106, 31));

        labelEditar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelEditar.setForeground(new java.awt.Color(0, 0, 0));
        labelEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEditar.setText("EDITAR");
        labelEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelEditarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnEditarLayout = new javax.swing.GroupLayout(btnEditar);
        btnEditar.setLayout(btnEditarLayout);
        btnEditarLayout.setHorizontalGroup(
            btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnEditarLayout.setVerticalGroup(
            btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        herramientas.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 190, 90, -1));

        btnNuevo.setBackground(new java.awt.Color(154, 136, 216));
        btnNuevo.setPreferredSize(new java.awt.Dimension(106, 31));

        labelNuevo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelNuevo.setForeground(new java.awt.Color(0, 0, 0));
        labelNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNuevo.setText("NUEVO");
        labelNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelNuevoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelNuevoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelNuevoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnNuevoLayout = new javax.swing.GroupLayout(btnNuevo);
        btnNuevo.setLayout(btnNuevoLayout);
        btnNuevoLayout.setHorizontalGroup(
            btnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnNuevoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnNuevoLayout.setVerticalGroup(
            btnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnNuevoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        herramientas.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 90, -1));

        btnBorrar.setBackground(new java.awt.Color(154, 136, 216));
        btnBorrar.setPreferredSize(new java.awt.Dimension(106, 31));

        labelBorrar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelBorrar.setForeground(new java.awt.Color(255, 0, 51));
        labelBorrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBorrar.setText("BORRAR");
        labelBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBorrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelBorrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelBorrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnBorrarLayout = new javax.swing.GroupLayout(btnBorrar);
        btnBorrar.setLayout(btnBorrarLayout);
        btnBorrarLayout.setHorizontalGroup(
            btnBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBorrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnBorrarLayout.setVerticalGroup(
            btnBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBorrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        herramientas.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 350, 90, -1));

        contenido.add(herramientas, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, 120, 420));

        labelTitle.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(0, 0, 0));
        labelTitle.setText("Lista de composiciones");
        contenido.add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(216, 188, 188));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(216, 188, 188));

        listaDeObjetos.setBackground(new java.awt.Color(255, 255, 255));
        listaDeObjetos.setForeground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 1, 1);
        flowLayout1.setAlignOnBaseline(true);
        listaDeObjetos.setLayout(flowLayout1);
        jScrollPane1.setViewportView(listaDeObjetos);

        contenido.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 700, 420));

        getContentPane().add(contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 880, 510));

        header.setBackground(new java.awt.Color(214, 232, 255));
        header.setForeground(new java.awt.Color(214, 232, 255));
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
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        header.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, -1, -1));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try{
            UIManager.setLookAndFeel(new RadianceModerateLookAndFeel());
            RadianceThemingCortex.GlobalScope.setSkin(new ModerateSkin());
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

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

    private void labelNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelNuevoMouseClicked
        new EditorDeCompositores(this).setVisible(true);
    }//GEN-LAST:event_labelNuevoMouseClicked

    private void labelNuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelNuevoMouseEntered
        btnNuevo.setBackground(COLOR2);
    }//GEN-LAST:event_labelNuevoMouseEntered

    private void labelNuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelNuevoMouseExited
        btnNuevo.setBackground(COLOR1);
    }//GEN-LAST:event_labelNuevoMouseExited

    private void labelEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEditarMouseClicked
        new EditorDeCompositores(this, compositor).setVisible(true);
    }//GEN-LAST:event_labelEditarMouseClicked

    private void labelEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEditarMouseEntered
        btnEditar.setBackground(COLOR2);
    }//GEN-LAST:event_labelEditarMouseEntered

    private void labelEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEditarMouseExited
        btnEditar.setBackground(COLOR1);
    }//GEN-LAST:event_labelEditarMouseExited

    private void labelBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBorrarMouseClicked
        if ((JOptionPane.showConfirmDialog(
                null,
                "¿Quieres borrarlor?",
                "Advertencia",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE)
        ) == 0) {
            try {
                CompositorService.delete(compositor.getId_compositor());
                updatePanel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_labelBorrarMouseClicked

    private void labelBorrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBorrarMouseEntered
        btnBorrar.setBackground(COLOR2);
    }//GEN-LAST:event_labelBorrarMouseEntered

    private void labelBorrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBorrarMouseExited
        btnBorrar.setBackground(COLOR1);
    }//GEN-LAST:event_labelBorrarMouseExited

    public void setCompositor(Compositor compositor) {
        this.compositor = compositor;
        btnBorrar.setVisible(true);
        btnEditar.setVisible(true);
    }

    private void getCompositores() {
        try {
            ArrayList<Compositor> compositores = CompositorService.readAll();
            listaDeObjetos.removeAll();
            gridLayout.setRows(compositores.size());

            for (Compositor compositor : compositores ) {
                ItemCompositor ic = new ItemCompositor(this, compositor);
                listaDeObjetos.add(ic);
            }

            listaDeObjetos.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updatePanel(){
        getCompositores();
        compositor = null;
        btnBorrar.setVisible(false);
        btnEditar.setVisible(false);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Formulario().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnBorrar;
    private javax.swing.JPanel btnEditar;
    private javax.swing.JPanel btnNuevo;
    private javax.swing.JPanel btnSalir;
    private javax.swing.JPanel contenido;
    private javax.swing.JPanel header;
    private javax.swing.JPanel herramientas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBorrar;
    private javax.swing.JLabel labelEditar;
    private javax.swing.JLabel labelNuevo;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel listaDeObjetos;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
