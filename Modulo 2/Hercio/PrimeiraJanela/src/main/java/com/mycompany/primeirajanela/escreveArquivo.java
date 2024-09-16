package com.mycompany.primeirajanela;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 import java.io.*;
import javax.swing.*;

public class escreveArquivo {    

    public static void main(String[] args){    
        JFrame j = new JFrame("ARQUIVO");
        j.setSize(400,350);
        j.setLocationRelativeTo(j);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel p = new JPanel();
        p.setLayout(null);
        
        GridLayout layout = new GridLayout(0,2,20,20);
        p.setLayout(layout);
        
        
        JLabel jLbnum1 = new JLabel("Nome:");       
        jLbnum1.setHorizontalAlignment(JLabel.CENTER);
        jLbnum1.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxnome = new JTextField();
        jTxnome.setPreferredSize(new Dimension( 50, 24 ));
        
        JLabel jLbnum2 = new JLabel("E-mail");
        jLbnum2.setHorizontalAlignment(JLabel.CENTER);
        jLbnum2.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxemail = new JTextField();
        jTxemail.setPreferredSize(new Dimension( 50, 24 ));
        
        JLabel jLbnum3 = new JLabel("Telefone");
        jLbnum2.setHorizontalAlignment(JLabel.CENTER);
        jLbnum2.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxtel = new JTextField();
        jTxtel.setPreferredSize(new Dimension( 50, 24 ));
        
        JLabel jLbnum4 = new JLabel("Sexo");
        jLbnum2.setHorizontalAlignment(JLabel.CENTER);
        jLbnum2.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxsexo = new JTextField();
        jTxsexo.setPreferredSize(new Dimension( 50, 24 ));
        
        JLabel jLbnum5 = new JLabel("Cidade");
        jLbnum2.setHorizontalAlignment(JLabel.CENTER);
        jLbnum2.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxcidade = new JTextField();
        jTxcidade.setPreferredSize(new Dimension( 50, 24 ));
        
        JLabel jLbnum6 = new JLabel("Estado");
        jLbnum2.setHorizontalAlignment(JLabel.CENTER);
        jLbnum2.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxestado = new JTextField();
        jTxestado.setPreferredSize(new Dimension( 50, 24 ));
        
        JButton jBtEscreva = new JButton("Toma");  
        JButton jBtLer = new JButton("Ler");  
        
        jBtEscreva.setBounds(50,100,95,30);
        jBtLer.setBounds(50,100,95,30);
        
        jBtEscreva.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("saida.txt"))) {
                    String nome = jTxnome.getText();
                    String email = jTxsexo.getText();
                    String tel = jTxtel.getText();
                    String sexo = jTxsexo.getText();
                    String cidade = jTxcidade.getText();
                    String estado = jTxestado.getText();
                    
                    writer.write("Nome: " + nome);
                    writer.newLine();
                    writer.write("E-mail: " + email);
                    writer.newLine();
                    writer.write("Telefone: " + tel);
                    writer.newLine();
                    writer.write("Sexo: " + sexo);
                    writer.newLine();
                    writer.write("Cidade: " + cidade);
                    writer.newLine();
                    writer.write("Estado: " + estado);
                    writer.newLine();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        
        p.add(jLbnum1);
        p.add(jTxnome);
        
        p.add(jLbnum2);
        p.add(jTxemail);
        
        p.add(jLbnum3);
        p.add(jTxtel);
        
        p.add(jLbnum4);
        p.add(jTxsexo);
        
        p.add(jLbnum5);
        p.add(jTxcidade);
        
        p.add(jLbnum6);
        p.add(jTxestado);
        
        p.add(jBtEscreva);
        p.add(jBtLer);
        j.add(p);
        j.pack();
        j.setVisible(true);
    }    
}
