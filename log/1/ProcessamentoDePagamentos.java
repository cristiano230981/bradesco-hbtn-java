import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ProcessamentoDePagamentos {

    // Logger SLF4j
    private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);
    private static final Random random = new Random();

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            logger.info("Iniciando o processamento do pagamento {}", i);

            try {
                Thread.sleep(1000); // Simula tempo de processamento
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Processamento interrompido.");
                return;
            }

            int resultado = random.nextInt(3); // 0 = sucesso, 1 = falha, 2 = pendente

            switch (resultado) {
                case 0 -> logger.info("Pagamento {} processado com sucesso.", i);
                case 1 -> logger.error("Erro ao processar o pagamento {}: Falha na transação.", i);
                case 2 -> logger.warn("Pagamento {} está pendente. Aguardando confirmação.", i);
            }
        }

        logger.info("Processamento de pagamentos concluído.");
    }
}