import java.util.*;

public class Blog {
    private Set<Post> postagens;

    public Blog() {
        postagens = new HashSet<>();
    }

    public void adicionarPostagem(Post postagem) {
        if (postagens.contains(postagem)) {
            throw new IllegalArgumentException("Postagem jah existente");
        }
        postagens.add(postagem);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post postagem : postagens) {
            autores.add(postagem.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new HashMap<>();
        for (Post postagem : postagens) {
            Categorias cat = postagem.getCategoria();
            contagem.put(cat, contagem.getOrDefault(cat, 0) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> postsAutor = new TreeSet<>();
        for (Post postagem : postagens) {
            if (postagem.getAutor().equals(autor)) {
                postsAutor.add(postagem);
            }
        }
        return postsAutor;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> postsCategoria = new TreeSet<>();
        for (Post postagem : postagens) {
            if (postagem.getCategoria() == categoria) {
                postsCategoria.add(postagem);
            }
        }
        return postsCategoria;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> mapa = new HashMap<>();
        for (Post postagem : postagens) {
            Categorias cat = postagem.getCategoria();
            mapa.putIfAbsent(cat, new TreeSet<>());
            mapa.get(cat).add(postagem);
        }
        return mapa;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> mapa = new HashMap<>();
        for (Post postagem : postagens) {
            Autor autor = postagem.getAutor();
            mapa.putIfAbsent(autor, new TreeSet<>());
            mapa.get(autor).add(postagem);
        }
        return mapa;
    }
}
