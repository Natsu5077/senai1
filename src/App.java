import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "O Jardim Encanto lhe dá as boas-vindas.");
        int opcao = JOptionPane.showConfirmDialog(null, "Podemos te ajudar?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Ótimo! Iremos te ajudar.");
            
            // Cadastro do cliente
            String nome = JOptionPane.showInputDialog("Por favor, digite seu nome:");
            String telefone = JOptionPane.showInputDialog("Por favor, digite seu número para contato:");
            String email = JOptionPane.showInputDialog("Por favor, digite seu e-mail:");
            String cep = JOptionPane.showInputDialog("Por favor, digite seu CEP:");
            String casa = JOptionPane.showInputDialog("Por favor, digite o número do lote:");
            String complemento = JOptionPane.showInputDialog("Por favor, digite o complemento do endereço:");

            double largura = obterValorNumerico("Digite a largura do local em metros:");
            double comprimento = obterValorNumerico("Digite o comprimento do local em metros:");
            
            double area = comprimento * largura;
            String tamanhoJardim = (area > 50) ? "Grande" : "Pequeno";
            JOptionPane.showMessageDialog(null, "A área do jardim é: " + area + " metros quadrados.\nClassificação: " + tamanhoJardim);

            boolean continuar = true;
            while (continuar) {
                String opcaoServicoStr = JOptionPane.showInputDialog(
                    "Escolha um serviço:\n1 - Poda\n2 - Irrigação\n3 - Adubação\n4 - Paisagismo\n5 - Controle de pragas\n6 - Instalação de drenagem\n7 - Revitalização do jardim\n0 - Continuar");

                int servico;
                try {
                    servico = Integer.parseInt(opcaoServicoStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                    continue;
                }

                String descricaoserv;
                switch (servico) {
                    case 1: descricaoserv = "Serviço de poda: manutenção das plantas."; break;
                    case 2: descricaoserv = "Irrigação: rega automatizada ou manual."; break;
                    case 3: descricaoserv = "Adubação: aplicação de fertilizantes."; break;
                    case 4: descricaoserv = "Paisagismo: planejamento e design."; break;
                    case 5: descricaoserv = "Controle de pragas: proteção contra insetos."; break;
                    case 6: descricaoserv = "Instalação de drenagem: prevenção contra acúmulo de água."; break;
                    case 7: descricaoserv = "Revitalização do jardim."; break;
                    case 0: continuar = false; continue;
                    default: descricaoserv = "Opção inválida."; break;
                }

                if (servico != 0) {
                    JOptionPane.showMessageDialog(null, descricaoserv);
                }
            }

            // Aplicação de desconto
            int qtdeServicos = obterValorInteiro("Quantos serviços você deseja contratar?");
            double desconto = 0;

            if (qtdeServicos >= 3) {
                desconto = 0.15;
            } else if (qtdeServicos >= 2) {
                desconto = 0.10;
            }

            if (desconto > 0) {
                JOptionPane.showMessageDialog(null, "Você recebeu um desconto de: " + (desconto * 100) + "%!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum desconto aplicado.");
            }

            JOptionPane.showMessageDialog(null, "Obrigado por escolher nossos serviços!");
        } else {
            JOptionPane.showMessageDialog(null, "Tudo bem, ficaremos à disposição!");
            System.exit(0);
        }
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
}