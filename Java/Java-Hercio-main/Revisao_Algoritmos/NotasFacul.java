import java.util.Scanner;

public class notasFacul {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Mete a nota do 1: ");
        double nota1 = scan.nextDouble();
        System.out.println("Mete a nota do 2: ");
        double nota2 = scan.nextDouble();

        double nota1Peso = 4;
        double nota2Peso = 6;

        double mediaPon = ((nota1 * nota1Peso) + (nota2 * nota2Peso)) / (nota1Peso + nota2Peso);
        System.out.println(mediaPon);
    }
}

/*O critério de notas semestrais numa faculdade consiste em dois bimestres, sendo
que, cada nota varia de 0 a 10 e tem os respectivos pesos 4 e 6. Elabore um
algoritmo que leia as notas bimestrais, calcule e escreva a media semestral.*/