import javax.swing.JOptionPane;
//import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
      // Boas vindas
      //if
      //if else
      // switch
      //termário ?
      int op= Integer.parseInt(JOptionPane.showInputDialog(
        "Qual o resultado de uma população? 1 parâmetro 2 estatistica?")) ;
        if(op==1){
        JOptionPane.showMessageDialog(null,
         "Certa resposta");
        } else{
            JOptionPane.showMessageDialog(null, "Resposta errada", "JStatistics",
            JOptionPane.ERROR_MESSAGE );
        }
        double aritimetica = Double.parseDouble(JOptionPane.showInputDialog(
            "Considerando os números 30, 50, 80 e 90, digite o valor da média aritmética simples?"));
        if (aritimetica == 62.5) {
            JOptionPane.showMessageDialog(null, "Certa resposta");
        } else {
            JOptionPane.showMessageDialog(null, "Resposta errada", "JStatistics", JOptionPane.ERROR_MESSAGE);
        }
        
        int moda = Integer.parseInt(JOptionPane.showInputDialog(
            "Considerando os valores 10, 40, 50, 80, 10, digite qual é a moda"));        
                if(moda==10){
                JOptionPane.showMessageDialog(null,
                 "Certa resposta");
                } else{
                    JOptionPane.showMessageDialog(null, "Resposta errada", "JStatistics",
                    JOptionPane.ERROR_MESSAGE );
                }
                String centro = JOptionPane.showInputDialog(
                    "Considerando os números fornecidos, qual valor representa o centro da amostra? (10, 40, 50, 80, 10)?");
                String mediana = "mediana";
                
                if (centro.equalsIgnoreCase(mediana)) { 
                    JOptionPane.showMessageDialog(null, "Certa resposta");
                } else {
                    JOptionPane.showMessageDialog(null, "Resposta errada", "JStatistics", JOptionPane.ERROR_MESSAGE);
                }
                
                
    // else

        System.out.print("Alô Git");
    }
}
    // exercicio 
//* considerando os números 30, 50, 80 e 90 digite o valor da média arítmetica simples R=62,5  */
/* considerando os valores 10, 40, 50, 80, 10 digite qual é a moda R= 10*/
/* QUal a medida de tendência central que mostra o centro da amostra  R: mediana */

    

