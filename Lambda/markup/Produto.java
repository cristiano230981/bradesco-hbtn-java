import java.util.function.Supplier;
import java.util.function.Consumer;

public class Produto {
    private String nome;
    private double preco;
    private double percentualMarkup = 10.0;

    public Supplier<Double> precoComMarkup;
    public Consumer<Double> atualizarMarkup;

    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;

        precoComMarkup = () -> preco + (preco * percentualMarkup / 100);
        atualizarMarkup = novoValor -> this.percentualMarkup = novoValor;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getPercentualMarkup() {
        return percentualMarkup;
    }
}