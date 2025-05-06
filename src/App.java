import javax.swing.JOptionPane;
import java.util.Random;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Alô Git");
    // cara ou coroa - probabilidade
    // 50% cara 50% coroa
    //espaço amostral
    // criar uma variavel que recebe a interface do jogo
    //Random
    //Switch
    // for, do while e while 
    
    String [] espaçoamostral= {"CARA","COROA"};
        //objeto random
        //sorteio
        Random random = new Random();
        // contador para verificação
        int contCara =0;
        int contCoroa =0;
        String menssagem= "Espaço amostral: Cara ou Coroa: "+
                        "A probabilidade de cara: 50%\n "+
                        "probabilidade de coroa: 50%\n " +
                        "deseja lancar a moeda? ";
        //loop de lançamento
        while (true) {
        //interação com  o usuário
        int opcao = JOptionPane.showConfirmDialog(null, menssagem, "Lançando moedas", JOptionPane.YES_NO_OPTION);
        
        if (opcao != JOptionPane.YES_OPTION) {

            //estatisticas
            String estatistica = "jogo finalizado \n "+
                                "total de lançamentos: "+ (contCara+contCoroa)+"\n "+
                                "caras: " +contCara +"\n "+
                                "coroas: " +contCoroa +"\n";
                                JOptionPane.showMessageDialog(null,  estatistica, "Finalizando jogo", JOptionPane.INFORMATION_MESSAGE);
                            

            break;
        }        
        int resultado =random.nextInt(2); //0-cara 1- coroa
        if (resultado==0) {
            contCara++;
        } else{
            contCoroa++;
        }
            String saida= "resultado de lançamento: " + espaçoamostral[resultado]+
                            "\n indice gerado: "+ resultado +")";
                            JOptionPane.showMessageDialog(null,  saida, "Resultado",JOptionPane.INFORMATION_MESSAGE);
    }
    
}
}
