/*Leia a velocidade máxima permitida em uma avenida, a placa do veículo e a velocidade
com que o motorista estava dirigindo nela e calcule a multa que uma pessoa vai
receber, sabendo que são pagos: a) 50 reais se o motorista estiver ultrapassar em até
10km/h a velocidade permitida(ex.: velocidade máxima: 50km/h; motorista a 60km/h ou
a 56km/h); b) 100 reais, se o motorista ultrapassar de 11 a 30 km/h a velocidade
permitida. c) 200 reais, se estiver acima de 31km/h da velocidade permitida.*/
import java.util.Scanner;
public class pardal {

    public static void main (String [] args) {

        String local = "";
        String placa = "";
        double vel = 0;
        Scanner scan = new Scanner (System.in); 

        System.out.println("Digite a placa do teu veículo: ");
        placa = scan.nextLine();
        System.out.println("Agora escóie a avenida: ");
        local = scan.nextLine();
        System.out.println("Joia, bota a velocidade: ");
        vel = scan.nextDouble();
        System.out.println("Os valores são: " + placa + " , " + local + " e " + vel);
        
    }
}