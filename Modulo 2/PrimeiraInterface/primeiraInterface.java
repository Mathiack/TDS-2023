/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author Suporte
 */
public class PrimeiraInterfasse extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ok");
        PrimeiraInterfasse p = new PrimeiraInterfasse();
        p.setVisible(false);
        p.setSize(500, 500);
        p.setLocationRelativeTo(null);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setResizable(true);
        p.setAlwaysOnTop(true);
        Scanner s = new Scanner(System.in);
        if (s.nextLine().equalsIgnoreCase("i")) {
            p.setVisible(true);
        }
        System.out.println("Feito!");
        System.out.println(">");
        String ns = s.nextLine();
        System.out.println("= " + ns);
    }
    
}
