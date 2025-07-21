import java.util.Map;

public abstract class Armazem<T> implements Armazenavel<T> {
    protected Map<String, T> inventario;

    public Armazem(Map<String, T> inventarioInicial) {
        this.inventario = inventarioInicial;
    }

    @Override
    public void adicionarAoInventario(String nome, T valor) {
        inventario.put(nome, valor);
    }

    @Override
    public T obterDoInventario(String nome) {
        return inventario.get(nome);
    }
}
