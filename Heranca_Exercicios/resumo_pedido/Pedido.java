import java.util.Locale;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0.0;

        for (ItemPedido item : itens) {
            total += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
        }

        total -= total * (percentualDesconto / 100.0);
        return total;
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");

        double totalProdutos = 0.0;

        for (ItemPedido item : itens) {
            produtos.Produto produto = item.getProduto();
            double precoLiquido = produto.obterPrecoLiquido();
            int quantidade = item.getQuantidade();
            double subtotal = precoLiquido * quantidade;
            totalProdutos += subtotal;

            String tipo = (produto instanceof produtos.Livro) ? "Livro" : "Dvd";

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                    tipo, produto.getTitulo(), precoLiquido, quantidade, subtotal);
        }

        System.out.println("----------------------------");

        double desconto = totalProdutos * (percentualDesconto / 100.0);
        double totalFinal = totalProdutos - desconto;

        System.out.printf("DESCONTO: %.2f\n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f\n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f\n", totalFinal);
        System.out.println("----------------------------");
    }
}