import javax.swing.JOptionPane;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "O Jardim Encanto lhe dá as boas-vindas.");
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar seus Jardins?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Ótimo! Iremos te ajudar.");

            // Cadastro do cliente
            String nome = JOptionPane.showInputDialog("Por favor, digite seu nome:");
            String telefone = JOptionPane.showInputDialog("Por favor, digite seu número para contato:");
            String email = JOptionPane.showInputDialog("Por favor, digite seu e-mail:");
            String cep = JOptionPane.showInputDialog("Por favor, digite seu CEP:");
            String casa = JOptionPane.showInputDialog("Por favor, digite o número do lote:");
            String complemento = JOptionPane.showInputDialog("Por favor, digite o complemento do endereço:");

            ArrayList<Double> areasJardins = new ArrayList<>();
            int jardinsGrandes = 0;
            boolean cadastrarOutro = true;

            while (cadastrarOutro) {
                //  dimensões do jardim
                double comprimento = Double.parseDouble(JOptionPane.showInputDialog("Digite o comprimento do jardim em metros:"));
                double largura = Double.parseDouble(JOptionPane.showInputDialog("Digite a largura do jardim em metros:"));

                double area = comprimento * largura;
                areasJardins.add(area);

                String tamanhoJardim = (area > 100) ? "Grande" : "Pequeno";
                JOptionPane.showMessageDialog(null, "A área do jardim é: " + area + " metros quadrados.\nClassificação: " + tamanhoJardim);

                if (area > 100) {
                    jardinsGrandes++;
                }

                String resposta = JOptionPane.showInputDialog("Deseja cadastrar outro jardim? (Sim / Não)").trim().toLowerCase();
                if (resposta.startsWith("n")) { 
                    cadastrarOutro = false;
                }
            }
            // Calcula a média da área dos jardins
            double somaAreas = 0;
            for (double area : areasJardins) {
                somaAreas += area;
            }
            double mediaArea = somaAreas / areasJardins.size();
            JOptionPane.showMessageDialog(null, "A média da área dos jardins cadastrados é: " + mediaArea + " metros quadrados.");
            JOptionPane.showMessageDialog(null, "Número de jardins grandes cadastrados (> 100m²): " + jardinsGrandes);
            
            boolean continuar = true;
            while (continuar) {
                String opcaoServicoStr = JOptionPane.showInputDialog(
                    "Escolha um serviço:\n1 - Poda\n2 - Irrigação\n3 - Adubação\n4 - Paisagismo\n5 - Controle de pragas\n6 - Instalação de drenagem\n7 - Revitalização do jardim\nDigite 'sair' para finalizar.");

                if (opcaoServicoStr.equalsIgnoreCase("sair")) {
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Cadastro finalizado. Obrigado por cadastrar seu jardim no Jardim Encanto! Entraremos em contato para marcar a execução do serviço  pedido");
                } else {
                    try {
                        int opcaoServico = Integer.parseInt(opcaoServicoStr);
                        JOptionPane.showMessageDialog(null, "Serviço " + opcaoServico + " cadastrado com sucesso.");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada inválida. Digite um número de serviço ou 'sair'.");
                    }
}
}
}
else {
    JOptionPane.showMessageDialog(null, "Tudo bem! Se mudar de ideia, estaremos à disposição.");
}
}
}