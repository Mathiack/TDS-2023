package Java.Domino_Ederson;
import java.util.Scanner;

public class Jogar {
    public static void main (String [] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Opa vamo play, so n rusha pq tem tryhard messe bgl");

        Mesa mesa = new Mesa();
        Monte monte = new Monte();

        System.out.println("Quantos jogador tu vai ter?");
        int qntJogadores = scan.nextInt();
        scan.nextLine();
        mesa.setQuantidadeJogadores(qntJogadores);

        if (qntJogadores > 4) {
            System.out.println("N pode ser maior que 4 man, vai le o ridme<");
        } else if (qntJogadores < 2) {
            System.out.println("Vai jogar sosinho?");
        } else {
            System.out.println("Vai ter " + mesa.getQuantidadeJogadores() + " jogadores nessa play");
        }

        for (int i = 0 ; i < qntJogadores ; i++) {
            System.out.println("Qual o nome do jogador " + (i+1) + "?");
            mesa.adicionarJogador(new Jogador(scan.nextLine()));
        }

        //System.out.println("Restam " +  pecasTotal + " peças no monte.");

        monte.criarPecas();
        mesa.distribuirPeca();

        for (int i = 0 ; i < qntJogadores ; i++) {
            System.out.println(mesa.pegarJogador());
            mesa.proximo();
        }
    }
}