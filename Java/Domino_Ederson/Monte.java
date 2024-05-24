package Java.Domino_Ederson;
import java.util.ArrayList;
import java.util.Random;

public class Monte {
    ArrayList<Peca> pecas;
    Monte() {
        this.criarPecas();
    }
    public void criarPecas() {
        pecas = new ArrayList<Peca>();
        for (int num_Esq = 0; num_Esq < 7; num_Esq++) {
            for (int num_Dir = num_Esq; num_Dir < 7; num_Dir++) {
                System.out.println("|" + num_Esq + "|" + num_Dir + "|");
                pecas.add(new Peca(num_Esq, num_Dir));
            }
        }
    }

    public Peca pescarPeca() {
        Random rand = new Random();
        int posicao = rand.nextInt(pecas.size());
        Peca peca = pecas.remove(posicao);
        return peca;
    }
}