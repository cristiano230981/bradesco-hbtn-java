public class SistemaFilas {
    public static void main(String[] args) {
        Fila filaCompartilhada = new Fila(10); // Capacidade de 10

        Produtor p1 = new Produtor(filaCompartilhada);
        Produtor p2 = new Produtor(filaCompartilhada);
        Consumidor c1 = new Consumidor(filaCompartilhada);
        Consumidor c2 = new Consumidor(filaCompartilhada);

        p1.start();
        p2.start();
        c1.start();
        c2.start();

        try {
            Thread.sleep(20000); // Executa por 20 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        p1.interrupt();
        p2.interrupt();
        c1.interrupt();
        c2.interrupt();

        System.exit(0);
    }
}