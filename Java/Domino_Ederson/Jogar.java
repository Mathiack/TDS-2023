package Java.Domino_Ederson; //packge por que sim
import java.util.Scanner; //importando Scanner

public class Jogar { //classe Main
    public static void main (String [] args) { //aqui mostra que é a Main
        Scanner scan = new Scanner(System.in); //inicializando o Scanner
        System.out.println("Opa vamo jogar"); //início
        Mesa mesa = new Mesa();
        //monte.criarPecas(); ---> teste pra mostrar as peças
        System.out.println("Quantos jogador tu vai ter?");//settando a quantidade de jogadores
        mesa.setQuantidadeJogadores(scan.nextInt()); //aqui ta settando
        
    }
}