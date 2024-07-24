import java.util.Scanner;

public class vetor {

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int vetor[] = new int [10];

        for (int i = 1 ; i <= 5 ; i ++) {

        System.out.println("Digite o " + i + " número: ");
        vetor[i] = scan.nextInt();
        
        }
        System.out.println(vetor[5] +" "+ vetor[4] +" "+ vetor[3] +" "+ vetor[2] +" "+ vetor[1]);
    }
}