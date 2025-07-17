package provedores;

public class JadLog implements ProvedorFrete {
    public Frete calcularFrete(double peso, double valor) {
        double taxa = (peso > 2000) ? 0.07 : 0.045;
        double valorFrete = valor * taxa;
        return new Frete(valorFrete, TipoProvedorFrete.JADLOG);
    }

    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.JADLOG;
    }
}
