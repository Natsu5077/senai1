import javax.swing.JOptionPane;
import java.util.Random;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Bem-Vindo ao lançamento de dados. Quer apostar hoje?");
    //probabilidade
    //espaço amostral
    // criar uma variavel que recebe a interface do jogo
    //Random
    //Switch
    // for, do while e while 
    
    int [] espaçoamostral= new int [6];
        //objeto random
        //sorteio
        Random random = new Random();
        // contador para verificação
        int totaljogadas= 0;
        String menssagem= "Espaço amostral: 1 a 6 "+
                        "Cada número tem probabilidade inicial de 16,67%\n"+
                        "deseja lançar o dado? E que tal uma aposta? ";
        //loop de lançamento
        while (true) {
        //interação com  o usuário
        int opcao = JOptionPane.showConfirmDialog(null, menssagem, "Lançandor de dado", JOptionPane.YES_NO_OPTION);
        
        if (opcao != JOptionPane.YES_OPTION) {

            //estatisticas
            String estatistica = "jogo finalizado \n "+
                                "total de lançamentos:  "+ totaljogadas+"\n ";
                            for (int  i= 0; i <6; i ++){
                            double porcentagem = (totaljogadas == 0) ? 0 : ((double) espaçoamostral[i] / totaljogadas) * 100;
                            estatistica += "Número " + (i+1) +": "+ espaçoamostral [i]+ " vezes \n" + " vezes (" + String.format("%.2f", porcentagem) + "%)\n";
                             } JOptionPane.showMessageDialog(null,  estatistica, "Finalizando jogo" , JOptionPane.INFORMATION_MESSAGE);
            break;
        }        
        // finalização 
        int resultado =random.nextInt(6) +1; 
        espaçoamostral [ resultado - 1]++;
        totaljogadas ++;
        double prob1 = 1.0 / 6.0; 
        double prob2 = (double) espaçoamostral[resultado - 1] / totaljogadas; 
        double prob1e2 = prob1; 
        double bayes = (prob2 == 0) ? 0 : (prob1e2 / prob2);       
        String saida = "Resultado do lançamento: " + resultado + "\n" +
        "Probabilidade teorema de Bayes de sair " + resultado + "= " + String.format("%.4f", bayes);
        JOptionPane.showMessageDialog(null, saida, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }  
}
}
