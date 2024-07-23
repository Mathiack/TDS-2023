public class idade {

    public static void main (String [] args) {

        double idade = Double.parseDouble(args[0]);

        if (idade < 18) {

            System.out.println("Tu é de menor");
        }
        else {

            System.out.println("Tu é de maior");
        }
    }
}