package Practica2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class TAP_U1P2  extends JFrame{

    public TAP_U1P2()
    {
        initComponents();
    }

    private void sonido(String ruta)
    {
        try
        {
            File file = new File(ruta);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        }
        catch (Exception ex)
        {
            System.out.println();
        }
    }

    private void initComponents()
    {
        this.setSize(600,600);
        setLocationRelativeTo(null); // La ventana al inicializarse se coloca al centro.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cuando se cierra la pestaña tambien la ejecucion del Frame termina y por ende ya no hay instrucciones.

        Container container = getContentPane(); // Contiene los componentes

        /*
        Tipo de layout: Orden de los componentes

        Flow Layout
        Grid Layout
        Card Layout
         */

        container.setLayout(new FlowLayout());

        JLabel label = new JLabel("Cande si hizo su tarea"); // Se crea nuestro componente
        label.setForeground(Color.decode("#4f90ff")); //Color de fuente
        container.add(label); // Se agrega el componente al contendor

        JTextField field = new JTextField(20);
        container.add(field);

        JButton dinero = new JButton("Dame dinero");
        dinero.setForeground(Color.decode("#defabd"));
        dinero.setBackground(Color.decode("#cacaca"));

        dinero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                sonido("C:/Users/User/Documents/Programming/JetBrains/IntelliJ Projects/Topicos Avanzados de Programacion/TAP Tema 1/src/main/java/Practica2/money.wav");
                String nombre = field.getText();
                JOptionPane.showMessageDialog(null, nombre + ", me diste dinero. Zangano");
            }
        });
        container.add(dinero);

        Button despedida = new Button("Despedida");
        despedida.setForeground(Color.decode("#bdfade"));
        despedida.setBackground(Color.decode("#acaca"));

        despedida.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               String s = JOptionPane.showInputDialog(null,"Como te quieres despedir?");
               sonido("C:/Users/User/Documents/Programming/JetBrains/IntelliJ Projects/Topicos Avanzados de Programacion/TAP Tema 1/src/main/java/Practica2/vineboom.wav");
               JOptionPane.showMessageDialog(null,  s + ", " + field.getText());
           }
        });

        container.add(despedida);


    }

    public static void main(String[] args) {
        new TAP_U1P2().setVisible(true);
    }
}
