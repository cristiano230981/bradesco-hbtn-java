public class Produtor extends Thread {
    private final Fila fila;

    public Produtor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = (int) (Math.random() * 100) + 1;
                fila.adicionar(item);
                Thread.sleep(1000); // Produz a cada 1s
            }
        } catch (InterruptedException e) {
            System.out.println("Produtor encerrado.");
        }
    }
}