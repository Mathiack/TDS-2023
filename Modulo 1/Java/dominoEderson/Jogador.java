package Java.Domino_Ederson; //package sigma
import java.util.ArrayList; //ArrayList pras peças

public class Jogador { //class Jogador 
    ArrayList<Peca> mao = new ArrayList<Peca>();
    private String nome;

    Jogador (String nome) {
        this.nome = nome;
    }
    public String toString() {
        return this.nome;
    }

    public void mostrarMao() {
        for (Peca peca : mao) {
            System.out.println(peca);
        }
    } 

    public void adicionarPeca(Peca peca) {
        this.mao.add(peca);
    }
}