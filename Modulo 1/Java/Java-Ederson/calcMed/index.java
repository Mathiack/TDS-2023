package com.mycompany.calcmed;

import java.util.Scanner;

public class Calcmed {

    public static void main(String[] args) {
        Scanner l = new Scanner(System.in); 
        int soma = 0;       
        int qtd=0;       
        float media;        
        System.out.println("Digite um numero: ");       
        int numero = l.nextInt();
        while (numero >=0) {           
            soma = soma + numero;
            qtd++;
            System.out.println("Digite um numero: ");           
            numero = l.nextInt();          
        }
            
        media = soma/qtd;        
        System.out.println("Somou " + soma + " rodou " + qtd +"\n");        
        System.out.println("Media: "+ media);
    }
}
