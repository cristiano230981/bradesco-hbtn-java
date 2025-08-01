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
        Map<Categorias, Integer> contagem = new TreeMap<>();
        for (Post postagem : postagens) {
            Categorias categoria = postagem.getCategoria();
            contagem.put(categoria, contagem.getOrDefault(categoria, 0) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> posts = new TreeSet<>();
        for (Post postagem : postagens) {
            if (postagem.getAutor().equals(autor)) {
                posts.add(postagem);
            }
        }
        return posts;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> posts = new TreeSet<>();
        for (Post postagem : postagens) {
            if (postagem.getCategoria() == categoria) {
                posts.add(postagem);
            }
        }
        return posts;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> mapa = new TreeMap<>();
        for (Post postagem : postagens) {
            Categorias categoria = postagem.getCategoria();
            mapa.putIfAbsent(categoria, new TreeSet<>());
            mapa.get(categoria).add(postagem);
        }
        return mapa;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> mapa = new TreeMap<>();
        for (Post postagem : postagens) {
            Autor autor = postagem.getAutor();
            mapa.putIfAbsent(autor, new TreeSet<>());
            mapa.get(autor).add(postagem);
        }
        return mapa;
    }
}
