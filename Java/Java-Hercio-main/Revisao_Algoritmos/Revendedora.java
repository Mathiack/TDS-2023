import java.util.Scanner;

public class Revendedora {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Carros: ");
        double nCarros = scan.nextDouble();
        System.out.println("Salário Fixo: ");
        double salFixo = scan.nextDouble();
        System.out.println("Valor Total Vendas: ");
        double totVenda = scan.nextDouble();
        System.out.println("Valor Recebido por Carro: ");
        double valCarro = scan.nextDouble();

        double commissaoPorCarros = nCarros * valCarro;
        double commissaoTotalVendas = totVenda * 0.05;
        double salFinal = salFixo + commissaoPorCarros + commissaoTotalVendas;

        System.out.println("------------------");
        System.out.println("Comissão por Carro: " + commissaoPorCarros);
        System.out.println("Comissão das Vendas: " + commissaoTotalVendas);
        System.out.println("Salário Final: " + salFinal);
        System.out.println("------------------");
    }
}

/*Uma revendedora de carros usados paga a seus funcionários vendedores um salário
fixo por mês, mais uma comissão também fixa para cada carro vendido e mais 5% do
valor das vendas por ele efetuadas. Escrever um algoritmo que leia o número de
carros por ele vendidos, o valor total de suas vendas, o salário fixo e o valor que ele
recebe por carro vendido. Calcule e escreva o salário final do vendedor.*/
