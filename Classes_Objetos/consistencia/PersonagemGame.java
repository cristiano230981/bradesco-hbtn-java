public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    private String status;

    // Construtor que garante dados consistentes
    public PersonagemGame(int saudeInicial, String nomeInicial) {
        setNome(nomeInicial);            // usa o setter que valida nome
        setSaudeAtual(saudeInicial);     // usa o setter que ajusta saúde e status
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        if (saudeAtual < 0) {
            saudeAtual = 0;
        } else if (saudeAtual > 100) {
            saudeAtual = 100;
        }

        this.saudeAtual = saudeAtual;

        if (this.saudeAtual > 0) {
            this.status = "vivo";
        } else {
            this.status = "morto";
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
        // Se nome for nulo ou vazio, mantemos o atual
    }

    public String getStatus() {
        return status;
    }

    public void tomarDano(int quantidadeDeDano) {
        setSaudeAtual(this.saudeAtual - quantidadeDeDano);
    }

    public void receberCura(int quantidadeDeCura) {
        setSaudeAtual(this.saudeAtual + quantidadeDeCura);
    }
}