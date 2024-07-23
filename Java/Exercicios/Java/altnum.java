/* Tem-se um conjunto de dados contendo a altura e o sexo (masculino, feminino) de 10 pessoas.
Fazer um algoritmo que calcule e escreva:
a. a maior e a menor altura do grupo;
b. média de altura dos homens;
c. o número de mulheres. */
import java.util.Scanner;
public class altnum {
    
    public static void main (String [] args) {
        String ler = "";
        double altH = 0 ; 
        double altM = 0 ;
        double medaltH = 0;
        double numM = 0;
        double media = 0;

        Scanner scan = new Scanner (System.in);
        for (int i = 0 ; i <= 10 ; i++) {
            System.out.println("Digite a altura: ");
            ler = scan.nextLine();
        }
    }
}
/* não terminado */
