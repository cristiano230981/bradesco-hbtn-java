public class Numero {
    public static void dividir(int a, int b) {


        try {
            resultado = a / b;
        } catch (Exception e) {
            System.out.printf("Nao foi possivel dividir %d por %d\n", a, b);
        } finally {
            System.out.printf("%d / %d = %d\n", a, b, resultado);
        }
    }
}