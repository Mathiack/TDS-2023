package Java.Domino_Ederson; //package sigma
import java.util.ArrayList; //ArrayList pras peças

public class Jogador { //class Jogador 
    ArrayList<Peca> mao = new ArrayList<Peca>();
    private String nome;

    Jogador (String nome) {
        this.nome = nome;
    }

    public void adicionarPeca(Peca peca) {
        this.peca = peca;
    }
}