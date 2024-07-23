package Java.Domino_Ederson; //package sigma do sul (eu)
import java.lang.reflect.Array;
import java.util.ArrayList; //importando ArrayList denovo
import java.util.Arrays;

public class Mesa {
    ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
    int jogadorAtual = 0;
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

    public void adicionarJogador(Jogador jogador) {
        this.jogadores.add(jogador);
    } 
    public Jogador pegarJogador() {
        return this.jogadores.get(jogadorAtual);
    }
    public void proximo() {
        this.jogadorAtual = (this.jogadorAtual + 1) % this.jogadores.size();
    }

    public void setMonte( Monte monte) {
        this.monte = monte;
    }

    public void distribuirPeca() {
        for (int i = 0 ; i < 7 ; i++) {
            for(int ii = 0; ii < this.getQuantidadeJogadores(); ii++) {
                jogadores.get(ii).adicionarPeca(monte.pescarPeca());
            }
        }
    }
}