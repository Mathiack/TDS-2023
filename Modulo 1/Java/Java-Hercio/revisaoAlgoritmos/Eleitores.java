//NÃO TERMINADO
import java.util.Scanner;

public class Eleitores {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Branco: ");
        double br = scan.nextDouble();
        System.out.println("Nulos: ");
        double nl = scan.nextDouble();
        System.out.println("Válidos: ");
        double vl = scan.nextDouble();

        double totalEl = br + nl + vl;
        double percBr = (totalEl / br);
        double percNl = (totalEl / nl);
        double percVl = (totalEl / vl);

        System.out.println("Total de Eleitores: " + totalEl);
        System.out.println("Percentual Brancos: " + percBr + "%");
        System.out.println("Percentual Nulos: " + percNl + "%");
        System.out.println("Percentual Válidos: " + percVl + "%");        
    }
}
/*Escreva um algoritmo para ler o número total de eleitores de um município, o
número de votos brancos, nulos e válidos. Calcular e escrever o percentual que cada
um representa em relação ao total de eleitores*/