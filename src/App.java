import javax.swing.JOptionPane;

public class App {
    public static final int fidelidade = 1; // Fidelidade é 10, você precisa de 10 compras
    public static final double desconto = 0.30;

    public static void main(String[] args) {

        int contador = 0;
        double acumulador = 0;
        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                "Iniciando compra:\n1 - Poda (R$150)\n2 - Cortar grama (R$250)\n3 - Sair"
            ));

            if (opcao == 1) {
                acumulador += 150;
            } else if (opcao == 2) {
                acumulador += 250;
                contador++;
            }

        } while (opcao != 3);

        JOptionPane.showMessageDialog(null, "Total da compra: R$" + acumulador);

     
        JOptionPane.showMessageDialog(null, "Você fez " + contador + " compras de cortar grama.");

      
        if (contador >= fidelidade) {
            double valorcomdesconto = acumulador - (acumulador * desconto);
            JOptionPane.showMessageDialog(null, "Valor com desconto de 30% (fidelidade): R$" + valorcomdesconto);
        } else {
            JOptionPane.showMessageDialog(null, "Não atingiu o mínimo para desconto.");
        }
    }
}
