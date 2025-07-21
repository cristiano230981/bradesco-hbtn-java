import java.util.List;

public class ManipularArrayNumeros {

    public static int buscarPosicaoNumero(List<Integer> lista, int numero) {
        return lista.indexOf(numero); // Retorna -1 se não encontrar
    }

    public static void adicionarNumero(List<Integer> lista, int numero) {
        if (buscarPosicaoNumero(lista, numero) != -1) {
            throw new IllegalArgumentException("Numero jah contido na lista");
        }
        lista.add(numero);
    }

    public static void removerNumero(List<Integer> lista, int numero) {
        int posicao = buscarPosicaoNumero(lista, numero);
        if (posicao == -1) {
            throw new IllegalArgumentException("Numero nao encontrado na lista");
        }
        lista.remove(posicao);
    }

    public static void substituirNumero(List<Integer> lista, int numeroSubstituir, int numeroSubstituto) {
        int posicao = buscarPosicaoNumero(lista, numeroSubstituir);
        if (posicao != -1) {
            lista.set(posicao, numeroSubstituto);
        } else {
            adicionarNumero(lista, numeroSubstituto);
        }
    }
}
