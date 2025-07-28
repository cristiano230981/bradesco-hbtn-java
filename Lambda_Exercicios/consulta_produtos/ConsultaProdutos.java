import java.util.ArrayList;
import java.util.List;

public class ConsultaProdutos {
    public static List<Produto> filtrar(List<Produto> lista, CriterioFiltro criterio) {
        List<Produto> resultado = new ArrayList<>();
        for (Produto p : lista) {
            if (criterio.testar(p)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}