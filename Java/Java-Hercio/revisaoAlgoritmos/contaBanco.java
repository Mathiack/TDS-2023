import java.util.Scanner;

public class contaBanco {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Tua conta: ");
        double nConta = scan.nextDouble();
        System.out.println("Teu saldo: ");
        double saldo = scan.nextDouble();
        System.out.println("Teus debito: ");
        double debito = scan.nextDouble();
        System.out.println("Teus credito: ");
        double credito = scan.nextDouble();

        double saldoAtual = saldo - (debito + credito);

        if (saldoAtual >= 0) {
            System.out.println("Saldo Positivo.");
            System.out.println("Saldo: R$" + saldoAtual);
        } else {
            System.out.println("Saldo Negativo.");
            System.out.println("Devendo: R$" + saldoAtual);
        }
    }
}
/*
    Faça um algoritmo para ler: número da conta do cliente, saldo, débito e crédito.
    Após, calcular e escrever o saldo atual (saldo atual = saldo - débito + crédito).
    Também testar se saldo atual for maior ou igual a zero escrever a mensagem 'Saldo
    Positivo', senão escrever a mensagem 'Saldo Negativo'.
*/