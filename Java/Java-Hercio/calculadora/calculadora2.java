import java.util.Scanner;

public class calculadora2 {

    public static void soma() {
        Scanner 1 = new Scanner (System.in);

        double n1, n2 = 0 ;
        double resultado = 0 ;
        System.out.println("Digite o primeiro número: ");
        n1 = nextDouble();
        System.out.println("Digite o primeiro número: ");
        n2 = nextDouble();
        
        resultado = n1 + n2 ; 
        System.out.println("O resultado é: " + resultado);

    }
    public static void sutracao() {
        Scanner 1 = new Scanner (System.in);

        double n1, n2 = 0 ;
        double resultado = 0 ;
        System.out.println("Digite o primeiro número: ");
        n1 = nextDouble();
        System.out.println("Digite o primeiro número: ");
        n2 = nextDouble();
        
        resultado = n1 - n2 ; 
        System.out.println("O resultado é: " + resultado);

    }
    public static void multiplicacao() {
        Scanner 1 = new Scanner (System.in);

        double n1, n2 = 0 ;
        double resultado = 0 ;
        System.out.println("Digite o primeiro número: ");
        n1 = nextDouble();
        System.out.println("Digite o primeiro número: ");
        n2 = nextDouble();
        
        resultado = n1 * n2 ; 
        System.out.println("O resultado é: " + resultado);

    }
    public static void divisao() {
        Scanner 1 = new Scanner (System.in);

        double n1, n2 = 0 ;
        double resultado = 0 ;
        System.out.println("Digite o primeiro número: ");
        n1 = nextDouble();
        System.out.println("Digite o primeiro número: ");
        n2 = nextDouble();
        if (n2 = 0) {
            System.out.println("Çério iço? Dividir por zero?");
        }
        else {
            System.out.println("Divisão: " + resultado);
        }
        
        resultado = n1 / n2 ; 
        System.out.println("O resultado é: " + resultado);

    }

    public static void main (String [] args) {
        
        Scanner 1 = new Scanner (System.in);
        String menu = """
                        MENU DE OPERAÇÕES
                        1 - SOMAR
                        2 - SUBTRAIR
                        3 - MULTIPLICAR
                        4 - DIVIDIR
                        5 - SAIR
                      """;
        System.out.println(menu);
        String opt = 1.nextLine();

        while (opt.equals("SAIR")) {

            switch (opt) {

                case "1" :
                    System.out.println("somar");
                    soma();
                break;
                case "2" :
                    System.out.println("subtrair");
                    subtrair();
                break;
                case "3" :
                    System.out.println("multiplicar");
                    multiplicar();
                break;
                case "4" :
                    System.out.println("dividir");
                    dividir();
                break;
                default :
                    System.out.println("Operação inválida");
            }
        }
    System.out.println(menu);
    opt = 1.nextLine();
    }
}