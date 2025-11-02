package proyecto;

import java.awt.Color;
import org.pushingpixels.radiance.theming.api.RadianceThemingCortex;
import org.pushingpixels.radiance.theming.api.skin.*;
import proyecto.enums.UserType;
import proyecto.enums.StateNames;
import proyecto.models.Session;
import proyecto.services.UserServices;
import proyecto.utils.DialogHelper;
import proyecto.utils.SecurityTools;

public class LogInPanel extends javax.swing.JFrame {

    int xMouse, yMouse;
    boolean logIn = true;
    private Session currentSession;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.
            getLogger(LogInPanel.class.getName());

    public LogInPanel() {
        currentSession = new Session();
        initComponents();
        setLocationRelativeTo(null);

        choiceUser.setVisible(false);
        choiceAdmin.setVisible(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioUserType = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        labelSubtitle = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();
        labelCredential1 = new javax.swing.JLabel();
        fieldUsername = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        labelCredential2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        fieldPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JPanel();
        labelLogIn = new javax.swing.JLabel();
        btnGuest = new javax.swing.JPanel();
        labelGuest = new javax.swing.JLabel();
        btnSalir = new javax.swing.JPanel();
        x = new javax.swing.JLabel();
        labelLogInSetts = new javax.swing.JLabel();
        choiceUser = new javax.swing.JRadioButton();
        choiceAdmin = new javax.swing.JRadioButton();
        header = new javax.swing.JPanel();
        imgPanel = new org.edisoncor.gui.panel.PanelImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        bg.setBackground(new java.awt.Color(204, 204, 204));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginPanel.setBackground(new java.awt.Color(102, 102, 102));

        labelSubtitle.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        labelSubtitle.setForeground(new java.awt.Color(209, 197, 197));
        labelSubtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtitle.setText("INICIAR SESIÓN");

        labelTitle.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(209, 197, 197));
        labelTitle.setText("CONOCE A MÉXICO");

        labelCredential1.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        labelCredential1.setForeground(new java.awt.Color(209, 197, 197));
        labelCredential1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCredential1.setText("Usuario");

        fieldUsername.setBackground(new java.awt.Color(255, 255, 255));
        fieldUsername.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        fieldUsername.setForeground(new java.awt.Color(235, 233, 233));
        fieldUsername.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldUsername.setText("Ingresa tu usuario");
        fieldUsername.setBorder(null);
        fieldUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fieldUsernameMousePressed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        labelCredential2.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        labelCredential2.setForeground(new java.awt.Color(209, 197, 197));
        labelCredential2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCredential2.setText("Contraseña");

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        fieldPassword.setBackground(new java.awt.Color(255, 255, 255));
        fieldPassword.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        fieldPassword.setForeground(new java.awt.Color(235, 233, 233));
        fieldPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldPassword.setText("******");
        fieldPassword.setBorder(null);
        fieldPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fieldPasswordMousePressed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(96, 243, 96));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelLogIn.setBackground(new java.awt.Color(51, 51, 51));
        labelLogIn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelLogIn.setForeground(new java.awt.Color(255, 255, 255));
        labelLogIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogIn.setText("ENTRAR");
        labelLogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLogInMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelLogInMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelLogInMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnLoginLayout = new javax.swing.GroupLayout(btnLogin);
        btnLogin.setLayout(btnLoginLayout);
        btnLoginLayout.setHorizontalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelLogIn, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );
        btnLoginLayout.setVerticalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelLogIn, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        btnGuest.setBackground(new java.awt.Color(96, 243, 96));
        btnGuest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelGuest.setBackground(new java.awt.Color(51, 51, 51));
        labelGuest.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelGuest.setForeground(new java.awt.Color(255, 255, 255));
        labelGuest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGuest.setText("INVITADO");
        labelGuest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelGuestMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelGuestMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelGuestMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnGuestLayout = new javax.swing.GroupLayout(btnGuest);
        btnGuest.setLayout(btnGuestLayout);
        btnGuestLayout.setHorizontalGroup(
            btnGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelGuest, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
        );
        btnGuestLayout.setVerticalGroup(
            btnGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelGuest, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSalirLayout.createSequentialGroup()
                .addComponent(x, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnSalirLayout.setVerticalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(x, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        labelLogInSetts.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        labelLogInSetts.setText("¿Aún no tienes cuenta?");
        labelLogInSetts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLogInSetts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLogInSettsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelLogInSettsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelLogInSettsMouseExited(evt);
            }
        });

        radioUserType.add(choiceUser);
        choiceUser.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choiceUser.setText("Usuario");
        choiceUser.setBorder(null);
        choiceUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        radioUserType.add(choiceAdmin);
        choiceAdmin.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        choiceAdmin.setText("Administrador");
        choiceAdmin.setBorder(null);
        choiceAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCredential2)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCredential1)
                            .addComponent(labelSubtitle)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(choiceUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(choiceAdmin))
                            .addComponent(labelLogInSetts)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(labelTitle)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(labelTitle))
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(labelSubtitle)
                .addGap(27, 27, 27)
                .addComponent(labelCredential1)
                .addGap(18, 18, 18)
                .addComponent(fieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelCredential2)
                .addGap(18, 18, 18)
                .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addComponent(choiceUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelLogInSetts))
                    .addComponent(choiceAdmin))
                .addGap(20, 20, 20))
        );

        bg.add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 300, 460));

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

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 70));

        imgPanel.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\Programming\\JetBrains\\IntelliJ Projects\\Topicos Avanzados de Programacion\\TAP Tema 1\\src\\main\\java\\proyecto\\resources\\login.png")); // NOI18N

        javax.swing.GroupLayout imgPanelLayout = new javax.swing.GroupLayout(imgPanel);
        imgPanel.setLayout(imgPanelLayout);
        imgPanelLayout.setHorizontalGroup(
            imgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        imgPanelLayout.setVerticalGroup(
            imgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        bg.add(imgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try{
            RadianceThemingCortex.GlobalScope.setSkin(new GraphiteGoldSkin());
        }catch(Exception e){
            e.printStackTrace();
        }

    }//GEN-LAST:event_formWindowOpened

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();

    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

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

    private void fieldUsernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldUsernameMousePressed
        if (fieldUsername.getText().equals("Ingresa tu usuario")){
            fieldUsername.setText("");
            fieldUsername.setForeground(Color.white);
        }
        if (String.valueOf(fieldPassword.getPassword()).isEmpty()){
            fieldPassword.setText("******");
            fieldPassword.setForeground(new Color(235,233,233));
        }
    }//GEN-LAST:event_fieldUsernameMousePressed

    private void fieldPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldPasswordMousePressed
        if (String.valueOf(fieldPassword.getPassword()).equals("******")){
            fieldPassword.setText("");
            fieldPassword.setForeground(Color.white);
        }
        if (fieldUsername.getText().isEmpty()){
            fieldUsername.setText("Ingresa tu usuario");
            fieldUsername.setForeground(new Color(235,233,233));
        }
    }//GEN-LAST:event_fieldPasswordMousePressed

    private void labelLogInSettsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLogInSettsMouseEntered
        labelLogInSetts.setForeground(new Color(0, 61, 255));
    }//GEN-LAST:event_labelLogInSettsMouseEntered

    private void labelLogInSettsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLogInSettsMouseExited
        labelLogInSetts.setForeground(new Color(235,233,233));
    }//GEN-LAST:event_labelLogInSettsMouseExited

    private void labelLogInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLogInMouseClicked
        if (fieldUsername.getText().equals("Ingresa tu usuario") ||
                String.valueOf(fieldPassword.getPassword()).equals("******") ||
                fieldUsername.getText().isEmpty() ||
                String.valueOf(fieldPassword.getPassword()).isEmpty()
        ){
            DialogHelper.errorMessageDialog(
                    "No dejes ningún campo vacío.",
                    "Campo vacío.");
            return;
        }


        if (logIn) {
            if(UserServices.numberOfUsers() == 0) {
                DialogHelper.errorMessageDialog(
                        "No hay ningún usuario registrado aún",
                        "Sin usuarios registrados."
                );
                clearFields();
                return;
            }
            String password = String.valueOf(fieldPassword.getPassword());
            password = SecurityTools.hashString(password);

            if(Session.logIn(
                    fieldUsername.getText(),
                    password)
            ) {
                hideElements();
                new HomePanel(this, currentSession).setVisible(true);
                return;
            }
            return;
        }

        UserType type = null;
        if (choiceUser.isSelected()){
            type = UserType.USER;
        } if (choiceAdmin.isSelected()){
            type = UserType.ADMIN;
        }

        if (type == null) {
            DialogHelper.errorMessageDialog(
                    "Por favor, selecciona un rol.",
                    "Rol no seleccionado."
            );
            return;
        }
        String password = String.valueOf(fieldPassword.getPassword());
        password = SecurityTools.hashString(password);

        if (Session.signUp(
                type,
                fieldUsername.getText(),
                password)
        ) {
            hideElements();
            new HomePanel(this, currentSession).setVisible(true);
        }
    }//GEN-LAST:event_labelLogInMouseClicked

    private void labelGuestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelGuestMouseClicked
        logIn = true;
        hideElements();
        Session.guestMode();
        new HomePanel(this, currentSession).setVisible(true);
    }//GEN-LAST:event_labelGuestMouseClicked

    private void labelLogInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLogInMouseEntered
        btnLogin.setBackground(new Color(146,246,146));
    }//GEN-LAST:event_labelLogInMouseEntered

    private void labelLogInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLogInMouseExited
        btnLogin.setBackground(new Color(96,243,96));
    }//GEN-LAST:event_labelLogInMouseExited

    private void labelGuestMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelGuestMouseEntered
        btnLogin.setBackground(new Color(146,246,146));
    }//GEN-LAST:event_labelGuestMouseEntered

    private void labelGuestMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelGuestMouseExited
        btnLogin.setBackground(new Color(96,243,96));
    }//GEN-LAST:event_labelGuestMouseExited

    private void labelLogInSettsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLogInSettsMouseClicked
        if(logIn){
            labelSubtitle.setText("CREAR CUENTA");
            labelLogIn.setText("CREAR");
            labelLogInSetts.setText("¿Ya tienes cuenta?");
            choiceAdmin.setVisible(true);
            choiceUser.setVisible(true);
            logIn = false;
        }else{
            labelSubtitle.setText("INICIAR SESIÓN");
            labelLogIn.setText("ENTRAR");
            labelLogInSetts.setText("¿Aún no tienes cuenta?");
            choiceUser.setVisible(false);
            choiceAdmin.setVisible(false);
            logIn = true;
        }
    }//GEN-LAST:event_labelLogInSettsMouseClicked

    private void hideElements(){
        labelSubtitle.setText("INICIAR SESIÓN");
        labelLogIn.setText("ENTRAR");
        labelLogInSetts.setText("¿Aún no tienes cuenta?");
        choiceUser.setVisible(false);
        choiceAdmin.setVisible(false);
        logIn = true;
        clearFields();
        this.setVisible(false);
    }

    private void clearFields(){
        fieldPassword.setText("******");
        fieldPassword.setForeground(new Color(235,233,233));
        fieldUsername.setText("Ingresa tu usuario");
        fieldUsername.setForeground(new Color(235,233,233));
    }

    public void reopenLogIn(){
        this.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new LogInPanel().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btnGuest;
    private javax.swing.JPanel btnLogin;
    private javax.swing.JPanel btnSalir;
    private javax.swing.JRadioButton choiceAdmin;
    private javax.swing.JRadioButton choiceUser;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JTextField fieldUsername;
    private javax.swing.JPanel header;
    private org.edisoncor.gui.panel.PanelImage imgPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelCredential1;
    private javax.swing.JLabel labelCredential2;
    private javax.swing.JLabel labelGuest;
    private javax.swing.JLabel labelLogIn;
    private javax.swing.JLabel labelLogInSetts;
    private javax.swing.JLabel labelSubtitle;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel loginPanel;
    private javax.swing.ButtonGroup radioUserType;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
