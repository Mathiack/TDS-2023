/* conversor de Celsius para Fahrenheit, Kelvin, Rankine e Réaumur */
import java.util.Scanner;

public class temperatura {

    public static void main (String [] args) {


        String opc = "" ;
        float C = Float.parseFloat(args[0]) ;
        float F = C * 1.8f + 32 ;
        float K = C + 273.15f ;
        float RE = C * 0.8f ;
        float RA = C * 1.8f + 32 + 459.67f ; 

        Scanner scan = new Scanner (System.in);
        System.out.println("Vamos converter algumas temperaturas.");
        System.out.println("Digite F para Fahrenheit, K para Kelvin, RE para Réaumur e RA para Rankine");
        opc = scan.next();

        switch (opc) {
            case "F":
            System.out.println("Você escolheu Fahrenheit");
            System.out.println(F);    
                break;

            case "K":
            System.out.println("Você escolheu Kelvin");
            System.out.println(K);    
                break;

            case "RE":
            System.out.println("Você escolheu Réaumur");
            System.out.println(RE);    
                break;

            case "RA":
            System.out.println("Você escolheu Rankine");
            System.out.println(RA);    
                break;
            
            default:
            System.out.println("Operação inválida.");
                break;
        }
    }
}
