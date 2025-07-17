public class Numero {
    public static void dividir(int a, int b) {
        int resultado = 0;
        boolean erro = false;

        try {
            resultado = a / b;
        } catch (Exception e) {
            erro = true;
        } finally {
            if (erro) {
                System.out.printf("Nao foi possivel dividir %d por %d\n", a, b);
            }
            System.out.printf("%d / %d = %d\n", a, b, resultado);

        }
    }
}