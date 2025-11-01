package proyecto.utils;

import javax.swing.*;

/** <h1> Diálogo de mensaje</h1>
 *  <p> Esta función permite mostrar un diálogo, es de utilidad al evitar reescribir código.</p>
 * <p> {@code title}: Este parámetro de tipo {@code String} recibe el título, se puede dejar vacío.</p>
 *<p> {@code message}: Este parámetro de tipo {@code String} recibe el cuerpo del mensaje principal, también se puede dejar vacío, pero es mejor no. </p>
 *  <ol>
 *  <li> {@code ERROR_MESSAGE = 0;} </li>
 *  <li> {@code INFORMATION_MESSAGE = 1;} </li>
 *  <li> {@code WARNING_MESSAGE = 2;} </li>
 *  <li> {@code QUESTION_MESSAGE = 3;} </li>
 *  <li> {@code PLAIN_MESSAGE = -1;} </li>
 *  </ol>
 */


public class DialogHelper {


    public static void errorMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(
                null,
                message,
                title,
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static void infoMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(
                null,
                message,
                title,
                JOptionPane.INFORMATION_MESSAGE
                );
    }

    public static void warnMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(
                null,
                message,
                title,
                JOptionPane.WARNING_MESSAGE
        );
    }

    public static void questionMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(
                null,
                message,
                title,
                JOptionPane.QUESTION_MESSAGE
        );
    }

    public static void plainMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(
                null,
                message,
                title,
                JOptionPane.PLAIN_MESSAGE
        );
    }
}
