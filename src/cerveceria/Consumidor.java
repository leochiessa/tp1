package cerveceria;

public class Consumidor implements Runnable {

    private final Cerveceria cerveceria;
    private final int idconsumidor;

    public Consumidor(Cerveceria cerveceria, int idconsumidor) {
        this.cerveceria = cerveceria;
        this.idconsumidor = idconsumidor;
    }

    @Override
    public void run() {
        while (Boolean.TRUE) {
            System.out.println("El consumidor " + idconsumidor + " consume: " + cerveceria.get());
        }
    }
}