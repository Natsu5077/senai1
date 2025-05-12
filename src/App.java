import javax.swing.JOptionPane;
import java.util.*;

class Cliente {
    private String nome, telefone, email, cep, casa, complemento;
    public Cliente(String nome, String telefone, String email, String cep, String casa, String complemento) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.casa = casa;
        this.complemento = complemento;
    }
    public void exibir() {
        JOptionPane.showMessageDialog(null, "Dados do Cliente:\nNome: " + nome +
                "\nTelefone: " + telefone + "\nE-mail: " + email + "\nCEP: " + cep +
                "\nLote: " + casa + "\nComplemento: " + complemento);
    }
    public void editarDados() {
        this.nome = JOptionPane.showInputDialog("Atualize seu nome:", nome);
        this.telefone = JOptionPane.showInputDialog("Atualize seu telefone:", telefone);
        this.email = JOptionPane.showInputDialog("Atualize seu e-mail:", email);
        this.cep = JOptionPane.showInputDialog("Atualize seu CEP:", cep);
        this.casa = JOptionPane.showInputDialog("Atualize o número do lote:", casa);
        this.complemento = JOptionPane.showInputDialog("Atualize o complemento:", complemento);
    }
    }
        class Jardim {
        public double largura, comprimento;
        public List<Servico> servicos;
        public Jardim(double largura, double comprimento) {
        this.largura = largura;
        this.comprimento = comprimento;
        this.servicos = new ArrayList<>();
    }
    public double calcularArea() {
        return largura * comprimento;
    }
    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }
    public List<Servico> getServicos() {
        return servicos;
    }
}
        class Servico {
        public String nome;
        public double preco;

         public Servico(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
        public double aplicarDesconto(int qtdeServicos) {
        double desconto = qtdeServicos >= 3 ? 0.15 : (qtdeServicos >= 2 ? 0.10 : 0);
        return preco - (preco * desconto);
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
    }
    public class App {
    public static void main(String[] args) {
        // cadastro do cliente 
        JOptionPane.showMessageDialog(null, "O Jardim Encanto lhe dá as boas-vindas.");
                Cliente cliente = new Cliente(
                JOptionPane.showInputDialog("Por favor, digite seu nome:"),
                JOptionPane.showInputDialog("Por favor, digite seu número para contato:"),
                JOptionPane.showInputDialog("Por favor, digite seu e-mail:"),
                JOptionPane.showInputDialog("Por favor, digite seu CEP:"),
                JOptionPane.showInputDialog("Por favor, digite o número do lote:"),
                JOptionPane.showInputDialog("Por favor, digite o complemento do endereço:")
        );
        cliente.exibir();
        if (JOptionPane.showConfirmDialog(null, "Deseja editar seus dados cadastrais?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            cliente.editarDados();
            cliente.exibir();
        }
        JOptionPane.showMessageDialog(null, "Agora você pode cadastrar seus jardins e escolher os serviços.");
            //serviços listados 
        List<Servico> servicos = Arrays.asList(
                new Servico("Poda", 50),
                new Servico("Adubação", 60),
                new Servico("Irrigação", 80),
                new Servico("Controle de pragas", 90),
                new Servico("Paisagismo", 150)
        );

        // Ordenar os serviços por preço
        servicos.sort(Comparator.comparingDouble(Servico::getPreco));

        List<Jardim> jardins = new ArrayList<>();
        while (JOptionPane.showConfirmDialog(null, "Deseja cadastrar um jardim?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            double largura = Double.parseDouble(JOptionPane.showInputDialog("Digite a largura do jardim em metros:"));
            double comprimento = Double.parseDouble(JOptionPane.showInputDialog("Digite o comprimento do jardim em metros:"));

            Jardim jardim = new Jardim(largura, comprimento);

            // Exibir a área calculada do jardim
            double area = jardim.calcularArea();
            JOptionPane.showMessageDialog(null, "Área do jardim cadastrada: " + area + " m²");

            while (true) {
                StringBuilder servicosMsg = new StringBuilder("Escolha um serviço para este jardim:\n");
                for (int i = 0; i < servicos.size(); i++) {
                    Servico servico = servicos.get(i);
                    servicosMsg.append(i + 1).append(" - ").append(servico.getNome()).append(" (R$ ").append(servico.getPreco()).append(")\n");
                }
                servicosMsg.append("0 - Finalizar escolha de serviços para este jardim\n");

                int servicoEscolhido = Integer.parseInt(JOptionPane.showInputDialog(servicosMsg.toString()));

                if (servicoEscolhido == 0) break;

                if (servicoEscolhido > 0 && servicoEscolhido <= servicos.size()) {
                    jardim.adicionarServico(servicos.get(servicoEscolhido - 1));
                } else {
                    JOptionPane.showMessageDialog(null, "Opção inválida! Escolha um número válido.");
                }
            }

            jardins.add(jardim);
        }
            //desconto aplicado 
        double totalSemDesconto = jardins.stream().flatMap(j -> j.getServicos().stream()).mapToDouble(Servico::getPreco).sum();
        double totalComDesconto = jardins.stream().flatMap(j -> j.getServicos().stream()).mapToDouble(s -> s.aplicarDesconto(jardins.size())).sum();
        double totalDesconto = totalSemDesconto - totalComDesconto;

        JOptionPane.showMessageDialog(null, "Valor total dos serviços: R$ " + totalSemDesconto +
                "\nDesconto aplicado: R$ " + totalDesconto +
                "\nValor final com desconto: R$ " + totalComDesconto);
    }
}
