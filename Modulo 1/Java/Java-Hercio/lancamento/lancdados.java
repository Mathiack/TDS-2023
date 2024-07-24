/*Crie um programa que simule o lançamento de um dado 100 vezes. Conte e exiba a
quantidade de vezes que cada face do dado foi sorteada. Você deve usar um `for`
para os lançamentos e estrutura de switch para somar cada quantidade.*/

import java.util.Random;

public class lancdados {

    public static void main (String [] args) {

        Random rand = new Random();
        int [] num = new int[6];

        for ( int i = 0 ; i <= 100 ; i++) {

        int numeros = rand.nextInt(6) + 1;
        switch (numeros) {
            case 1 : num [0]++; break;
            case 2 : num [1]++; break;
            case 3 : num [2]++; break;
            case 4 : num [3]++; break;
            case 5 : num [4]++; break;
            case 6 : num [5]++; break;
            }
        }
        for (int i = 0 ; i < 6; i++) {
            System.out.println((i+1) + " Foi sorteado " + num[i] + " vezes " );
        }
    }
}
/* */