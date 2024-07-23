import java.util.Scanner;

public class ConvTemp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Temperatura: ");
        double tempFah = scan.nextDouble();

        double celToFah = (tempFah - 32) / 1.8;

        System.out.println(celToFah);
    }
}

/*Um canal de notícias internacionais, previa temperatura máxima para Brasília de 85
graus Farenheit. Escrever um programa que lhe permita converter esta temperatura
(e qualquer outra) para graus Celsius, sabendo que a relação entre elas é C=5/9*(F–
32).*/