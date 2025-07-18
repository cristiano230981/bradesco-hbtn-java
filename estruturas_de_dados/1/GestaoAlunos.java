import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {
    private List<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(String nome, int idade) {
        alunos.add(new Aluno(nome, idade));
        System.out.println("Aluno adicionado com sucesso.");
    }

    public void excluirAluno(String nome) {
        boolean removido = alunos.removeIf(a -> a.getNome().equalsIgnoreCase(nome));
        if (removido) {
            System.out.println("Aluno removido com sucesso.");
        } else {
            System.out.println("Aluno não encontrado para exclusão.");
        }
    }

    public void buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado: " + aluno);
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("Lista de alunos:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        // Adiciona três alunos
        gestao.adicionarAluno("João", 20);
        gestao.adicionarAluno("Maria", 22);
        gestao.adicionarAluno("Carlos", 19);

        // Exibe todos os alunos
        gestao.listarAlunos();
        System.out.println();

        // Busca por um aluno
        gestao.buscarAluno("Maria");
        System.out.println();

        // Exclui um aluno
        gestao.excluirAluno("Carlos");
        System.out.println();

        // Tenta excluir um aluno que não existe
        gestao.excluirAluno("Ana");

        // Tenta buscar um aluno que foi excluído
        gestao.buscarAluno("Carlos");
    }
}
