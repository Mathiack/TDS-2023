package Java.Domino_Ederson; //packge por que sim
import java.util.Scanner; //importando Scanner

public class Jogar { //classe Main
    public static void main (String [] args) { //aqui mostra que é a Main
        Scanner scan = new Scanner(System.in); //inicializando o Scanner
        System.out.println("Opa vamo play, so n rusha pq tem tryhard messe bgl"); //início
        Mesa mesa = new Mesa();
        Monte monte = new Monte();
        //monte.criarP  ecas(); ---> teste pra mostrar as peças
        System.out.println("Quantos jogador tu vai ter?");//settando a quantidade de jogadores
        int qntJogadores = scan.nextInt(); //quantidade de jogadores sendo obtida
        mesa.setQuantidadeJogadores(qntJogadores); //aqui ta settando
        if (qntJogadores > 4) {
            System.out.println("N pode ser maior que 4 man, vai le o ridme<");
        } else {
            System.out.println("Vai ter " + mesa.getQuantidadeJogadores() + " jogadores nessa play");
        }
        monte.criarPecas(); 
    }
}