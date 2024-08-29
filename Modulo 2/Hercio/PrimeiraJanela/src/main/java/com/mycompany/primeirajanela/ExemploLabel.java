package com.mycompany.primeirajanela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExemploLabel extends JFrame {
    JLabel rotulo1, rotulo2, rotulo3, rotulo4;
    JTextField texto1, texto2, texto3, texto4;
    JButton botao, botaoCadastro, botaoSair, botaoCalculadora, botaoEstados;

    // Painéis para exibir
    JPanel panelMain, panelCadastro;

    public ExemploLabel() {
        super("Exemplo com Label");
       
        Container panelMain = getContentPane();
        panelMain.setLayout(null);
        
        rotulo1 = new JLabel("Nome");
        rotulo2 = new JLabel("Idade");
        rotulo3 = new JLabel("Telefone");
        rotulo4 = new JLabel("Celular");

        botao = new JButton("Procurar");
        botaoCadastro = new JButton("Cadastro");
        botaoSair = new JButton("Sair");
        botaoCalculadora = new JButton("Calculadora");
        botaoEstados = new JButton("Estados");

        texto1 = new JTextField(50);
        texto2 = new JTextField(3);
        texto3 = new JTextField(14);
        texto4 = new JTextField(14);

        rotulo1.setBounds(50, 20, 120, 20);
        rotulo2.setBounds(50, 60, 120, 20);
        rotulo3.setBounds(50, 100, 120, 20);
        rotulo4.setBounds(50, 140, 120, 20);

        texto1.setBounds(150, 20, 200, 20);
        texto2.setBounds(150, 60, 20, 20);
        texto3.setBounds(150, 100, 80, 20);
        texto4.setBounds(150, 140, 80, 20);

        botao.setBounds(35, 180, 100, 20);
        botaoSair.setBounds(35, 210, 100, 20);
        botaoCadastro.setBounds(35, 240, 100, 20);
        botaoCalculadora.setBounds(35, 270, 100, 20);
        botaoEstados.setBounds(35, 300, 100, 20);

        rotulo1.setForeground(Color.red);
        rotulo2.setForeground(Color.blue);
        rotulo3.setForeground(new Color(190, 152, 142));
        rotulo4.setForeground(new Color(201, 200, 100));

        rotulo1.setFont(new Font("Arial", Font.BOLD, 14));
        rotulo2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        rotulo3.setFont(new Font("Courier New", Font.BOLD, 18));
        rotulo4.setFont(new Font("Times New Roman", Font.BOLD, 20));

        panelMain.add(rotulo1);
        panelMain.add(rotulo2);
        panelMain.add(rotulo3);
        panelMain.add(rotulo4);
        panelMain.add(texto1);
        panelMain.add(texto2);
        panelMain.add(texto3);
        panelMain.add(texto4);
        
        panelMain.add(botao);
        panelMain.add(botaoCadastro);
        panelMain.add(botaoSair);
        panelMain.add(botaoCalculadora);
        panelMain.add(botaoEstados);

        // Define o comportamento dos botões
        botaoCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janCad();
            }
        });
        
        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        botaoCalculadora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janCalc();
            }
        });
        
        botaoEstados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janEst();
            }
        });
        setSize(400, 430);
        setVisible(true);
        setLocationRelativeTo(null);
        
    }
    
    //            JANELA DO CADASTRO            //
    static void janCad() {
        JFrame j = new JFrame("CADASTRO");
        j.setSize(400, 350);
        j.setLocationRelativeTo(j);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        
        GridLayout layout = new GridLayout(0, 2, 20, 20);
        p.setLayout(layout);
        
        JLabel JLnome = new JLabel("Nome:");
        JLnome.setHorizontalAlignment(JLabel.CENTER);
        JLnome.setHorizontalTextPosition(JLabel.CENTER);
        JTextField JTnome = new JTextField();
        JTnome.setPreferredSize(new Dimension(50, 24));
        
        JLabel JLemail = new JLabel("E-mail:");
        JTextField JTemail = new JTextField();
        
        JLabel JLidade = new JLabel("Idade:");
        JTextField JTidade = new JTextField();
        
        JLabel JLtelefone = new JLabel("Telefone:");
        JTextField JTtelefone = new JTextField();
        
        JLabel JLcpf = new JLabel("CPF:");
        JTextField JTcpf = new JTextField();
        
        JLabel JLdata = new JLabel("Data de Nascimento:");
        JTextField JTdata = new JTextField();
        
        JLabel JLendereco = new JLabel("Endereço:");
        JTextField JTendereco = new JTextField();
        
        JLabel JLcep = new JLabel("CEP:");
        JTextField JTcep = new JTextField();
        
        JLabel JLsenha = new JLabel("Senha:");
        JTextField JTsenha = new JTextField();
        
        JButton JBenviar = new JButton("Enviar");
        
        p.add(JLemail);
        p.add(JTemail);
        
        p.add(JLidade);  
        p.add(JTidade);
        
        p.add(JLtelefone);
        p.add(JTtelefone);
        
        p.add(JLcpf);
        p.add(JTcpf);
        
        p.add(JLdata);
        p.add(JTdata);
        
        p.add(JLendereco);
        p.add(JTendereco);
        
        p.add(JLcep);
        p.add(JTcep);
        
        p.add(JLsenha);
        p.add(JTsenha);
        
        p.add(JBenviar);
        
        String nome = JTnome.getText();
        String idade = JTidade.getText();
        String telefone = JTtelefone.getText();
        String data = JTdata.getText();
        String endereco = JTendereco.getText();
        String cep = JTcep.getText();
        String senha = JTsenha.getText();
        
        //JBenviar.setHorizontalAlignment(JButton.CENTER);
        //JBenviar.setHorizontalTextPosition(JButton.CENTER);
        
        j.add(p);
        j.pack();
        j.setVisible(true);
        
        JBenviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Integer print = JOptionPane.showConfirmDialog(rootPane, 
                "-------------------------------\n" +
                "Nome: " + nome + "\n" +
                "E-mail"
                "-------------------------------\n" +
                "Endereço: " + endereco + "\n" +
                "-------------------------------\n" +
                "PEDIDOS\n" +
                "Sabor: " + sabor + "\n" +
                "Tamanho: " + tamanho + "\n" +
                "Bebida: " + bebida + "\n" +
                "-------------------------------\n" +
                "PREÇO\n" +
                "Total: " + preco + "\n" + 
                "-------------------------------\n"
                );
        
                if (print == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(rootPane, "Fasido");
                    Pedido p = new Pedido(nome_Cliente, endereco, bairro, nCasa, hora, sabor, tamanho, bebida);
                    p.mostrar();
                } else if (print == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(rootPane, "Beta");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Beta");
                }
            }
        });
    }
    
    //            JANELA DA CALCULADORA            //
    static void janCalc() {
        JFrame j = new JFrame("CALCULADORA");
        j.setSize(400,350);
        j.setLocationRelativeTo(j);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        
        GridLayout layout = new GridLayout(0,2,20,20);
        p.setLayout(layout);
        
        
        JLabel jLbnum1 = new JLabel("Número 1:");       
        jLbnum1.setHorizontalAlignment(JLabel.CENTER);
        jLbnum1.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxnum1 = new JTextField();
        jTxnum1.setPreferredSize(new Dimension( 50, 24 ));
        
        
        JLabel jLbnum2 = new JLabel("Número 2:");
        jLbnum2.setHorizontalAlignment(JLabel.CENTER);
        jLbnum2.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxnum2 = new JTextField();
        jTxnum2.setPreferredSize(new Dimension( 50, 24 ));
        
        
        JLabel jLbresultado = new JLabel("RESULTADO");
        jLbresultado.setHorizontalAlignment(JLabel.CENTER);
        jLbresultado.setHorizontalTextPosition(JLabel.CENTER);
        JLabel jLbVazio = new JLabel("");

        
        jLbresultado.setBounds(50,100,95,30);
        
        JButton jBtSoma=new JButton("Somar");  
        JButton jBtSubtrair=new JButton("Subtrair"); 
        JButton jBtMultiplicar=new JButton("Multiplicar"); 
        JButton jBtDividir=new JButton("Dividir"); 
        
        JButton jBtLimpar=new JButton("Limpar");  
        jBtLimpar.setBounds(50,100,95,30);
        
        jBtSoma.setBounds(50,100,95,30);
        
        jBtSoma.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
                  {
                   Calculos c = new Calculos();   
                   c.setNumero1(Double.parseDouble(jTxnum1.getText()));
                   c.setNumero2(Double.parseDouble(jTxnum2.getText()));
                   c.soma();
                   jLbresultado.setText(c.getCalculo().toString());

                }
        });
        
        
        jBtSubtrair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
                  {
                   Calculos c = new Calculos();   
                   c.setNumero1(Double.parseDouble(jTxnum1.getText()));
                   c.setNumero2(Double.parseDouble(jTxnum2.getText()));
                   c.subtracao();
                   jLbresultado.setText(c.getCalculo().toString());

                }
        });
        
        jBtMultiplicar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
                  {
                   Calculos c = new Calculos();   
                   c.setNumero1(Double.parseDouble(jTxnum1.getText()));
                   c.setNumero2(Double.parseDouble(jTxnum2.getText()));
                   c.multiplicacao();
                   jLbresultado.setText(c.getCalculo().toString());

                }
        });
        
        jBtDividir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
                  {
                   Calculos c = new Calculos();   
                   c.setNumero1(Double.parseDouble(jTxnum1.getText()));
                   c.setNumero2(Double.parseDouble(jTxnum2.getText()));
                   c.divisao();
                   jLbresultado.setText(c.getCalculo().toString());

                }
        });
        
        
        jBtLimpar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
                  {

                   jTxnum1.setText("");
                  jTxnum2.setText("");

                   jLbresultado.setText("");

                }
        });
        
        p.add(jLbnum1);
        p.add(jTxnum1);        
        p.add(jLbnum2);
        p.add(jTxnum2);
        p.add(jLbVazio);
        
        p.add(jLbresultado);
        p.add(jBtSoma);
        p.add(jBtSubtrair);
        p.add(jBtMultiplicar);
        p.add(jBtDividir);
        p.add(jBtLimpar);
        j.add(p);
        j.pack();
        j.setVisible(true);
    }
    
    //            JANELA DOS ESTADOS            //
    //               FAZER DEPOIS               //
    static void janEst() {
        JFrame j = new JFrame("ESTADOS");
        j.setSize(400, 350);
        j.setLocationRelativeTo(j);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        
        GridLayout layout = new GridLayout(0, 2, 20, 20);
        p.setLayout(layout);
    }
}