package com.mycompany.primeirajanela;

 import java.io.*;

public class escreveArquivo {    
    public static void main(String[] args){        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("saida.txt"))) {
            writer.write("Escrevendo uma linha no arquivo.");
            writer.newLine();
            writer.write("Esta é a segunda linha.");
        } catch (IOException e) {
            e.printStackTrace();        
       }    
    }
}
