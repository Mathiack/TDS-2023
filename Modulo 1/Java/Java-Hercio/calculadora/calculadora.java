import java.util.Scanner;

public class calculadora {

    public static void main (String [] args) {

        int soma;
        double n1 = Double.parseDouble(args[0]);
        double n2 = Double.parseDouble(args[1]);
        int sub;
        float div;
        int mult;

        Scanner scan = new Scanner (System.in);
        String ops = "";
        System.out.println("Bem-vindo. Vamos calcular:");
        System.out.println("Digite SOMA para somar, SUB para subtrair, MULTI para multiplicar e DIV para dividir.");
        ops = scan.nextLine();

        if (ops.equals("SOMA")) {
            System.out.println("O resultado é:" + (n1 + n2));
        }
        else if (ops.equals("SUB")) {
            System.out.println("O resultado é: " + ( n1 - n2));
        }
        else if (ops.equals("MULTI")) {
            System.out.println("O resultado é: " + ( n1 * n2));
        }
        else if (ops.equals("DIV")) {
            System.out.println("O resultado é: " + ( n1 / n2));
        }
        esle if (ops.equals("SAIR")) {
            System.our.println("")
        }
    }
}
