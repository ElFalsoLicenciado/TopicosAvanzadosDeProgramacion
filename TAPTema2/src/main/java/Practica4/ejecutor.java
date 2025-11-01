
package Practica4;

/** Practica 4:
 * <p> Cliente + Servidor + Hilos = Chat</p>
 * <ul>
 *     <li> Solapar llamadas bloqueantes al sistemas</li>
 *     <li> Servidor: server.accept()</li>
 * </ul>
 *
 */

public class ejecutor {
    public static void main(String[] args) {
        new ChatFrame().setVisible(true);
    }
}
