import java.util.Scanner;

public class Revendedora {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Carros: ");
        double nCArros = scan.nextDouble();
        System.out.println("Salário Fixo: ");
        double salFixo = scan.nextDouble();

    }
}

/*Uma revendedora de carros usados paga a seus funcionários vendedores um salário
fixo por mês, mais uma comissão também fixa para cada carro vendido e mais 5% do
valor das vendas por ele efetuadas. Escrever um algoritmo que leia o número de
carros por ele vendidos, o valor total de suas vendas, o salário fixo e o valor que ele
recebe por carro vendido. Calcule e escreva o salário final do vendedor.*/
