package Java.Domino_Ederson; //package sigma do sul (eu)
import java.util.ArrayList; //importando ArrayList denovo

public class Mesa {
    Monte monte = new Monte(); //iniciando o Monte
    int QuantidadeJogadores; //Quantidade de Jogadores que vai ter (MAX == 4)

    public void setQuantidadeJogadores(int QuantidadeJogadores) { //fazendo o set dos Jogadores
        this.QuantidadeJogadores = QuantidadeJogadores; //fez os negocio ai
    }
    public int getQuantidadeJogadores() { //gettando os Jogadores
        return QuantidadeJogadores; //retornando a Quantidade de Jogadores
    }
    /*public void seMaiorQueQuatro(){
        if (this.getQuantidadeJogadores() > 4) {
            System.out.println("N pode ser maior que 4 man, vai le o ridme<");
        }
    }*/
}