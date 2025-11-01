
package Practica3;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**  <h1>Sockets: </h1>
 *   <p>
 *   Los sockets permiten enlazar en memoria un puerto fisico a un puerto logico.
 *   la memoria enlazada se puede leer y escribir y con ello, comunicar Hardware con Software.
 *
 *   <h2>
 *   Puertos
 *   </h2>
 *   <p>
 *   Puertos fisicos: Conectan el exterior con el interior, comunicacion con el exterior (hardware y software)
 *   <p>
 *   Puertos logicos: 64 * 624 = 65536, del 0-1024 estan reservados para el sistema.
 *   </p>
 */


public class SocketsReceptor {

    public static void main(String[] args) {
        //Servidor
        ServerSocket server = null;
        Socket channel = null;

        try {
            // Estaremos escuchando el puerto 9000
            server = new ServerSocket(8000);
            System.out.println("Esperando llegada de mensaje...");
            channel = server.accept();  //Llamada bloqueante, esperate a que llegue un mensaje.

            /*Ya llego el mensaje a partir de aqui.
              El mensaje esta en lenguaje de maquina, hay que descifrar
             */
            ObjectInputStream ois = new ObjectInputStream(
                    channel.getInputStream()
            ); // Se accede a la entrada en memoria

            String message = "" + ois.readObject(); // Se lee el mensaje.

            // Se muestra el mensaje
            System.out.println("Llego este mensaje:\n " + message);

            System.out.println("\nEmisor: " + channel.getInetAddress());

            /* Se cierran los stream y el socket
               Se cierran en orden inverso, del ultimo al primero.
             */
            ois.close();
            channel.close();
            server.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
