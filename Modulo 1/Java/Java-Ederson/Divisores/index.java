package com.mycompany.diivsores;

import java.util.Scanner;

public class Diivsores {
 
    @SuppressWarnings("empty-statement")
    public static void main(String args[]) {
 
        Scanner a = new Scanner(System.in);
        System.out.println("coloca um numero ai bagual: ");
        int y = a.nextInt();
        
        for (int i = y; i > 0; ) {
            if (y%i==0) {
                System.out.println(i);
            }
        }
        
    }
}
/*nao terminado*/
