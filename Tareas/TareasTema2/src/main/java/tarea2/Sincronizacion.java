package tarea2;

public class Sincronizacion {

    public static final int INTENTOS = 300;
    Thread hilo1;
    Thread hilo2;
    Thread hilo3;
    Thread hilo4;

    /**
     * <h1> Demostración de sincronización.</h1>
     * <p> Creamos dos hilos, cada hilo entra a un ciclo donde se crea una clase {@link Compartido Compartido} la cual contiene el método para incrementar una variable.</p>
     * <p> Los hilos: {@code hilo1} y {@code hilo2} son para la demostración sin sincronización, mientras que los hilos: {@code hilo3} y {@code hilo4} para la demostración con sincronización.</p>
     * <p> Hacemos que cada hilo se ejecute y haga sus respectivas operaciones e imprimimos los resultados.</p>
     */

    public static void main(String[] args) throws InterruptedException {


        Thread hilo1 = new Thread() {
            public void run() {
                for (int i = 0; i < INTENTOS; i++) {
                    Compartido paraA = new Compartido();
                    paraA.sumarZ(1);
                }
            }
        };

        Thread hilo2 = new Thread() {
            public void run() {
                for (int i = 0; i < INTENTOS; i++) {
                    Compartido paraB = new Compartido();
                    paraB.sumarZ(1);
                }
            }
        };

        hilo1.start();
        hilo2.start();
        hilo1.join();
        hilo2.join();
        Compartido.imprimirZ();


        Thread hilo3 = new Thread() {
            public void run() {
                for (int i = 0; i < INTENTOS; i++) {
                    Compartido paraA = new Compartido();
                    paraA.sumarX(1);
                }
            }
        };

        Thread hilo4 = new Thread() {
            public void run() {
                for (int i = 0; i < INTENTOS; i++) {
                    Compartido paraB = new Compartido();
                    paraB.sumarX(1);
                }
            }
        };

        hilo3.start();
        hilo4.start();
        hilo3.join();
        hilo4.join();
        Compartido.imprimirX();
    }



}



