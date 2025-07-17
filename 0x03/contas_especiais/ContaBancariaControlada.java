public class ContaBancariaControlada extends ContaBancariaBasica {
    private double saldoMinimo;
    private double valorPenalidade;

    public ContaBancariaControlada(String numeracao, double taxaJurosAnual, double saldoMinimo, double valorPenalidade) {
        super(numeracao, taxaJurosAnual);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    public void aplicarAtualizacaoMensal() {
        double tarifa = calcularTarifaMensal();
        double juros = calcularJurosMensal();
        double novoSaldo = getSaldo() - tarifa + juros;

        if (novoSaldo < saldoMinimo) {
            novoSaldo -= valorPenalidade;
        }

        try {
            // Ajusta diretamente o saldo usando métodos da superclasse
            sacar(getSaldo());             // zera
            depositar(novoSaldo);          // atualiza com novo valor calculado
        } catch (Exception e) {
            // Não deve acontecer, pois valores já são validados
        }
    }
}
