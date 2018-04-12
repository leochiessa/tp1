package cerveceria;

public class ProductorConsumidor {

    private static Cerveceria cerveceria;
    private static Thread productor;
    private static Thread[] consumidores;
    private static final int CANTIDADCONSUMIDORES = 5;

    public static void main(String[] args) {
        cerveceria = new Cerveceria();
        productor = new Thread(new Productor(cerveceria, 1));
        consumidores = new Thread[CANTIDADCONSUMIDORES];

        for (int i = 0; i < CANTIDADCONSUMIDORES; i++) {
            consumidores[i] = new Thread(new Consumidor(cerveceria, i));
            consumidores[i].start();
        }

        productor.start();

    }
}