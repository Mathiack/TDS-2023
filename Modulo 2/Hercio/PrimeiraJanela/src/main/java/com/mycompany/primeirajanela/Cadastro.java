package com.mycompany.primeirajanela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cadastro extends JFrame {
    
    //////////////////////////////////////////////////////////////////
        //JLABEL
    JLabel nome;
    JLabel email;
    JLabel idade; 
    JLabel telefone;
    JLabel cpf;
    JLabel data;
    JLabel endereco;
    JLabel cep;
    JLabel senha;
    
    //////////////////////////////////////////////////////////////////
        //JTEXTFIELD
    JTextField campo1;
    JTextField campo2;
    JTextField campo3;
    JTextField campo4;
    
    //////////////////////////////////////////////////////////////////
        //JBUTTON
    JButton botaoCadastrar;
    JButton botaoPesquisar;
    JButton botaoVoltar;
    JButton botaoSair;
    
    //////////////////////////////////////////////////////////////////
    
    public Cadastro() {
        super("Tela de Cadastro");
        setLayout(null);
        
        //////////////////////////////////////////////////////////////////
        
        nome =      new JLabel("Nome: ");
        email =     new JLabel("E-mail: ");
        senha =     new JLabel("Senha: ");
        idade =     new JLabel("Idade: ");
        telefone =  new JLabel("Telefone: ");
        cpf =       new JLabel("CPF: ");
        data =      new JLabel("Data de Nascimentos");
        endereco =  new JLabel("Endereço: ");
        cep =       new JLabel("CEP: ");
        
        botaoCadastrar =    new JButton("Cadastrar");
        botaoPesquisar =    new JButton("Pesquisar");
        botaoVoltar =       new JButton("Voltar");
        botaoSair =         new JButton("Sair");
        
        //////////////////////////////////////////////////////////////////
        
        botaoCadastrar.setMnemonic(KeyEvent.VK_C);
        botaoPesquisar.setMnemonic(KeyEvent.VK_P);
        botaoCadastrar.setMnemonic(KeyEvent.VK_V);
        botaoCadastrar.setMnemonic(KeyEvent.VK_S);
        
        //////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////
    }
}
