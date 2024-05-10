package Java.Domino_Ederson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
    ArrayList<String> pecas = new ArrayList<>(Arrays.asList(
    "|0|0|", "|0|1|", "|0|2|", "|0|3|", "|0|4|", "|0|5|", "|0|6|",
    "|1|1|", "|1|2|", "|1|3|", "|1|4|", "|1|5|", "|1|5|",
    "|2|2|", "|2|3|", "|2|4|", "|2|5|", "|2|6|",
    "|3|3|", "|3|4|", "|3|5|", "|3|6|",
    "|4|4|", "|4|5|", "|4|6|",
    "|5|5|", "|5|6|",
    "|6|6|"));

    public void aleatorio() {

        Random random = new Random();
        int cont = 0;
        for(int i = 0; i <=6; i++) {
            cont++;
            cont = random.nextInt(pecas.size());
        }
    }

    public void pesca(){
        Random random = new Random();
        int escolha= random.nextInt(pecas.size());
        pecas.remove(escolha);
        System.out.println(pecas);

    }
    
}
