/* Criar um programa que calcule a média de salários de uma empresa, pedindo ao usuário a grade de funcionários e os salários, e devolvendo a média salarial. */
import java.util.Scanner;
public class medsal {

    public static void main (String [] args) {

        String func = "";
        double numfunc = Double.parseDouble(args[0]);
        double sal = 0;

        Scanner scan = new Scanner (System.in);

        for (int i = 0 ; i <= numfunc ; i++) {

            System.out.println("Digite os nomes e os : ");
            func = scan.nextLine();
        }
    }    
}