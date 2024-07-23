import java.util.Scanner;
//NÃO TERMINADO
public class CLT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Horas Trabalhadas na Semana: ");
        double hrCLT = scan.nextDouble();
        System.out.println("Salário por Hora: ");
        double salHora = scan.nextDouble();

        double horaExtra = hrCLT - 40;
        double salPadrao = (hrCLT * salHora) * 4;
        double salExtra = ((salPadrao * 1.50) + salPadrao) * 4;

        if (hrCLT >= 40) {
            System.out.println("Toma hora extra.\n");
            System.out.println("O salario total é: " + salExtra);
        } else {
            System.out.println("Sem hora extra.");
            System.out.println("O salário é: " + salPadrao);
        }
    }    
}
/*A jornada de trabalho semanal de um funcionário é de 40 horas. O funcionário que
trabalhar mais de 40 horas receberá hora extra, cujo cálculo é o valor da hora regular
com um acréscimo de 50%.Escreva um algoritmo que leia o número de horas
trabalhadas em um mês, o salário por hora e escreva o salário total do funcionário,
que deverá ser acrescido das horas extras, caso tenham sido trabalhadas(considere
que o mês possua 4 semanas exatas)*/