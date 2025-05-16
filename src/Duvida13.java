import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Duvida13{
  public static void main(String[] args) {
    JOptionPane.showMessageDialog(null, "Bem-vindo ao Jardim Encanto!");
   int opcao= JOptionPane.showConfirmDialog(null, "Pronto(a) para embelezar seu jardim?", "confirmação" , JOptionPane.YES_NO_OPTION);
    if (opcao== JOptionPane.YES_OPTION) {
      JOptionPane.showMessageDialog(null, "Execelente! Iremos te ajudar");
      // cadastro do cliente 
        String nome = JOptionPane.showInputDialog("Por favor digite seu nome");
        String telefone = JOptionPane.showInputDialog("Por favor digite um telefone para contato com o DD");
        String email= JOptionPane.showInputDialog("Por favor digite seu email");   
        String cep = JOptionPane.showInputDialog("Informe o CEP da localidade do Jardim");
        String lote = JOptionPane.showInputDialog("Digite o número do lote:");
        String complemento= JOptionPane.showInputDialog("Complemento do endereço:");
      // chamando função exibir dados 
        exibirDados(nome, telefone, email,  cep, lote, complemento);
      ArrayList<Double> areajardim = new ArrayList<>();
      boolean cadastraoutro= true;
      while (cadastraoutro) {
        double comprimento= Double.parseDouble(JOptionPane.showInputDialog("Digite o comprimento do jardim em metros: "));
        double largura = Double.parseDouble(JOptionPane.showInputDialog("Digite a largura do jardim em metros: "));
        double area= calculodaarea(largura, comprimento);
        areajardim.add(area);
        int outro = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro jardim? ", "confirmação", JOptionPane.YES_NO_OPTION);
        cadastraoutro = (outro == JOptionPane.YES_OPTION);
      }
      double mediaarea = calculomedia(areajardim);
      JOptionPane.showMessageDialog(null, "A média da(s) área(s) do(s) jardim(ns) cadastrados é: " + mediaarea + " metros quadrados");
      JOptionPane.showMessageDialog(null, "Jardim(ns) cadastrados com sucesso, nossa equipe entrará m contato para a realização dos serviços");
    }
     
    //mensagem de saida
    else {
        JOptionPane.showMessageDialog(null, "Tudo bem, quando precisar estaremos a disposição!");
    }

  }
  //função calculo da área
  public static double calculodaarea (double i, double c) {
    return i*c;
  }
  // função exibir dados do cliente
  public static void exibirDados (String nome, String telefone, String email, String cep, String lote, String complemento )
    {
      JOptionPane.showMessageDialog(null, "Ddos do cliente: \n Nome: " + nome + "\n telefone: " + telefone + "\n E-mail: " + 
      email + "\n CEP: " + cep + "\n lote: " + lote + "\n complemento: " + complemento);
    }
    // função calculo media das áreas
    public static double calculomedia (ArrayList<Double> areas){
      double somaarea=0;
      for (double area : areas ){
        somaarea+= area;
    }
    return somaarea/areas.size();

}
}