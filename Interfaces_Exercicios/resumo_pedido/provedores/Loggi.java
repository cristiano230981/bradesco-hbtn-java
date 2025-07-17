package provedores;

public class Loggi implements ProvedorFrete {
    public Frete calcularFrete(double peso, double valor) {
        double taxa = (peso > 5000) ? 0.12 : 0.04;
        double valorFrete = valor * taxa;
        return new Frete(valorFrete, TipoProvedorFrete.LOGGI);
    }

    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.LOGGI;
    }
}
