public class maiorqdez {
 
    public static void main (String [] args) {

        double n1 = Double.parseDouble(args[0]);
        double n2 = Double.parseDouble(args[1]);

        double soma = n1 + n2;

        if (soma <= 10) {

            System.out.println("A tua soma é menor ou igoal a des");
        }
        else {

            System.out.println("A tua soma é maior q des");
        } 
    }
}