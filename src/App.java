import javax.swing.JOptionPane;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Jardinagem");
        //1. Alô, Jardim! - Exibe mensagem de boas-vindas com JOptionPane.
       //Cadastro simples de cliente - Entrada e exibição do nome e endereço.
       //Área do jardim - Calcula a área a partir da largura e comprimento.
    JOptionPane.showMessageDialog(null, "O Jardim Encanto lhe da as boas-vindas.");
    int opcao = JOptionPane.showConfirmDialog(null, "Podemos te ajudar?", "Confirmação", JOptionPane.YES_NO_OPTION);
    if (opcao == JOptionPane.YES_OPTION) {
        JOptionPane.showMessageDialog(null, "Otímo iremos te ajudar");
        String nome = JOptionPane.showInputDialog("Por favor digite seu nome:");
        String telefone = JOptionPane.showInputDialog("Por favor digite número para contato:");
        String email= JOptionPane.showInputDialog("Por favor digite seu E-MAIL:");
        String cep = JOptionPane.showInputDialog("Por favor digite CEP:");
        String casa = JOptionPane.showInputDialog("Por favor digite número do lote");
        String complemento = JOptionPane.showInputDialog("Por favor digite o complemento do endereço:");
        String  alturast = JOptionPane.showInputDialog("Por favor digite a altura do local em metros");
        String  comprimentost = JOptionPane.showInputDialog("Por favor digite o comprimento do local em metros");
        
        double comprimento = Double.parseDouble(comprimentost);
        double altura = Double.parseDouble(alturast);


        double area= comprimento*altura;
        JOptionPane.showMessageDialog(null, "a àrea do jardim é: " + area + "m");
        
    } else {
        JOptionPane.showMessageDialog(null, "Tudo bem ficaremos à disposição");
        System.exit(0); 
    }    
    
  
    }
}