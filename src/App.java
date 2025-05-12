import javax.swing.JOptionPane;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "O Jardim Encanto lhe dá as boas-vindas.");
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar os seus Jardins?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Ótimo! Iremos te ajudar.");

            // Cadastro do cliente
            String nome = JOptionPane.showInputDialog("Por favor, digite seu nome:");
            String telefone = JOptionPane.showInputDialog("Por favor, digite seu número para contato:");
            String email = JOptionPane.showInputDialog("Por favor, digite seu e-mail:");
            String cep = JOptionPane.showInputDialog("Por favor, digite seu CEP:");
            String casa = JOptionPane.showInputDialog("Por favor, digite o número do lote:");
            String complemento = JOptionPane.showInputDialog("Por favor, digite o complemento do endereço:");

            exibirDadosCliente(nome, telefone, email, cep, casa, complemento);

            ArrayList<Double> areasJardins = new ArrayList<>();
            boolean cadastrarOutro = true;

            while (cadastrarOutro) {
                double comprimento = Double.parseDouble(JOptionPane.showInputDialog("Digite o comprimento do jardim em metros:"));
                double largura = Double.parseDouble(JOptionPane.showInputDialog("Digite a largura do jardim em metros:"));
                double area = calcularArea(comprimento, largura);
                areasJardins.add(area);      
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro jardim?", "Confirmação", JOptionPane.YES_NO_OPTION);
                cadastrarOutro = (resposta == JOptionPane.YES_OPTION);
            }
            double mediaArea = calcularMedia(areasJardins);
            JOptionPane.showMessageDialog(null, "A média da área dos jardins cadastrados é: " + mediaArea + " metros quadrados.");
            JOptionPane.showMessageDialog(null, "Cadastro finalizado. Obrigado por cadastrar seu jardim no Jardim Encanto!");
        } else {
            JOptionPane.showMessageDialog(null, "Tudo bem! Se mudar de ideia, estaremos à disposição.");
        }
    }

    // Função para calcular a área do jardim
    public static double calcularArea(double largura, double comprimento) {
        return largura * comprimento;
    }

    //exibir os dados do cliente
    public static void exibirDadosCliente(String nome, String telefone, String email, String cep, String casa, String complemento) {
        JOptionPane.showMessageDialog(null, "Dados do Cliente:\nNome: " + nome + "\nTelefone: " + telefone +
                "\nE-mail: " + email + "\nCEP: " + cep + "\nLote: " + casa + "\nComplemento: " + complemento);
    }

    // Função para calcular a média das áreas
    public static double calcularMedia(ArrayList<Double> areas) {
        double somaAreas = 0;
        for (double area : areas) {
            somaAreas += area;
        }
        return somaAreas / areas.size();
    }
}
