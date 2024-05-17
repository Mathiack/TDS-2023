package Java.Domino_Ederson;
import java.util.ArrayList;

public class Monte {
    ArrayList<Peca> pecas;
    Monte() {

    }
    public void criarPecas() {
        for (int num_Esq = 0; num_Esq < 7; num_Esq++) {
            for (int num_Dir = num_Esq; num_Dir < 7; num_Dir++) {
                System.out.println("|" + num_Esq + "|" + num_Dir + "|");
            }
        }
    }
}