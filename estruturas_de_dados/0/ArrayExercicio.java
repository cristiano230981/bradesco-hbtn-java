import java.util.Scanner;

public class ArrayExercicio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definindo o tamanho do array
        int tamanhoArray = 10;
        int[] numeros = new int[tamanhoArray];
        int soma = 0;
        int maiorNumero = Integer.MIN_VALUE;

        // Preenchendo o array com números fornecidos pelo usuário
        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < tamanhoArray; i++) {
            System.out.printf("Digite o número %d: ", i + 1);
            numeros[i] = scanner.nextInt();
            soma += numeros[i];
            if (numeros[i] > maiorNumero) {
                maiorNumero = numeros[i];
            }
        }

        System.out.println("\nConteúdo do array:");
        for (int i = 0; i < tamanhoArray; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();

        System.out.printf("Soma de todos os números: %d\n", soma);
        System.out.printf("Maior número no array: %d\n", maiorNumero);

        scanner.close();
    }
}
