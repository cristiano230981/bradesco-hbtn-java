public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        // Cria duas threads que compartilham o mesmo contador
        Thread t1 = new ThreadContador(contador);
        Thread t2 = new ThreadContador(contador);

        // Inicia as threads
        t1.start();
        t2.start();

        // Aguarda as threads finalizarem
        t1.join();
        t2.join();

        // Imprime o valor final do contador
        System.out.println("Valor final do contador: " + contador.getContagem());
    }
}