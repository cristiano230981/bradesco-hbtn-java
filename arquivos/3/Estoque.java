import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;
    private String arquivo;

    public Estoque(String arquivo) {
        this.arquivo = arquivo;
        this.produtos = new ArrayList<>();
        carregarDoArquivo();
    }

    private void carregarDoArquivo() {
        produtos.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null && !linha.trim().isEmpty()) {
                String[] partes = linha.split(",");
                if (partes.length == 4) {
                    int id = Integer.parseInt(partes[0]);
                    String nome = partes[1];
                    int quantidade = Integer.parseInt(partes[2]);
                    double preco = Double.parseDouble(partes[3]);
                    produtos.add(new Produto(id, nome, quantidade, preco));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o estoque: " + e.getMessage());
        }
    }

    private void salvarNoArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Produto produto : produtos) {
                writer.write(produto.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o estoque: " + e.getMessage());
        }
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        int novoId = gerarNovoId();
        Produto produto = new Produto(novoId, nome, quantidade, preco);
        produtos.add(produto);
        salvarNoArquivo();
        //System.out.println("Produto adicionado com sucesso: " + produto);
    }

    private int gerarNovoId() {
        int maxId = 0;
        for (Produto produto : produtos) {
            if (produto.getId() > maxId) {
                maxId = produto.getId();
            }
        }
        return maxId + 1;
    }

    public void excluirProduto(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            salvarNoArquivo();
            //System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        boolean encontrado = false;
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setQuantidade(novaQuantidade);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            salvarNoArquivo();
            //System.out.println("Quantidade atualizada com sucesso.");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }

        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
