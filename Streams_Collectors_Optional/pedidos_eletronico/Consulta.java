import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Consulta {
    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream()
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .findFirst()
                .orElse(null);
    }

    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return produtos.stream()
                .filter(p -> p.getPreco() >= precoMinimo)
                .collect(Collectors.toList());
    }

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        return pedidos.stream()
                .filter(p -> p.getProdutos().stream()
                        .anyMatch(prod -> prod.getCategoria() == CategoriaProduto.ELETRONICO))
                .collect(Collectors.toList());
    }


}