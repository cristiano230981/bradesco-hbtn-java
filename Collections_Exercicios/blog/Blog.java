import java.util.*;

public class Blog {
    private ArrayList<Post> postagens;

    public Blog() {
        postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        postagens.add(postagem);
    }

    public Set<String> obterTodosAutores() {
        Set<String> autoresOrdenados = new TreeSet<>();
        for (Post postagem : postagens) {
            autoresOrdenados.add(postagem.getAutor());
        }
        return autoresOrdenados;
    }

    public Map<String, Integer> obterContagemPorCategoria() {
        Map<String, Integer> contagem = new TreeMap<>();
        for (Post postagem : postagens) {
            String categoria = postagem.getCategoria();
            contagem.put(categoria, contagem.getOrDefault(categoria, 0) + 1);
        }
        return contagem;
    }
}
