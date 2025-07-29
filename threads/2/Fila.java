import java.util.LinkedList;
import java.util.List;

public class Fila {
    private final List<Integer> fila = new LinkedList<>();
    private final int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
    }

    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() == capacidade) {
            wait(); // Espera espaço na fila
        }
        fila.add(item);
        System.out.println("Produtor adicionou: " + item);
        notifyAll(); // Acorda consumidores
    }

    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {
            wait(); // Espera item disponível
        }
        int item = fila.remove(0);
        System.out.println("Consumidor retirou: " + item);
        notifyAll(); // Acorda produtores
        return item;
    }
}