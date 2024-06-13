import java.util.Scanner;

public class prefeitura {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Salário Bruto: ");
        double salBruto = scan.nextDouble();
        System.out.println("Valor da Prestação: ");
        double valPrest = scan.nextDouble();

        double valMaxPrest = salBruto * 0.3;

        if (valMaxPrest <= valPrest) {
            System.out.println("Pode n man");
            System.out.println("Prestação: R$" + valPrest);
            System.out.println("Salário: R$" + salBruto);
        } else {
            System.out.println("Toma");
            System.out.println("Prestação: R$" + valPrest);
            System.out.println("Salário: R$" + salBruto);
        }
    }
}

/*
A prefeitura de Aparecida de Goiânia abriu uma linha de crédito para os funcionários
estatutários. O valor máximo da prestação não poderá ultrapassar 30% do salário
bruto. Fazer um algoritmo que permita entrar com o salário bruto e o valor da
prestação e informar se o empréstimo pode ou não ser concedido.
 */