import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Aula3 switch e loops");
        // o switch é uma estrutura de seleção multipla
        // um if mais organizado
        //escolha
        //case
        // para resolver listas ou constantes
        //menu 
        //opção1
        // opção2
        int op = Integer.parseInt(JOptionPane.showInputDialog( "Digite uma opção 1- estatistica descritiva 2- probabilidade 3 - modelos probalisticos, 4 - sair"));
        if (op!=4){ 
            switch (op) {
        
            case 1:JOptionPane.showMessageDialog(null, "Estatistica descritiva"); break;
            case 2:JOptionPane.showMessageDialog(null, "probabilidade"); break;
            case 3: JOptionPane.showMessageDialog(null, "modelos probalisticos");  break;
            default: JOptionPane.showMessageDialog(null, "Escolha invaLida");  break;
        }

            //!= diferente
        }
        else {JOptionPane.showMessageDialog(null, "encerrando o sistema...");

        }

        // como funciona os loops
        // while
        //for
        // do while 
        /*
         * inicio/contador = 1 
         * condição = 5
         * incremento ou decremento = i=i+1
         */
       int contador = 1;
       while (contador<=3) {
        JOptionPane.showMessageDialog(null, "viva o Senai");
        contador=contador +1;
       }
       int i= 1;
       while (i<=5) {
        System.out.println(i);
        i++;
       }
       for (int cont = 1; cont <=10 ; cont++) {
        System.out.println(cont);
       }
      String sair;
       do {
      
         System.out.println("sair S ou N");
        sair =    JOptionPane.showInputDialog("Digite: Sim ou Não");
       } while (sair.equalsIgnoreCase("sim"));
       // ajustar os bugs logicos do menu estatistico
       //criar um loop
       //deixar o usuario decidir quando sair
      int menu;
       do {
           menu = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção:\n1 - Estatística Descritiva\n2 - Probabilidade\n3 - Modelos Probabilísticos\n4 - Sair"));

           switch (menu) {
               case 1:
                   JOptionPane.showMessageDialog(null, "Estatística Descritiva");
                   break;
               case 2:
                   JOptionPane.showMessageDialog(null, "Probabilidade");
                   break;
               case 3:
                   JOptionPane.showMessageDialog(null, "Modelos Probabilísticos");
                   break;
               case 4:
                   JOptionPane.showMessageDialog(null, "Saindo...");
                   break;
               default:
                   JOptionPane.showMessageDialog(null, "Escolha inválida! Tente novamente.");
                   break;
           }
       } while (menu != 4);
   }
    }
