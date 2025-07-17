public class ContaBancariaTarifada extends ContaBancariaBasica {
    private int quantidadeTransacoes = 0;
    private static final double TARIFA_TRANSACAO = 0.10;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
    }

    @Override
    public void depositar(double valor) throws exceptions.OperacaoInvalidaException {
        super.depositar(valor);
        quantidadeTransacoes++;
        super.sacar(TARIFA_TRANSACAO);
    }

    @Override
    public void sacar(double valor) throws exceptions.OperacaoInvalidaException {
        super.sacar(valor);
        quantidadeTransacoes++;
        super.sacar(TARIFA_TRANSACAO);
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }
}

