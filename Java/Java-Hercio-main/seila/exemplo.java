import java.util.Scanner;

public class exemplo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] notas = new int[5][4];

        for (int i = 0; i < 5; i++) {
            System.out.println("Insira as 4 notas para a disciplina " + (i + 1) + ":");
            for (int j = 0; j < 4; j++) {
                notas[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            int soma = 0;
            for (int j = 0; j < 4; j++) {
                soma += notas[i][j];
            }
            int media = soma / 4;
            System.out.println("A média das notas para a disciplina " + (i + 1) + " é: " + media);
        }
    }
}
