import java.util.Scanner;
public class pardal2 {

    public static void main (String [] args) {

        int vel = 0;
        
        int av2vel = 55;
        int av2vel = 45;
        int av2vel = 300;
        int av2vel = 2;
        String escolha = "";
        Scanner scan = new Scanner (System.in);
        System.out.println("Se quiser (sim mano) Sair daqui devido aos erros de programação, digite SAIR");
        System.out.println("""
                            ESCLHE A AVENIDA QUE TU QUER:
                            1 - VALDECIR JUNIOR SEILA DO QUE
                            2 - TENENTE GENERAL CORONEL SARGENTO SOLDADO MARINHEIRO CARLOS
                            3 - VICENTE CEZAR GOMES JÚNIOR SILVA MOREIRA DOS SANTOS VIEIRA FERREIRA CARVALHO II
                            4 - ALGUEM FAMOSO QUE NINGUÉM CONHECE
                            5 - TOBEY MAGUAIRE
                            """);
        escolha = scan.nextLine();
        System.out.println(escolha);

        while (escolha != "SAIR") {

            switch (escolha) {
                case "1":
                System.out.println("VALDECIR JUNIOR SEILA DO QUE");
                break;

                case "2":
                System.out.println("TENENTE GENERAL CORONEL SARGENTO SOLDADO MARINHEIRO CARLOS");
                break;

                case "3":
                System.out.println("VICENTE CEZAR GOMES JÚNIOR SILVA MOREIRA DOS SANTOS VIEIRA FERREIRA CARVALHO II");
                break;

                case "4":
                System.out.println("ALGUEM FAMOSO QUE NINGUÉM CONHECE");
                break;

                case "5":
                System.out.println("TOBEY MAGUAIRE");
                break;

                default :
                System.out.println("Vai denovo.");
                break;
            }
        }
        
    }
}
class av1vel {

    int velperm = 50;
    int velac = velmper + 10;
    int velmot = Integer.parseInt(args[0]); 

    System.out.println(velmot);
}
/*não terminado*/
/* if velmot <= 10 print multa 1 */