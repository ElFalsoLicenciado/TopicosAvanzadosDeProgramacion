package tarea2;

/** <h1> Clase {@code Compartido}</h1>
 *  <p> Esta clase contiene los siguientes atributos:</p>
 *  <ul>
 *      <li> {@link #x x}: Atributo que guarda la sumas para la demostración con sincronización.</li>
 *      <li> {@link #z z}: Atributo que guarda la sumas para la demostración sin sincronización.</li>
 *      <li> {@link #lock}: Atributo que funciona como candado para que un solo hilo pueda ejecutar las líneas de código y en caso de que un hilo que entró
 *      en el método si es interrumpido no deje pasar al otro hilo que intente acceder al método.</li>
 *      <p>Estos atributos son <b>estáticos</b> (significa que es una variable de clase) así solo hay un atributo compartido en todas las instancias creadas de la clase.</p>
 *  </ul>
 *
 *  <p> Y tiene sus respectivos métodos para sumar e imprimir. </p>
 * */

public class Compartido {
    private static int x;
    private static int z;
    private static final Object lock = new Object();

    /** <h2>Método para sumar con sincronización </h2>
     * <p> El atributo {@link #lock lock} funciona así en este caso: El {@code lock} como había dicho es estático, porque quiero que cada instancia de la {@link Compartido clase} use el candado de nivel de clase, ya que solo puede haber uno mientras exista una o varias instancias de la clase. Es importante que esté el candado este como {@code final} para que no cambie el objeto al que apunta. </p>
     * <p> Con esto se puede evitar el problema conocido como <a href="https://es.wikipedia.org/wiki/Condici%C3%B3n_de_carrera"><i>Race condition </i></a></p>
     */


    public void sumarX(int y) {
        synchronized (lock) {
            x = x + y;
        }
    }

    /** <h2> Método para sumar sin sincronización </h2>
     * <p> En este caso nos podemos encontrar con el problema de <a href="https://es.wikipedia.org/wiki/Condici%C3%B3n_de_carrera"><i>Race condition</i></a>, donde si un hilo que entró en el proceso de sumar a {@code z} pueda ser interrumpido, entonces otro hilo también ejecuta el proceso y sin interrupciones realiza la suma. Para ese momento si el primer hilo ya se descongeló y va a sumar 1 a z, toma el valor antiguo. Veamos un ejemplo:  </p>
     * <ol>
     *     <li> {@code z = 1}, entra el hilo 1 </li>
     *     <li> Este toma el valor de {@code z} y le suma uno pero es interrumpido</li>
     *     <li> Entra el hilo 2, también toma el valor de z que aún no ha cambiado, sigue estando en 1.</li>
     *     <li> Le suma 1 a z y se actualiza el valor de este. {@code z = 2}</li>
     *     <li> El hilo 1 ya se descongeló, y actualiza z pero este como tomó el valor antiguo lo sigue tomando como {@code z = 1 + 1}. Por ende, {@code z = 2}</li>
     *     <li> Al finalizar nuestro proceso tendré menos valores esperados por este problema.</li>
     * </ol>
     *  Esto fue un ejemplo de 2 hilos, pero en la vida real pueden ser muchos, pues si esto puede ser pequeño entre más hilos pueden ocurrir más de estos problemas.
     */

    public void sumarZ(int w) {
        z = z +w;
    }

    public static void imprimirX(){
        System.out.println("X: " + x);
    }

    public static void imprimirZ(){
        System.out.println("Z: " + z);
    }
}