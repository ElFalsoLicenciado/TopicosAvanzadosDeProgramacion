package tarea3;

import java.io.*;
import java.net.*;

public class Cliente {

    public static final String NOMBRE_MAQUINA = "G2D3B3A3B3D3B3";

    public static void main(String[] args) throws IOException {

        //Creo my socket
        DatagramSocket socket = new DatagramSocket();

        //Creo un arreglo de bits que servirá como una solicitud
        byte[] buf = new byte[256];

        //Obtengo la dirección IP basándonos en el nombre de la computadora.
        InetAddress address = InetAddress.getByName(NOMBRE_MAQUINA);
        System.out.println("Nombre y dirreción IP del servidor: " + address);

        //Creo un paquete de solicitud y lo envió al servidor.
        //En los parámetros mando mi mensaje de solicitud, su longitud, dirección y puerto del receptor.
        DatagramPacket paquete = new DatagramPacket(buf, buf.length, address, 4445);
        socket.send(paquete);

        //Creo un paquete de recepción y se envía.
        //Tan solo mandó de parametros mi arreglo y su longitud, si funciona recibiré de vuelta el mensaje en arreglo de bytes.
        paquete = new DatagramPacket(buf, buf.length);
        socket.receive(paquete);

        //Convierte los bytes en una String y la imprimo.
        String received = new String(paquete.getData(), 0, paquete.getLength());
        System.out.println("Mensaje: " + received);

        socket.close();
    }
}
