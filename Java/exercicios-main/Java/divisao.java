/* Write a Java program to divide two numbers and print them on the screen */
public class divisao {
    
    public static void main (String [] args) {

    double n1 = Double.parseDouble(args[0]);
    double n2 = Double.parseDouble(args[1]);

    System.out.println("O resultado é: " + (n1 / n2));
    }
}