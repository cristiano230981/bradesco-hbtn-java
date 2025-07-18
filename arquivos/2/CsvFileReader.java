import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        String fileName = "funcionarios.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;

            // Lê o cabeçalho
            linha = reader.readLine();
            if (linha != null) {
                String[] cabecalho = linha.split(",");
                System.out.printf("Funcionário: %s\n", cabecalho[0]);
                System.out.printf("Idade: %s\n", cabecalho[1]);
                System.out.printf("Departamento: %s\n", cabecalho[2]);
                System.out.printf("Salarial: %s\n", cabecalho[3]);
                System.out.println("------------------------");
            }

            // Lê os funcionários
            while ((linha = reader.readLine()) != null && !linha.trim().isEmpty()) {
                String[] dados = linha.split(",");
                System.out.printf("Funcionário: %s\n", dados[0]);
                System.out.printf("Idade: %s\n", dados[1]);
                System.out.printf("Departamento: %s\n", dados[2]);
                System.out.printf("Salarial: %s\n", dados[3]);
                System.out.println("------------------------");
            }

            System.out.println("Leitura do arquivo concluída.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
