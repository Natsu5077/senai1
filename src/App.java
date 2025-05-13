import javax.swing.JOptionPane;
import java.util.*;

class Cliente {
    public String nome, telefone, email, cep, casa, complemento;

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

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public String getCep() { return cep; }
    public String getCasa() { return casa; }
    public String getComplemento() { return complemento; }
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

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
}

class Estatisticas {
    public static void calcularEstatisticas(List<Jardim> jardins) {
        List<Double> areas = new ArrayList<>();
        for (Jardim j : jardins) {
            areas.add(j.calcularArea());
        }

        double media = areas.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        double max = areas.stream().mapToDouble(Double::doubleValue).max().orElse(0);
        double min = areas.stream().mapToDouble(Double::doubleValue).min().orElse(0);
        double moda = calcularModa(areas);

        JOptionPane.showMessageDialog(null, "Estatísticas dos Jardins:\nMédia: " + media +
                "\nMáximo: " + max + "\nMínimo: " + min + "\nModa: " + moda);
    }

    public static void calcularEstatisticasServicos(List<Jardim> jardins) {
        Map<String, Integer> contagemServicos = new HashMap<>();
        double custoTotal = 0;
        int totalServicos = 0;

        for (Jardim jardim : jardins) {
            for (Servico servico : jardim.getServicos()) {
                contagemServicos.put(servico.getNome(),
                        contagemServicos.getOrDefault(servico.getNome(), 0) + 1);
                custoTotal += servico.getPreco();
                totalServicos++;
            }
        }

        String maisComum = null;
        int maiorFrequencia = 0;
        for (Map.Entry<String, Integer> entry : contagemServicos.entrySet()) {
            if (entry.getValue() > maiorFrequencia) {
                maisComum = entry.getKey();
                maiorFrequencia = entry.getValue();
            }
        }

        StringBuilder relatorio = new StringBuilder("Estatísticas dos Serviços:\n");
        relatorio.append("Total de serviços prestados: ").append(totalServicos).append("\n");
        relatorio.append("Custo total dos serviços: R$ ").append(String.format("%.2f", custoTotal)).append("\n");
        relatorio.append("Serviço mais comum: ").append(maisComum)
                 .append(" (").append(maiorFrequencia).append(" vezes)\n\n");

        relatorio.append("Frequência e porcentagem por serviço:\n");
        for (Map.Entry<String, Integer> entry : contagemServicos.entrySet()) {
            double porcentagem = (entry.getValue() * 100.0) / totalServicos;
            relatorio.append("- ").append(entry.getKey()).append(": ")
                     .append(entry.getValue()).append(" vez (")
                     .append(String.format("%.2f", porcentagem)).append("%)\n");
        }

        JOptionPane.showMessageDialog(null, relatorio.toString());
    }

    public static double calcularModa(List<Double> lista) {
        Map<Double, Integer> frequencias = new HashMap<>();
        for (double num : lista) {
            frequencias.put(num, frequencias.getOrDefault(num, 0) + 1);
        }

        double moda = lista.get(0);
        int maxFreq = 0;

        for (Map.Entry<Double, Integer> entry : frequencias.entrySet()) {
            if (entry.getValue() > maxFreq) {
                moda = entry.getKey();
                maxFreq = entry.getValue();
            }
        }

        return moda;
    }
}

public class App {
    public static void gerarRelatorioFinal(Cliente cliente, List<Jardim> jardins) {
        StringBuilder relatorio = new StringBuilder("Relatório Final - Consolidação dos Dados\n\n");

        relatorio.append("Dados do Cliente:\n")
                 .append("Nome: ").append(cliente.getNome()).append("\n")
                 .append("Telefone: ").append(cliente.getTelefone()).append("\n")
                 .append("E-mail: ").append(cliente.getEmail()).append("\n")
                 .append("CEP: ").append(cliente.getCep()).append("\n")
                 .append("Lote: ").append(cliente.getCasa()).append("\n")
                 .append("Complemento: ").append(cliente.getComplemento()).append("\n\n");

        relatorio.append("Jardins Cadastrados:\n");
        for (Jardim jardim : jardins) {
            relatorio.append("Área: ").append(jardim.calcularArea()).append("m²\nServiços:\n");
            for (Servico servico : jardim.getServicos()) {
                relatorio.append(" - ").append(servico.getNome()).append(" (R$ ").append(servico.getPreco()).append(")\n");
            }
            relatorio.append("\n");
        }

        JOptionPane.showMessageDialog(null, relatorio.toString());
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bem-vindo ao Jardim Encanto! Vamos cadastrar o seu jardim!");

        Cliente cliente = new Cliente(
                JOptionPane.showInputDialog("Digite seu nome:"),
                JOptionPane.showInputDialog("Digite seu telefone:"),
                JOptionPane.showInputDialog("Digite seu email:"),
                JOptionPane.showInputDialog("Digite seu CEP:"),
                JOptionPane.showInputDialog("Digite o número do lote:"),
                JOptionPane.showInputDialog("Digite o complemento do endereço:")
        );

        cliente.exibir();

        if (JOptionPane.showConfirmDialog(null, "Deseja editar seus dados cadastrais?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            cliente.editarDados();
            cliente.exibir();
        }

        List<Servico> servicos = Arrays.asList(
                new Servico("Poda", 50),
                new Servico("Adubação", 60),
                new Servico("Irrigação", 80),
                new Servico("Controle de pragas", 90),
                new Servico("Paisagismo", 150)
        );

        List<Jardim> jardins = new ArrayList<>();
        while (JOptionPane.showConfirmDialog(null, "Deseja cadastrar um jardim?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Jardim jardim = new Jardim(
                    Double.parseDouble(JOptionPane.showInputDialog("Digite a largura do jardim:")),
                    Double.parseDouble(JOptionPane.showInputDialog("Digite o comprimento do jardim:"))
            );

            while (true) {
                StringBuilder servicosMsg = new StringBuilder("Escolha um serviço (0 para finalizar):\n");
                for (int i = 0; i < servicos.size(); i++) {
                    servicosMsg.append(i + 1).append(" - ").append(servicos.get(i).getNome())
                               .append(" (R$ ").append(servicos.get(i).getPreco()).append(")\n");
                }
                servicosMsg.append("0 - Finalizar escolha de serviços\n");

                int escolha = Integer.parseInt(JOptionPane.showInputDialog(servicosMsg.toString()));
                if (escolha == 0) break;
                if (escolha > 0 && escolha <= servicos.size()) {
                    jardim.adicionarServico(servicos.get(escolha - 1));
                }
            }

            jardins.add(jardim);
        }

        Estatisticas.calcularEstatisticas(jardins);
        Estatisticas.calcularEstatisticasServicos(jardins);
        gerarRelatorioFinal(cliente, jardins);
    }
}
