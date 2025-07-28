import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ConsultaProdutos {
    public static List<Produto> filtrar(List<Produto> lista, Predicate<Produto> criterio) {
        List<Produto> resultado = new ArrayList<>();
        for (Produto p : lista) {
            if (criterio.test(p)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}