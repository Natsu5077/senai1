import javax.swing.JOptionPane;
import java.util.*;

public class App {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "O Jardim Encanto lhe dá as boas-vindas.");
        int opcao = JOptionPane.showConfirmDialog(null, "Podemos te ajudar?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (opcao != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Tudo bem, ficaremos à disposição!");
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null, "Ótimo! Iremos te ajudar.");

        String nome = JOptionPane.showInputDialog("Por favor, digite seu nome:");
        String telefone = JOptionPane.showInputDialog("Por favor, digite seu número para contato:");
        String email = JOptionPane.showInputDialog("Por favor, digite seu e-mail:");

        List<Double> areas = new ArrayList<>();
        Map<String, Double> servicosSelecionados = new HashMap<>();

        // Lista de serviços disponíveis 
        Map<Integer, String> servicosDisponiveis = Map.of(
            1, "Poda",
            2, "Irrigação",
            3, "Adubação",
            4, "Paisagismo",
            5, "Controle de pragas",
            6, "Instalação de drenagem",
            7, "Revitalização do jardim"
        );

        Map<Integer, Double> precosServicos = Map.of(
            1, 50.0,
            2, 80.0,
            3, 60.0,
            4, 150.0,
            5, 90.0,
            6, 120.0,
            7, 200.0
        );
      

        double valorTotal = 0;

        while (true) {
            int continuar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar um novo jardim?", "Cadastro", JOptionPane.YES_NO_OPTION);
            if (continuar != JOptionPane.YES_OPTION) {
                break;
            }

            double largura = obterValorNumerico("Digite a largura do local em metros:");
            double comprimento = obterValorNumerico("Digite o comprimento do local em metros:");
            double area = comprimento * largura;
            areas.add(area);

           //lista de serviços em ordem 
         List<Map.Entry<Integer, Double>> servicosOrdenados = new ArrayList<>(precosServicos.entrySet());
         servicosOrdenados.sort(Map.Entry.comparingByValue());
        StringBuilder servicosOrdenadosMsg = new StringBuilder("Serviços ofertados:\n");
        for (Map.Entry<Integer, Double> entry : servicosOrdenados) {
        servicosOrdenadosMsg.append(entry.getKey()).append(" - ").append(servicosDisponiveis.get(entry.getKey()))
                        .append(" (R$ ").append(entry.getValue()).append(")\n");
}
        JOptionPane.showMessageDialog(null, servicosOrdenadosMsg.toString());

            boolean escolherServicos = true;
            while (escolherServicos) {
                StringBuilder menuServicos = new StringBuilder("Escolha um serviço:\n");
                for (Map.Entry<Integer, String> entry : servicosDisponiveis.entrySet()) {
                    menuServicos.append(entry.getKey()).append(" - ").append(entry.getValue())
                               .append(" (R$ ").append(precosServicos.get(entry.getKey())).append(")\n");
                }
                menuServicos.append("0 - Finalizar seleção");

                int escolhaServico = obterValorInteiro(menuServicos.toString());
                if (escolhaServico == 0) {
                    escolherServicos = false;
                } else if (servicosDisponiveis.containsKey(escolhaServico)) {
                    double valorServico = precosServicos.get(escolhaServico);
                    servicosSelecionados.put(servicosDisponiveis.get(escolhaServico), valorServico);
                    valorTotal += valorServico;
                    JOptionPane.showMessageDialog(null, "Serviço escolhido: " + servicosDisponiveis.get(escolhaServico) +
                                                  " - R$ " + valorServico);
                } else {
                    JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.");
                }
            }
        }

        // desconto
        double desconto = 0;
        if (servicosSelecionados.size() >= 3) {
            desconto = 0.15;
        } else if (servicosSelecionados.size() >= 2) {
            desconto = 0.10;
        }

        double valorFinal = valorTotal - (valorTotal * desconto);
        JOptionPane.showMessageDialog(null, "Total dos serviços: R$ " + valorTotal +
                                      "\nDesconto aplicado: " + (desconto * 100) + "%" +
                                      "\nValor final: R$ " + valorFinal);

        JOptionPane.showMessageDialog(null, "Obrigado por escolher nossos serviços! Entraremos em contato.");

        // Exibir moda das áreas
        JOptionPane.showMessageDialog(null, "Moda das áreas cadastradas: " + calcularModa(areas));

    
    }

    private static double obterValorNumerico(String mensagem) {
        while (true) {
            try {
                String entrada = JOptionPane.showInputDialog(mensagem);
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico válido.");
            }
        }
    }

    private static int obterValorInteiro(String mensagem) {
        while (true) {
            try {
                String entrada = JOptionPane.showInputDialog(mensagem);
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um número inteiro válido.");
            }
        }
    }

    // calculo a moda das áreas
    private static double calcularModa(List<Double> areas) {
        Map<Double, Integer> frequencia = new HashMap<>();
        for (double area : areas) {
            frequencia.put(area, frequencia.getOrDefault(area, 0) + 1);
        }

        int maxFrequencia = 0;
        double moda = -1;
        for (Map.Entry<Double, Integer> entry : frequencia.entrySet()) {
            if (entry.getValue() > maxFrequencia) {
                maxFrequencia = entry.getValue();
                moda = entry.getKey();
            }
        }
        return moda;
    }

}
