package Java.Domino_Ederson;
import java.util.ArrayList;

public class Monte {
    ArrayList<Peca> pecas;
    // Monte() { }
    public void criarPecas() {
        Mesa mesa = new Mesa();
        int n = mesa.getQuantidadeJogadores();
        for(int iiiii = 0; iiiii < n; iiiii++){
            for (int num_Esq = 0; num_Esq < 7; num_Esq++) {
                for (int num_Dir = num_Esq; num_Dir < 7; num_Dir++) {
                    System.out.println("|" + num_Esq + "|" + num_Dir + "|");
                }
            }
        }
    }
}