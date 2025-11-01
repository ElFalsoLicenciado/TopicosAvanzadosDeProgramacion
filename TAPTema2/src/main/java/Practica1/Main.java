package Practica1;



public class Main {

    /**
     * <h1> Proceso: La instancia activa de un programa </h1>
     *  <p>Hilo / Thread / Proceso ligero
     * <p>->  Es un proceso que contiene menos campos que un proceso normal.
     * <p>->  Nace de un proceso existente.
     * <p>->  Es mas facil de crear y destruir que un proceso normal.
     * <p>-> Permite solapar llamadas bloqueantes al sistema.
     * <p>Parelelismo: Tareas ejecutadas el mismo tiempo.
     * </p>
    */

    int c = 0;
    public Main() {
        Hilo hilo = new Hilo();
        hilo.start(); //FORMA CORRECTA
      //hilo.run();     FORMA INCORRECTA
        for(;;){
            if (c >= 5 && c <= 9)
                System.out.println("Soy el proceso prinicipal");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            c++;
            if(c >= 10) c = 0;
        }
    }
    
    public static void main(String[] args) {
        new Main();
    }
    
    class Hilo extends Thread {

        @Override
        public void run() {
            
            while (true) {
                if ( c >= 0 && c <= 4)
                    System.out.println("\tSoy el hilo");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
}
