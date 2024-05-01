/* Write a Java program to print the sum (addition), multiply, subtract, divide and remainder of two numbers */
/* não terminei */
public class calc {
    
    public static void main (String [] args) {

        String opc = "" ;
        double res = 0 ;
        double n1 = Double.parseDouble(args[1]) ; 
        double n2 = Double.parseDouble(args[2]) ;

        Calculo calc = new Calculo(n1, n2);

        System.out.println("Escolha S para SOMA, Su para SUBTRAIR, M para MULTIPLICAR e D para DIVIDIR.") ;

        switch (opc) {

            case "S" :
                res = calc.soma();
                break;
            case "Su" :
                res = calc.sub();
                break;
            case "M" :
                res = calc.multi();
                break;
            case "D" :
                res = calc.div();
                break;
            default :
                System.out.println("Eu disse S, Su, M e D. Não esse número.");
                break;
        }
    }
}
class Calculo {

    private double n1;
    private double n2;

    Calculo(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public double soma() {
        return this.n1 + this.n2 ;
    }
    public double sub() {
        return this.n1 - this.n2 ;
    }
    public double multi() {
        return this.n1 * this.n2 ;
    }
    public double div() {
        return this.n1 / this.n2 ;
    }
}
