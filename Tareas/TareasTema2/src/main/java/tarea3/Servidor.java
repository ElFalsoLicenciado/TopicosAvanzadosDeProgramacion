package tarea3;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor extends Thread {

    protected DatagramSocket socket = null;
    protected boolean quedanFrases = true;
    protected String [] mensajes = {"Hola", "Como te va", "Un gusto conocerte", "Toma agua"};
    protected int n = 0;

    public Servidor() throws IOException {
        this("Servidor");
    }

    public Servidor(String name) throws IOException {
        super(name);
        socket = new DatagramSocket(4445);
    }

    public void run() {

        while (quedanFrases) {
            try {
                byte[] buf = new byte[256];

                //Esperamos a recibir una solicitud por parte del cliente.
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                //Obtenemos nuestro mensaje a enviar.
                String mensaje = null;
                mensaje = getNextQuote();

                //Convertimos el mensaje a bytes.
                buf = mensaje.getBytes();

                //Enviamos el mensaje al cliente, usamos el paquete que recibimos para obtener la IP y puerto.
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
                quedanFrases = false;
            }
        }
        socket.close();
    }

    protected String getNextQuote() {
        String returnValue = null;
        if (n >= mensajes.length) {
            quedanFrases = false;
            returnValue = "Ya no hay frases. Adios.";
        }else {
            returnValue = mensajes[n];
            n++;
        }
        return returnValue;
    }

    public static void main(String[] args) throws IOException {
        new Servidor().start();
    }
}