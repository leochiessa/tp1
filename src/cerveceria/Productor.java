package cerveceria;

import java.util.Random;

public class Productor implements Runnable {

    private final Random aleatorio;
    private final Cerveceria cerveceria;
    private final int idproductor;
    private final int TIEMPOESPERA = 100;

    public Productor(Cerveceria cerveceria, int idproductor) {
        this.cerveceria = cerveceria;
        this.idproductor = idproductor;
        aleatorio = new Random();
    }

    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run() {
        while (Boolean.TRUE) {
            int poner = aleatorio.nextInt(10);
            cerveceria.set(poner);
            System.out.println("El productor " + idproductor + " pone: " + poner);
            try {
                Thread.sleep(TIEMPOESPERA);
            } catch (InterruptedException e) {
                System.err.println("Productor: Error en get -> " + e.getMessage());
            }
        }
    }
}