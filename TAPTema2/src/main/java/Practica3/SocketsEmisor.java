package Practica3;

import javax.swing.*;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketsEmisor {

    public static void main(String[] args) {

        try {
            /* Para ver tu IP, en la terminal escribes:
            *  ipconfig: Te vas al apartado de Wireless Lan Adapter Wifi:
            * IPv4 Address
            */
            Socket socket = new Socket("10.31.17.131", 8000); // Se apunte el origen y destino.

            // Se enlaza la memoria del socket

            ObjectOutputStream oos = new ObjectOutputStream(
                    socket.getOutputStream()
            );

            // Se escribe en la memoria enlazada

            oos.writeObject(
                    JOptionPane.showInputDialog("Mensaje a enviar:")
            );

            // Se cierran los streams y sockets

            oos.close();
            socket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
