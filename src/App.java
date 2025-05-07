import javax.swing.JOptionPane;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Bem-Vindo ao lançamento de dados. Quer apostar hoje?");
        
        int[] espaçoamostral = new int[6];
        Random random = new Random();
        int totaljogadas = 0;
        int contPares = 0;
        int contImpares = 0;
        

        String mensagem = "Espaço amostral: 1 a 6\n" +
                          "Cada número tem probabilidade inicial de 16,67%\n" +
                          "Deseja lançar o dado? E que tal uma aposta?";

        while (true) {
            int opcao = JOptionPane.showConfirmDialog(null, mensagem, "Lançador de dado", JOptionPane.YES_NO_OPTION);

            if (opcao != JOptionPane.YES_OPTION) {
                // Exibição das estatísticas
                String estatistica = " Jogo finalizado! \n\n";
                estatistica += "Total de lançamentos: " + totaljogadas + "\n\n";
                estatistica += "Distribuição dos resultados:\n";

                for (int i = 0; i < 6; i++) {
                    double porcentagem = (totaljogadas == 0) ? 0 : ((double) espaçoamostral[i] / totaljogadas) * 100;
                    estatistica += String.format("Número %d: %d vezes (%.2f%%)\n", i + 1, espaçoamostral[i], porcentagem);
                }

                // Exibição da contagem de pares e ímpares
                double percPares = (totaljogadas == 0) ? 0 : ((double) contPares / totaljogadas) * 100;
                double percImpares = (totaljogadas == 0) ? 0 : ((double) contImpares / totaljogadas) * 100;
                estatistica += String.format("\n Números pares: %d vezes (%.2f%%)", contPares, percPares);
                estatistica += String.format("\n Números ímpares: %d vezes (%.2f%%)\n", contImpares, percImpares);

                JOptionPane.showMessageDialog(null, estatistica, "Finalizando jogo", JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            // Simulação de rolagem do dado
            int resultado = random.nextInt(6) + 1;
            espaçoamostral[resultado - 1]++;
            totaljogadas++;

          //contagem pares e impares
            if (resultado % 2 == 0) {
                contPares++;  
            } else {
                contImpares++;
            }
            double prob1 = 1.0 / 6.0;
            double prob2 = (double) espaçoamostral[resultado - 1] / totaljogadas;
            double prob1e2 = prob1;
            double bayes = (prob2 == 0) ? 0 : (prob1e2 / prob2);

            // Exibir resultado do lançamento
            String saida = String.format("Resultado do lançamento:  %d\nProbabilidade Teorema de Bayes de sair %d: %.4f", resultado, resultado, bayes);
            JOptionPane.showMessageDialog(null, saida, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
