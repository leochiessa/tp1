package cerveceria;

import java.util.Random;

public class Cerveceria {

    private int cerveza;
    private Random random;
    private int capacidadMaxima;
    private boolean contenedorLleno = Boolean.FALSE;

    public synchronized int get() {
        while (!contenedorLleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Cerveceria: Error en get -> " + e.getMessage());
            }
        }
        random = new Random();
        int consumo = (random.nextInt(4)) + 1;
        capacidadMaxima = capacidadMaxima - consumo;
        if (capacidadMaxima <= 0) {
            contenedorLleno = Boolean.FALSE;
        }
        notify();
        return consumo;
    }

    public synchronized void set(int valor) {
        while (contenedorLleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Cerveceria: Error en get -> " + e.getMessage());
            }
        }
        cerveza = valor;
        capacidadMaxima = capacidadMaxima + cerveza;
        if (capacidadMaxima >= 100) {
            contenedorLleno = Boolean.TRUE;
        }
        notify();
    }

    public boolean getContenedorLleno() {
        return contenedorLleno;
    }
}