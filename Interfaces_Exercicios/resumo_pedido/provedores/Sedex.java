package provedores;

public class Sedex implements ProvedorFrete {
    public Frete calcularFrete(double peso, double valor) {
        double taxa = (peso > 1000) ? 0.10 : 0.05;
        double valorFrete = valor * taxa;
        return new Frete(valorFrete, TipoProvedorFrete.SEDEX);
    }

    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }
}
