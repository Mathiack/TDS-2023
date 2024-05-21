package Java.Domino_Ederson; //package sigma do sul (eu)
import java.lang.reflect.Array;
import java.util.ArrayList; //importando ArrayList denovo
import java.util.Arrays;

public class Mesa {
    Monte monte = new Monte(); //iniciando o Monte

    /*private Jogador jogador;
    public void jogador*/
    int QuantidadeJogadores; //Quantidade de Jogadores que vai ter (MAX == 4)

    public void setQuantidadeJogadores(int QuantidadeJogadores) { //fazendo o set dos Jogadores
        this.QuantidadeJogadores = QuantidadeJogadores; //fez os negocio ai
    }
    public int getQuantidadeJogadores() { //gettando os Jogadores
        return QuantidadeJogadores; //retornando a Quantidade de Jogadores
    }
    public void criarPecas() {
        ArrayList<Integer> peca = new ArrayList<>();
        for(int i = 0; i < this.getQuantidadeJogadores(); i++){
            for (int num_Esq = 0; num_Esq < 7; num_Esq++) {
                for (int num_Dir = num_Esq; num_Dir < 7; num_Dir++) {
                    peca.add(num_Esq);
                    peca.add(num_Dir);
                    System.out.println("|" + num_Esq + "|" + num_Dir + "|");
                }
            }
            System.out.println("-----");
        }
    }
    

    /*public void seMaiorQueQuatro(){
        if (this.getQuantidadeJogadores() > 4) {
            System.out.println("N pode ser maior que 4 man, vai le o ridme<");
        }
    }*/
}