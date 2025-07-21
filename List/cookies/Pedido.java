import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pedido {
    private ArrayList<PedidoCookie> cookies;

    public Pedido() {
        cookies = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedido) {
        cookies.add(pedido);
    }

    public int obterTotalCaixas() {
        int total = 0;
        for (PedidoCookie cookie : cookies) {
            total += cookie.getQuantidadeCaixas();
        }
        return total;
    }

    public int removerSabor(String sabor) {
        int removidos = 0;
        Iterator<PedidoCookie> iterator = cookies.iterator();

        while (iterator.hasNext()) {
            PedidoCookie cookie = iterator.next();
            if (cookie.getSabor().equals(sabor)) {
                removidos += cookie.getQuantidadeCaixas();
                iterator.remove();
            }
        }

        return removidos;
    }
}
